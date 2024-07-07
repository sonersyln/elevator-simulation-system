package models;

public class Person {

    private final int patienceLimit = 7;
    private int weight;
    private int patience;
    private int destinationFloor;


    public Person(int weight) {
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPatienceLimit() {
        return patienceLimit;
    }

    public int getPatience() {
        return patience;
    }

    public void simulate() {


        patience++;
        if (patience > patienceLimit) {
            leaveFloor();
        }

    }

    public void leaveFloor() {
    }
}
