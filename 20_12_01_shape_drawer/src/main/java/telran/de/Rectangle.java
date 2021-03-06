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


       StringBuilder builder = new StringBuilder();

        for(int j = 0; j < height; j++){
            for(int i = 0; i < width; i++){

                if((j == 0 || i == 0) || (i == width -1 || j == height -1))
                    builder.append(symbol);
                //System.out.print(symbol);

                else  builder.append(" "); //System.out.print(" ");
            }

            if(j != height -1)
            builder.append(System.lineSeparator()); //System.out.println();
        }

        System.out.println(builder);
    }

}
