package lakshmi;

import library.TestLocations;
import org.junit.Test;

public class TestInheritLocations extends TestLocations {//class begins
    @Test
    public void inheritLocations(){//method inherit Locations begins
        jacksonvilleLocation();
        System.out.println("Markers");

        stJohnsLocation();
        System.out.println("Office Table");

        opLocation();
        System.out.println("Easel Board");

    }//method inherit locations ends

}//class ends
