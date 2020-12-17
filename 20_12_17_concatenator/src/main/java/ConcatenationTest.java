import java.util.ArrayList;

public class ConcatenationTest {

    private IConcatenator concatenator;

    ConcatenationTest(IConcatenator concatenator){

            this.concatenator = concatenator;
    }

    public void test(int times, String text){
        String[] strings = composeArray(times, text);
        long timeBefore = System.currentTimeMillis();
        concatenator.concatenate(strings);
        System.out.println(System.currentTimeMillis() - timeBefore);
    }

    private String[] composeArray(int times, String text) {

            ArrayList<String> strings = new ArrayList<>();

            for (int i = 0; i < times; i++) {

                strings.add(text);
        }
            return strings.toArray(new String[0]);
    }
}
