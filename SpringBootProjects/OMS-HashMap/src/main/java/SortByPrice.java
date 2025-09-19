public class SortByPrice implements java.util.Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
