package com.gymstarter.gymstarterapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @GetMapping
    public void teste(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getPathInfo());
        System.out.println(request.getQueryString());
        System.out.println(request.getScheme());
        System.out.println(request.getLocalName());
    }
}
