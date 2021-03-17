package doemu.buildingweb;

import doemu.buildingweb.entities.Composition;
import doemu.buildingweb.repository.CompositionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BuildingwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingwebApplication.class, args);
    }

    /*@Bean
    CommandLineRunner init(CompositionRepository compositionRepository){
        return args -> {
            Composition comp1 = new Composition("hehe1");
            Composition comp2 = new Composition("hehe2");
            Composition comp3 = new Composition("hehe3");
            compositionRepository.save(comp1);
            compositionRepository.save(comp2);
            compositionRepository.save(comp3);
        };
    }*/
}
