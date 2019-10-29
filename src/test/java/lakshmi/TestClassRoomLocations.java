package lakshmi;

import org.junit.Test;

public class TestClassRoomLocations {//Test Class Room Locations class begins
    @Test
    public void ClassRoom(){// method Class Room begins
        Locations jacksonvilleLocation = new Locations();
        jacksonvilleLocation.jacksonville();
        System.out.println("Markers");

        jacksonvilleLocation.jacksonville();
        System.out.println("Office Table");

        Locations stJohnsLocation = new Locations();
        stJohnsLocation.stJohns();
        System.out.println("Hand Soap");

        stJohnsLocation.stJohns();
        System.out.println("Storage Supplies");

        Locations orangeParkLocation = new Locations();
        orangeParkLocation.orangePark();
        System.out.println("Easel Board");

    }// method Class Room ends
}//Test Class Room Locations class ends
