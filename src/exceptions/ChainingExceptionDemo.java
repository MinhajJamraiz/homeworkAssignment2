package exceptions;

public class ChainingExceptionDemo {
    public void execute() throws Exception{
        try{
            performTask();
        } catch (IllegalStateException e){
            throw new Exception("Execution failed" ,e);
        }
    }

    private void performTask(){
        throw new IllegalStateException("Root cause occurred");
    }
}
