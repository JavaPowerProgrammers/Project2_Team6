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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		Room room = new Room();
		Map<Integer, String> theMap =  new HashMap<>();
		theMap.put(1, "You found a skull");
		List<Map<Integer, String>> fragments = new ArrayList<Map<Integer, String>>();
		fragments.add(theMap);
		//new Action()
		Action action = new Action("Look at Skull.", false, "/path/to/img", "", fragments);

		List<Action> actions = room.getActions();
		for(Action a: actions)
			a.getDesc();
			a.getActionFragments().get(0);
		}
		//items
		{
			List<Key> keys = keyService.getAllKeys();
			Key key = new Key("Key", "This key can open any lock your heart desires...as long as its that chest" +
					"over there. ");

			if(keys.size() == 0){
				keyService.save(key);
			}
		}

		{
			List<Rope> ropes = ropeService.getAllRopes();
			Rope rope = new Rope("Rope", "This smooth silky rope feels nice on your skin. You wonder what other" +
					"uses it might have beyond climbing cliffs.");

			if(ropes.size() == 0){
				ropeService.save(rope);
			}
		}

		{
			List<Torch> torches = torchService.getAllTorches();
			Torch torch = new Torch("Torch", " This brightly lit torch illuminates the entire room you are in. As a Flameable object, " +
					"it can burn highly flammable substances", 1);

			if(torches.size() == 0){
				torchService.save(torch);
			}
		}

		{
			//weapons
			List<Weapon> weapons = weaponService.getAllWeapons();
			Weapon daggerWeapon = new Weapon("Dagger", null, null, null, null, "/equipment/dagger");
			Weapon maceWeapon = new Weapon("Mace", null, null, null, null, "/equipment/mace");
			Weapon longswordWeapon = new Weapon("Longsword", null, null, null, null, "/equipment/longsword");
			Weapon heavycrossbowWeapon = new Weapon("Heavy-Crossbow", "Piercing", "Piercing", null, null, "/equipment/crossbow-heavy");
			Weapon maulWeapon = new Weapon("Maul", null, "Bludgeoning", null, null, "/equipment/maul");

			if(weapons.size() == 0){
				weaponService.save(daggerWeapon);
				weaponService.save(maceWeapon);
				weaponService.save(longswordWeapon);
				weaponService.save(heavycrossbowWeapon);
				weaponService.save(maulWeapon);
			}
		}
		{
			//spells
			List<Spell> spells = spellService.getAllSpells();

			Spell acidarrow = new Spell("Acid-arrow", null, null, null, "/spells/acid-arrow");
			Spell dancingLights = new Spell("Dancing-lights", null, null, null, "/spells/dancing-lights");
			Spell burningHands = new Spell("Burning-hands", null, null, null, "/spells/burning-hands");
			Spell magicMissile = new Spell("Magic-missile", null, null, null, "/spells/magic-missile");

			if(spells.size() == 0){
				spellService.save(acidarrow);
				spellService.save(dancingLights);
				spellService.save(burningHands);
				spellService.save(magicMissile);
			}
		}
		{
			//DND classes
			List<DnDClass> dnDClasses = dnDClassService.getAllDnDClasses();
			// Fighter weapon
			List<Weapon> fighterWeapons = new ArrayList<>();
			fighterWeapons.add(weaponService.findByName("Longsword"));
			fighterWeapons.add(weaponService.findByName("Mace"));
//		DnDClass dnDClass = new DnDClass(null, 0, 0, 0, 0, 0, 0,
//				new ArrayList<Weapon>(), new ArrayList<Spell>());
			DnDClass fighterClass = new DnDClass("Fighter", 3, 3, 3, 1, 1, 1, fighterWeapons, null);
			//Wizard weapon
			List<Weapon> wizardWeapons = new ArrayList<>();
			wizardWeapons.add(weaponService.findByName("Dagger"));
			//Wizard spells
			List<Spell> wizardSpells = new ArrayList<>();
			wizardSpells.add(spellService.findByName("Magic-missile"));
			wizardSpells.add(spellService.findByName("Dancing-lights"));
			wizardSpells.add(spellService.findByName("Burning-hands"));


			DnDClass wizardClass = new DnDClass("Wizard", 2, 1, 1, 4, 2, 2,
					wizardWeapons, wizardSpells);


			List<Weapon> rogueWeapons = new ArrayList<>();
			rogueWeapons.add(weaponService.findByName("Dagger"));
			DnDClass rogueClass = new DnDClass("Rogue", 4, 2, 1, 2, 1, 2, rogueWeapons, null);

			if(dnDClasses.size() == 0){
				dnDClassService.save(wizardClass);
				dnDClassService.save(fighterClass);
				dnDClassService.save(rogueClass);
			}
		}

		{
			//species
			List<Species> speciesList = speciesService.getAllSpecies();

			//Species species = new Species(null, 0, 0, 0, 0, 0, 0, 0);
			Species elfRace = new Species("Elf", 4, 1, 1, 3, 2, 1, 1);
			Species dwarfRace = new Species("Dwarf", 1, 3, 3, 1, 3, 1, 1);
			Species humanRace = new Species("Human", 2, 2, 2, 2, 2, 2, 0);
			if(speciesList.size() == 0){
				speciesService.save(elfRace);
				speciesService.save(dwarfRace);
				speciesService.save(humanRace);
			}
		}


		//player characters
