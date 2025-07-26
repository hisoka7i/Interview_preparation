package CoreJAVA.FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> contains_abc = s -> s.contains("abc");
        Predicate<String> contains_th = s->s.contains("th");

        List<String> list_strings = Arrays.asList("thjinks","avc","abcasdf");

        //using and, or we are doing predicate chaining
        //negate to create a new predicate who give opposite value of existing predicate

        List<String> output_list = list_strings.stream().filter(contains_abc.negate().or(contains_th)).toList();

        System.out.println(output_list);
    }
}
