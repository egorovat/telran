import java.util.Random;

public class RangeRandomRule implements RandomRule{

    private int n;

    public RangeRandomRule(int number){

        n = number;
    }

    @Override
    public int nextInt() {

        Random rand = new Random();
        return  rand.nextInt(n);

    }
}
