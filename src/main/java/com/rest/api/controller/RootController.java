package com.rest.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by chou3ibi on 25/08/17.
 */

@Controller
public class RootController {

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView render() throws ServletException, IOException {

        return new ModelAndView("index");
    }
}
