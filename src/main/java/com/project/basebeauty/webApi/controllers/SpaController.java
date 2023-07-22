package com.project.basebeauty.webApi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SpaController {

    @GetMapping(value = {"/{path:[^.]*}", "/{path:[^.]*}/{subPath:[^.]*}"})
    public String redirectToIndex(@PathVariable(required = false) String path,
                                  @PathVariable(required = false) String subPath) {
        return "forward:/index.html";
    }
}
