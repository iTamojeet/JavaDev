class Item {
    private final int id;
    private final String name;
    private final double price;

    Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    int id() { return id; }
    String name() { return name; }
    double price() { return price; }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Item i && i.id == this.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return id + " | " + name + " | ₹" + price;
    }
}
