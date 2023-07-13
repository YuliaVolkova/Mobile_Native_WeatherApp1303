package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SettingPage {
    By tempID = By.id("com.weather.forecast.weatherchannel:id/tgTemperature_setting");
    By titleSpeed = By.id("com.weather.forecast.weatherchannel:id/md_title");
    By speedD = By.id("com.weather.forecast.weatherchannel:id/iv_arrow_distance");
    By speedFormat = By.id("com.weather.forecast.weatherchannel:id/tv_wind_speed_format");
    By speedList = By.id("com.weather.forecast.weatherchannel:id/md_contentRecyclerView");
    By speedMeters = By.className("android.widget.LinearLayout") ;
    By speedElements = By.className("android.widget.TextView");
    By timeFormatID = By.id("com.weather.forecast.weatherchannel:id/tg_format_time_setting");
    By notifiSettingsID = By.id("com.weather.forecast.weatherchannel:id/tgNotifi_settings");
    By statusBarID = By.id("com.weather.forecast.weatherchannel:id/tg_notifi_second_settings");
    By finishSettingsID = By.id("com.weather.forecast.weatherchannel:id/tvDone");

    public SettingPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private static AndroidDriver driver;

    public void changeTemp(char temp) {
        MobileElement element = (MobileElement) driver.findElement(tempID);
        switch (temp) {
            case 'f': {
                if (element.getAttribute("checked").equals("false")) {// false=C
                    element.click();
                }
            }
            break;

            case 'c': {
                if (element.getAttribute("checked").equals("true")) {// true=F
                    element.click();
                }
            }
            break;
        }

    }

    public void changeTimeFormat(String timeFormat){
        MobileElement element = (MobileElement) driver.findElement(timeFormatID);
        switch (timeFormat){
            case "12": {
                if (element.getAttribute("checked").equals("false")){
                    element.click();

                }
            }
            break;

            case "24": {
                if (element.getAttribute("checked").equals("true")) {
                    element.click();
                }
            }
            break;
        }
    }

    public void changeNotifiSettings (String notifiSettings){

        MobileElement element = (MobileElement) driver.findElement(notifiSettingsID);
        switch (notifiSettings){
            case "on": {
                if (element.getAttribute("checked").equals("false")){
                    element.click();

                }
            }
            break;

            case "off": {
                if (element.getAttribute("checked").equals("true")) {
                    element.click();
                }
            }
            break;
        }

    }

    public void changeStatusBarSettings (String statusBarSettings){
        MobileElement element = (MobileElement) driver.findElement(statusBarID);
        switch (statusBarSettings){
            case "on": {
                if (element.getAttribute("checked").equals("false")){
                    element.click();

                }
            }
            break;

            case "off": {
                if (element.getAttribute("checked").equals("true")) {
                    element.click();
                }
            }
            break;
        }
    }

    public void changeSpeed(SPEED speed) {
        if (!driver.findElement(speedFormat).getText().equals(speed.speed)) {
            driver.findElement(speedD).click();
            MobileElement button = (MobileElement) new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(speedList));
            List<MobileElement> list = button.findElements(speedMeters);
            for (MobileElement l : list) {

                if (l.findElement(speedElements).getText().equals(speed.speed)) {
                    l.click();
                    break;
                }
            }
        }
    }

    public enum SPEED {
        METERS("m/s"),
        KILOMETERS("km/h");
        String speed;

        SPEED(String speed) {
            this.speed = speed;
        }
    }


    public void finishSettings() {
        MobileElement element;
        element = (MobileElement) finishSettingsID.findElement(driver);
        if (element.getAttribute("enabled").equals("true")) {
            element.click();
        }

    }


}
