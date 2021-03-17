package doemu.buildingweb;

import doemu.buildingweb.Views.CompositionViewModel;
import doemu.buildingweb.Views.PerformedCompositionsViewModel;
import doemu.buildingweb.Views.PerformerViewModel;
import doemu.buildingweb.entities.Composition;
import doemu.buildingweb.entities.PerformedComposition;
import doemu.buildingweb.entities.Performer;
import doemu.buildingweb.repository.CompositionRepository;
import doemu.buildingweb.repository.PerformedCompositionRepository;
import doemu.buildingweb.repository.PerformerRepository;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private CompositionRepository compositionRepository;
    private PerformerRepository performerRepository;
    private PerformedCompositionRepository performedCompositionRepository;

    public Mapper(CompositionRepository compositionRepository, PerformerRepository performerRepository, PerformedCompositionRepository performedCompositionRepository) {
        this.compositionRepository = compositionRepository;
        this.performerRepository = performerRepository;
        this.performedCompositionRepository = performedCompositionRepository;
    }

    public Composition convertViewToComposition(CompositionViewModel view){
        return new Composition(view.getName());
    }

    public CompositionViewModel convertCompositionToView(Composition composition){
        var view = new CompositionViewModel();
        view.setName(composition.getCompositionName());
        return view;
    }

    public Performer convertViewToPerformer(PerformerViewModel view){
        return new Performer(view.getName());
    }

    public PerformerViewModel convertPerformerToView(Performer performer){
        var view = new PerformerViewModel();
        view.setName(performer.getPerformerName());
        return view;
    }

    public PerformedComposition convertViewToPc(PerformedCompositionsViewModel view){
        return new PerformedComposition(view.getCompositionName(), view.getPerformerName());
    }

    public PerformedCompositionsViewModel convertPcToView(PerformedComposition pc){
        var view = new PerformedCompositionsViewModel();
        view.setPerformerName(pc.getPerformerName());
        view.setCompositionName(pc.getCompositionName());
        return view;
    }
}
