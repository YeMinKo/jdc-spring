package demo.custom.printer;

import com.sun.jdi.Value;

public class DecoratedValuePrinter implements ValuePrinter {
    @Override
    public void print(int value) {
        System.out.println(String.format("Value = [%d]", value));
    }
}
