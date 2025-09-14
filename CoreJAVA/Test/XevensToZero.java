
import java.util.Scanner;

class XevensToZero {
    public static String replaceXevens(String input) {
        if (input == null || input.isEmpty()) return input;
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            if (i + 1 < input.length() && Character.isDigit(input.charAt(i)) && 
                Character.isDigit(input.charAt(i + 1)) && 
                (input.charAt(i + 1) == '0' || input.charAt(i + 1) == '2' || 
                 input.charAt(i + 1) == '4' || input.charAt(i + 1) == '8')) {
                // Check for sequence of digits ending in even digit (0, 2, 4, 8)
                int j = i + 2;
                while (j < input.length() && Character.isDigit(input.charAt(j))) {
                    j++;
                }
                result.append("0");
                i = j;
            } else {
                result.append(input.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        System.out.println(replaceXevens(input));
    }
}