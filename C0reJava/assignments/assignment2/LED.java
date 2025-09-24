class LED {
    int id;
    String brand;
    double price;

    // Getter and Setter methods
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to print details of the LED
    public void printDetails() {
        System.out.println("LED ID: " + id + ", Brand: " + brand + ", Price: Rs" + price);
    }
}

class LEDComparison{
    // Method to compare prices of Sony and Samsung and set the higher priced TV as "Premium Model"
    public static void compareAndSetPremium(LED sony, LED samsung) {
        if (sony.getPrice() > samsung.getPrice()) {
            sony.setBrand("Premium Model - Sony");
        } else if (samsung.getPrice() > sony.getPrice()) {
            samsung.setBrand("Premium Model - Samsung");
        }
    }

    // Method to print the details of both LED TVs
    public static void printLEDDetails(LED sony, LED samsung) {
        sony.printDetails();
        samsung.printDetails();
    }

	public static void main(String[] args) {
        LED sonyLED = new LED(1, "Sony", 50000.00);
        LED samsungLED = new LED(2, "Samsung", 40000.00);

        //  method to compare the prices and update the brand
        compareAndSetPremium(sonyLED, samsungLED);

        //  method to print the details
        printLEDDetails(sonyLED, samsungLED);
	}
}