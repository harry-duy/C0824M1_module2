package ss6.s2;

public class Circle {
        private double radius;
        private String color;

        public Circle(double radius, String color) {
            this.radius = radius;
            this.color = color;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public double getArea() {
            return Math.PI * Math.pow(radius, 2);
        }

        @Override
        public String toString() {
            return "Circle has radius: " + radius + " and color " + color + ", area is " + getArea();
        }

        public static void main(String[] args) {
            Circle circle = new Circle(5, "red");
            System.out.println(circle.toString());
            circle.setRadius(10);
            System.out.println(circle.toString());
        }

}
