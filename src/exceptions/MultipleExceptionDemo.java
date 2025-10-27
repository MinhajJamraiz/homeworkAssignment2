package exceptions;

public class MultipleExceptionDemo {
    public String devideAndAccess(int a, int b, int[] arr , int index){
        try{
            int result = a/b;
            return "Values: "+ arr[index] + ", Result: "+result;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e){
            return "Error: "+e.getMessage();
        }
    }
}