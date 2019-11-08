package com.sample.web.controller.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : YJLEE
 * @packageName : com.sample.web.controller.main
 * @since : 2019-11-07
 */
@Controller
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "main.do")
    public String getMain() {

        System.out.println("==== [ main Strat ] =====");
        return "main/main";
    }
}
