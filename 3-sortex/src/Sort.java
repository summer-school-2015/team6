import java.io.*;
import java.util.*;

/**
 * Created by User on 04/06/2015.
 */


public class Sort {

    static PrintWriter out;

    static class Shape{
        public double getSquare(){
            return 0.0;
        }

        void output(){
        }

    }

    static class Rectangle extends Shape{
        double a, b;

        Rectangle(double _a, double _b) {
            a = _a;
            b = _b;
        }

        @Override
        void output(){
            out.printf("RECT %f\n", getSquare());
        }

        public double getSquare() {
            return a * b;
        }
    }

    static class Triangle extends Shape{
        double p, h;

        Triangle(double _p, double _h){
            p = _p;
            h = _h;
        }

        @Override
        void output(){
            out.printf("TRIANGLE %f\n", getSquare());
        }

        public double getSquare() {
            return p * h * 0.5;
        }
    }

    static class Circle extends Shape{
        double r;

        Circle(double _r){
            r = _r;
        }

        @Override
        void output(){
            out.printf("CIRCLE %f\n", getSquare());
        }

        public double getSquare() {
            return r * r * Math.PI;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //Comparator<Shape> c;
        Scanner in = new Scanner(new FileReader("input.txt"));
        out = new PrintWriter("output.txt");
        int n = in.nextInt();
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        for (int i = 0; i < n; i++){
            String s = in.next();
            if (s.equals("TRIANGLE")){
                double p = (double)in.nextInt(), h = (double)in.nextInt();
                shapes.add(new Triangle(p, h));
            }
            else if (s.equals("RECT")) {
                double a = (double)in.nextInt(), b = (double)in.nextInt();
                shapes.add(new Rectangle(a, b));
            }
            else{
                double r = (double)in.nextInt();
                shapes.add(new Circle(r));
            }
        }
        assert shapes != null;
        shapes.sort(new Comparator<Shape>() {

            @Override
            public int compare(Shape o1, Shape o2) {
                Shape a = (Shape) o1;
                Shape b = (Shape) o2;
                if (a.getSquare() < b.getSquare()) return -1;
                else if (a.getSquare() == b.getSquare()) return 0;
                else return 1;
            }
        });
        for (Object obj: shapes){
            Shape s = (Shape) obj;
            s.output();
        }
        /*for (int i = 0; i < n; i++){
            ar[i].output();
        }*/
        out.close();
    }

}
