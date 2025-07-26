package CoreJAVA.FunctionalInterface;

@FunctionalInterface
interface Calculation{
    int calculate(int x);
}

public class Test {
    public static void main(String[] args) {
        Calculation calc = (int x) -> x * 2;
        System.out.println(calc.calculate(3));
    }
}
