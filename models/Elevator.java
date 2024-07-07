package models;

import services.abstracts.Simulatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Elevator implements Simulatable {
    private final Building building;
    private int currentFloor;
    private int direction;
    private final int capacity = 20;
    private final int weightCapacity = 2000;
    private final List<Person> passengers;
    private int passengerCount = 0;
    private int floorCount;
    private double totalWeight;
    private int totalWaitTime = 0;
    private int waitCount = 0;


    public Elevator(Building building) {
        this.passengers = new ArrayList<>();
        this.direction = 1;
        this.building = building;
        this.passengerCount = 0;
        this.floorCount = 0;
        this.totalWeight = 0;
    }

    @Override
    public void simulate() {
        move();

        Floor currentFloorObject = building.getFloors().get(currentFloor);
        pickUpPassengers(currentFloorObject);

        dropOffPassengers(currentFloor);

        floorCount++;

        totalWeight = getTotalWeight();


        Random random = new Random();
        int waitTime = random.nextInt(2) + 1;
        totalWaitTime += waitTime;
        waitCount++;

    }

    public double getAverageWaitTime() {
        return waitCount == 0 ? 0 : (double) totalWaitTime / waitCount;
    }

    public void move() {

        if (currentFloor == Building.MAX_FLOORS - 1) {
            direction = -1;
        } else if (currentFloor == 0) {
            direction = 1;
        }

        currentFloor += direction;

        dropOffPassengers(currentFloor);

        Floor currentFloorObject = building.getFloors().get(currentFloor);
        pickUpPassengers(currentFloorObject);
    }

    public void pickUpPassengers(Floor floor) {
        List<Person> waitingPersons = floor.getWaitingPersons();
        for (Person person : waitingPersons) {
            if (passengerCount < capacity) {
                passengers.add(person);
                passengerCount++;
            } else {
                break;
            }
        }
        waitingPersons.removeAll(passengers);
    }

    public void dropOffPassengers(int currentFloor) {
        passengers.removeIf(person -> person.getDestinationFloor() == currentFloor);
        passengerCount = passengers.size();
    }

    public double getTotalWeight() {
        totalWeight = 0;
        for (Person person : passengers) {
            totalWeight += person.getWeight();
        }
        return passengers.isEmpty() ? 0 : totalWeight / passengers.size();
    }

    public int getFloorCount() {
        return floorCount;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public List<Person> getPassengers() {
        return passengers;
    }

}
