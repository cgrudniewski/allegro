package pl.test.allegro;

import org.openqa.selenium.firefox.FirefoxProfile;

/**
 *
 * Created by Czarek on 2015-05-14.
 */
public class FirefoxDriverConf {

    public static FirefoxProfile getFirefoxProfileConfiguration() {

        FirefoxProfile profile = new FirefoxProfile();

        profile.setPreference("dom.ipc.plugins.enabled", false);
        profile.setPreference("dom.ipc.plugins.flash.subprocess.crashreporter.enabled", false);
        profile.setPreference("dom.ipc.plugins.reportCrashURL", false);
        profile.setPreference("plugin.state.flash", 0);

        return profile;
    }
}
