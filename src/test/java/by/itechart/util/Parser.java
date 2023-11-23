package by.itechart.util;

public class Parser {
    public static double parseNumberWithCommaToDouble(String value) {
        return Double.parseDouble(value.replaceAll(",", "."));
    }
}
