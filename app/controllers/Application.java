package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
//    	Applicant kim = new Applicant("Kim", "Pohl");
//    	kim.save();
//    	List<Applicant> applicants = Applicant.find("date >= '2012-03-21 22:00:00, yyyy-mm-dd HH:mm:ss' AND date <= '2012-03-24 22:00:30, yyyy-mm-dd HH:mm:ss' and id > ? order by id desc", 1l).fetch();
//        render(applicants);
    	render();
    }
    
    public static void que(){
    	render();
    }
    
    public static void post(@Required String fname, @Required String lname){
    	if(validation.hasErrors())
    		System.out.println("has errors");
    	else
    		new Applicant(fname, lname).save();
    	
    	index();
    }

}