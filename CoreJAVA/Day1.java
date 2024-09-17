package CoreJAVA;
public class Day1{
    static int x = 10; //this will unload when, class unload
    int instance_variable = 10; //this will unload when object unloads
    public static void main(String[] args) {
        //int x = 10;
        int local_varible = 10; //this will get destroyed, with it gets out of scope
        //System
        var$argTest(1,23,3);
    }
    public static void var$argTest(int ...args){
        System.err.println(args[1]); //internally it is a array
    }

    /*
     * Why do we use commmand line arguments?
     * Solution: To modify the behavior of main() method.
     * 
     * What is use of toString()?
     * Solution: Whenever we print object referent internally toString() is called.
     * 
     * What is use of equals?
     * Solution" It is used for reference comparison. It is present in object class. We can 
     * override it for object comparison, when doing so make sure of handling class cast exception.
     * 
     * == vs .equals?
     * ==  ::> For primitve type it does content comparison and for object type it does reference comparison
     *     ::> If objects are not of some type then it will throw error
     * .equals() ::> We can do reference comparison with this. 
     * 
     * What is a Runtime class?
     * It is used to communicate with JVM, can be used to get memory, execute system commands,
     * shutting down the application, etc.
     * 
     * What is System class?
     * For system level operations. 
     *
    */

}