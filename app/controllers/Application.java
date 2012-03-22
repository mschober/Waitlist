package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	List<Applicant> applicants = Applicant.find("id > ? order by id asc", 1l).fetch();
        render(applicants);
    }

}