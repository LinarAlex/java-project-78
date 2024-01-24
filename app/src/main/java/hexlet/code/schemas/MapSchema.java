package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public final MapSchema required() {
        addConditions(m -> m instanceof Map<?, ?> && m != null);
        setRequiredOn();
        return this;
    }

    public final MapSchema sizeof(int size) {
        addConditions(m -> m instanceof Map && ((Map<?, ?>) m).size() == size);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> newMap) {
        addConditions(m -> checkingMap((Map<String, BaseSchema>) m, newMap));
        return this;
    }

    private boolean checkingMap(Map<String, BaseSchema> original, Map<String, BaseSchema> shapedMap) {
        for (Map.Entry<String, BaseSchema> map : shapedMap.entrySet()) {
            String key = map.getKey();
            if (!map.getValue().isValid(original.get(key))) {
                return false;
            }
        } return true;
    }
}
