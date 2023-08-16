package hexlet.code.schemas;


public class StringSchema extends BaseSchema{
    private static final String DATA_TYPE = "dataType";
    private static final String REQUIRED = "required";
    private static final String MIN_LENGTH = "minLength";
    private static final String CONTAINS = "contains";
    private static int minLengthValue;
    private static String containsString;

    public StringSchema() {
        addCheck(DATA_TYPE, value -> (value instanceof String) || value == null);
//        containsStatus = false;
//        requiredStatus = false;
//        lengthStatus = false;
    }

    public StringSchema required() {
        //requiredStatus = true;
        addCheck(REQUIRED, value -> (value instanceof String) && (!value.equals("")));
        return this;
    }

    public StringSchema minLength(int length) {
        //lengthStatus = true;
        minLengthValue = length;
        addCheck(MIN_LENGTH, value -> (value == null) || (value.toString().length() >= minLengthValue));
        return this;
    }

    public StringSchema contains(String str) {
        //containsStatus = true;
        containsString = str;
        addCheck(CONTAINS, value -> (value != null) && (value.toString().contains(containsString)));
        return this;
    }

//    public boolean isValid(String checkedValue) {
//        return isRequired(checkedValue) && isCorrectLength(checkedValue) && containsCurString(checkedValue);
//    }
//
//    private boolean containsCurString(String checkedValue) {
//        if (containsStatus) {
//            if (checkedValue == null)
//                return false;
//            return checkedValue.contains(containsString);
//        }
//        return true;
//    }
//
//    private boolean isCorrectLength(String checkedValue) {
//        if (lengthStatus) {
//            return checkedValue != null && checkedValue.length() >= minLengthValue;
//        }
//        return true;
//    }
//
//    private boolean isRequired(String checkedValue) {
//        if (requiredStatus) {
//            if (checkedValue == null)
//                return false;
//            return !checkedValue.isEmpty();
//        }
//        return true;
//    }
}
