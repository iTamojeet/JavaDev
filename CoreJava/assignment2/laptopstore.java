class Laptop {
    private String brand;
    private double price;
    private String processorType;

    // Getter methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    // Method to print laptop details
    public void printDetails() {
        System.out.println("Brand: " + brand + ", Price: Rs" + price + ", Processor: " + processorType);
    }
}

// User class with getter and setter methods
class User {
    private String username;
    private String address;

    // Getter methods for User
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Method to compare processors and purchase laptop
    public void compareAndPurchaseLaptop(Laptop[] laptops) {
        boolean purchased = false;

        // Iterate over all laptops to find one with Intel Core Ultra processor
        for (Laptop laptop : laptops) {
            if ("Intel Core Ultra".equals(laptop.getProcessorType())) {
                System.out.println(username + " has purchased the " + laptop.getBrand() + " laptop with Intel Core Ultra processor.");
                laptop.printDetails();
                purchased = true;
                break;
            }
        }

        // If no laptop with Intel Core Ultra is found
        if (!purchased) {
            System.out.println(username + " did not purchase any laptop as none have the Intel Core Ultra processor.");
        }
    }
}

class LaptopPurchaseSystem {

    // Method to create laptops and a user and compare processors
    public static void createAndCompareLaptops() {
        Laptop hpLaptop = new Laptop();
        hpLaptop.setBrand("HP");
        hpLaptop.setPrice(73000.00);
        hpLaptop.setProcessorType("Intel Core i7");

        Laptop lenovoLaptop = new Laptop();
        lenovoLaptop.setBrand("Apple");
        lenovoLaptop.setPrice(60000.00);
        lenovoLaptop.setProcessorType("Intel Core Ultra");

        Laptop dellLaptop = new Laptop();
        dellLaptop.setBrand("Lenovo");
        dellLaptop.setPrice(68000.00);
        dellLaptop.setProcessorType("Intel Core i5");

        Laptop[] laptops = { hpLaptop, lenovoLaptop, dellLaptop };

        // User object
        User user = new User();
        user.setUsername("Tamojeet");
        user.setAddress("madhyamgram, kolkata");

        user.compareAndPurchaseLaptop(laptops);
    }

    public static void main(String[] args) {
        // Main method to create laptops and compare
        createAndCompareLaptops();
    }
}