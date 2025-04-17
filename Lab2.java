import java.util.ArrayList;
import java.util.Scanner;

/*
 NO CHANGES should be made to the lines below
 EXCEPT FOR THE COPY CONSTRUCTOR
 Note: Java has its own enum for days of the week, 
 but I realized this too late. Work with this enum instead
 -------------NO CHANGES BELOW THIS LINE----------------
 */
enum Day { MON, TUES, WED, THURS, FRI, SAT, SUN }
enum Color { RED, YELLOW, GREEN }

class Task {
    String date;
    String itemInfo;
    boolean isComplete;
    Color importance;
    static int itemsCreated = 0;
    int id;

    Task(String date, String info, Color importance){
        this.date = date;
        this.itemInfo = info;
        this.isComplete = false;
        this.importance = importance;

        id = ++itemsCreated;
    }

    Task(Task originalTask) {
        this.date = originalTask.date;
        this.itemInfo = originalTask.itemInfo;
        this.isComplete = originalTask.isComplete;
        this.importance = originalTask.importance; 
        this.id = ++itemsCreated; //this just says take the orignal id, then add one. 
    }

    void changeIsComplete(){
        isComplete = !isComplete;
    }

    public String toString(){
        String completionStatus = isComplete ? "Complete" : "Incomplete"; 
        String str = String.format("TaskID: %d\nImportance: %s\nStatus: %s\nInfo: %s\nDate: %s", id, importance.toString(), completionStatus, this.itemInfo, this.date);
        return str;
    }
}

// -------------NO CHANGES ABOVE THIS LINE----------------

class Planner {
    // Create a data structure that will store tasks as a task list
    ArrayList <Task> taskList = new ArrayList<>();

    Task myPlanner;


    // this method adds a new task to a task list
    // @params: Day weekday, int monthDay, String taskInfo, Color importance
    void addNewTask(Day weekday, int monthDay, String taskInfo, Color importance){
        // add your code here
    }

    // this method removes an item by the Task ID
    // NOT the task list index
    // do NOT change the value of Task.itemsCreated 
    // @param: int id
    void removeTaskById(int id){
        // add your code here
    }

    // this method calls the task toString method
    // for each task that exists in the task list
    void showAllTasks(){
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(taskList.get(i)); //using getter and looping through the arrayList based off number of indices
        }
    }

    // this method will change the completion status of a task item
    // by the Task ID, NOT by the task list index
    void markCompletion(int id){
        // add your code here
    }

}


class Lab2{


    /* 
    This method prompts the user to enter the information needed
    to create a task. Cases such as "red", "RED", "Monday", "MON"
    should be taken into account as potential inputs. Invalid inputs
    should also be alerted to the user. Select default values to
    initialize your variables to.

    @Param: Planner obj
    */
    static void addNewTask(Planner a){
       System.out.println("Welcome to Your Digital Planner\nPlease select from the following menu options:");
       System.out.println("");
       System.out.println("1. Display all planner tasks");
       System.out.println("2. Add task to planner");
       System.out.println("3. Remove task from planner");
       System.out.println("4. Mark Planner task as complete");
       System.out.println("");
       System.out.println("Please make your selection:\n>>>");
       

    }


    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        Planner myPlanner = new Planner();

        addNewTask(myPlanner);
        
        myPlanner.showAllTasks();

            
    }
}