package com.ex;

import com.ex.pojos.items.Weapon;
import com.ex.repositories.WeaponMongoRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeaponMongoRepositoryTest {
    @Autowired
    private WeaponMongoRepository weaponMongoRepository;
    @Before
    public void setUp() throws Exception {
        Weapon weapon1 = new Weapon("Mace", "", "", "", "", "");
        Weapon weapon2 = new Weapon("Maul", "", "", "", "", "");

        //save product, verify has ID value after save
        assertNull(weapon1.getId());
        assertNull(weapon2.getId());//null before save
        this.weaponMongoRepository.save(weapon1);
        this.weaponMongoRepository.save(weapon2);
        assertNotNull(weapon1.getId());
        assertNotNull(weapon2.getId());
    }
    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        Weapon weaponA = weaponMongoRepository.findByName("Mace");
        assertNotNull(weaponA);
        assertEquals("Mace", weaponA.getDamage_dice());
        /*Get all products, list should only have two*/
        Iterable<Weapon> weapons = weaponMongoRepository.findAll();
        int count = 0;
        for(Weapon p : weapons){
            count++;
        }
        assertEquals(count, 2);
    }
    @Test
    public void testDataUpdate(){
        /*Test update*/
        Weapon weaponB = weaponMongoRepository.findByName("Maul");
        weaponB.setDescription("hello world");
        weaponMongoRepository.save(weaponB);
        Weapon weaponC= weaponMongoRepository.findByName("Maul");
        assertNotNull(weaponC);
        assertEquals("hello world", weaponC.getDescription());
    }
    @After
    public void tearDown() throws Exception {
        this.weaponMongoRepository.deleteAll();
    }
}