package models;

import services.abstracts.Simulatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Floor implements Simulatable {
    private final List<Person> waitingPersons;
    private int leftPersonsCount;


    public Floor() {
        this.waitingPersons = new ArrayList<>();
    }

    @Override
    public void simulate() {
        Random random = new Random();
        int numPersons = random.nextInt(5);

        for (int i = 0; i < numPersons; i++) {
            Person person = new Person(random.nextInt(100));
            person.setWeight(random.nextInt(50) + 50);
            waitingPersons.add(person);
        }

        for (Person person : waitingPersons) {
            person.simulate();
        }

        leftPersonsCount += waitingPersons.stream()
                .filter(person -> person.getPatience() > person
                        .getPatienceLimit()).count();

        waitingPersons.removeIf(person -> person.getPatience() > person.getPatienceLimit());
    }

    public int getLeftPersonsCount() {
        return leftPersonsCount;
    }

    public List<Person> getWaitingPersons() {
        return waitingPersons;
    }

}