package io.sarath.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Warnings implements Serializable{

    @Id
    @Column(columnDefinition = "varchar(36)")
    private String Warningid;
    @Id
    private String Vin;

    private String ReadingId;
    private String alert;
    private String priority;

    public String getWarningid() {
        return Warningid;
    }

    public void setWarningid(String warningid) {
        Warningid = warningid;
    }

    public String getVin() {
        return Vin;
    }

    public void setVin(String vin) {
        Vin = vin;
    }

    public String getReadingId() {
        return ReadingId;
    }

    public void setReadingId(String readingId) {
        ReadingId = readingId;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Warnings() {
        this.Warningid = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Warnings{" +
                "Warningid='" + Warningid + '\'' +
                ", Vin='" + Vin + '\'' +
                ", ReadingId='" + ReadingId + '\'' +
                ", alert='" + alert + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
