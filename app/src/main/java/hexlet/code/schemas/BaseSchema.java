package hexlet.code.schemas;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema {
    private ArrayList<Predicate<Object>> conditions = new ArrayList<>();

    public final boolean isValid(Object data) {
        return conditions.stream().allMatch(p -> p.test(data));
    }

    public final void addConditions(Predicate<Object> predicate) {
        conditions.add(predicate);
    }

    public final void addNotNullCheck() {
        addConditions(Objects::nonNull);
    }


}
