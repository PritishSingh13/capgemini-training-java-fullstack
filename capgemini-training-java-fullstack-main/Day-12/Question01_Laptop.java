/*Write a Java program to create a Laptop class that demonstrates constructor chaining using this().

Requirements:

The Laptop class should have three instance variables:
brand (String)
ramSize (int)
price (double)

Implement the following constructors using constructor chaining (this()):

Default constructor that sets default values ("Unknown", 8GB, 50000.0).
Constructor with only brand (calls the default constructor).
Constructor with brand and ramSize (calls the constructor with brand).
Constructor with all three fields (brand, ramSize, price) --(the final constructor)--.

Create a printDetails() method to display laptop details.

In main(), create different Laptop objects using all constructors and print their details.*/

class Question01_Laptop {

    String brand;
    int ramSize;
    double price;

    // Default constructor
    Question01_Laptop() {
        brand = "Unknown";
        ramSize = 8;
        price = 50000.0;
    }

    // Constructor with brand only
    Question01_Laptop(String brand) {
        this();                // constructor chaining
        this.brand = brand;
    }

    // Constructor with brand and ramSize
    Question01_Laptop(String brand, int ramSize) {
        this(brand);           // constructor chaining
        this.ramSize = ramSize;
    }

    // Constructor with all three fields
    Question01_Laptop(String brand, int ramSize, double price) {
        this(brand, ramSize);  // constructor chaining
        this.price = price;
    }

    void printDetails() {
        System.out.println("Brand: " + brand +
                           ", RAM: " + ramSize +
                           "GB, Price: " + price);
    }

    public static void main(String[] args) {

        Question01_Laptop l1 = new Question01_Laptop();
        Question01_Laptop l2 = new Question01_Laptop("Dell");
        Question01_Laptop l3 = new Question01_Laptop("HP", 16);
        Question01_Laptop l4 = new Question01_Laptop("Apple", 32, 150000);

        l1.printDetails();
        l2.printDetails();
        l3.printDetails();
        l4.printDetails();
    }
}
