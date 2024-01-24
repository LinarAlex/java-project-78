package hexlet.code.schemas;

public class NumberSchema extends BaseSchemas {

    public final NumberSchema required() {
        addConditions(n -> n instanceof Integer && n != null);
        setRequiredOn();
        return this;
    }

    public final NumberSchema positive() {
        addConditions(n -> n instanceof Integer && Integer.parseInt(n.toString()) > 0);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        addConditions(n -> n instanceof Integer && Integer.parseInt(n.toString()) >= min
                && Integer.parseInt(n.toString()) <= max);
        return this;
    }
}
