package com.github.JeffersonRolino.AvaliacaoSprint3.controller;

import com.github.JeffersonRolino.AvaliacaoSprint3.model.dto.StateDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @PostMapping
    public Object addNewState(StateDto state){
        System.out.println("Realizando Cadastro de Estado...");

        return "ok";
    }

}
