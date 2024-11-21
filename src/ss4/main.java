package ss4;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the width:");
//        double width = scanner.nextDouble();
//        System.out.print("Enter the height:");
//        double height = scanner.nextDouble();
//
//        Rectangle rectangle = new Rectangle(width, height);
//
//        System.out.println("Your Rectangle \n"+ rectangle.display());
//        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
//        System.out.println("Area of the Rectangle: "+ rectangle.getArea());

        //QuadraticEquation
//        QuadraticEquation qe = new QuadraticEquation(9,9,0);
//        double delta = qe.getDiscriminant();
//        if (delta < 0)
//            System.out.println("The equation has no solution");
//        else if (delta == 0)
//            System.out.println("The equation has one root" + qe.getRoot1());
//        else
//            System.out.println("The equation has two roots" + qe.getRoot2() +  " and "+ qe.getRoot1());

       // StopWatchStopWatch
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        for (int i = 0; i < 1000000; i++) {
//            System.out.println(i);
//        }
//        stopWatch.stop();
//        System.out.println("Elapsed Time: " + stopWatch.getElapsedTime() + "milliseconds");

        //FAN
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.getFAST());
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.println(fan1.toString());
        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.getMEDIUM());
        fan2.setRadius(5);
        fan2.setColor("red");
        fan2.setOn(false);
        System.out.println(fan2.toString());
    }

}
