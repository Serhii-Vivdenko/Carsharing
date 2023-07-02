import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    List<Vehicle>vehicles = Main.tenant.getVehicles();
    private String firstName;
    private String secondName;
    private int money;
    private String category;
    private List<Vehicle> rentedVehicles;
    private Vehicle selectedVehicle;
    public User(String firstName, String secondName, int money, String category) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.category = category;
        this.money = money;
        this.rentedVehicles = new ArrayList<>();
    }
    public void rentAuto(Vehicle vehicle) {
        rentedVehicles.add(vehicle);
    }
    public String getCategory() {
        return category;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void personalCabinet() {
       if (!rentedVehicles.isEmpty()) {
           for (Vehicle a : rentedVehicles){
               System.out.println(a);
           }
       }
        System.out.println("first name:  " + firstName);
        System.out.println("second name: " + secondName);
        System.out.println("money:       " + money);
        System.out.println("category:    " + category);
        System.out.println("Return to previous menu - 0, exit - 1");
        Scanner sc = new Scanner(System.in);
        int exit = sc.nextInt();
        if (1 == exit) {
            System.exit(exit);
        }
    }
    public void selectAuto(){
        int choice;
        do {
            System.out.println("Write action( select  auto 1 -" + vehicles.size() + ", 0 - Return to previous menu)");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            if (choice >= 1 && choice <= vehicles.size()){
                Vehicle vehicle = vehicles.stream()
                        .skip(choice - 1)
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);

                if (getMoney() >= vehicle.getPrice() && getCategory().equals(vehicle.getCategory())) {
                    setMoney(getMoney() - vehicle.getPrice());
                    selectedVehicle = vehicle;
                    vehicles.removeIf(a -> a.equals(selectedVehicle));
                    System.out.println("you rented a vehicle: " + vehicle);
                    rentAuto(vehicle);
                } else if(getMoney() < vehicle.getPrice()){
                    System.out.println("No money");
                }
                else if (!getCategory().equals(vehicle.getCategory())){
                    System.out.println("you can't rent category A vehicles");
                    System.out.println("only category B");
                }
            }
            else {
                System.out.println("You input the wrong number");
                int count = 1;
                for (Vehicle vehicle : vehicles) {
                    System.out.println(count + " " + vehicle);
                    count++;
                }
            }
        } while (choice != 0);
    }
}
