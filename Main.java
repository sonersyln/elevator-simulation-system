import models.Building;
import models.Elevator;
import models.Floor;
import services.concretes.SystemVisualizer;

public class Main {
    public static void main(String[] args) {
        Building building = new Building(5, 3);
        SystemVisualizer visualizer = new SystemVisualizer();

        while (true) {
            building.getFloors().forEach(Floor::simulate);
            building.getElevators().forEach(Elevator::simulate);
            visualizer.display(building);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}