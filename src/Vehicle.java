public class Vehicle {
    private int id;
    private String nameAuto;
    private int year;
    private String category;
    private int price;
//    private List<Auto> catalog;

    public Vehicle(int id, String nameAuto, int year, String category, int price) {
        this.id = id;
        this.nameAuto = nameAuto;
        this.year = year;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Auto{" +
                " nameAuto='" + nameAuto + '\'' +
                ", year=" + year +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
