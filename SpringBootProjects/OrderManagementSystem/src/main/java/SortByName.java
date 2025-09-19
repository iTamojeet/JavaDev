public class SortByName implements java.util.Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return
                o1.name().compareToIgnoreCase(o2.name());
    }
}