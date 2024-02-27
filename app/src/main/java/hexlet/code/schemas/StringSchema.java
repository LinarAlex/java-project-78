package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        addConditions(n -> n == null || n instanceof String);
    }

    public final StringSchema required() {
        addNotNullCheck();
        addConditions(n -> n != "");
        return this;
    }

    public final StringSchema minLength(int min) {
        addConditions(n -> n == null || ((String) n).length() >= min);
        return this;
    }

    public final StringSchema contains(String substring) {
        addConditions(n -> n == null || ((String) n).contains(substring));
        return this;
    }
}
