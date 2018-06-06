// package com.example.demo.configuration;
//
// import org.apache.catalina.User;
// import org.aspectj.lang.annotation.AfterReturning;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Pointcut;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.web.servlet.ModelAndView;
//
// @Aspect
// @Configuration
// public class AOPConfiguration {
//     @Pointcut("execution(org.springframework.web.servlet.ModelAndView com.example.demo.controller.*.*(..))")
//     private void viewPointCut(){
//
//     }
//
//     @AfterReturning(value = "viewPointCut()",returning = "modelAndView")
//     public ModelAndView asd(ModelAndView modelAndView) {
//         return modelAndView.addObject("username",((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
//     }
// }
