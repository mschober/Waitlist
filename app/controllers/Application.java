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