package com.ponomarevsy.user;

/**
 * Created by Стас on 27.12.14.
 */

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("userFormValidator")
public class UserFormValidator implements Validator
{
        @SuppressWarnings("unchecked")
        @Override
        public boolean supports(Class clazz)
        {
                return User.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object model, Errors errors)
        {

                        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name", "Name is strongly required.");

        }

        public void validate(User user, Errors errors) {

                if (user.getAge() < 0) {
                        errors.rejectValue("age", "validation.negative", "must be > 0");
                }
                else if(user.getName() == "") {
                        errors.rejectValue("name", "validation.emptyname" , "name is strongly required");
                }
        }

}
