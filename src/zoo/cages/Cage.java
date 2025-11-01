package zoo.cages;

import zoo.animals.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class Cage<T extends Animal> {
    private final int maxCapacity;
    private final List<T> animals = new ArrayList<>();

    protected Cage(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getOccupiedPlaces() {
        return animals.size();
    }

    public void addAnimal(T animal) {
        if (animals.size() >= maxCapacity) {
            throw new IllegalStateException("Cage is full! Cannot add " + animal);
        }
        animals.add(animal);
    }

    public void removeAnimal(T animal) {
        if (!animals.remove(animal)) {
            throw new NoSuchElementException("Animal not found in cage: " + animal);
        }
    }

    public List<T> getAnimals() {
        return new ArrayList<>(animals);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + animals.size() + "/" + maxCapacity + "]";
    }
}
