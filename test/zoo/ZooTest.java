package zoo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zoo.animals.*;
import zoo.cages.*;

import static org.junit.jupiter.api.Assertions.*;

public class ZooTest {
    private Zoo zoo;
    private LionCage lionCage;
    private HoofedCage hoofedCage;
    private BirdCage birdCage;

    @BeforeEach
    void setup() {
        zoo = new Zoo();
        lionCage = new LionCage(2);
        hoofedCage = new HoofedCage(3);
        birdCage = new BirdCage(2);

        zoo.addCage(lionCage);
        zoo.addCage(hoofedCage);
        zoo.addCage(birdCage);
    }

    @Test
    void testAddAndCountAnimals() {
        lionCage.addAnimal(new Lion("Lion #1"));
        hoofedCage.addAnimal(new Zebra("Zebra #1"));
        hoofedCage.addAnimal(new Giraffe("Giraffe #1"));
        birdCage.addAnimal(new Eagle("Eagle #1"));

        assertEquals(4, zoo.getCountOfAnimals());

        System.out.println("Test 'add and count animals' passed");
    }

    @Test
    void testCageCapacityLimit() {
        lionCage.addAnimal(new Lion("Lion #1"));
        lionCage.addAnimal(new Lion("Lion #2"));

        assertThrows(IllegalStateException.class, () ->
            lionCage.addAnimal(new Lion("Lion #3"))
        );

        System.out.println("Test 'cage capacity limit' passed");
    }

    @Test
    void testRemoveAnimal() {
        Zebra zebra = new Zebra("Zebra #1");
        hoofedCage.addAnimal(zebra);
        hoofedCage.removeAnimal(zebra);

        assertEquals(0, hoofedCage.getOccupiedPlaces());

        System.out.println("Test 'remove animal' passed");
    }

    @Test
    void testRemoveNonexistentAnimalThrows() {
        assertThrows(java.util.NoSuchElementException.class, () ->
            birdCage.removeAnimal(new Eagle("Eagle #0"))
        );

        System.out.println("Test 'remove nonexisting animal' passed");
    }

    @Test
    void testHoofedCageAcceptsBothZebraAndGiraffe() {
        hoofedCage.addAnimal(new Zebra("Zebra #1"));
        hoofedCage.addAnimal(new Giraffe("Giraffe #1"));

        assertEquals(2, hoofedCage.getOccupiedPlaces());

        System.out.println("Test 'hoofed cage' passed");
    }
}
