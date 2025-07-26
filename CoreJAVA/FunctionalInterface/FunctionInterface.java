package CoreJAVA.FunctionalInterface;

import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {
        Function<Integer, Double> half = a -> a/2.0;
        half = half.andThen(a -> a * 10);
        System.out.println(half.apply(34));

    }
}
