package club.focus.searchtest.db.specification;

import club.focus.searchtest.db.entity.TaskAction;
import org.springframework.data.jpa.domain.Specification;

import java.util.Locale;

public class TaskActionSpecification {

    public static Specification<TaskAction> searchNameAndType(String search) {
        var searchLower = search.toLowerCase();
        return (root, query, builder) ->
            builder.or(
                    builder.like(builder.lower(root.get("task").get("name")), "%"+searchLower+"%"),
                    builder.like(builder.lower(root.get("actionType")), "%"+searchLower+"%")
            );
    }
}
