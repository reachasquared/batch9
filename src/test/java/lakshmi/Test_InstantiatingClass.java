package lakshmi;

import library.TestLocations;
import org.junit.Test;

public class Test_InstantiatingClass {
    /**
     * Instantiation TestLocations class and calling the methods using class object created.
     */
    @Test
    public void instantiatingClass() {
        //Instantiating a class
        //CLASS NAME <variable> = new CLASS NAME();
        //TestLocations Locations = new TestLocations
        library.TestLocations locations = new TestLocations();

        //Calling method using class object
        locations.jacksonvilleLocation();
        System.out.println("Markers");

        locations.jacksonvilleLocation();
        System.out.println("Office table");

        locations.stJohnsLocation();
        System.out.println("Hand soap");

        locations.stJohnsLocation();
        System.out.println("Storage supplies");

        locations.opLocation();
        System.out.println("Easel Board");
    }
}
