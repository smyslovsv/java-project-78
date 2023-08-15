package hexlet.code.schemas;

public class NumberSchema {
    private static boolean positiveStatus = false;
    private static boolean rangeStatus = false;
    private static boolean requiredStatus = false;
    private static int minValue = 0;
    private static int maxValue = 0;

    public NumberSchema() {
    }

    public void required() {
        requiredStatus = true;
    }

    public void range(int start, int end) {
        rangeStatus = true;
        minValue = start;
        maxValue = end;
    }

    public void positive() {
        positiveStatus = true;
    }

    public boolean isValid(Integer checkedValue) {
        return isRequired(checkedValue) && isCorrectRange(checkedValue) && isPositive(checkedValue);
    }

    private boolean isPositive(Integer checkedValue) {
        if (positiveStatus)
            return checkedValue > 0;
        return true;
    }

    private boolean isCorrectRange(Integer checkedValue) {
        if (rangeStatus)
            return checkedValue >= minValue && checkedValue <= maxValue;
        return true;
    }

    private boolean isRequired(Integer checkedValue) {
        if (requiredStatus) {
            return checkedValue != null;
        }
        return true;
    }

}
