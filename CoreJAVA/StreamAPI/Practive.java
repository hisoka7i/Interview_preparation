package StreamAPI.java;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practive {
    public static void main(String[] args) {
        
    }

    public int sum(int[] nums){
        return Arrays.stream(nums).boxed().sum();
    }

    public List<Integer> getEvens(int[] nums){
        return Arrays.stream(nums).filter(n -> n % 2 == 0).boxed().collect(Collectors.toList());
    }

    public List<String> toUpperCase(List<String> string){
        return string.stream().map(String::toUpperCase).toList();
    }

    public List<Integer> sort(List<Integer> nums){
        return nums.stream().sorted().toList();
    }

    public Long startsWithA(List<String> sample){
        return sample.stream().filter(s->s.startsWith("a")).count();
    }

    public void groupByEmployees(List<Employee> emps){
         emps.stream().collect(Collectors.groupingBy(emp -> emp.dept));
    }

    public Long secondHighestSalary(List<Employee> emps){
        return emps.stream().map(e -> e.salary).sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
    }

    public String findLongestString(List<String> samples){
        return samples.stream().sorted(((a,b) -> b.length() - a.length())).findFirst().orElse(null);
    }

    public Optional<String> longestStringUsingReduce(List<String> samples){
        return samples.stream().reduce((s1,s2)->s1.length() >= s2.length() ? s1: s2);
    }

    public Map<Boolean, List<Integer>> partitionPrimeNonPrime(List<Integer> nums){
        return nums.stream().collect(Collectors.partitioningBy(Practive::isPrime));
    }

    static boolean isPrime(int num){
        return num <= 1 ? false:IntStream.rangeClosed(2, (int)Math.sqrt(num)).allMatch( i -> num%i != 0);
    }
}

class Employee {
    String dept;
    Long salary;
}
