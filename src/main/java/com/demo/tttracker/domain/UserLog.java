package com.demo.tttracker.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ttt_user_log", schema = "task_time_tracker", catalog = "")
public class UserLog {
    private int idUserLog;
    private String username;
    private String ipAddress;
    private String status;
    private Timestamp logDate;

    @Id
    @Column(name = "id_user_log")
    public int getIdUserLog() {
        return idUserLog;
    }

    public void setIdUserLog(int idUserLog) {
        this.idUserLog = idUserLog;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "log_date")
    public Timestamp getLogDate() {
        return logDate;
    }

    public void setLogDate(Timestamp logDate) {
        this.logDate = logDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLog userLog = (UserLog) o;

        if (idUserLog != userLog.idUserLog) return false;
        if (username != null ? !username.equals(userLog.username) : userLog.username != null) return false;
        if (ipAddress != null ? !ipAddress.equals(userLog.ipAddress) : userLog.ipAddress != null) return false;
        if (status != null ? !status.equals(userLog.status) : userLog.status != null) return false;
        if (logDate != null ? !logDate.equals(userLog.logDate) : userLog.logDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUserLog;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (logDate != null ? logDate.hashCode() : 0);
        return result;
    }
}
