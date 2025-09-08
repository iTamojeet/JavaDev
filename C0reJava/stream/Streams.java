import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Streams{
    public static void main(String[] args) {
        example1(); example2(); example3(); example4(); example5();
        example6(); example7(); example8(); example9(); example10();
        example11(); example12(); example13(); example14(); example15();
        example16(); example17(); example18(); example19(); example20();
        example21(); example22(); example23(); example24(); example25();
        example26(); example27(); example28(); example29(); example30();
        example31(); example32(); example33(); example34(); example35();
        example36(); example37(); example38(); example39(); example40();
        example41(); example42(); example43(); example44(); example45();
        example46(); example47(); example48(); example49(); example50();
    }



    // 1. How to create a stream from a list?
    public static void example1() {
        System.out.println("\n1. How to create a stream from a list?");
        //String s[] = new String[]{};
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    // 2. How to filter elements in a stream?
    public static void example2() {
        System.out.println("\n2. How to filter elements in a stream?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Result: " + evenNumbers);
    }

    // 3. How to transform elements using map
    public static void example3() {
        System.out.println("\n3. How to transform elements using map");
        List<String> names = Arrays.asList("john", "jane", "doe");
        List<String> upperCaseNames = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Result: " + upperCaseNames);
    }

    // 4. How to sort elements in a stream?
    public static void example4() {
        System.out.println("\n4. How to sort elements in a stream?");
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
        List<Integer> sortedNumbers = numbers.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Result: " + sortedNumbers);
    }

    // 5. How to limit the number of elements?
    public static void example5() {
        System.out.println("\n5. How to limit the number of elements?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> limited = numbers.stream()
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("Result: " + limited);
    }

    // 6. How to skip elements in a stream?
    public static void example6() {
        System.out.println("\n6. How to skip elements in a stream?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> skipped = numbers.stream()
            .skip(2)
            .collect(Collectors.toList());
        System.out.println("Result: " + skipped);
    }

    // 7. How to remove duplicates using distinct?
    public static void example7() {
        System.out.println("\n7. How to remove duplicates using distinct?");
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = numbers.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Result: " + distinctNumbers);
    }

    // 8. How to use flatMap to flatten nested collections?
    public static void example8() {
        System.out.println("\n8. How to use flatMap to flatten nested collections?");
        List<List<String>> nestedList = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("c", "d")
        );
        List<String> flatList = nestedList.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
        System.out.println("Result: " + flatList);
    }

    // 9. How to use peek for debugging?
    public static void example9() {
        System.out.println("\n9. How to use peek for debugging?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = numbers.stream()
            .peek(n -> System.out.println("Processing: " + n))
            .map(n -> n * 2)
            .collect(Collectors.toList());
        System.out.println("Result: " + result);
    }

    // 10. How to chain multiple operations?
    public static void example10() {
        System.out.println("\n10. How to chain multiple operations?");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> result = names.stream()
            .filter(name -> name.length() > 3)
            .map(String::toUpperCase)
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Result: " + result);
    }

    // 11. How to collect to a list?
    public static void example11() {
        System.out.println("\n11. How to collect to a list?");
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        List<String> result = names.stream()
            .collect(Collectors.toList());
        System.out.println("Result: " + result);
    }

    // 12. How to collect to a set?
    public static void example12() {
        System.out.println("\n12. How to collect to a set?");
        List<String> names = Arrays.asList("John", "Jane", "John");
        Set<String> result = names.stream()
            .collect(Collectors.toSet());
        System.out.println("Result: " + result);
    }

    // 13. How to join strings?
    public static void example13() {
        System.out.println("\n13. How to join strings?");
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        String result = names.stream()
            .collect(Collectors.joining(", "));
        System.out.println("Result: " + result);
    }

    // 14. How to count elements?
    public static void example14() {
        System.out.println("\n14. How to count elements?");
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        long count = names.stream().count();
        System.out.println("Result: " + count);
    }

    // 15. How to check if any element matches a condition?
    public static void example15() {
        System.out.println("\n15. How to check if any element matches a condition?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("Result: " + hasEven);
    }

    // 16. How to check if all elements match a condition?
    public static void example16() {
        System.out.println("\n16. How to check if all elements match a condition?");
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8);
        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println("Result: " + allEven);
    }

    // 17. How to check if no elements match a condition?
    public static void example17() {
        System.out.println("\n17. How to check if no elements match a condition?");
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7);
        boolean noneEven = numbers.stream().noneMatch(n -> n % 2 == 0);
        System.out.println("Result: " + noneEven);
    }

    // 18. How to find the first element?
    public static void example18() {
        System.out.println("\n18. How to find the first element?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstEven = numbers.stream()
            .filter(n -> n % 2 == 0)
            .findFirst();
        System.out.println("Result: " + firstEven);
    }

    // 19. How to find any element?
    public static void example19() {
        System.out.println("\n19. How to find any element?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> anyEven = numbers.stream()
            .filter(n -> n % 2 == 0)
            .findAny();
        System.out.println("Result: " + anyEven);
    }

    // 20. How to use forEach?
    public static void example20() {
        System.out.println("\n20. How to use forEach?");
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        names.stream().forEach(System.out::println);
    }

        // 21. How to calculate sum?
    public static void example21() {
        System.out.println("\n21. How to calculate sum?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
        System.out.println("Result: " + sum);
    }

    // 22. How to find average?
    public static void example22() {
        System.out.println("\n22. How to find average?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        OptionalDouble average = numbers.stream()
            .mapToInt(Integer::intValue)
            .average();
        System.out.println("Result: " + average);
    }

    // 23. How to find maximum value?
    public static void example23() {
        System.out.println("\n23. How to find maximum value?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        OptionalInt max = numbers.stream()
            .mapToInt(Integer::intValue)
            .max();
        System.out.println("Result: " + max);
    }

    // 24. How to find minimum value?
    public static void example24() {
        System.out.println("\n24. How to find minimum value?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        OptionalInt min = numbers.stream()
            .mapToInt(Integer::intValue)
            .min();
        System.out.println("Result: " + min);
    }

    // 25. How to use range?
    public static void example25() {
        System.out.println("\n25. How to use range?");
        IntStream.range(1, 5).forEach(System.out::println);
    }

    // 26. How to group elements?
    public static void example26() {
        System.out.println("\n26. How to group elements?");
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Diana");
        Map<Integer, List<String>> groupedByLength = names.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Result: " + groupedByLength);
    }

    // 27. How to partition elements?
    public static void example27() {
        System.out.println("\n27. How to partition elements?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Result: " + partitioned);
    }

    // 28. How to create a map from a stream?
    public static void example28() {
        System.out.println("\n28. How to create a map from a stream?");
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        Map<String, Integer> nameLengthMap = names.stream()
            .collect(Collectors.toMap(
                Function.identity(), // key
                String::length       // value
            ));
        System.out.println("Result: " + nameLengthMap);
    }

    // 29. How to use reduce to accumulate values?
    public static void example29() {
        System.out.println("\n29. How to use reduce to accumulate values?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("Result: " + sum);
    }

    // 30. How to concatenate streams?
    public static void example30() {
        System.out.println("\n30. How to concatenate streams?");
        Stream<String> stream1 = Stream.of("A", "B", "C");
        Stream<String> stream2 = Stream.of("D", "E", "F");
        Stream<String> concatenated = Stream.concat(stream1, stream2);
        System.out.print("Result: ");
        concatenated.forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

        // 31. How to create a stream from an array?
    public static void example31() {
        System.out.println("\n31. How to create a stream from an array?");
        String[] array = {"a", "b", "c"};
        Stream<String> stream = Arrays.stream(array);
        stream.forEach(System.out::println);
    }

    // 32. How to create a stream of primitive values?
    public static void example32() {
        System.out.println("\n32. How to create a stream of primitive values?");
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);
        System.out.print("IntStream: ");
        intStream.forEach(n -> System.out.print(n + " "));
        System.out.print("\nDoubleStream: ");
        doubleStream.forEach(d -> System.out.print(d + " "));
        System.out.println();
    }

    // 33. How to generate infinite streams?
    public static void example33() {
        System.out.println("\n33. How to generate infinite streams?");
        Stream<Integer> infiniteStream = Stream.generate(() -> 1).limit(5);
        System.out.println("Result: " + infiniteStream.collect(Collectors.toList()));
    }

    // 34. How to use iterate?
    public static void example34() {
        System.out.println("\n34. How to use iterate?");
        Stream<Integer> numbers = Stream.iterate(0, n -> n + 2).limit(5);
        System.out.println("Result: " + numbers.collect(Collectors.toList()));
    }

    // 35. How to create an empty stream?
    public static void example35() {
        System.out.println("\n35. How to create an empty stream?");
        Stream<String> emptyStream = Stream.empty();
        System.out.println("Result: " + emptyStream.count()); // should print 0
    }

    // 36. How to collect to a specific collection type?
    public static void example36() {
        System.out.println("\n36. How to collect to a specific collection type?");
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        TreeSet<String> treeSet = names.stream()
            .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Result: " + treeSet);
    }

    // 37. How to calculate summary statistics?
    public static void example37() {
        System.out.println("\n37. How to calculate summary statistics?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        IntSummaryStatistics stats = numbers.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();
        System.out.println("Stats: " + stats);
    }

    // 38. How to use collectingAndThen?
    public static void example38() {
        System.out.println("\n38. How to use collectingAndThen?");
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        List<String> unmodifiableList = names.stream()
            .collect(Collectors.collectingAndThen(
                Collectors.toList(),
                Collections::unmodifiableList
            ));
        System.out.println("Result: " + unmodifiableList);
    }

    // 39. How to use mapping collector?
    public static void example39() {
        System.out.println("\n39. How to use mapping collector?");
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        List<Integer> nameLengths = names.stream()
            .collect(Collectors.mapping(
                String::length,
                Collectors.toList()
            ));
        System.out.println("Result: " + nameLengths);
    }

    // 40. How to use filtering collector?
    public static void example40() {
        System.out.println("\n40. How to use filtering collector?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = numbers.stream()
            .collect(Collectors.filtering(
                n -> n % 2 == 0,
                Collectors.toList()
            ));
        System.out.println("Result: " + evenNumbers);
    }

    // 41. How to use parallel streams?
    public static void example41() {
        System.out.println("\n41. How to use parallel streams?");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.parallelStream()
            .forEach(n -> System.out.println("Thread: " + Thread.currentThread().getName() + " -> " + n));
    }

    // 42. How to convert a stream to an array?
    public static void example42() {
        System.out.println("\n42. How to convert a stream to an array?");
        Stream<String> stream = Stream.of("A", "B", "C");
        String[] array = stream.toArray(String[]::new);
        System.out.println("Result: " + Arrays.toString(array));
    }

    // 43. How to handle null values safely in streams?
    public static void example43() {
        System.out.println("\n43. How to handle null values safely in streams?");
        List<String> names = Arrays.asList("John", null, "Jane", "Doe");
        List<String> nonNullNames = names.stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
        System.out.println("Result: " + nonNullNames);
    }

    // 44. How to flatten nested collections?
    public static void example44() {
        System.out.println("\n44. How to flatten nested collections?");
        List<List<String>> nestedList = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("c", "d"),
            Arrays.asList("e", "f")
        );
        List<String> flatList = nestedList.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
        System.out.println("Result: " + flatList);
    }

    // 45. How to count frequency of elements?
    public static void example45() {
        System.out.println("\n45. How to count frequency of elements?");
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> frequency = items.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Result: " + frequency);
    }

    // 46. How to join strings with a delimiter?
    public static void example46() {
        System.out.println("\n46. How to join strings with a delimiter?");
        List<String> words = Arrays.asList("Java", "Streams", "API");
        String joined = words.stream()
            .collect(Collectors.joining(" - "));
        System.out.println("Result: " + joined);
    }

    // 47. How to parallel sort with streams?
    public static void example47() {
        System.out.println("\n47. How to parallel sort with streams?");
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2);
        List<Integer> sorted = numbers.parallelStream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Result: " + sorted);
    }

    // 48. How to debug streams with peek?
    public static void example48() {
        System.out.println("\n48. How to debug streams with peek?");
        List<String> names = Arrays.asList("John", "Jane", "Jack");
        List<String> result = names.stream()
            .peek(s -> System.out.println("Processing: " + s))
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Result: " + result);
    }

    // 49. How to find the second highest number?
    public static void example49() {
        System.out.println("\n49. How to find the second highest number?");
        List<Integer> numbers = Arrays.asList(5, 1, 9, 3, 7);
        Optional<Integer> secondHighest = numbers.stream()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst();
        System.out.println("Result: " + secondHighest);
    }

    // 50. How to find common elements between two lists?
    public static void example50() {
        System.out.println("\n50. How to find common elements between two lists?");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> common = list1.stream()
            .filter(list2::contains)
            .collect(Collectors.toList());
        System.out.println("Result: " + common);
    }
}