void main() {
    var order = new Order();
    int choice;

    do {
        IO.println("\n==== Order Management Menu ====");
        IO.println("1. Add Item");
        IO.println("2. View All Items");
        IO.println("3. Update Item");
        IO.println("4. Delete Item");
        IO.println("5. Search Item by Name");
        IO.println("6. Sort Items by Name");
        IO.println("7. Sort Items by Price");
        IO.println("0. Exit");
        IO.print("Enter choice: ");
        choice = Integer.parseInt(IO.readln());

        try {
            switch (choice) {
                case 1 -> {
                    IO.print("Enter Item ID: ");
                    int id = Integer.parseInt(IO.readln());
                    IO.print("Enter Item Name: ");
                    String name = IO.readln();
                    IO.print("Enter Price: ");
                    double price = Double.parseDouble(IO.readln());
                    order.addItem(new Item(id, name, price));
                    IO.println("Item added successfully.");
                }
                case 2 -> {
                    IO.println(" --- All Items --- ");
                    order.viewItems();
                }
                case 3 -> {
                    IO.print("Enter Item ID to update: ");
                    int uid = Integer.parseInt(IO.readln());
                    IO.print("Enter new Name: ");
                    String newName = IO.readln();
                    IO.print("Enter new Price: ");
                    double newPrice = Double.parseDouble(IO.readln());
                    order.updateItem(uid, newName, newPrice);
                    IO.println("Item updated.");
                }
                case 4 -> {
                    IO.print("Enter Item ID to delete: ");
                    int did = Integer.parseInt(IO.readln());
                    order.deleteItem(did);
                    IO.println("Item deleted.");
                }
                case 5 -> {
                    IO.print("Enter Item Name to search: ");
                    String sname = IO.readln();
                    var found = order.searchItem(sname);
                    IO.println("Found: " + found);
                }
                case 6 -> {
                    IO.println(" --- Items Sorted by Name --- ");
                    var listName = new ArrayList<>(order.getAllItems());
                    listName.sort(new SortByName());
                    listName.forEach(IO::println);
                }
                case 7 -> {
                    IO.println(" --- Items Sorted by Price --- ");
                    var listPrice = new ArrayList<>(order.getAllItems());
                    listPrice.sort(new SortByPrice());
                    listPrice.forEach(IO::println);
                }
                case 0 -> IO.println("Goodbye.\nExiting...");
                default -> IO.println("Invalid choice!");
            }
        } catch (Exception e) {
            IO.println("Error: " + e.getMessage());
        }
    } while (choice != 0);
}
