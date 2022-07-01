package com.github.JeffersonRolino.AvaliacaoSprint3.service;

import com.github.JeffersonRolino.AvaliacaoSprint3.model.dto.StateDto;
import com.github.JeffersonRolino.AvaliacaoSprint3.model.entity.State;
import com.github.JeffersonRolino.AvaliacaoSprint3.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public StateDto addNewState(StateDto stateDto){

        State savedState = stateRepository.save(new State(stateDto));
        return new StateDto(savedState);
    }
}
