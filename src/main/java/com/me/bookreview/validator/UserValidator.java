package com.me.bookreview.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.bookreview.pojos.User;

public class UserValidator implements Validator{
	
		@Override
	    public boolean supports(Class<?> type) {
	    //need to check if class is being supported or not; class should be user or its subclass
        return User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Name", "error-name", "First Name cannot be empty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error-email", "email cannot be empty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error-username", "username cannot be empty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error-password", "password cannot be empty");
        try {
        	System.out.println("hereee");
	        User user = (User) o;
	        System.out.println("User="+user);
	        if (!user.getEmail().matches("([a-zA-Z1-9.-_])*(@)([A-Za-z]+)(.com)")) {
	            errors.rejectValue("email", "This is not an email");
	        }
	        if (!user.getEmail().matches("([a-zA-Z1-9.-_])*(@)([A-Za-z]+)(.com)")) {
	            errors.rejectValue("email", "This is not an email");
	        }
        }
        catch(NullPointerException e) {
        	System.out.println("In Validator "+ e);
        }
        
      
        
  
    }
}
