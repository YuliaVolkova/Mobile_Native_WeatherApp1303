import Pages.SettingPage;
import configuration.BaseClass;
import org.junit.Test;

public class TestMobileApp extends BaseClass {
    static SettingPage settingPage=new SettingPage(driver);



    @Test
    public void test1() {
        System.out.println(driver.currentActivity());
    }

    @Test
    public void test2(){
        settingPage.changeTemp('f');
    }
    @Test
    public void test3(){
        settingPage.changeSpeed(SettingPage.SPEED.METERS);
    }

    @Test
    public void test4(){settingPage.changeTimeFormat("24"); }

    @Test
    public void test5(){settingPage.changeNotifiSettings("on");}

    @Test
    public void test6(){settingPage.changeStatusBarSettings("on");}

    @Test
    public void test7(){settingPage.finishSettings();}


}
