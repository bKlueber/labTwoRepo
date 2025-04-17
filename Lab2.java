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

    Task(Task originalTask) { // this is my copy constructor and i will not add any other code to this area
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
    void addNewTask(Day weekDay, int monthDay, String taskInfo, Color importance){
        String date = weekDay + " " + monthDay; // formats the date
        Task newTask = new Task(date, taskInfo, importance);
        taskList.add(newTask);
    }

    // this method removes an item by the Task ID
    // NOT the task list index
    // do NOT change the value of Task.itemsCreated 
    // @param: int id
    void removeTaskById(int id){
        for( Task task: taskList) { //goes through the task lists
            if (task.id == id) { //checks to see if current itteration matches user input id
            taskList.remove(task); //says if found remove that task
            break; //stops the loop
            }
        }
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
        for (Task task : taskList) { //loops through each task currently in taskList
            if(task.id == id) { //checks if the current task matches user input id
                task.changeIsComplete(); //if user input is found it calls the changeIsComplete method
                break;

            }
        }
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

        Scanner addTaskUser = new Scanner(System.in);
;      
        Day weekday = null;
        
        while(weekday == null) {
            System.out.print("Enter day of the week: MON, TUES, WED, THUR, FRI, SAT, SUN");
            String dayInput = addTaskUser.next().toUpperCase(); //autoconverts user input to upercase for error handling to be easier
       
        if (dayInput.equals("MON") || dayInput.equals("TUES") || dayInput.equals("WED") ||
        dayInput.equals("THURS") || dayInput.equals("FRI") || dayInput.equals("SAT") ||
        dayInput.equals("SUN")) {

            weekday = Day.valueOf(dayInput); 
            } 
            else {
                System.out.println("Invalid input, please select a valid day of the week: ");
            } //this converts the string into an enum, without this program would error 
        }

        int monthDay; //initializes monthDay
        while(true){ //ensures the date selected makes logical sense. only uses average range of 1-31, meaning some dates could still have 'impossible' days
            System.out.println("Enter the day of the month");
            monthDay = addTaskUser.nextInt();
            addTaskUser.nextLine();
            if (monthDay > 0 && monthDay <= 31) {
            break;
            }
            else {
                 System.out.println("Error, invalid input. Date selected outside possible date range."); 
            }
        }

        System.out.println("Enter task description: ");
        String taskInfo = addTaskUser.nextLine();

        String colorInput;
        Color importance; 

        while(true) { //this ensures only red, yellow or green are allowed as input
            System.out.println("Please select importance level: RED, YELLOW, GREEN: ");
            colorInput = addTaskUser.next().toUpperCase();
        
            if (colorInput.equals("RED") || colorInput.equals("YELLOW") || colorInput.equals("GREEN")) {
                importance = Color.valueOf(colorInput); //only converts if matches
                break;
            }
            else {
            System.out.println("Invalid selection please try again");
            }
        }

        a.addNewTask(weekday, monthDay, taskInfo, importance); //calls Planner.addNewTask and populates a new task with these arguments

    }


    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        Planner myPlanner = new Planner();

        while(true) { //this keeps the user returning to main menu
        System.out.println("Welcome to Your Digital Planner\nPlease select from the following menu options:");
        System.out.println("");
        System.out.println("1. Display all planner tasks");
        System.out.println("2. Add task to planner");
        System.out.println("3. Remove task from planner");
        System.out.println("4. Mark Planner task as complete");
        System.out.println("5. Exit program");
        System.out.println("");
        System.out.println("Please make your selection:\n>>>");
        int userChoice = userInput.nextInt();

         switch(userChoice) {
            
            case 1:
               myPlanner.showAllTasks();
               break;

            case 2:
                addNewTask(myPlanner);
                break;

            case 3: 
                System.out.println("Please eneter the Task ID you would like to remove: ");
                int removeId = userInput.nextInt();
                myPlanner.removeTaskById(removeId); //calls the remove task mathod and passes the user input as an arguement
                break;

            case 4: 
                 System.out.println("Please eneter the Task ID you would like to mark as complete: ");
                int completeId = userInput.nextInt();
                myPlanner.markCompletion(completeId); //calls the remove task mathod and passes the user input as an arguement
                break;

            case 5:

                userInput.close();
                System.exit(0);
                break;    

            default:
                System.out.println("Invalid selection please try again choosing from the menu options listed.");
            
        }
    }
}

}