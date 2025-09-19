public class Order implements OrderOperations {
    private final java.util.HashMap<Integer, Item> itemMap = new java.util.HashMap<>();

    public void addItem(Item item) throws DuplicateItemException {
        if (itemMap.containsKey(item.getItemId())) {
            throw new DuplicateItemException("Item with ID " + item.getItemId() + " already exists.");
        }
        itemMap.put(item.getItemId(), item);
    }

    public void viewItems() {
        if (itemMap.isEmpty()) {
            IO.println("No items found.");
        } else {
            for (Item item : itemMap.values()) {
                IO.println(item.toString());
            }
        }
    }

    public void updateItem(int itemId, String newName, double newPrice) throws ItemNotFoundException {
        Item item = itemMap.get(itemId);
        if (item == null) throw new ItemNotFoundException("Item ID " + itemId + " not found.");
        item.setItemName(newName);
        item.setPrice(newPrice);
    }

    public void deleteItem(int itemId) throws ItemNotFoundException {
        if (!itemMap.containsKey(itemId)) throw new ItemNotFoundException("Item ID " + itemId + " not found.");
        itemMap.remove(itemId);
    }

    public Item searchItem(String name) throws ItemNotFoundException {
        for (Item item : itemMap.values()) {
            if (item.getItemName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        throw new ItemNotFoundException("Item with name '" + name + "' not found.");
    }

    public java.util.Set<Item> getAllItems() {
        return new java.util.HashSet<>(itemMap.values());
    }

    public java.util.List<Item> getSortedItemsByName() {
        java.util.List<Item> list = new java.util.ArrayList<>(itemMap.values());
        list.sort(new SortByName());
        return list;
    }

    public java.util.List<Item> getSortedItemsByPrice() {
        java.util.List<Item> list = new java.util.ArrayList<>(itemMap.values());
        list.sort(new SortByPrice());
        return list;
    }
}
