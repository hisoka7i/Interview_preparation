package CoreJAVA.FunctionalInterface;


public class SupplierTest {
    public static void main(String[] args) {
        java.util.function.Supplier<String> supplier_test = () -> "This  is hello from supplier";
        System.out.println(supplier_test.get());
    }
}
