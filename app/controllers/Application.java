package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	Applicant kim = new Applicant("Kim", "Pohl", "1234 somewhwers ville, CA 92342",  "null", "someEmail@gmail.com");
    	kim.save();
    	List<Applicant> applicants = Applicant.find("date >= '2012-03-21 22:00:00, yyyy-mm-dd HH:mm:ss' AND date <= '2012-03-24 22:00:30, yyyy-mm-dd HH:mm:ss' and id > ? order by id desc", 1l).fetch();
        render(applicants);
    }

}