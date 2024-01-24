package hexlet.code.schemas;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchemas {
    private List<Predicate> conditions = new ArrayList<>();
    private boolean check;

    protected final void addConditions(Predicate condition) {
        conditions.add(condition);
    }

    protected final void setRequiredOn() {
        check = true;
    }

    public final boolean isValid(Object obj) {
        if (obj == null) {
            return !check;
        }
        for (Predicate condition : conditions) {
            if (!condition.test(obj)) {
                return false;
            }
        } return true;
    }

}
