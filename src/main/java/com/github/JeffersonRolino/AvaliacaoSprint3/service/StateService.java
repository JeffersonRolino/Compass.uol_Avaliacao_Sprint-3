package com.github.JeffersonRolino.AvaliacaoSprint3.service;

import com.github.JeffersonRolino.AvaliacaoSprint3.model.dto.StateDto;
import com.github.JeffersonRolino.AvaliacaoSprint3.model.entity.State;
import com.github.JeffersonRolino.AvaliacaoSprint3.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

        if(isValidRegion(stateDto.getRegion())){
            State savedState = stateRepository.save(new State(stateDto));
            return new StateDto(savedState);
        }
        else {
            return null;
        }

    }

    public List<StateDto> getAllStates(){
        return stateRepository.findAll().stream().map(StateDto::new).collect(Collectors.toList());
    }

    public List<StateDto> getStateByRegion(String region){
        return stateRepository.findByRegion(region).stream().map(StateDto::new).collect(Collectors.toList());
    }

    public List<StateDto> sortByPopulation(){
        return stateRepository.findAll(Sort.by(Sort.Direction.DESC, "population")).stream().map(StateDto::new).collect(Collectors.toList());
    }

    public List<StateDto> sortByArea() {
        return stateRepository.findAll(Sort.by(Sort.Direction.DESC, "area")).stream().map(StateDto::new).collect(Collectors.toList());
    }

    public ResponseEntity<StateDto> findById(Long id){
        Optional<State> state = stateRepository.findById(id);
        if(state.isPresent()){
            return ResponseEntity.ok(new StateDto(state.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<StateDto> updateStateById(Long id, StateDto stateDto){
        Optional<State> targetState = stateRepository.findById(id);
        if(targetState.isPresent()){
            State state = update(id, stateRepository, stateDto);
            stateRepository.save(state);
            return ResponseEntity.ok(new StateDto(state));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<StateDto> deleteStateById(Long id){
        Optional<State> targetState = stateRepository.findById(id);
        if(targetState.isPresent()){
            stateRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    public State update(Long id, StateRepository stateRepository, StateDto stateDto){
        State state = stateRepository.getReferenceById(id);

        state.setName(stateDto.getName());
        state.setRegion(stateDto.getRegion());
        state.setPopulation(stateDto.getPopulation());
        state.setCapital(stateDto.getCapital());
        state.setArea(stateDto.getArea());

        return state;
    }

    public boolean isValidRegion(String region){
        return region.equalsIgnoreCase("Norte") ||
                region.equalsIgnoreCase("Nordeste") ||
                region.equalsIgnoreCase("Sul") ||
                region.equalsIgnoreCase("Sudeste") ||
                region.equalsIgnoreCase("Centro-Oeste");
    }
}
