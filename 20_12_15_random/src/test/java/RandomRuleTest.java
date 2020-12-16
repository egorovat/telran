import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomRuleTest {

    @Test
    public void testRangeRandomRule(){

        RangeRandomRule rule = new RangeRandomRule(15);
        for (int i = 0; i < 20; i++) {
            System.out.print(rule.nextInt() + "; ");
        }
    }

    @Test
    public void testListRandomRuleIntArray(){

        int[] numbers = {4,18,0,-7,9,9,34};
        ListRandomRule rule = new ListRandomRule(numbers);
        for (int i = 0; i < 20; i++) {
            System.out.print(rule.nextInt() + "; ");
        }
    }

    @Test
    public void testListRandomRuleArrayList(){

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(18);
        numbers.add(0);
        numbers.add(-7);
        numbers.add(34);

        ListRandomRule rule = new ListRandomRule(numbers);
        for (int i = 0; i < 20; i++) {
            System.out.print(rule.nextInt() + "; ");
        }
    }

    @Test
    public void testListGeneratorRangeRandomRule(){

        RandomGenerator generator = new RandomGenerator(new RangeRandomRule(5));
        System.out.println(generator.nextInts(20));
    }

    @Test
    public void testListGeneratorListRandomRuleArrayList(){

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(18);
        numbers.add(0);
        numbers.add(-7);
        numbers.add(34);
        RandomGenerator generator = new RandomGenerator(new ListRandomRule(numbers));
        System.out.println(generator.nextInts(20));
    }

    @Test
    public void testListGeneratorListRandomRuleIntArray(){

        int[] numbers = {4,18,0,-7,9,9,34};

        RandomGenerator generator = new RandomGenerator(new ListRandomRule(numbers));
        System.out.println(generator.nextInts(20));
    }
}
