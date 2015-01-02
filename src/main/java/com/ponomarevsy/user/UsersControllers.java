package com.ponomarevsy.user;

/**
 * Created by Стас on 27.12.14.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UsersControllers
{
        @Autowired
        private UsersDAO usersDAO;

        @Autowired
        private UserFormValidator validator;

        @RequestMapping("/home")
        public String home()
        {
                return "home";
        }

        @InitBinder
        public void initBinder(WebDataBinder binder)
        {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setLenient(false);
                binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        }

        @RequestMapping("/searchUsers")
        public ModelAndView searchUsers(@RequestParam(required= false, defaultValue="") String name)
        {
                ModelAndView mav = new ModelAndView("showUsers");
                List<User> users = usersDAO.searchUsers(name.trim());
                mav.addObject("SEARCH_USERS_RESULTS_KEY", users);
                return mav;
        }

        @RequestMapping(value = "/viewAllUsers" , method=RequestMethod.GET)
        //@RequestMapping("/viewAllUsers")
       // public ModelAndView getAllUsers()
        public ModelAndView getAllUsers(@RequestParam(value = "pageNum", required = false) int pageNum)
        {
                ModelAndView mav = new ModelAndView("showUsers");
                List<User> users = usersDAO.getAllUsers(pageNum);
                mav.addObject("SEARCH_USERS_RESULTS_KEY", users);

                //----------
                int pageCount = 0;
                List<User> usersAll = usersDAO.getAllOfUsers();
                if (usersAll.size()%5 == 0)
                        pageCount = usersAll.size()/5;
                else pageCount = usersAll.size()/5 + 1;
                mav.addObject("USERS_PAGE_COUNT" , pageCount);
                //-----------

                return mav;
        }


        @RequestMapping(value="/saveUser", method=RequestMethod.GET)
        public ModelAndView newuserForm()
        {
                ModelAndView mav = new ModelAndView("newUser");
                User user = new User();
                mav.getModelMap().put("newUser", user);
                return mav;
        }

        @RequestMapping(value="/saveUser", method=RequestMethod.POST)
        public String create(@ModelAttribute("newUser")User user, BindingResult result, SessionStatus status)
        {
                validator.validate(user, result);
                if (result.hasErrors())
                {
                        return "newUser";
                }
                usersDAO.save(user);
                status.setComplete();
                return "redirect:viewAllUsers.do?pageNum=1";
        }

        @RequestMapping(value="/updateUser", method=RequestMethod.GET)
        public ModelAndView edit(@RequestParam("id")Integer id)
        {
                ModelAndView mav = new ModelAndView("editUser");
                User user = usersDAO.getById(id);
                mav.addObject("editUser", user);
                return mav;
        }

        @RequestMapping(value="/updateUser", method=RequestMethod.POST)
        public String update(@ModelAttribute("editUser") User user, BindingResult result, SessionStatus status)
        {
                validator.validate(user, result);
                if (result.hasErrors()) {
                        return "editUser";
                }
                usersDAO.update(user);
                status.setComplete();
                return "redirect:viewAllUsers.do?pageNum=1";
        }


        @RequestMapping("deleteUser")
        public ModelAndView delete(@RequestParam("id")Integer id)
        {
                ModelAndView mav = new ModelAndView("redirect:viewAllUsers.do?pageNum=1");
                usersDAO.delete(id);
                return mav;
        }

        //------------------


}
