package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        addConditions(m -> m == null || (m instanceof Map));
    }

    public final MapSchema required() {
        addNotNullCheck();
        return this;
    }

    public final MapSchema sizeof(int size) {
        addConditions(m -> m == null || ((Map) m).size() == size);
        return this;
    }

    public final void shape(Map<String, BaseSchema> schemas) {
        addConditions(m -> checkingMap(schemas, (Map) m));
    }

    private boolean checkingMap(Map<String, BaseSchema> schemas, Map<String, Object> input) {
        return input.entrySet().stream()
               .allMatch(x -> schemas.get(x.getKey()).isValid(x.getValue()));
    }
}
