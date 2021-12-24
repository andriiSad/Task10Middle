import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
    private Task() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> task6(List<Integer> integerList, List<String> stringList) {
        return integerList
                .stream()
                .map(integer -> stringList.stream().filter(s -> Character.isDigit(s.charAt(0)) && s.length() == integer).findFirst().orElse("NOT FOUND"))
                .collect(Collectors.toList());
    }

    public static List<Integer> task7(List<Integer> integerList, int number) {
        return Stream.concat(
                        (integerList.stream()
                                .filter(x -> x % 2 == 0)
                                .filter(x -> !(integerList.stream()
                                        .skip(number)
                                        .collect(Collectors.toList()))
                                        .contains(x))
                        ),
                        (integerList.stream()
                                .skip(number)
                                .filter(x -> !(integerList.stream()
                                        .filter(y -> y % 2 == 0)
                                        .collect(Collectors.toList()))
                                        .contains(x))))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<Integer> task8(int k, int d, List<Integer> integerList) {
        return Stream.concat(
                        (integerList.stream()
                                .filter(x -> x > d)
                        ),
                        (integerList.stream()
                                .skip(k)
                        ))
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

    }

    public static List<String> task9(List<String> stringList) {
        return stringList.stream()
                .map(s -> String.valueOf(s.charAt(0)))
                .distinct()
                .map(s -> stringList.stream()
                        .filter(s1 -> s1.startsWith(s))
                        .mapToInt(String::length)
                        .sum() + "-" + s
                )
                .sorted(Comparator.comparingInt((String s) -> Integer.parseInt(s.split("-")[0])).reversed().thenComparing((String s) -> (s.split("-")[1])))
                .collect(Collectors.toList());
    }

    public static List<String> task10(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .map(s -> String.valueOf(s.charAt(s.length() - 1)).toUpperCase())
                .collect(Collectors.toList());
    }
}
