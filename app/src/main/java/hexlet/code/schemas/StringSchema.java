package hexlet.code.schemas;


public class StringSchema {
    private static boolean requiredStatus;
    private static boolean lengthStatus;
    private static boolean containsStatus;
    private static int minLengthValue;
    private static String containsString;

    public StringSchema() {
        containsStatus = false;
        requiredStatus = false;
        lengthStatus = false;
    }

    public StringSchema required() {
        requiredStatus = true;
        return this;
    }

    public StringSchema minLength(int length) {
        lengthStatus = true;
        minLengthValue = length;
        return this;
    }

    public StringSchema contains(String str) {
        containsStatus = true;
        containsString = str;
        return this;
    }

    public boolean isValid(String checkedValue) {
        return isRequired(checkedValue) && isCorrectLength(checkedValue) && containsCurString(checkedValue);
    }

    private boolean containsCurString(String checkedValue) {
        if (containsStatus) {
            if (checkedValue == null)
                return false;
            return checkedValue.contains(containsString);
        }
        return true;
    }

    private boolean isCorrectLength(String checkedValue) {
        if (lengthStatus) {
            return checkedValue != null && checkedValue.length() >= minLengthValue;
        }
        return true;
    }

    private boolean isRequired(String checkedValue) {
        if (requiredStatus) {
            if (checkedValue == null)
                return false;
            return !checkedValue.isEmpty();
        }
        return true;
    }

}
