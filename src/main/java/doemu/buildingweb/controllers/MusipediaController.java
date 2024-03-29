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
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
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
        var list = performedCompositionRepository.findByOrderByCompositionAsc();
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

    @PostMapping
    @RequestMapping("/addComposition")
    public void addComposition(@RequestBody CompositionViewModel compositionViewModel, BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()){
            throw new ValidationException("Adding error");
        }

        //var entity = mapper.convertViewToComposition(compositionViewModel);//new Composition(compositionViewModel.getName());
        var entity = new Composition(compositionViewModel.getName());
        compositionRepository.save(entity);
    }

    @PostMapping
    @RequestMapping("/saveComposition")
    public void saveComposition(@RequestBody CompositionViewModel compositionViewModel, BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()){
            throw new ValidationException("Adding error");
        }

        var entity = mapper.convertViewToComposition(compositionViewModel);//new Composition(compositionViewModel.getName());
        //var entity = new Composition(compositionViewModel.getName());
        compositionRepository.save(entity);
    }

    @PostMapping
    @RequestMapping("/addPerformer")
    public void addPerformer(@RequestBody PerformerViewModel performerViewModel, BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()){
            throw new ValidationException("Adding error");
        }

        var entity = new Performer(performerViewModel.getName());
        performerRepository.save(entity);
    }

    @PostMapping
    @RequestMapping("/savePerformer")
    public void savePerformer(@RequestBody PerformerViewModel performerViewModel, BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()){
            throw new ValidationException("Adding error");
        }

        var entity = mapper.convertViewToPerformer(performerViewModel);
        //var entity = mapper.convertViewToPerformer(performerViewModel);
        performerRepository.save(entity);
    }

    @DeleteMapping("deleteComposition/{id}")
    public void deleteComposition(@PathVariable long id){
        this.compositionRepository.deleteById(id);
    }

    @DeleteMapping("deletePerformer/{id}")
    public void deletePerformer(@PathVariable long id){
        this.performerRepository.deleteById(id);
    }

    @DeleteMapping("deletePerformedComposition/{id}")
    public void deletePerformedComposition(@PathVariable long id){
        this.performedCompositionRepository.deleteById(id);
    }

    @PostMapping
    @RequestMapping("/createPerformedComposition")
    public void createPerformedComposition(@RequestBody PerformedCompositionsViewModel performedCompositionsViewModel, BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()){
            throw new ValidationException("Adding error");
        }

        PerformedComposition entity;
        /*CompositionViewModel compositionViewModel = new CompositionViewModel(performedCompositionsViewModel.getCompositionName());  //Страшный некрокод, потому что я дурак, ещё и ленивый
        PerformerViewModel performerViewModel = new PerformerViewModel(performedCompositionsViewModel.getPerformerName());*/

        if(compositionRepository.existsByCompositionName(performedCompositionsViewModel.getCompositionName())&&performerRepository.existsByPerformerName(performedCompositionsViewModel.getPerformerName())) {
            entity = new PerformedComposition(
                    compositionRepository.findCompositionByCompositionName(performedCompositionsViewModel.getCompositionName()),
                    performerRepository.findPerformerByPerformerName(performedCompositionsViewModel.getPerformerName())
            );
        }
        else if(!compositionRepository.existsByCompositionName(performedCompositionsViewModel.getCompositionName())&&!performerRepository.existsByPerformerName(performedCompositionsViewModel.getPerformerName())){
            Composition composition = new Composition(performedCompositionsViewModel.getCompositionName());
            Performer performer = new Performer(performedCompositionsViewModel.getPerformerName());
            entity = new PerformedComposition(
                    composition,
                    performer
            );
            compositionRepository.save(composition);
            performerRepository.save(performer);
        }
        else if(compositionRepository.existsByCompositionName(performedCompositionsViewModel.getCompositionName())){
            Performer performer = new Performer(performedCompositionsViewModel.getPerformerName());
            entity = new PerformedComposition(
                    compositionRepository.findCompositionByCompositionName(performedCompositionsViewModel.getCompositionName()),
                    performer
            );
            performerRepository.save(performer);
        }
        else {
            Composition composition = new Composition(performedCompositionsViewModel.getCompositionName());
            entity = new PerformedComposition(
                    composition,
                    performerRepository.findPerformerByPerformerName(performedCompositionsViewModel.getPerformerName())
            );
            compositionRepository.save(composition);
        }
        performedCompositionRepository.save(entity);
    }
    /*@GetMapping("/test/{name}")
    public List<PerformedCompositionsViewModel> test(@PathVariable String name){
        performerRepository.deleteById(name);
        var list = performedCompositionRepository.findAll();
        return list.stream().map(obj -> this.mapper.convertPcToView(obj)).collect(Collectors.toList());
    }

    @GetMapping("/test2")
    public List<PerformedComposition> test2(){
        return performedCompositionRepository.findAll();
    }

    @GetMapping("/add")
    public void add(){
        var comp = compositionRepository.findById("We Will Rock you").orElse(null);
        var per = performerRepository.findById("Queen").orElse(null);
        var ent = new PerformedComposition(comp,per);
        //compositionRepository.save(comp);
        //performerRepository.save(per);
        performedCompositionRepository.save(ent);
    }*/

    /*@PostMapping
    public void addComposition(@RequestBody CompositionViewModel compositionViewModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new
        }
    }*/
}
