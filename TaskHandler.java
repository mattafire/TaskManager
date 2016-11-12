/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class TaskHandler {

    ArrayList tasks = new ArrayList();
    TaskViewCLI outPut = new TaskViewCLI();
    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
    Hibernate hib = new Hibernate();

    public TaskHandler() {
    }

    public void newTask(String name) {
        tasks.add(new Task(name));
    }

    public void newTask(String name, Date date, String priority, String notes) {
        tasks.add(new Task(name, notes, date, priority));
    }

    public void toView() {
        //may change type
        String[][] outTasks = new String[tasks.size()][4];
        //0-name 1-date 2-priority 3-notes
        for (int i = 0; i < tasks.size(); i++) {
            outTasks[i] = parseTask(i);
        }
        outPut.taskView(outTasks);
    }

    private String[] parseTask(int i) {
        String[] out = new String[4];
        out[0] = ((Task) tasks.get(i)).getTaskName();
        out[1] = ((Task) tasks.get(i)).getDateDue().toString();
        out[2] = ((Task) tasks.get(i)).getPriority();
        out[3] = ((Task) tasks.get(i)).getNotes();
        return out;
    }

    public void userMenu() throws ParseException {
        boolean done = false;
        do {
            String userIn = outPut.menu();
            String name = new String();
            Date date = new Date();
            String priority = new String();
            String notes = new String();
            switch (userIn) {
                case "1":
                    name = outPut.getName();
                    date = format.parse("12/25/2016");//outPut.getDate();
                    priority = outPut.getPriority();
                    notes = outPut.getNotes();
                    newTask(name, date, priority, notes);
                    break;
                case "2":
                    int choice = Integer.parseInt(outPut.editTask());
                    outPut.viewTask(parseTask(choice));
                    boolean finish = false;
                    while (!finish) {
                        String in = outPut.editTaskChoice();
                        switch (in) {
                            case "1":
                                name = outPut.getName();
                                ((Task) tasks.get(choice)).setTaskName(name);
                                break;
                            case "2":
                                date = format.parse("12/31/2016");//outPut.getDate();
                                ((Task) tasks.get(choice)).setDateDue(date);
                                break;
                            case "3":
                                priority = outPut.getPriority();
                                ((Task) tasks.get(choice)).setPriority(priority);
                                break;
                            case "4":
                                notes = outPut.getNotes();
                                ((Task) tasks.get(choice)).setNotes(notes);
                                break;
                            case "5":
                                finish = true;
                                break;
                        }
                    }
                    break;
                case "3":
                    toView();
                    break;
                case "4":
                    userIn = outPut.save();
                    System.out.println(userIn + " "+(userIn.contains("all")));
                    if(userIn.toLowerCase().contains("all")||userIn == "0"){
                        for(int i = 0; i < tasks.size();i++){
                            hib.updatetask((Task)tasks.get(i));
                        }
                    }
                    else{
                        hib.updatetask((Task)tasks.get(Integer.parseInt(userIn)-1));
                    }
                        
                    break;
                case "5" :
                    done = true;
                    break;
            }
        } while (!done);

    }

}
