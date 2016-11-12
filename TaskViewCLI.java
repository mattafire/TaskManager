/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskManager;

import java.util.Scanner;

/**
 *
 * @author Mattafire
 */
public class TaskViewCLI {

    public TaskViewCLI() {
    }
    
    public void taskView(String[][] tasks){
        for(int i = 0; i<tasks.length;i++){
            System.out.print(i+1 + " " + tasks[i][0] + " " + tasks[i][1] + " " + tasks[i][2]+ " "); //+ " "+tasks[i][3]);
            int length = 5 + tasks[i][0].length() + tasks[i][1].length() + tasks[i][2].length();
            for(int l=0;length<77&&l<tasks[i][3].length();length++,l++){
                System.out.print(tasks[i][3].charAt(l));
            }
            System.out.println("...");
        }
    }
    
    public String menu(){
        System.out.println("Please choose and option:");
        System.out.println("1: New Task");
        System.out.println("2: Edit Task");
        System.out.println("3: View Tasks");
        System.out.println("4: Save");
        System.out.println("5: Quit");
        System.out.print(">>");
        Scanner input = new Scanner(System.in);
        String userIn = input.next();
        return userIn;
    }
    
    public String save(){
        System.out.println("Please enter a task number or type 'All'");
        return getUserInput();
    }
    
    public void viewTask(String[] task){
        System.out.println("1 Name: "+ task[0]);
        System.out.println("2 Date: "+ task[1]);
        System.out.println("3 Priority: "+ task[2]);
        System.out.println("4 Notes: "+ task[3]);
        System.out.println("5 none");
    }
    
    public String editTask(){
        System.out.print("Please choose a task number:");
        return getUserInput();
    }
    public String editTaskChoice(){
        System.out.print("Please choose a task detail to edit:");
        return getUserInput();
    }
    public String getName(){
        System.out.print("Please enter a Task name:");
        return getUserInput();
    }
    public String getNotes(){
        System.out.print("Please enter Task Notes:");
        return getUserInput();
    }
    public String getDate(){
        System.out.print("Please enter a Task due Date:");
        return getUserInput();
    }
    public String getPriority(){
        System.out.print("Please enter Task Priority:");
        return getUserInput();
    }
    private String getUserInput(){
        Scanner input = new Scanner(System.in);
        String userIn = input.nextLine();
        return userIn;
    }
}
