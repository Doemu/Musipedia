package doemu.buildingweb.controllers;

import doemu.buildingweb.Mapper;
import doemu.buildingweb.Views.CompositionViewModel;
import doemu.buildingweb.Views.PerformedCompositionsViewModel;
import doemu.buildingweb.Views.PerformerViewModel;
import doemu.buildingweb.entities.Composition;
import doemu.buildingweb.entities.PerformedComposition;
import doemu.buildingweb.entities.Performer;
import doemu.buildingweb.repository.CompositionRepository;
import doemu.buildingweb.repository.PerformedCompositionRepository;
import doemu.buildingweb.repository.PerformerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MusipediaController {

    @Autowired
    private PerformedCompositionRepository performedCompositionRepository;
    @Autowired
    private CompositionRepository compositionRepository;
    @Autowired
    private PerformerRepository performerRepository;
    @Autowired
    private Mapper mapper;

    public MusipediaController(PerformedCompositionRepository performedCompositionRepository, CompositionRepository compositionRepository, PerformerRepository performerRepository, Mapper mapper) {
        this.performedCompositionRepository = performedCompositionRepository;
        this.compositionRepository = compositionRepository;
        this.performerRepository = performerRepository;
        this.mapper = mapper;
    }

    public MusipediaController() {
    }

    @RequestMapping("/hi")
    public String hello(){
        return "Hello here";
    }

    @GetMapping("/list")
    public List<PerformedCompositionsViewModel> list(){
        var list = performedCompositionRepository.findAll();
        return list.stream().map(obj -> this.mapper.convertPcToView(obj)).collect(Collectors.toList());
    }
    @GetMapping("/compositions")
    public List<CompositionViewModel> getCompositions(){
        var list = compositionRepository.findAll();
        return list.stream().map(obj -> this.mapper.convertCompositionToView(obj)).collect(Collectors.toList());
    }

    @GetMapping("/performers")
    public List<PerformerViewModel> getPerformer(){
        var list = performerRepository.findAll();
        return list.stream().map(obj -> this.mapper.convertPerformerToView(obj)).collect(Collectors.toList());
    }
}
