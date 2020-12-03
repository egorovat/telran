package telran.de;


public class Line extends Shape {

    int lang;

    public Line(int lang, char symbol) {

        this.lang = lang;
        this.symbol = symbol;
    }

    @Override
    void draw(){

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < lang; i++){
           builder.append(symbol).append(" ");
        }

        System.out.println(builder);
    }

}
