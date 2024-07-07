package models;

import java.util.ArrayList;
import java.util.List;

public class Building {
    public static final int MAX_FLOORS = 5;
    private final List<Floor> floors;
    private final List<Elevator> elevators;


    public Building(int numFloors, int numElevators) {
        this.floors = new ArrayList<>();
        this.elevators = new ArrayList<>();

        for (int i = 0; i < numFloors; i++) {
            floors.add(new Floor());
        }

        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(this));
        }

    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<Elevator> getElevators() {
        return elevators;
    }


}