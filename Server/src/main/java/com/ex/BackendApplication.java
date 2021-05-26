package com.ex;

import com.ex.pojos.Action;
import com.ex.pojos.Room;
import com.ex.pojos.User;
import com.ex.pojos.items.*;
import com.ex.pojos.player.DnDClass;
import com.ex.pojos.player.PlayerCharacter;
import com.ex.pojos.player.Species;
import com.ex.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
//public class BackendApplication {
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private ActionService actionService;
	@Autowired
	private DnDClassService dnDClassService;
	@Autowired
	private KeyService keyService;
	@Autowired
	private PlayerCharacterService playerCharacterService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private RopeService ropeService;
	@Autowired
	private SpeciesService speciesService;
	@Autowired
	private SpellService spellService;
	@Autowired
	private TorchService torchService;
	@Autowired
	private WeaponService weaponService;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
//		User user = new User("ben", 32);
//		service.save(user);

		//items
		Key key = new Key(null, null, 0);
		keyService.save(key);

		Rope rope = new Rope(null, null, 0);
		ropeService.save(rope);

		Torch torch = new Torch(null, null, null, 0);
		torchService.save(torch);

		//weapons
		Weapon weapon = new Weapon(null, null, null, null, null, null);
		weaponService.save(weapon);

		//spells
		Spell spell = new Spell(null, null, null, null, null);
		spellService.save(spell);

		//DND classes
		DnDClass dnDClass = new DnDClass(null, 0, 0, 0, 0, 0, 0,
				new ArrayList<Weapon>(), new ArrayList<Spell>());
		dnDClassService.save(dnDClass);

		//species
		Species species = new Species(null, 0, 0, 0, 0, 0, 0, 0);
		speciesService.save(species);

		//player characters
		PlayerCharacter playerCharacter = new PlayerCharacter(0, species, dnDClass, 0, 0, 0, 0, 0, 0, new ArrayList<Weapon>(),
				new ArrayList<Spell>(), new ArrayList<Item>(), null, 0);

		//actions
		Action action = new Action(null, false, null, null, new ArrayList<HashMap<Integer,String>>());
		actionService.save(action);

		//rooms
		Room entrance = new Room(new ArrayList<Action>(), null, null, null, "Entrance");
		roomService.save(entrance);
		Room foyar = new Room(new ArrayList<Action>(), null, null, null, "Foyar");
		roomService.save(foyar);
		Room goblinRoom = new Room(new ArrayList<Action>(), null, null, null, "Goblin Room");
		roomService.save(goblinRoom);
		Room spiderNest = new Room(new ArrayList<Action>(), null, null, null, "Spider Nest");
		roomService.save(spiderNest);
		Room treasureTrove = new Room(new ArrayList<Action>(), null, null, null, "Treasure Trove");
		roomService.save(treasureTrove);
	}

}
