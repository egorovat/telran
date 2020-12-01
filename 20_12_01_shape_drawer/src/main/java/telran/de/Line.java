package telran.de;


public class Line extends Shape {

    int lang;

    public Line(int lang, char symbol) {

        this.lang = lang;
        this.symbol = symbol;
    }

    @Override
    void draw(){

        System.out.println();
        for(int i = 0; i < lang; i++){
            System.out.print(symbol);
        }
    }

}
