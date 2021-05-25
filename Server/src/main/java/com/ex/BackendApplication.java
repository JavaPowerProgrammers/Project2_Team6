package com.ex;

import com.ex.pojos.*;
import com.ex.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
//public class BackendApplication {
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private DaggerService daggerService;
	@Autowired
	private AcidArrowService acidArrowService;
	@Autowired
	private DancingLightsService dancingLightsService;
	@Autowired
	private BurningHandsService burningHandsService;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	/*spells/burning-hands
equipment/crossbow-heavy
equipment/potion-of-healing*/
	@Override
	public void run(String... args) throws Exception{
		if(daggerService.getAllDaggers().size() == 0){
			daggerService.save(new Dagger(null, null, null, null, "/equipment/dagger"));
		}
		if(acidArrowService.getAllAcidArrows().size() == 0){
			acidArrowService.save(new AcidArrow(null, null, null, null, "/spells/acid-arrow"));
		}
		if(dancingLightsService.getAllDancingLights().size() == 0){
			dancingLightsService.save(new DancingLights(null, null, "/spells/dancing-lights"));
		}
		if(burningHandsService.getAllBurningHands().size() == 0){
			burningHandsService.save(new BurningHands(null, null, null, null, "/spells/burning-hands"));
		}
	}
}
