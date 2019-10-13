package core.engine;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * @author asquared
 */
public class AsquaredEventFiringWebDriver extends EventFiringWebDriver implements HasCapabilities {

    private RemoteWebDriver driver;

    public AsquaredEventFiringWebDriver(RemoteWebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public Capabilities getCapabilities() {
        return driver.getCapabilities();
    }
}