//		List<PlayerCharacter> playerCharacters = playerCharacterService.getAllPlayerCharacters();
// do the math of character creation in the javascript
//		PlayerCharacter playerCharacter = new PlayerCharacter(0, species, dnDClass, 0, 0, 0, 0, 0, 0,
//				new ArrayList<Weapon>(), new ArrayList<Spell>(), new ArrayList<Item>(), null, 0);
//
//		if(playerCharacters.size() == 0){
//			playerCharacterService.save(playerCharacter);
//		}

//		currentMiniDisplay:null,
//				roomBGImage:null,
//				roomDesc:"You've Come Across A Mysterious Dark Room Filled With Cobb-Webs And See A Giant Mother Spider On The Wall... What Do You Do? ",
//				roomActionsDesc:["Attack Spider.","Examine Dead Body In The Corner.","Open Chest.","Pick Up Torch From Ground.", "Go Into Goblin Room."],
//		roomActionsImgs:["res/gifs/creatures/spider.gif","res/imgs/other/bonepile.png","res/gifs/other/chest.gif","res/gifs/items/torch.gif","res/imgs/other/door.png"],
//		roomActionsChosen:{
//			"Attack Spider.":false,
//					"Examine Dead Body In The Corner.":false,
//					"Open Chest.":false,
//					"Pick Up Torch From Ground.":false,
//					"Go Into Goblin Room.":false
//		},
//		roomActionsLogic:{
//			"Attack Spider." : [],
//			"Examine Dead Body In The Corner." : [ [1,"You found a skull"]], //Found a torch!!! Found A Weird Book... Now Im suddenly feeling smarter...
//			"Open Chest." : [],
//			"Pick Up Torch From Ground.":[[1,"Wow! You picked up a torch, COOLL"]],
//			"Go Into Goblin Room.":[]
//		},
//		roomNext: "foyar",
		//actions
		//Action action = new Action(String desc, boolean selected, String image, String name, List<Map<Integer, String>> actionFragments);

		//Entrance
		{
			String desc = "";

			List<Map<Integer, String>> fragments = new ArrayList<Map<Integer, String>>();
			Map<Integer, String> theMap = new HashMap<>();// string descriptions
			theMap.put(0,"Before you lies the adventurous dungeon you have chosen. To your left there is a statue that is " +
					"practically unrecognizable. You see tracks in the mud leading into the ivy covered entryway of the dungeon. " +
					"It is a beautiful day outside, but your purpose and dreams of fortune and fame, lie within");
			theMap.put(1, "In front of you stands a marble statue of what appears to be an elven woman wearing robes. It is hard" +
					"to determine who it depicts as it is heavily damaged. You see claw marks ravaging the lower parts and acid " +
					"bubbles on the upper torso. Her left arm seems to have been broken off and lies on the ground next to her. ");
			theMap.put(2, " Beneath your feet you see a few trails of footprint. They are smaller than your and apear to be of " +
					"goblin origin. They lead both in and out of the curtain of ivy blocking vision into the dungeon, with more " +
					"tracks leading into, than out of. One hopes you are prepared for the invasion of a goblin home. ");
			theMap.put(3, " You enter what appears to be a normal cave. You see on the other end, what could generously" +
					"be called a doorway leading to another room. In here, you see a small angry looking goblin, a wooden chest, a strawmat " +
					"with rags that might be called a sheet. Lighting up the whole room, is a torch at eye level near the entryway");
			fragments.add(theMap);
			Action examineStatue = new Action(theMap.get(1), false, null, "Examine Statue", fragments);//this needs an image
			Action examineTrack = new Action(theMap.get(2), false,null,"Examine Tracks", fragments);
			Action enterFoyarRoom = new Action(theMap.get(3), false, null, "Enter Foyar Room", fragments);//somehow go to next room

			List<Action> actions = new ArrayList<>();//adding the actions to the list of actions
			actions.add(examineStatue);
			actions.add(examineTrack);
			actions.add(enterFoyarRoom);

			// THe below manages all weapons, spells, and msic items
			List<Weapon> weapons = weaponService.getAllWeapons();
			for(Weapon w: weapons){
				//some filtering
			}
			List<Spell> spells = spellService.getAllSpells();
			for(Spell s: spells){
				//filter
			}
			List<Object> items = new ArrayList<>();
			items.add(keyService.getAllKeys().get(0));
			items.add(torchService.getAllTorches().get(0));
			items.add(ropeService.getAllRopes().get(0));

			//Map<String, Boolean> theMap = new HashMap<>();
			//theMap.put
			List<Map<String, Boolean>> rmActChose = new ArrayList<Map<String, Boolean>>();



			Room entrance = new Room()
		}

		//Foyar
		{
			String desc = "";

			List<Map<Integer, String>> fragments = new ArrayList<Map<Integer, String>>();
			Map<Integer, String> theMap = new HashMap<>();// string descriptions
			theMap.put(0," You enter what appears to be a normal cave. You see on the other end, what could generously" +
					"be called a doorway leading to another room. In here, you see a small angry looking goblin, a wooden chest, a strawmat " +
					"with rags that might be called a sheet. Lighting up the whole room, is a torch at eye level near the entryway");
			theMap.put(1, " You grab the nearby torch on the wall. It is 2feet long with cloth and oil wrapped around one end. " +
					"Unusaully, you also see it doesnt seem to actually burn away the oil and cloth, but rather the flame is burning " +
					"with no visible source of fuel. It still is hot and gives plenty of heat and light for the surrounding area.");
			theMap.put(2, " Beneath your feet you see a few trails of footprint. They are smaller than your and apear to be of " +
					"goblin origin. They lead both in and out of the curtain of ivy blocking vision into the dungeon, with more " +
					"tracks leading into, than out of. One hopes you are prepared for the invasion of a goblin home. ");
			theMap.put(3, " Noticing and avoiding the trap, you are able to open the chest carefully enough to not " +
					"trigger the fireball. Looking inside your see a few desirable items, your first loot of the day. ");//succ wisdom
			theMap.put(4, "Opening the chest carelessly was a mistake. A hidden fireball trap was rigged to the " +
					"inside of the chest. You are hit and take fire damage. Shameful and a poor start to your advenure");//fail wisdom, fail dex
			theMap.put(5, " Despite your careless disregard for your own safety, you fling open the chest and " +
					"narrowly dodge the fireball trap inside. Your close brush with death is offset by the goodies you see in " +
					"front of you. It was worth the risk");//fail wisdom, succ dex
			theMap.put(6, "You see a 3ft wide 2ft high wooden chest sitting against a nearby wall");// just looking at chest might not be used?
			theMap.put(7," Before you stands a ugly wretched creature. The foul goblin of the dungeons. Its overly large head," +
					"sharp pointed teeth and small beady eyes shows its distain for you. It does appear frightened of you, but its" +
					"posture and sharp rusty dagger in its hand betrays its ill intentions towards your phsyical wellbeing. You " +
					"ready your weapons and your mind for the coming fight");
			theMap.put(8, " This dark room is visbile only due to your innate racial heritage. All around you are heavy spiderwebs. " +
					"You see spiderwebs covering almost all the ground, walls and ceilings of the room. " +
					"You can see the entrance to another room across the way, with minimal webs blocking your path. " +
					"The skittering sounds of a giant spider reach your ears and strike fear into your heart. Pherhaps this was " +
					"a bad idea? It is too late however, there is only moving forward. The corpse of a dead humanoid lies on the" +
					"ground wrapped so heavily is spidersilk you are unable to determine who or what it once was.");
			fragments.add(theMap);
			Action examineSrawBed = new Action(theMap.get(1), false, null, "Examine Strawbed", fragments);
			Action grabTorch = new Action(theMap.get(2), false,null,"Grab Torch", fragments);// add +1 torch object to the player along with +1 visibility to his stats
			Action openChest = new Action(theMap.get(6), false, null, "Open Chest", fragments);//no matter what happens, access to 30gold, spell burning hands, potion of healing
			Action attackGoblin = new Action(theMap.get(7), false, null, "Attack Goblin", fragments);//open combat system with goblin
			Action enterSpiderRoom = new Action(theMap.get(8), false, null, "Enter Spider Room", fragments);


			List<Action> actions = new ArrayList<>();//adding the actions to the list of actions
			actions.add(examineSrawBed);
			actions.add(grabTorch);
			actions.add(openChest);
			actions.add(attackGoblin);
			actions.add(enterSpiderRoom);

		}
		//spider room
		{
			String desc = "";

			List<Map<Integer, String>> fragments = new ArrayList<Map<Integer, String>>();
			Map<Integer, String> theMap = new HashMap<>();// string descriptions
			theMap.put(0," This dark room is visbile only due to your innate racial heritage. All around you are heavy spiderwebs. " +
					"You see spiderwebs covering almost all the ground, walls and ceilings of the room. " +
					"You can see the entrance to another room across the way, with minimal webs blocking your path. " +
					"The skittering sounds of a giant spider reach your ears and strike fear into your heart. Pherhaps this was " +
					"a bad idea? It is too late however, there is only moving forward. The corpse of a dead humanoid lies on the" +
					"ground wrapped so heavily is spidersilk you are unable to determine who or what it once was.");
			theMap.put(1, " Lying tussled on the stone floor is the corpse of a humonoid creature of some kind. As you search around" +
					"you realize that it is too tightly wrapped to pull away any of the silk. However, next to the cadaver a scroll" +
					" is just lying there, seeming to beckon you and use it. Along with a fair number of gold coins lying around" +
					"just waiting to be taken by the next adventurer to pass through. ");// drops loot of acid arrow spell and 10 gold
			theMap.put(2, " If only you had some flames able to burn these spider webs.");// no torch
			theMap.put(3, " The flames from your torch quickly spread throughout the room clearing out most of the webbings." +
					"You hear a screech from the spider, it seems both angered and in pain from your arsonic ways. ");// yes torch burn the spider, dealing 5 damage
			theMap.put(4, " Stepping lightly upon the webbings is a large spider. No spider should ever reach this size, having " +
					"grown so large it cannot leave this room. Its mandibles click and clatter ");// enter combat attacking spider
			theMap.put(5, " This open and spaciaous cavern is a breath of fresh air after traversing through the spider's home. " +
					"Before you stands a 5ft tall goblin with a large maul in his hands, and a pile of rope at his feet." +
					" He does not seem hostile currently, but " +
					"has his eye on you. Beyond him, you see a 15ft rough cliff that leads to the next room. Perhaps you can talk " +
					"to this goblin and ask him for his rope to assist you, or maybe even his maul. Or you could defeat him and take" +
					"both for yourself, though this may weaken you against future foes. ");//entering the next room
			fragments.add(theMap);
			Action lootWebbedBody = new Action(theMap.get(1), false, null, "Loot Webbed Body", fragments);
			Action burnWebbing = new Action(theMap.get(2), false,null,"Burn Webbing", fragments);// Check inventory for torch, if yes, spider takes 5 damage
			Action attackSpider = new Action(theMap.get(4), false, null, "Attack Spider", fragments);// enter combat with spider
			Action enterGoblinRoom = new Action(theMap.get(5), false, null, "Enter Goblin Room", fragments);//move out into next room

			List<Action> actions = new ArrayList<>();//adding the actions to the list of actions
			actions.add(lootWebbedBody);
			actions.add(burnWebbing);
			actions.add(attackSpider);
			actions.add(enterGoblinRoom);



		}

		//Goblin Room
		{
			String desc = "";

			List<Map<Integer, String>> fragments = new ArrayList<Map<Integer, String>>();
			Map<Integer, String> theMap = new HashMap<>();// string descriptions
			theMap.put(0," This open and spaciaous cavern is a breath of fresh air after traversing through the spider's home. " +
					"Before you stands a 5ft tall goblin with a large maul in his hands, and a pile of rope at his feet." +
					" He does not seem hostile currently, but " +
					"has his eye on you. Beyond him, you see a 15ft rough cliff that leads to the next room. Perhaps you can talk " +
					"to this goblin and ask him for his rope to assist you, or maybe even his maul. Or you could defeat him and take" +
					"both for yourself, though this may weaken you against future foes. ");
			theMap.put(1, "Greetings adventurer, Ive got what you need. I assume you plan on climbing up this here cliff and doing " +
					"battle with the dragon in the next room. How about this, you give me 10 gold, and ill sell you this here rope. " +
					"If you trade me your weapon, ill give you my maul. ");// talk to goblin
			theMap.put(2, " Wise choice, I am sure you wont regret it");// deal is made
			theMap.put(3, "You know, I like you, I really do. You seem like a swell chap. Here, because you obviously cleared " +
					"the roomed behind you. Ill give you this rope for free. If you want this maul, youll have to trade me your weapon. Fair is fair. " +
					"hurry up now, time is money.");// talk to goblin, high charisma check
			theMap.put(4, " How dare you attack me traveler. I was here just like you, to loot a forgotten cave. You will pay for " +
					"this treachery. The goblin starts swinging his maul");// enter combat attacking goblin2
			theMap.put(5, " Despite your 'best' efforts, you we only able to climb partway when you fell 10 feet back to" +
					"the ground. You have sprained your ankle and have taken 1 fall damage. Get good noob");//strength check 10, this is failure
			theMap.put(6, " Huffing and puffing, you are able to pull yourself over the edge of the stone cliff. YES! You " +
					"knew your times of swinging your sword would be handy in other situations. Carefully looking around, a large " +
					"shiney, pile of gold catches your eye. Laying in a 4 poster bed next to the gold, lays a small Black Dragon" +
					"wyrmling. From where you are, you cannot determine if they dragon is awake or asleep. ");// this is succcess
			fragments.add(theMap);
			Action talkToGoblin = new Action(theMap.get(1), false, null, "Talk to Goblin", fragments);// charisma check DC 15, succes means chat 3, failure means chat 1,
			Action attackGoblin = new Action(theMap.get(2), false,null,"Attack Goblin", fragments);//  enter combat with goblin
			Action climbCliff = new Action(theMap.get(4), false, null, "Climb the Cliff", fragments);// enter combat with spider

			List<Action> actions = new ArrayList<>();//adding the actions to the list of actions
			actions.add(talkToGoblin);
			actions.add(attackGoblin);
			actions.add(climbCliff);


		}
		//Treasure Trove room
		{
			String desc = "";

			List<Map<Integer, String>> fragments = new ArrayList<Map<Integer, String>>();
			Map<Integer, String> theMap = new HashMap<>();// string descriptions
			theMap.put(0," This dark room is visbile only due to your innate racial heritage. All around you are heavy spiderwebs. " +
					"You see spiderwebs covering almost all the ground, walls and ceilings of the room. " +
					"You can see the entrance to another room across the way, with minimal webs blocking your path. " +
					"The skittering sounds of a giant spider reach your ears and strike fear into your heart. Pherhaps this was " +
					"a bad idea? It is too late however, there is only moving forward. The corpse of a dead humanoid lies on the" +
					"ground wrapped so heavily is spidersilk you are unable to determine who or what it once was.");
			theMap.put(1, " Lying tussled on the stone floor is the corpse of a humonoid creature of some kind. As you search around" +
					"you realize that it is too tightly wrapped to pull away any of the silk. However, next to the cadaver a scroll" +
					" is just lying there, seeming to beckon you and use it. Along with a fair number of gold coins lying around" +
					"just waiting to be taken by the next adventurer to pass through. ");// drops loot of acid arrow spell and 10 gold
			theMap.put(2, " If only you had some flames able to burn these spider webs.");// no torch
			theMap.put(3, " The flames from your torch quickly spread throughout the room clearing out most of the webbings." +
					"You hear a screech from the spider, it seems both angered and in pain from your arsonic ways. ");// yes torch burn the spider, dealing 5 damage
			theMap.put(4, " Stepping lightly upon the webbings is a large spider. No spider should ever reach this size, having " +
					"grown so large it cannot leave this room. Its mandibles click and clatter ");// enter combat attacking spider
			theMap.put(5, " This open and spaciaous cavern is a breath of fresh air after traversing through the spider's home. " +
					"Before you stands a 5ft tall goblin with a large maul in his hands, and a pile of rope at his feet." +
					" He does not seem hostile currently, but " +
					"has his eye on you. Beyond him, you see a 15ft rough cliff that leads to the next room. Perhaps you can talk " +
					"to this goblin and ask him for his rope to assist you, or maybe even his maul. Or you could defeat him and take" +
					"both for yourself, though this may weaken you against future foes. ");//entering the next room
			fragments.add(theMap);
			Action lootWebbedBody = new Action(theMap.get(1), false, null, "Loot Webbed Body", fragments);
			Action burnWebbing = new Action(theMap.get(2), false,null,"Burn Webbing", fragments);// Check inventory for torch, if yes, spider takes 5 damage
			Action attackSpider = new Action(theMap.get(4), false, null, "Attack Spider", fragments);// enter combat with spider
			Action enterGoblinRoom = new Action(theMap.get(5), false, null, "Enter Goblin Room", fragments);//move out into next room

			List<Action> actions = new ArrayList<>();//adding the actions to the list of actions
			actions.add(lootWebbedBody);
			actions.add(burnWebbing);
			actions.add(attackSpider);
			actions.add(enterGoblinRoom);
		}





		if(actions.size() == 0){
			actionService.save(action);
		}

		//rooms
		List<Room> rooms = roomService.getAllRooms();
		String entranceDesc = "Before you lies the adventurous dungeon you have chosen. To your left there is a statue that is " +
				"practically unrecognizable. You see tracks in the mud leading into the ivy covered entryway of the dungeon. " +
				"It is a beautiful day outside, but your purpose and dreams of fortune and fame, lie within";
		String foyarDesc = " You enter what appears to be a normal cave. You see on the other end, what could generously" +
				"be called a doorway leading to another room. In here, you see a small angry looking goblin, a wooden chest, a strawmat " +
				"with rags that might be called a sheet. Lighting up the whole room, is a torch at eye level near the entryway";
		String spiderroomDesc = " This dark room is ominously dim, filling you with dread. All around you are heavy spiderwebs. " +
				"You see spiderwebs covering almost all the ground, walls and ceilings of the room. " +
				"You can see the entrance to another room across the way, with minimal webs blocking your path. " +
				"The skittering sounds of a giant spider reach your ears and strike fear into your heart. Pherhaps this was " +
				"a bad idea? It is too late however, there is only moving forward. The corpse of a dead humanoid lies on the" +
				"ground wrapped so heavily is spidersilk you are unable to determine who or what it once was.";
		String goblinroomDesc = " This open and spaciaous cavern is a breath of fresh air after traversing through the spider's home. " +
				"Before you stands a 5ft tall goblin with a large maul in his hands, and a pile of rope at his feet." +
				" He does not seem hostile currently, but " +
				"has his eye on you. Beyond him, you see a 15ft rough cliff that leads to the next room. Perhaps you can talk " +
				"to this goblin and ask him for his rope to assist you, or maybe even his maul. Or you could defeat him and take" +
				"both for yourself, though this may weaken you against future foes. ";
		String treasureroomesc = " Huffing and puffing, you are able to pull yourself over the edge of the stone cliff. YES! You " +
				"knew your times of swinging your sword would be handy in other situations. Carefully looking around, a large " +
				"shiney, pile of gold catches your eye. Laying in a 4 poster bed next to the gold, lays a small Black Dragon" +
				"wyrmling. From where you are, you cannot determine if they dragon is awake or asleep. ";





		Room entrance = new Room(new ArrayList<Action>(), "Foyar", null, entranceDesc, "Entrance");
		Room foyar = new Room(new ArrayList<Action>(), "Spider Nest", null, foyarDesc, "Foyar");
		Room goblinRoom = new Room(new ArrayList<Action>(), "Treasure Trove", null, goblinroomDesc, "Goblin Room");
		Room spiderNest = new Room(new ArrayList<Action>(), "Goblin Room", null, spiderroomDesc, "Spider Nest");
		Room treasureTrove = new Room(new ArrayList<Action>(), null, null, treasureroomesc, "Treasure Trove");//the next room is end of game

		if(rooms.size() == 0){
			roomService.save(entrance);
			roomService.save(foyar);
			roomService.save(goblinRoom);
			roomService.save(spiderNest);
			roomService.save(treasureTrove);
		}
	}

}
