package com.github.JeffersonRolino.AvaliacaoSprint3.service;

import com.github.JeffersonRolino.AvaliacaoSprint3.model.dto.StateDto;
import com.github.JeffersonRolino.AvaliacaoSprint3.model.entity.State;
import com.github.JeffersonRolino.AvaliacaoSprint3.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public StateDto addNewState(StateDto stateDto){

        State savedState = stateRepository.save(new State(stateDto));
        return new StateDto(savedState);
    }

    public List<StateDto> getAllStates(){
            return stateRepository.findAll().stream().map(StateDto::new).collect(Collectors.toList());
    }

    public ResponseEntity<StateDto> findById(Long id){
        Optional<State> state = stateRepository.findById(id);
        if(state.isPresent()){
            return ResponseEntity.ok(new StateDto(state.get()));
        }
        return null;
    }

}
