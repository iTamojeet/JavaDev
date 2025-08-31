package haha.hehe;

class LibraryInterfaceDemo {
    public static void main(String[] args) {
        KidUser kidUser = new KidUser(10, "Kids");
        KidUser kidUser2 = new KidUser(18, "Fiction");
        AdultUser adultUser = new AdultUser(5, "Kids");
        AdultUser adultUser2 = new AdultUser(23, "Fiction");

        kidUser.registerAccount();
        kidUser.requestBook();

        kidUser2.registerAccount();
        kidUser2.requestBook();

        adultUser.registerAccount();
        adultUser.requestBook();

        adultUser2.registerAccount();
        adultUser2.requestBook();
    }
}
