package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	render();
    }
    
    public static void que(){
    	List<Applicant> applicants = Applicant.find("id > ? order by id asc", 1l).fetch();
    	render(applicants);
    }
    
    public static void post(@Required String fname, @Required String lname, @Required String email, @Required String phoneNumber){
    	if(validation.hasErrors())
    		System.out.println("has errors");
    	else{
    		Contact contact = new Contact(email, phoneNumber).save();
			new Applicant(fname, lname, contact).save();
    	}
    	
    	index();
    }

}