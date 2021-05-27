package com.ex;

import com.ex.pojos.Action;
import com.ex.pojos.Creature;
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
import java.util.*;

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
	@Autowired
	private CreatureService creatureService;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
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

		//Creatures
		{
			List<Creature> creatureList = creatureService.getAllCreatures();
			Creature goblin = new Creature(5, "1d4", "Goblin");
			Creature spider = new Creature(10,"1d6", "Spider");
			Creature goblin2 = new Creature(15, "id8", "Goblin Merchant");
			Creature dragon = new Creature(20, "1d10", "Black Dragon Wyrmling");
			if(creatureList.size() == 0){
				creatureService.save(goblin);
				creatureService.save(spider);
				creatureService.save(goblin2);
				creatureService.save(dragon);
			}
		}

		// Player Character
		{
			Species species = speciesService.findByName("Dwarf");
			DnDClass dnDClass = dnDClassService.findByName("Fighter");

			List<PlayerCharacter> playerCharacters = playerCharacterService.getAllPlayerCharacters(); //do the math of character creation in the javascript

			PlayerCharacter playerCharacter = new PlayerCharacter(15 + 2 * (species.getConstitution() + dnDClass.getConstitution()),
					species, dnDClass, species.getDexterity() + dnDClass.getDexterity(),
					species.getStrength() + dnDClass.getStrength(), species.getConstitution() + dnDClass.getConstitution(),
					species.getIntelligence() + dnDClass.getIntelligence(), species.getWisdom() + dnDClass.getWisdom(),
					species.getCharisma() + dnDClass.getCharisma(), dnDClass.getWeapons(), dnDClass.getSpells(), null,
					"Muffin", species.getHidden_Visibility());

			if(playerCharacters.size() == 0){
				playerCharacterService.save(playerCharacter);
			}
		}


		//Entrance
		{
			//Room Description
			String roomDesc = "Before you lies the adventurous dungeon you have chosen. To your left there is a statue that is " +
					"practically unrecognizable. You see tracks in the mud leading into the ivy covered entryway of the dungeon. " +
					"It is a beautiful day outside, but your purpose and dreams of fortune and fame, lie within";


			//List of Actions
			List<List<String>> examineStatueFragments = new ArrayList<>();
			{
				examineStatueFragments.add(Arrays.asList("1", "In front of you stands a marble statue of what appears to be an elven woman wearing robes. It is hard" +
						"to determine who it depicts as it is heavily damaged. You see claw marks ravaging the lower parts and acid " +
						"bubbles on the upper torso. Her left arm seems to have been broken off and lies on the ground next to her. "));
			}
			Action examineStatue = new Action("Examine Statue", false, null, "Examine Statue", examineStatueFragments);

			List<List<String>> examineTrackFragments = new ArrayList<>();
			{
				examineTrackFragments.add(Arrays.asList("1", " Beneath your feet you see a few trails of footprint. They are smaller than your and apear to be of " +
						"goblin origin. They lead both in and out of the curtain of ivy blocking vision into the dungeon, with more " +
						"tracks leading into, than out of. One hopes you are prepared for the invasion of a goblin home. "));
			}
			Action examineTrack = new Action("Examine Tracks", false,null,"Examine Tracks", examineTrackFragments);

			List<List<String>> enterFoyarRoomFragments = new ArrayList<>();
			{
				enterFoyarRoomFragments.add(Arrays.asList("1", " You enter what appears to be a normal cave. You see on the other end, what could generously" +
						"be called a doorway leading to another room. In here, you see a small angry looking goblin, a wooden chest, a strawmat " +
						"with rags that might be called a sheet. Lighting up the whole room, is a torch at eye level near the entryway"));
			}
			Action enterFoyarRoom = new Action("Enter Foyar Room", false, null, "Enter Foyar Room", enterFoyarRoomFragments);//somehow go to next room

			List<Action> actions = new ArrayList<>();//adding the actions to the list of actions
			actions.add(examineStatue);
			actions.add(examineTrack);
			actions.add(enterFoyarRoom);

			//List of Weapons
			List<Weapon> weapons = new ArrayList<>();
//			weapons.add(weaponService.findByName(""));

			//List of Spells
			List<Spell> spells = new ArrayList<>();
//			spells.add(spellService.findByName(""));

			//List of Items
			List<Object> items = new ArrayList<>();
//			items.add(keyService.getAllKeys().get(0));
//			items.add(torchService.getAllTorches().get(0));
//			items.add(ropeService.getAllRopes().get(0));

			//Room Actions Chosen
			List<List<String>> roomActionsChosen = new ArrayList<>();
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(examineStatue.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(examineTrack.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(enterFoyarRoom.getDesc(), "false")));

			Room entrance = new Room("", "", roomDesc, actions, roomActionsChosen, weapons, spells, items,"Foyar", "Entrance");
			if(roomService.findByName("Entrance") == null){
				roomService.save(entrance);
			}
		}

		//Foyar
		{
			//Room Description
			String roomDesc = " You enter what appears to be a normal cave. You see on the other end, what could generously" +
					"be called a doorway leading to another room. In here, you see a small angry looking goblin, a wooden chest, a strawmat " +
					"with rags that might be called a sheet. Lighting up the whole room, is a torch at eye level near the entryway";

			List<List<String>> examineStrawBedFragments = new ArrayList<>();
			{
				examineStrawBedFragments.add(Arrays.asList("1", " You grab the nearby torch on the wall. It is 2feet long with cloth and oil wrapped around one end. " +
					"Unusaully, you also see it doesnt seem to actually burn away the oil and cloth, but rather the flame is burning " +
					"with no visible source of fuel. It still is hot and gives plenty of heat and light for the surrounding area."));
			}
			Action examineStrawBed = new Action("Examine StrawBed", false, null, "Examine StrawBed", examineStrawBedFragments);

			List<List<String>> grabTorchFragments = new ArrayList<>();
			{
				grabTorchFragments.add(Arrays.asList("1", " Beneath your feet you see a few trails of footprint. They are smaller than your and apear to be of " +
						"goblin origin. They lead both in and out of the curtain of ivy blocking vision into the dungeon, with more " +
						"tracks leading into, than out of. One hopes you are prepared for the invasion of a goblin home. "));
			}
			Action grabTorch = new Action("Grab Torch", false,null,"Grab Torch", grabTorchFragments);

			List<List<String>> openChestFragments = new ArrayList<>();
			{
				openChestFragments.add(Arrays.asList("1", " Noticing and avoiding the trap, you are able to open the chest carefully enough to not " +
						"trigger the fireball. Looking inside your see a few desirable items, your first loot of the day. ")); //succ wisdom
				openChestFragments.add(Arrays.asList("2", "Opening the chest carelessly was a mistake. A hidden fireball trap was rigged to the " +
						"inside of the chest. You are hit and take fire damage. Shameful and a poor start to your adventure")); //fail wisdom, fail dex
				openChestFragments.add(Arrays.asList("3", " Despite your careless disregard for your own safety, you fling open the chest and " +
						"narrowly dodge the fireball trap inside. Your close brush with death is offset by the goodies you see in " +
						"front of you. It was worth the risk")); //fail wisdom, succ dex
				//manage dice rolls on frontend
			}
			Action openChest = new Action("Open Chest", false, null, "Open Chest", openChestFragments);

			List<List<String>> attackGoblinFragments = new ArrayList<>();
			{
				attackGoblinFragments.add(Arrays.asList("1", "Before you stands a ugly wretched creature. The foul goblin of the dungeons. Its overly large head," +
						"sharp pointed teeth and small beady eyes shows its disdain for you. It does appear frightened of you, but its" +
						"posture and sharp rusty dagger in its hand betrays its ill intentions towards your phsyical wellbeing. You " +
						"ready your weapons and your mind for the coming fight"));
			}
			Action attackGoblin = new Action("Attack Goblin", false, null, "Attack Goblin", attackGoblinFragments);

			List<List<String>> enterSpiderRoomFragments = new ArrayList<>();
			{
				enterSpiderRoomFragments.add(Arrays.asList("1", " All around you are heavy spiderwebs. " +
					"You see spiderwebs covering almost all the ground, walls and ceilings of the room. " +
					"You can see the entrance to another room across the way, with minimal webs blocking your path. " +
					"The skittering sounds of a giant spider reach your ears and strike fear into your heart. Pherhaps this was " +
					"a bad idea? It is too late however, there is only moving forward. The corpse of a dead humanoid lies on the" +
					"ground wrapped so heavily is spidersilk you are unable to determine who or what it once was."));
				enterSpiderRoomFragments.add(Arrays.asList("2", "js-action[if player visibility < 1, can't go into spider room.]"));
			}
			Action enterSpiderRoom = new Action("Enter Spider Room", false, null, "Enter Spider Room", enterSpiderRoomFragments);

			List<Action> actions = new ArrayList<>();//adding the actions to the list of actions
			actions.add(examineStrawBed);
			actions.add(grabTorch);
			actions.add(openChest);
			actions.add(attackGoblin);
			actions.add(enterSpiderRoom);

			//List of Weapons
			List<Weapon> weapons = new ArrayList<>();
//			weapons.add(weaponService.findByName(""));

			//List of Spells
			List<Spell> spells = new ArrayList<>();
			spells.add(spellService.findByName("Burning Hands"));
			spells.add(spellService.findByName("Potion of healing"));

			//List of Items
			List<Object> items = new ArrayList<>();
			items.add(keyService.getAllKeys().get(0)); // strawbed gives key to player inventory
			items.add(torchService.getAllTorches().get(0));  //player visibility stat +1, add torch to player inventory
//			items.add(ropeService.getAllRopes().get(0));

			//Room Actions Chosen
			List<List<String>> roomActionsChosen = new ArrayList<>();
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(examineStrawBed.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(grabTorch.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(openChest.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(attackGoblin.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(enterSpiderRoom.getDesc(), "false")));

			Room foyar = new Room("", "", roomDesc, actions, roomActionsChosen, weapons, spells, items,"Spider Nest", "Foyar");
			if(roomService.findByName("Foyar") == null){
				roomService.save(foyar);
			}
		}

		//Spider Nest
		{
			//Room Description
			String roomDesc = " This dark room is visbile only due to your innate racial heritage. All around you are heavy spiderwebs. " +
					"You see spiderwebs covering almost all the ground, walls and ceilings of the room. " +
					"You can see the entrance to another room across the way, with minimal webs blocking your path. " +
					"The skittering sounds of a giant spider reach your ears and strike fear into your heart. Pherhaps this was " +
					"a bad idea? It is too late however, there is only moving forward. The corpse of a dead humanoid lies on the" +
					"ground wrapped so heavily is spidersilk you are unable to determine who or what it once was.";

			List<List<String>> lootWebbedBodyFragments = new ArrayList<>();
			{
				lootWebbedBodyFragments.add(Arrays.asList("1", " Lying tussled on the stone floor is the corpse of a humanoid creature of some kind. As you search around" +
					"you realize that it is too tightly wrapped to pull away any of the silk. However, next to the cadaver a scroll" +
					" is just lying there, seeming to beckon you and use it. Along with a fair number of gold coins lying around" +
					"just waiting to be taken by the next adventurer to pass through. You have collected 10 gold coins.")); // drops loot of acid arrow spell and 10 gold
				lootWebbedBodyFragments.add(Arrays.asList("2", "js-action:[add acid arrow to player-inventory/spells.]"));
			}
			Action lootWebbedBody = new Action("Loot Webbed Body", false, null, "Loot Webbed Body", lootWebbedBodyFragments);

			List<List<String>> burnWebbingFragments = new ArrayList<>();
			{
				burnWebbingFragments.add(Arrays.asList("1", " If only you had some flames able to burn these spider webs."));// no torch
				burnWebbingFragments.add(Arrays.asList("2", " The flames from your torch quickly spread throughout the room clearing out most of the webbings." +
						"You hear a screech from the spider, it seems both angered and in pain from your arsonic ways. ")); // yes torch burn the spider, dealing 5 damage));))
			}
			Action burnWebbing = new Action("Burn Webbing", false,null,"Burn Webbing", burnWebbingFragments);

			List<List<String>> attackSpiderFragments = new ArrayList<>();
			{
				attackSpiderFragments.add(Arrays.asList("1", " Stepping lightly upon the webbings is a large spider. No spider should ever reach this size, having " +
					"grown so large it cannot leave this room. Its mandibles click and clatter ")); // enter combat attacking spider
			}
			Action attackSpider = new Action("Attack Spider", false, null, "Attack Spider", attackSpiderFragments);

			List<List<String>> enterGoblinRoomFragments = new ArrayList<>();
			{
				enterGoblinRoomFragments.add(Arrays.asList("1", " This open and spacious cavern is a breath of fresh air after traversing through the spider's home. " +
					"Before you stands a 5ft tall goblin with a large maul in his hands, and a pile of rope at his feet." +
					" He does not seem hostile currently, but " +
					"has his eye on you. Beyond him, you see a 15ft rough cliff that leads to the next room. Perhaps you can talk " +
					"to this goblin and ask him for his rope to assist you, or maybe even his maul. Or you could defeat him and take" +
					"both for yourself, though this may weaken you against future foes. ")); //entering the next room
			}
			Action enterGoblinRoom = new Action("Enter Goblin Room", false, null, "Attack Goblin Room", enterGoblinRoomFragments);

			List<Action> actions = new ArrayList<>();//adding the actions to the list of actions
			actions.add(lootWebbedBody);
			actions.add(burnWebbing);
			actions.add(attackSpider);
			actions.add(enterGoblinRoom);

			//List of Weapons
			List<Weapon> weapons = new ArrayList<>();
//			weapons.add(weaponService.findByName(""));

			//List of Spells
			List<Spell> spells = new ArrayList<>();
			spells.add(spellService.findByName("Acid Arrow"));

			//List of Items
			List<Object> items = new ArrayList<>();
//			items.add(keyService.getAllKeys().get(0));
//			items.add(torchService.getAllTorches().get(0));
//			items.add(ropeService.getAllRopes().get(0));

			//Room Actions Chosen
			List<List<String>> roomActionsChosen = new ArrayList<>();
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(lootWebbedBody.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(burnWebbing.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(attackSpider.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(enterGoblinRoom.getDesc(), "false")));

			Room spiderNest = new Room("", "", roomDesc, actions, roomActionsChosen, weapons, spells, items,"Goblin Room", "Spider Nest");
			if(roomService.findByName("Spider Nest") == null){
				roomService.save(spiderNest);
			}
		}

		//Goblin Room
		{
			//Room Description
			String roomDesc = " This open and spaciaous cavern is a breath of fresh air after traversing through the spider's home. " +
					"Before you stands a 5ft tall goblin with a large maul in his hands, and a pile of rope at his feet." +
					" He does not seem hostile currently, but " +
					"has his eye on you. Beyond him, you see a 15ft rough cliff that leads to the next room. Perhaps you can talk " +
					"to this goblin and ask him for his rope to assist you, or maybe even his maul. Or you could defeat him and take" +
					"both for yourself, though this may weaken you against future foes. ";

			List<List<String>> talkToGoblinFragments = new ArrayList<>();
			{
				talkToGoblinFragments.add(Arrays.asList("1", "Greetings adventurer, Ive got what you need. I assume you plan on climbing up this here cliff and doing " +
					"battle with the dragon in the next room.")); // talk to goblin
				talkToGoblinFragments.add(Arrays.asList("2", "You know, I like you, I really do. You seem like a swell chap. Here, because you obviously cleared " +
						"the roomed behind you. Ill give you this rope for free.")); // dc 15 charisma check pass, player.inventory gets rope.
			}
			Action talkToGoblin = new Action("Talk to Goblin", false, null, "Talk to Goblin", talkToGoblinFragments);

			List<List<String>> attackGoblinFragments = new ArrayList<>();
			{
				attackGoblinFragments.add(Arrays.asList("1", " How dare you attack me traveler. I was here just like you, to loot a forgotten cave. You will pay for " +
					"this treachery. The goblin starts swinging his maul")); // enter combat attacking goblin2
			}
			Action attackGoblin = new Action("Attack Goblin", false,null,"Attack Goblin", attackGoblinFragments);

			List<List<String>> climbCliffFragments = new ArrayList<>();
			{
				//on button click will do a roll d20 + strength +10 if they have a rope v. dc 10.
				//if failure, do fragment 1, and take 1 damage. player health -1. If success, fragment 2 and go to next room.
				climbCliffFragments.add(Arrays.asList("1", " Despite your 'best' efforts, you we only able to climb partway when you fell 10 feet back to" +
						"the ground. You have sprained your ankle and have taken 1 fall damage. Get good noob")); //strength check 10, this is failure
				climbCliffFragments.add(Arrays.asList("2", " Huffing and puffing, you are able to pull yourself over the edge of the stone cliff. YES! You " +
						"knew your times of swinging your sword would be handy in other situations. Carefully looking around, a large " +
						"shiney, pile of gold catches your eye. Laying in a 4 poster bed next to the gold, lays a small Black Dragon" +
						"wyrmling. From where you are, you cannot determine if they dragon is awake or asleep. ")); // this is success
			}
			Action climbCliff = new Action("Climb Cliff", false, null, "Climb Cliff", climbCliffFragments);


			List<Action> actions = new ArrayList<>();//adding the actions to the list of actions
			actions.add(talkToGoblin);
			actions.add(attackGoblin);
			actions.add(climbCliff);

			//List of Weapons
			List<Weapon> weapons = new ArrayList<>();
			weapons.add(weaponService.findByName("Maul"));

			//List of Spells
			List<Spell> spells = new ArrayList<>();
//			spells.add(spellService.findByName("Acid Arrow"));

			//List of Items
			List<Object> items = new ArrayList<>();
//			items.add(keyService.getAllKeys().get(0));
//			items.add(torchService.getAllTorches().get(0));
			items.add(ropeService.getAllRopes().get(0));

			//Room Actions Chosen
			List<List<String>> roomActionsChosen = new ArrayList<>();
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(talkToGoblin.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(attackGoblin.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(climbCliff.getDesc(), "false")));

			Room goblinRoom = new Room("", "", roomDesc, actions, roomActionsChosen, weapons, spells, items,"Treasure Trove", "Goblin Room");
			if(roomService.findByName("Goblin Room") == null){
				roomService.save(goblinRoom);
			}
		}

		//Treasure Trove
		{
			//Room Description
			String roomDesc = " You are able to pull yourself over the edge of the stone cliff. YES!  Carefully looking around, a large " +
				"shiney, pile of gold catches your eye. Laying in a 4 poster bed next to the gold, lays a small Black Dragon" +
				"wyrmling. From where you are, you cannot determine if they dragon is awake or asleep. ";

			List<List<String>> attackDragonFragments = new ArrayList<>();
			{
				attackDragonFragments.add(Arrays.asList("1", "Hissing green acid drips from the fanged maw of this black-scaled, " +
						"horned dragon. As it breaths, acid drips into the bed is lies upon, the smell of burned cloth fills the air. " +
						"As you approach with ill intent, the dragonling flies up and turns to confront you. Your intrusion will not go unpunished."));
			}
			Action attackDragon = new Action("Attack Dragon", false, null, "Attack Dragon", attackDragonFragments);

			List<List<String>> examineGoldPileFragments = new ArrayList<>();
			{
				examineGoldPileFragments.add(Arrays.asList("1", "You see you objective of fortune upon the ground near the bed. " +
						"Gold coins, more than any innkeeper would see in a month lie waiting on the ground. Waiting for you perhaps?"));
			}
			Action examineGoldPile = new Action("Examine Gold Pile", false,null,"Examine Gold Pile", examineGoldPileFragments);

			List<List<String>> lootGoldFragments = new ArrayList<>();
			{
				lootGoldFragments.add(Arrays.asList("1", "Sneaking closer, you grab the gold coins, greedily stuffing them " +
						"into your pockets and bags. The foolish dragon is sleeping, and the sneaky theif gets the gold. You silently laugh to yourself in glee."));
			}
			Action lootGold = new Action("Loot Gold", false, null, "Loot Gold", lootGoldFragments);

			List<List<String>> cantExitFragments = new ArrayList<>();
			{
				cantExitFragments.add(Arrays.asList("1", "Before you lies a green transparent shimmering wall. It appears " +
						"your path is blocked though magic. You see a thin green line connecting the doorway to the dragon. " +
						"It does not seem amused by your attempts to leave with his gold."));  // can't exit happens when you
				//try to leave dungeon and dragon is not dead.
			}
			Action cantExit = new Action("Can't Exit", false, null, "Can't Exit", cantExitFragments);

			List<List<String>> winGameFragments = new ArrayList<>();
			{
				winGameFragments.add(Arrays.asList("1", "You have braved and traveled though the dreaded dungeon. " +
						"Slew beasts, and looted coin. Your gods smile upon you and your just deserts. Fame and fortune be upon you adventurer."));
			}
			Action winGame = new Action("Win Game", false, null, "Win Game", winGameFragments);


			List<Action> actions = new ArrayList<>();//adding the actions to the list of actions
			actions.add(attackDragon);
			actions.add(examineGoldPile);
			actions.add(lootGold);
			actions.add(cantExit);
			actions.add(winGame);

			//List of Weapons
			List<Weapon> weapons = new ArrayList<>();
//			weapons.add(weaponService.findByName("Maul"));

			//List of Spells
			List<Spell> spells = new ArrayList<>();
//			spells.add(spellService.findByName("Acid Arrow"));

			//List of Items
			List<Object> items = new ArrayList<>();
//			items.add(keyService.getAllKeys().get(0));
//			items.add(torchService.getAllTorches().get(0));
//			items.add(ropeService.getAllRopes().get(0));

			//Room Actions Chosen
			List<List<String>> roomActionsChosen = new ArrayList<>();
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(attackDragon.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(examineGoldPile.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(lootGold.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(cantExit.getDesc(), "false")));
			roomActionsChosen.add(new ArrayList<>(Arrays.asList(winGame.getDesc(), "false")));

			Room treasureTrove = new Room("", "", roomDesc, actions, roomActionsChosen, weapons, spells, items,"", "Treasure Trove");
			if(roomService.findByName("Treasure Trove") == null){
				roomService.save(treasureTrove);
			}
		}
	}
}
