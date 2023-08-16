package hexlet.code.schemas;

public class NumberSchema {
    private static boolean positiveStatus;
    private static boolean rangeStatus;
    private static boolean requiredStatus;
    private static int minValue;
    private static int maxValue;

    public NumberSchema() {
        positiveStatus = false;
        requiredStatus = false;
        rangeStatus = false;
    }

    public NumberSchema required() {
        requiredStatus = true;
        return this;
    }

    public NumberSchema range(int start, int end) {
        rangeStatus = true;
        minValue = start;
        maxValue = end;
        return this;
    }

    public NumberSchema positive() {
        positiveStatus = true;
        return this;
    }

    public boolean isValid(Integer checkedValue) {
        return isRequired(checkedValue) && isCorrectRange(checkedValue) && isPositive(checkedValue);
    }

    private boolean isPositive(Integer checkedValue) {
        if (positiveStatus) {
            if (checkedValue == null)
                return true;
            return checkedValue > 0;
        }
        return true;
    }

    private boolean isCorrectRange(Integer checkedValue) {
        if (rangeStatus) {
            if (checkedValue == null)
                return false;

            return checkedValue >= minValue && checkedValue <= maxValue;
        }
        return true;
    }

    private boolean isRequired(Integer checkedValue) {
        if (requiredStatus) {
            if (checkedValue == null)
                return false;
        }
        return true;
    }

}
