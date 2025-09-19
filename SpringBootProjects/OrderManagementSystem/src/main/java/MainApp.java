void main() {
    try {
        var order = new Order();

        order.addItem(new Item(201, "Tshirt", 499));
        order.addItem(new Item(202, "Wallet", 1499));
        order.addItem(new Item(203, "Shirt", 1299));
        order.addItem(new Item(204, "Samsung s25", 69999));
        order.addItem(new Item(205, "Java Book", 6499));

        IO.println(" ---- All Items ---- ");
        order.viewItems();

        IO.println("\n ---- Search Item ---- ");
        IO.println(order.searchItem("Shirt"));

        IO.println("\n ---- Update Item (ID 202) ---- ");
        order.updateItem(202, "Wallet", 1599);
        order.viewItems();

        IO.println("\n ---- Delete Item (ID 204) ---- ");
        order.deleteItem(204);
        order.viewItems();

        IO.println("\n ---- Sort Items by Name ---- ");
        var sortedByName = order.getSortedItemsByName();
        sortedByName.forEach(IO::println);

        IO.println("\n ---- Sort Items by Price ---- ");
        var sortedByPrice = order.getSortedItemsByPrice();
        sortedByPrice.forEach(IO::println);

    } catch (Exception e) {
        IO.println("Error: " + e.getMessage());
    }
}
