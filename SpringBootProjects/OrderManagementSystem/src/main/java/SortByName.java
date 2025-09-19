public class SortByName implements java.util.Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}