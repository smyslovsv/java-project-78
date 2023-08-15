package hexlet.code.schemas;


public class StringSchema {
    private static boolean requiredStatus = false;
    private static boolean lengthStatus = false;
    private static boolean containsStatus = false;
    private static int minLengthValue = 0;
    private static String containsString = "";

    public StringSchema() {
    }

    public void required() {
        requiredStatus = true;
    }

    public void minLength(int length) {
        requiredStatus = true;
        minLengthValue = length;
    }

    public void contains(String str) {
        containsStatus = true;
        containsString = str;
    }

    public boolean isValid(String checkedValue) {
        return isRequired(checkedValue) && isCorrectLength(checkedValue) && containsCurString(checkedValue);
    }

    private boolean containsCurString(String checkedValue) {
        if (containsStatus) {
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
