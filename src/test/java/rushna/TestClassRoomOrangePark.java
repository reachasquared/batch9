package rushna;

import org.junit.Test;

public class TestClassRoomOrangePark {//class begins
    /**
     * Display In Orange Park
     */
    @Test
    public void orangePark()//method begins, In Orange Park Location, I see"
    {
        System.out.println(" In Orange Park location, I see, easel board ");
        TestClassRoomLocations orangeParkLocations = new TestClassRoomLocations();
        orangeParkLocations.LocationJax();
        orangeParkLocations.LocationStJohns();
        orangeParkLocations.LocationOrangePark();
    }//method ends
}//class ends
