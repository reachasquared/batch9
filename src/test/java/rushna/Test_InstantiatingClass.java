package rushna;

import library.TestLocations;
import org.junit.Test;

public class Test_InstantiatingClass {
    /**
     * Instantiation TestLocations class and calling the methods using class object created.
     */
   
    public void instantiatingClass() {
        //Instantiating a class
        //CLASS NAME <variable> = new CLASS NAME();
        //TestLocations locations = new TestLocations();
        TestLocations locations = new TestLocations();

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
        System.out.println("Storage supplies");
    }
}
