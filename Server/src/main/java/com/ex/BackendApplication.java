package com.ex;

import com.ex.pojos.Action;
import com.ex.pojos.Room;
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
		//items
		List<Key> keys = keyService.getAllKeys();
		Key key = new Key(null, null, 0);

		if(keys.size() == 0){
			keyService.save(key);
		}

		List<Rope> ropes = ropeService.getAllRopes();
		Rope rope = new Rope(null, null, 0);

		if(ropes.size() == 0){
			ropeService.save(rope);
		}

		List<Torch> torches = torchService.getAllTorches();
		Torch torch = new Torch(null, null, null, 0);

		if(torches.size() == 0){
			torchService.save(torch);
		}

		//weapons
		List<Weapon> weapons = weaponService.getAllWeapons();

		Weapon weapon = new Weapon(null, null, null, null, null, null);

		if(weapons.size() == 0){
			weaponService.save(weapon);
		}

		//spells
		List<Spell> spells = spellService.getAllSpells();

		Spell spell = new Spell(null, null, null, null, null);

		if(spells.size() == 0){
			spellService.save(spell);
		}

		//DND classes
		List<DnDClass> dnDClasses = dnDClassService.getAllDnDClasses();

		DnDClass dnDClass = new DnDClass(null, 0, 0, 0, 0, 0, 0,
				new ArrayList<Weapon>(), new ArrayList<Spell>());

		if(dnDClasses.size() == 0){
			dnDClassService.save(dnDClass);
		}

		//species
		List<Species> speciesList = speciesService.getAllSpecies();

		Species species = new Species(null, 0, 0, 0, 0, 0, 0, 0);

		if(speciesList.size() == 0){
			speciesService.save(species);
		}

		//player characters
		List<PlayerCharacter> playerCharacters = playerCharacterService.getAllPlayerCharacters();

		PlayerCharacter playerCharacter = new PlayerCharacter(0, species, dnDClass, 0, 0, 0, 0, 0, 0, new ArrayList<Weapon>(),
				new ArrayList<Spell>(), new ArrayList<Item>(), null, 0);

		if(playerCharacters.size() == 0){
			playerCharacterService.save(playerCharacter);
		}

		//actions
		List<Action> actions = actionService.getAllActions();

		Action action = new Action(null, false, null, null, new ArrayList<HashMap<Integer,String>>());

		if(actions.size() == 0){
			actionService.save(action);
		}

		//rooms
		List<Room> rooms = roomService.getAllRooms();

		Room entrance = new Room(new ArrayList<Action>(), null, null, null, "Entrance");
		Room foyar = new Room(new ArrayList<Action>(), null, null, null, "Foyar");
		Room goblinRoom = new Room(new ArrayList<Action>(), null, null, null, "Goblin Room");
		Room spiderNest = new Room(new ArrayList<Action>(), null, null, null, "Spider Nest");
		Room treasureTrove = new Room(new ArrayList<Action>(), null, null, null, "Treasure Trove");

		if(rooms.size() == 0){
			roomService.save(entrance);
			roomService.save(foyar);
			roomService.save(goblinRoom);
			roomService.save(spiderNest);
			roomService.save(treasureTrove);
		}
	}

}
