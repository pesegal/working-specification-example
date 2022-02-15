package club.focus.searchtest.db.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @Column(name = "updated_date", nullable = false)
    private Instant updatedDate;

    @Column(name = "deleted_timestamp")
    private Instant deletedTimestamp;

    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "`columnPos`", nullable = false)
    private Integer columnPos;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "notes", nullable = false)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`userId`")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`listId`")
    private List list;

    @ManyToMany
    @JoinTable(name = "project_tasks_task",
            joinColumns = @JoinColumn(name = "taskId"),
            inverseJoinColumns = @JoinColumn(name = "projectId"))
    private Set<Project> projects = new LinkedHashSet<>();

    @OneToMany(mappedBy = "task")
    private Set<TaskAction> taskActions = new LinkedHashSet<>();

    public Set<TaskAction> getTaskActions() {
        return taskActions;
    }

    public void setTaskActions(Set<TaskAction> taskActions) {
        this.taskActions = taskActions;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getColumnPos() {
        return columnPos;
    }

    public void setColumnPos(Integer columnPos) {
        this.columnPos = columnPos;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Instant getDeletedTimestamp() {
        return deletedTimestamp;
    }

    public void setDeletedTimestamp(Instant deletedTimestamp) {
        this.deletedTimestamp = deletedTimestamp;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}