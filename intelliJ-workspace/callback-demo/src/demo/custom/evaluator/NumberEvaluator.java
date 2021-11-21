package demo.custom.evaluator;

import demo.custom.ds.Pair;
import demo.custom.expression.ExpressionEvaluator;
import demo.custom.printer.ValuePrinter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberEvaluator {

    public void evaluate(int n, ExpressionEvaluator evaluator, ValuePrinter valuePrinter) {
        List<Pair> numberPairs = generatePairs(n);

        for(Pair pair: numberPairs) {
            valuePrinter.print(
                    evaluator.evaluate(pair.getA(), pair.getB())
            );
        }
    }

    private List<Pair> generatePairs(int n) {
        return IntStream.range(1, n + 1)
                .mapToObj(i -> new Pair(i,  2 * i))
                .collect(Collectors.toList());
    }
}
