package services.concretes;

import models.Building;

public class SystemVisualizer {
    public void display(Building building) {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------");

        System.out.printf("%-10s %-20s %-20s%n", "Floor", "Waiting Persons", "Left Persons");
        for (int i = 0; i < building.getFloors().size(); i++) {
            System.out.printf("%-10d %-20d %-20d%n", i, building.getFloors().get(i).getWaitingPersons().size(), building.getFloors().get(i).getLeftPersonsCount());
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------");

        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n", "Elevator", "Passengers", "Current Floor", "Floor Count", "Total Weight", "Average Wait Time");
        for (int i = 0; i < building.getElevators().size(); i++) {
            System.out.printf("%-10d %-20d %-20d %-20d %-20f %-20f%n", i, building.getElevators().get(i).getPassengers().size(), building.getElevators().get(i).getCurrentFloor(), building.getElevators().get(i).getFloorCount(), building.getElevators().get(i).getTotalWeight(), building.getElevators().get(i).getAverageWaitTime());
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }
}