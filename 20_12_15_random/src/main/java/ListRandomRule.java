import java.util.*;

public class ListRandomRule implements RandomRule{

    List<Integer> values;

    public ListRandomRule(List<Integer> list){

        values = list;
    }

    public ListRandomRule(int[] numbers){

        values = new ArrayList<>();
        for (Integer number : numbers) {
                values.add(number);
        }

    }

    @Override
    public int nextInt() {

        int index = new Random().nextInt(values.size() - 1 );
        return values.get(index);
    }
}
