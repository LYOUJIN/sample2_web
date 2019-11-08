/*****************************************************************************
 * Copyright(c) 2014 neonexsoft. All rights reserved.
 * This software is the proprietary information of neonexsoft.
 * <p/>
 * Description :
 * Create on 2017-05-11 **
 *****************************************************************************/
package com.sample.web.common.advice;


import com.sample.web.vo.RecordVo;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


@ControllerAdvice
public class DefaultControllerAdvice {
    private final Logger logger = LoggerFactory.getLogger(DefaultControllerAdvice.class);
 
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception ex) throws IOException{
        // logger.error("Exception: {}", ex.toString());
        printExceptionInfo(request, ex);
        ModelAndView mv = new ModelAndView("jsonView");
        
		RecordVo result = new RecordVo();
		result.put("resultCode","F");
		result.put("message",ex.getMessage());

		JSONObject json = JSONObject.fromObject(result);
		mv.addObject("result", json);
        return mv;
    }
 
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleRuntimeException(HttpServletRequest request, RuntimeException ex)  throws IOException {
        // logger.error("RuntimeException: {}", ex.toString());
        printExceptionInfo(request, ex);
        ModelAndView mv = new ModelAndView("jsonView");
        
		RecordVo result = new RecordVo();
		result.put("resultCode","F");
		result.put("message",ex.getMessage());

		JSONObject json = JSONObject.fromObject(result);
		mv.addObject("result", json);

        return mv;
    }
     
    private void printExceptionInfo(HttpServletRequest request, Exception ex)  throws IOException{
    	/*
        logger.error("PARMAS: {}", request.getParameterMap());
        //ex.printStackTrace();
        for( StackTraceElement s : ex.getStackTrace() ){
            logger.error("{}", ex);
        }
        */
        StringWriter writer = null;
        try {
            writer = new StringWriter();
            ex.printStackTrace(new PrintWriter(writer));
            logger.error("\r\nType : {}\r\nMessage : {}\r\n{}", ex.getClass().getSimpleName(), ex.getMessage(), writer.toString());
        }finally {
            writer.close();
        }
    }
 
}
