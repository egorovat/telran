package telran.de;


public class Picture extends Shape {

    Shape[] shapes;
    private final int BORDER_LENGTH = 50;

    private Line borderLine;

    public Picture(Shape[] shapes, char symbol) {

        this.shapes = shapes;
        this.symbol = symbol;
        borderLine = new Line(BORDER_LENGTH, symbol);

    }

    @Override
    public void draw(){

        borderLine.draw();


        for(Shape shape : shapes){

            shape.draw();
        }

        borderLine.draw();

    }



}
