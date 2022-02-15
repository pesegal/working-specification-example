package club.focus.searchtest.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

public class TaskActionDto implements Serializable {
    private final UUID id;
    private final OffsetDateTime start;
    private final OffsetDateTime end;
    private final String actionType;
    private final String taskName;

    public TaskActionDto(UUID id, OffsetDateTime start, OffsetDateTime end, String actionType, String taskName) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.actionType = actionType;
        this.taskName = taskName;
    }

    public UUID getId() {
        return id;
    }

    public OffsetDateTime getStart() {
        return start;
    }

    public OffsetDateTime getEnd() {
        return end;
    }

    public String getActionType() {
        return actionType;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskActionDto entity = (TaskActionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.start, entity.start) &&
                Objects.equals(this.end, entity.end) &&
                Objects.equals(this.actionType, entity.actionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, end, actionType);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "start = " + start + ", " +
                "end = " + end + ", " +
                "actionType = " + actionType + ")";
    }
}
