package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @project batch8
 * Creation date: 23-04-2019
 */
public class GlobalVariables {
    public Logger logger = LogManager.getLogger("test");

    public char gender;
    // Integer variable that can hold an integer value
    public int age;
    // String variable that can hold one string data
    //Variables can be declared and initiated at the same time like below
    public String weekDay = "Sunday";
    public String fullName = "";
    // Boolean variable can hold ONLY either true or false (no other data it accepts)
    public boolean status = true;

    public void displayValues() {
        int age = 0;
        //displayValues
        System.out.println();
        System.out.println("Student Information");
        System.out.println("Gender: " + gender);//we are displaying label 'Gender' and value
        //System.out.println("age: " + age);
        System.out.println("Week: " + weekDay);
        System.out.println("Status:" + status);
    }

}
