package lakshmi;

import org.junit.Test;

public class TestClassroom {//class begins

    /**
     * Display objects in a classroom
     */
    @Test
    public void testClassRoom(){//method testClassRoom begins
        iSee();
        System.out.println("Markers");
       iSee();
       System.out.println("Office table");
      stJohnsISee();
       System.out.println("Hand soap");
       stJohnsISee();
       System.out.println("Storage supplies");
       //class instantiation of TestClassRoomOrangePark
       TestClassRoomOrangePark orangeParkLocation = new TestClassRoomOrangePark();
       orangeParkLocation.orangePark();

   }//method testClassRoom ends
    /**
     * Display "I see"
     */
    public void iSee(){//method iSee begins
      //  System.out.println("In Prachee Arts,Jacksonville Location, I see");  //This will add new line next to the text
    System.out.print("In Prachee Arts,Jacksonville Location, I See ");

}//method iSee ends
    /**
     * Display "Stjohns I See"
     */
public void stJohnsISee(){//method stjohns i see begins
    System.out.print("In Prachee Arts,St Johns Location, I See ");
}//method st johns i see ends


}//class ends
