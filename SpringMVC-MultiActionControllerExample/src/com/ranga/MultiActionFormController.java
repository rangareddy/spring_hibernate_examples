package com.ranga;
/**
 * MultiActionFormController.java
 * @author ranga
 * Apr 6, 2014
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MultiActionFormController extends MultiActionController {
    public ModelAndView create(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("result", "resultMessage", "create() method called");
    }
    public ModelAndView read(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("result", "resultMessage", "read() method called");
    }
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("result", "resultMessage", "update() method called");
    }
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("result", "resultMessage", "delete() method called");
    }
}