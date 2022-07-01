package com.github.JeffersonRolino.AvaliacaoSprint3.controller;

import com.github.JeffersonRolino.AvaliacaoSprint3.model.dto.StateDto;
import com.github.JeffersonRolino.AvaliacaoSprint3.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @PostMapping
    public ResponseEntity<StateDto> addNewState(@RequestBody StateDto state){
        System.out.println("Realizando Cadastro de Estado...");

        StateDto stateDto = stateService.addNewState(state);

        return ResponseEntity.ok(stateDto);
    }

}
