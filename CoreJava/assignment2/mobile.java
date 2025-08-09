class Mobile {
    String brand;
    String model;
    String androidVersion;

    // Getter and Setter methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    // Method to print mobile details
    public void printDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Android Version: " + androidVersion);
    }
}

class Shop {
    private Mobile[] mobiles;

    // Method to set mobiles in the shop
    public void setMobiles(Mobile[] mobiles) {
        this.mobiles = mobiles;
    }

    // Method to check if the shop has a VIVO mobile with Android 15
    public Mobile findVivoWithAndroid15() {
        for (Mobile mobile : mobiles) {
            if ("VIVO".equals(mobile.getBrand()) && "Android 15".equals(mobile.getAndroidVersion())) {
                return mobile;
            }
        }
        return null; // No VIVO mobile with Android 15 found
    }
}

class Customer {
    String name;
    String address;

    // Getter and Setter methods for Customer
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Method for the customer to visit the shop and try to buy a VIVO mobile with Android 15
    public void visitShopAndPurchase(Shop shop) {
        Mobile mobileToPurchase = shop.findVivoWithAndroid15();

        if (mobileToPurchase != null) {
            System.out.println(name + " has purchased a VIVO mobile with Android 15.");
            mobileToPurchase.printDetails();
        } else {
            System.out.println(name + " did not find a VIVO mobile with Android 15 in the shop.");
        }
    }
}

class MobileShopSystem {

    // Method to initialize mobiles, customer, and shop, and then make a purchase
    public static void initializeAndPurchase() {
        //mobile attributes
        Mobile vivoMobile = new Mobile();
        vivoMobile.setBrand("VIVO");
        vivoMobile.setModel("X200 Pro");
        vivoMobile.setAndroidVersion("Android 15");

        Mobile samsungMobile = new Mobile();
        samsungMobile.setBrand("Samsung");
        samsungMobile.setModel("Galaxy S24 ultra");
        samsungMobile.setAndroidVersion("Android 14");

        Mobile iphoneMobile = new Mobile();
        iphoneMobile.setBrand("Apple");
        iphoneMobile.setModel("iPhone 16 Pro");
        iphoneMobile.setAndroidVersion("iOS 16");

        // Create the array of mobiles
        Mobile[] mobiles = {vivoMobile, samsungMobile, iphoneMobile};

        // Create Shop and set mobiles using setter
        Shop shop = new Shop();
        shop.setMobiles(mobiles);

        // Create Customer and set details using setter
        Customer customer = new Customer();
        customer.setName("Tamojeet");
        customer.setAddress("Madhyamgram, Kolkata");

        // Customer visits the shop and tries to purchase a VIVO mobile with Android 15
        customer.visitShopAndPurchase(shop);
    }

    public static void main(String[] args) {
        //main method
        initializeAndPurchase();
    }
}