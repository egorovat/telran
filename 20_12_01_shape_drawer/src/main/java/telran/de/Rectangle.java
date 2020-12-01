package telran.de;


public class Rectangle extends Shape {

    int height;
    int width;

    public Rectangle(int height, int width, char symbol) {

        this.symbol = symbol;
        this.height = height;
        this.width = width;

    }

    @Override
    public void draw() {


        System.out.println();

        for(int j = 0; j < height; j++){
            for(int i = 0; i < width; i++){

                if((j == 0 || i == 0) || (i == width -1 || j == height -1))
                    System.out.print(symbol);

                else System.out.print(" ");
            }

            if(j != height -1)
            System.out.println();
        }
    }

}
