package com.demo.tttracker.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ttt_task_log")
@NamedQueries({
        @NamedQuery(name = "TaskLog.findAll", query = "select t from TaskLog t"),
        @NamedQuery(name = "TaskLog.findByIdTaskLog", query = "select t from TaskLog t where t.idTaskLog = :idTaskLog"),
        @NamedQuery(name = "TaskLog.findByTaskDescription", query = "select t from TaskLog t where t.taskDescription = :taskDescription"),
        @NamedQuery(name = "TaskLog.findByTaskLogDate", query = "select t from TaskLog t where t.taskLogDate = :taskLogDate"),
        @NamedQuery(name = "TaskLog.findByTaskMinutes", query = "select t from TaskLog t where t.taskMinutes = :taskMinutes")
})
public class TaskLog {

    @Id
    @Column(name = "id_task_log")
    private int idTaskLog;
    private String taskDescription;
    private Date taskLogDate;
    private int taskMinutes;

    @Id
    @Column(name = "id_task_log")
    public int getIdTaskLog() {
        return idTaskLog;
    }

    public void setIdTaskLog(int idTaskLog) {
        this.idTaskLog = idTaskLog;
    }

    @Basic
    @Column(name = "task_description")
    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Basic
    @Column(name = "task_log_date")
    public Date getTaskLogDate() {
        return taskLogDate;
    }

    public void setTaskLogDate(Date taskLogDate) {
        this.taskLogDate = taskLogDate;
    }

    @Basic
    @Column(name = "task_minutes")
    public int getTaskMinutes() {
        return taskMinutes;
    }

    public void setTaskMinutes(int taskMinutes) {
        this.taskMinutes = taskMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskLog taskLog = (TaskLog) o;

        if (idTaskLog != taskLog.idTaskLog) return false;
        if (taskMinutes != taskLog.taskMinutes) return false;
        if (taskDescription != null ? !taskDescription.equals(taskLog.taskDescription) : taskLog.taskDescription != null)
            return false;
        if (taskLogDate != null ? !taskLogDate.equals(taskLog.taskLogDate) : taskLog.taskLogDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTaskLog;
        result = 31 * result + (taskDescription != null ? taskDescription.hashCode() : 0);
        result = 31 * result + (taskLogDate != null ? taskLogDate.hashCode() : 0);
        result = 31 * result + taskMinutes;
        return result;
    }
}
