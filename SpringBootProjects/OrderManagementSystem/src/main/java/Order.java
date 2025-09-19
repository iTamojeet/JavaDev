class Order {
    private final java.util.Set<Item> items = new java.util.HashSet<>();

    void addItem(Item item) {
        items.add(item); // HashSet ensures uniqueness
    }

    void viewItems() {
        for (var item : items) {
            IO.println(item);
        }
    }

    String searchItem(String name) {
        for (var item : items) {
            if (item.name().equalsIgnoreCase(name)) {
                return "Found: " + item;
            }
        }
        return "Item not found.";
    }

    void updateItem(int id, String newName, double newPrice) {
        Item toUpdate = null;
        for (var item : items) {
            if (item.id() == id) {
                toUpdate = item;
                break;
            }
        }
        if (toUpdate != null) {
            items.remove(toUpdate);
            items.add(new Item(id, newName, newPrice));
        }
    }

    void deleteItem(int id) {
        items.removeIf(item -> item.id() == id);
    }

    java.util.List<Item> getSortedItemsByName() {
        var sorted = new java.util.ArrayList<>(items);
        for (var i = 0; i < sorted.size(); i++) {
            for (var j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i).name().compareToIgnoreCase(sorted.get(j).name()) > 0) {
                    var temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        return sorted;
    }

    java.util.List<Item> getSortedItemsByPrice() {
        var sorted = new java.util.ArrayList<>(items);
        for (var i = 0; i < sorted.size(); i++) {
            for (var j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i).price() > sorted.get(j).price()) {
                    var temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        return sorted;
    }

    java.util.Set<Item> getAllItems() {
        return items;
    }
}
