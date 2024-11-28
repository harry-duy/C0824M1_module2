package ss6.s4;

public class main {
        public static void main(String[] args) {
            Point point = new Point(2, 3);
            System.out.println("Point: " + point);

            MovablePoint movablePoint = new MovablePoint(2, 3, 1, 1);
            System.out.println("MovablePoint before move: " + movablePoint);
            movablePoint.move();
            System.out.println("MovablePoint after move: " + movablePoint);
        }

}
