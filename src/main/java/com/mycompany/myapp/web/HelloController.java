package com.mycompany.myapp.web;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;

@Controller
public class HelloController {

    @Autowired DSLContext dsl1;
    @Autowired DSLContext dsl2;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public Object hello() {
        return Arrays.asList("hello", "world", new Date());
    }

}
