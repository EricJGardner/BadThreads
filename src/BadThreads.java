public class BadThreads {

    //Answers to lab questions-
    //2. The application should print out "Mares do eat oats."
    //
    //- Is it guaranteed to always do this?
    //
    //- If not, why not?
    // The application will not always print out "Mares do eat oats" bc nothing is guaranteed
    // without a happens-before relationship, but Key statement 1 is more likely to print
    // than Key statement 2 bc the sleep invocation
    //in run() is shorter than in the main and therefore will take precedence

    //3.Would it help to change the parameters of the two invocations of Sleep?
    // Asking if it would "help" to change the parameters of the two invocations of Sleep
    //is not really valid bc we do not know the intended purpose of the application. If the
    //sleep time was changed so that it was more time in the run() method than the start()
    //method, then "Mares do not eat oats" would be displayed

    //4. How would you guarantee that all changes to message will be visible in the main thread?
    // Using a join() function or synchronized methods
    // would make all the changes to message visible in the main thread
    static String message;

    private static class CorrectorThread extends Thread {

        public void run(){
            try {
                sleep(1000);
            }catch (InterruptedException e) {}
            //Key Statement 1
        message = "Mares do eat oats";
    }
}

    public static void main(String[] args) throws InterruptedException{

        (new CorrectorThread()).start();
        message = "Mares do not eat oats";
        Thread.sleep(2000);
        //Key Statement 2
        System.out.println(message);
    }

    }