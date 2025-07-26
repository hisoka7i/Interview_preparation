
import java.util.Arrays;
import java.util.List;


public class Test{
    public static void main(String[] args) {
        List<Integer> interger_list = Arrays.asList(1,2,3,4,5,5);

        List<Integer> val =  interger_list.stream().filter(n -> n%2 == 0).parallel().toList();
        System.out.println(val);
    }
}