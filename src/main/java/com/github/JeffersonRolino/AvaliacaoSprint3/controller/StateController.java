package com.github.JeffersonRolino.AvaliacaoSprint3.controller;

import com.github.JeffersonRolino.AvaliacaoSprint3.model.dto.StateDto;
import com.github.JeffersonRolino.AvaliacaoSprint3.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @PostMapping
    public ResponseEntity<StateDto> addNewState(@RequestBody StateDto state, UriComponentsBuilder uriComponentsBuilder){

        StateDto stateDto = stateService.addNewState(state);

        URI uri = uriComponentsBuilder.path("/api/states/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).body(stateDto);
    }

    @GetMapping
    public List<StateDto> listOfStates(){
        return stateService.getAllStates();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateDto> findById(@PathVariable() Long id){
        return stateService.findById(id);
    }

    @PutMapping("/{id}") @Modifying(clearAutomatically = true)
    public ResponseEntity<StateDto> updateStateById(@PathVariable() Long id, @RequestBody StateDto stateDto){
        return stateService.updateStateById(id, stateDto);
    }
}
