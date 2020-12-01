package telran.de;


public class ShapeDrawer {

    public static void main(String []args){

        Line line = new Line(5, '*');
        Rectangle rectangle = new Rectangle(4, 7, '+');

        Shape[] shapesInside = new Shape[]{new Line(28, '%'), new Line(12,'*'), new Rectangle(4, 7, '#'), new Line(28, '%')};

        Shape[] shapes = new Shape[]{new Line(28,'>'), new Picture(shapesInside, '`'), new Rectangle(5, 10, '/'), new Line(28, '<')};

        Picture picture = new Picture(shapes, '-');

        rectangle.draw();
        line.draw();
        picture.draw();

    }
}
