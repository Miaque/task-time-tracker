package com.demo.tttracker.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "ttt_task")
@NamedQueries({
        @NamedQuery(name = "Task.findAll", query = "select t from Task t"),
        @NamedQuery(name = "Task.findByIdTask", query = "select t from Task t where t.idTask = :idTask"),
        @NamedQuery(name = "Task.findByTaskName", query = "select t from Task t where t.taskName = :taskName")
})
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private int idTask;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "task_name")
    private String taskName;

    @JoinColumn(name = "id_project", referencedColumnName = "id_project")
    @ManyToOne
    private Project project;

    public Task() {
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return idTask == task.idTask;
    }

    @Override
    public int hashCode() {
        return idTask;
    }

    @Override
    public String toString() {
        return "Task{" +
                "idTask=" + idTask +
                ", taskName='" + taskName + '\'' +
                ", project=" + project +
                '}';
    }
}
