package com.github.JeffersonRolino.AvaliacaoSprint3.controller;

import com.github.JeffersonRolino.AvaliacaoSprint3.model.dto.StateDto;
import com.github.JeffersonRolino.AvaliacaoSprint3.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @PostMapping
    public ResponseEntity<StateDto> addNewState(@RequestBody StateDto state, UriComponentsBuilder uriComponentsBuilder){

        if(stateService.isValidRegion(state.getRegion())){
            StateDto stateDto = stateService.addNewState(state);
            URI uri = uriComponentsBuilder.path("/api/states/{id}").buildAndExpand(state.getId()).toUri();
            return ResponseEntity.created(uri).body(stateDto);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }


    // Endpoint para facilitar a vida e inserir um Array de JSON Objects para testes...
    // Está retornando 200 e o array inserido, mas não 201...
    @PostMapping("/insert")
    public List<StateDto> addMultipleStates(@RequestBody List<StateDto> states){

        for(StateDto state : states){
            stateService.addNewState(state);
        }
        return states;
    }

    @GetMapping
    public List<StateDto> listOfStates(String region, boolean sortByPopulation, boolean sortByArea){

        if(region != null && stateService.isValidRegion(region)){
            return stateService.getStateByRegion(region);
        }
        else if(sortByPopulation){
            return stateService.sortByPopulation();
        }
        else if(sortByArea){
            return stateService.sortByArea();
        }
        else {
            return stateService.getAllStates();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateDto> findById(@PathVariable() Long id){
        return stateService.findById(id);
    }

    @PutMapping("/{id}") @Modifying(clearAutomatically = true)
    public ResponseEntity<StateDto> updateStateById(@PathVariable() Long id, @RequestBody StateDto stateDto){
        return stateService.updateStateById(id, stateDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StateDto> deleteStateById(@PathVariable Long id){
        return stateService.deleteStateById(id);
    }

}
