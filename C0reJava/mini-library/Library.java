import java.util.Scanner;
// Generic Library Class
class Library<T> {
private T[] items;
private int count;
@SuppressWarnings("unchecked")
public Library(int size) {
items = (T[]) new Object[size];
count = 0;
}
// Add item
public void addItem(T item) {
if (count < items.length) {
items[count++] = item;
System.out.println(item + " added successfully!");
} else {
System.out.println("Library is full. Cannot add more items.");
}
}
// Display all items
public void displayItems() {
if (count == 0) {
System.out.println("No items in library.");
return;
}
for (int i = 0; i < count; i++) {
System.out.println((i + 1) + ". " + items[i]);
}
}
// Search
public int searchItem(T item) {
for (int i = 0; i < count; i++) {
if (items[i].equals(item)) {
return i;
}
}
return -1;
}
// Update item
public void updateItem(int index, T newItem) {
if (index >= 0 && index < count) {
items[index] = newItem;
System.out.println("Item updated successfully!");
} else {
System.out.println("Invalid index!");
}
}
// Delete item
public void deleteItem(int index) {
if (index >= 0 && index < count) {
for (int i = index; i < count - 1; i++) {
items[i] = items[i + 1];
}
items[--count] = null; // remove last duplicate
System.out.println("Item deleted successfully!");
} else {
System.out.println("Invalid index!");
}
}
}