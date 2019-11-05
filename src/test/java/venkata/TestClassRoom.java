package venkata;

import org.junit.Test;

public class TestClassRoom {//class begins

    /**
     * Display objects in a classroom
     */
    @Test
    public void testClassRoom() {//method begins

        iSee();
        System.out.println("Markers");
        iSee();
        System.out.println("Office table");
        iSeeStJohns();
        System.out.println("Hand soap");
        iSeeStJohns();
        System.out.println("Storage supplies");
        //Class instantiation of TestClassRoomOrangePark
        TestClassRoomOrangePark orangeParkLocation = new TestClassRoomOrangePark();
        orangeParkLocation.orangePark();
    }//method ends

    /**
     * Display "I see"
     */

    public void iSee() {//method iSee begins
        //System.out.print("In Prachee Arts, Jacksonville Location, I see ");//This will add a new line after printing

        System.out.print("In Prachee Arts, Jacksonville Location, I see ");

    }//method iSee ends

    public void iSeeStJohns() {//method iSeeStJohns begins
        System.out.print("In Prachee Arts, St Johns Location, I see ");
    }// iSeeStJohns method ends

}//class ends
