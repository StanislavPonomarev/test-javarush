package com.ponomarevsy.user;

/**
 * Created by Стас on 27.12.14.
 */

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class UsersDAO
{
        @Autowired
        private SessionFactory sessionFactory;

        public User getById(int id)
        {
                return (User) sessionFactory.getCurrentSession().get(User.class, id);
        }

        @SuppressWarnings("unchecked")
        public List<User> searchUsers(String name)
        {
                Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
                criteria.add(Restrictions.ilike("name", name+"%"));
                return criteria.list();
        }

        @SuppressWarnings("unchecked")

                //  public List<User> getAllUsers()
        public List<User> getAllUsers(int pageNumber)
        {



                Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
                criteria = criteria.setFirstResult(5 * (pageNumber - 1));
                criteria.setMaxResults(5);
                return criteria.list();


        }

        public int save(User user)
        {
                return (Integer) sessionFactory.getCurrentSession().save(user);
        }

        public void update(User user)
        {
                sessionFactory.getCurrentSession().merge(user);
        }

        public void delete(int id)
        {
                User c = getById(id);
                sessionFactory.getCurrentSession().delete(c);
        }

        public List<User> getAllOfUsers()
        {
                Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
                return criteria.list();

        }





}
