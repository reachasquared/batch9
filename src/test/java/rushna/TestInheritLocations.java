package rushna;
import library.TestLocations;
import org.junit.Test;

public class TestInheritLocations extends TestLocations {//class begins
    @Test
    public void inheritsLocations(){//method begins
        jacksonvilleLocation(); // directly calling Test Locations
        System.out.println("Markers");

        jacksonvilleLocation(); // directly calling Test Locations
        System.out.println("Office table");

        jacksonvilleLocation(); // directly calling Test Locations
        System.out.println("Storage supplies");
        jacksonvilleLocation(); // directly calling Test Locations

        System.out.println("Storage supplies");

        stJohnsLocation(); // directly calling Test Locations
        System.out.println("Freeman Nathan <3 ");
    }//methods ends
}
