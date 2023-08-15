package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class App {

    public static void main(String[] args) {
        Validator v = new Validator();
        StringSchema schema = v.string();

        System.out.println("\"\" -> " + schema.isValid("")); // true
        System.out.println("null -> " + schema.isValid(null)); // true

        schema.required();

        System.out.println("\n\"\" -> " + schema.isValid("")); // false
        System.out.println("null -> " + schema.isValid(null)); // false
        //System.out.println(schema.isValid(5)); // false
        System.out.println("what does the fox say -> " + schema.isValid("what does the fox say")); // true
        schema.contains("he");
        System.out.println("HExlet -> " + schema.isValid("hexlet")); // true
    }
}
