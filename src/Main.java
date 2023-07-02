import java.util.List;
import java.util.Scanner;

public class Main {
    static Tenant tenant = new Tenant();
    static List<Vehicle> vehicles = tenant.getVehicles();
    //    static  Vehicle selectedVehicle;
    static User user = new User("John", "Connor", 500, "B");
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        tenant.addAuto(new Vehicle(1,"BMW",2010,"A",100));
        tenant.addAuto(new Vehicle(2,"Audi",2011,"B",400));
        tenant.addAuto(new Vehicle(3,"Sprinter",2017,"B",150));
        tenant.addAuto(new Vehicle(4,"Gazon",2012,"B",150));
        tenant.addAuto(new Vehicle(5,"Mazda",2015,"B",1000));
        tenant.addAuto(new Vehicle(6,"Sprinter",2017,"B",150));

        boolean exit = false;
        try {
            while (!exit){
                System.out.println("Write action(1 - cabinet, 2 - catalog, 3 - exit)");
                String action = scanner.nextLine();
                switch (action){
                    case "1" -> user.personalCabinet();
                    case "2" -> catalog();
                    case "3" -> exit = true;
                    default ->  System.out.println("Wrong input");
                }
            }
        }catch (Exception e){
            System.out.println("invalid");
        }
    }
    public static void catalog() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Catalog auto:");
            System.out.println("1. List of available cars");
            System.out.println("2. Return to previous menu");
            System.out.println("3. Select auto");

            String action = scanner.nextLine();
            switch (action) {
                case "1" -> tenant.showAvailableAutos();
                case "2" -> exit = true;
                case "3" -> user.selectAuto();
                default  -> System.out.println("Invalid input. Try again.");
            }
        }
    }
    public static void selectAuto(){
        boolean exit = false;
        while (!exit){
            System.out.println("Write action( select  auto 1 -" + vehicles.size() + ", 2 - Return to previous menu)");
            String action = scanner.nextLine();
            switch (action){
                case "1" -> {}
                case "2" -> exit = true;
            }
        }
    }
}