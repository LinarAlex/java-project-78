package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addConditions(p -> p == null || (p instanceof Integer));
    }

    public final NumberSchema required() {
        addNotNullCheck();
        return this;
    }

    public final NumberSchema positive() {
        addConditions(p -> p == null || (Integer) p > 0);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        addConditions(p -> (p == null) || (min <= (Integer) p && (Integer) p <= max));
        return this;
    }
}
