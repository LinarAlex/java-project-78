package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchemas {

    public final MapSchema required() {
        addConditions(m -> m instanceof Map<?, ?> && m != null);
        setRequiredOn();
        return this;
    }

    public final MapSchema sizeof(int size) {
        addConditions(m -> m instanceof Map && ((Map<?, ?>) m).size() == size);
        return this;
    }
}
