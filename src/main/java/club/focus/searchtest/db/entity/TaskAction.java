package club.focus.searchtest.db.entity;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name="task_action")
public class TaskAction {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "start", nullable = false)
    private OffsetDateTime start;

    @Column(name = "\"end\"", nullable = false)
    private OffsetDateTime end;

    @Column(name = "`actionType`", nullable = false)
    private String actionType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`taskId`")
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public OffsetDateTime getEnd() {
        return end;
    }

    public void setEnd(OffsetDateTime end) {
        this.end = end;
    }

    public OffsetDateTime getStart() {
        return start;
    }

    public void setStart(OffsetDateTime start) {
        this.start = start;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
