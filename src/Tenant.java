import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Tenant {

    private List<Vehicle> vehicles;
    public Tenant() {
        this.vehicles = new ArrayList<>();
    }
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    public void addAuto(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    public void showAvailableAutos() {
        System.out.println("List of available cars:");
        if (vehicles.isEmpty()) {
            System.out.println("List of available cars ");
        } else {
            int count = 1;
            for (Vehicle vehicle : vehicles) {
                System.out.println(count + " " + vehicle);
                count++;
            }
        }
        System.out.println("Return to previous menu - 0, exit - 1");
        Scanner sc = new Scanner(System.in);
        int exit = sc.nextInt();
        if (1 == exit) {

        }
    }
}
