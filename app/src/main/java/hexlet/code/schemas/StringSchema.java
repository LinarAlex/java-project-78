package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        addConditions(s -> s instanceof String && !"".equals(s) && s != null);
        setRequiredOn();
        return this;
    }

    public final StringSchema minLength(int num) {
        addConditions(s -> s.toString().length() >= num);
        return this;
    }

    public final StringSchema contains(String substring) {
        addConditions(s -> s.toString().contains(substring));
        return this;
    }
}
