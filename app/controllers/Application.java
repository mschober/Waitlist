package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	PrimaryContact contact = new PrimaryContact("1234 somewhwers ville, CA 92342", "someEmail@gmail.com", "(253)-468-4141").save();
    	Boat boat = new Boat(40.40, 15.15, 10.10).save();
    	Applicant kim = new Applicant("Kim", "Pohl", contact, boat);
//    	kim.save();
    	List<Applicant> applicants = Applicant.find("date >= '2012-03-21 22:00:00, yyyy-mm-dd HH:mm:ss' AND date <= '2012-03-24 22:00:30, yyyy-mm-dd HH:mm:ss' and id > ? order by id desc", 1l).fetch();
        render(applicants);
    }

}