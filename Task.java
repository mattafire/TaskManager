/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskManager;

import java.util.Date;

/**
 *
 * @author Mattafire
 */
public class Task {
    Date dateDue = new Date();
    String taskName = new String();
    String notes = new String();
    String priority = new String();

    public Task(String name,String notes,Date date, String priority) {
        taskName = name;
        this.notes = notes;
        dateDue = date;
        this.priority = priority;
    }
    public Task(String name) {
        taskName = name;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
}
