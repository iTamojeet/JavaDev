void main() {
    try {
        Order order = new Order();

        // Add demo items
        order.addItem(new Item(201, "Tshirt", 499));
        order.addItem(new Item(202, "Wallet", 1499));
        order.addItem(new Item(203, "Shirt", 1299));
        order.addItem(new Item(204, "Samsung s25", 69999));
        order.addItem(new Item(205, "Java Book", 6499));

        IO.println("---- All Items ----");
        order.viewItems();

        IO.println("---- Search Item ----");
        IO.println(order.searchItem("Shirt"));

        IO.println("---- Update Item ID 202 ----");
        order.updateItem(202, "Wallet", 1599);
        order.viewItems();

        IO.println("---- Delete Item ID 204 ----");
        order.deleteItem(204);
        order.viewItems();

        IO.println("---- Sort Items by Name ----");
        for (Item item : order.getSortedItemsByName()) {
            IO.println(item);
        }

        IO.println("---- Sort Items by Price ----");
        for (Item item : order.getSortedItemsByPrice()) {
            IO.println(item);
        }
    } catch (Exception e) {
        IO.println("Error: " + e.getMessage());
    }
}
