package dev.LambdaRunnable;

public class MyAppLambdaRunnable {

    public static void main(String[] args) {

        //Runnable com Java 8
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Olá mundo!");
            }

        }).run();

        //Runnable com Lambda no Java 8
        new Thread(() -> System.out.println("Olá mundo!")).run();

        // É possível criar um Runnable ou qualquer outro tipo de objeto dessa forma no Lambda
        // graças ao SAM (Single Abstract Method), isto é, qualquer interface que tenha apenas
        // um método abstrato.
    }

}