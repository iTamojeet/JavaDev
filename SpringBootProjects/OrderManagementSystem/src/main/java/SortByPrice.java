public class SortByPrice implements java.util.Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        return Double.compare(a.getPrice(), b.getPrice());
    }
}