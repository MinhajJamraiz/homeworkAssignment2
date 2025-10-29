package exceptions;

public class RethrowExceptionDemo {

    public void riskyMethod() throws Exception {
        try {
            throw new NullPointerException("Some Error Found!");
        } catch (NullPointerException e) {
            System.out.println("Caught and rethrowing...");
            throw new Exception("Re-thrown exception" , e);
        }
    }
    
}
