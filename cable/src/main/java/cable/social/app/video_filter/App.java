package cable.social.app.video_filter;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.quickblox.auth.session.QBSettings;

import cable.social.app.R;
import cable.social.app.util.QBResRequestExecutor;
import io.fabric.sdk.android.BuildConfig;
import io.fabric.sdk.android.Fabric;

/**
 * @author LLhon
 * @Project Android-Video-Editor
 * @Package com.marvhong.videoeditor
 * @Date 2018/8/21 16:00
 * @description
 */
public class App extends Application {

    public static Context sApplication;




    private static final String APPLICATION_ID = "85732";
    private static final String AUTH_KEY = "Ag-pL8F9v4nJ8c4";
    private static final String AUTH_SECRET = "dB5ZQKSGBmtqRgX";
    private static final String ACCOUNT_KEY = "HaPQmY-kspxQjaLf7Uxn";

    public static final String USER_DEFAULT_PASSWORD = "quickblox";

    private static App instance;
    private QBResRequestExecutor qbResRequestExecutor;



    private void initFabric() {
        if (!BuildConfig.DEBUG) {
            Fabric.with(this, new Crashlytics());
        }
    }

    private void checkAppCredentials() {
        if (APPLICATION_ID.isEmpty() || AUTH_KEY.isEmpty() || AUTH_SECRET.isEmpty() || ACCOUNT_KEY.isEmpty()) {
            throw new AssertionError(getString(R.string.error_credentials_empty));
        }
    }

    private void initCredentials() {
        QBSettings.getInstance().init(getApplicationContext(), APPLICATION_ID, AUTH_KEY, AUTH_SECRET);
        QBSettings.getInstance().setAccountKey(ACCOUNT_KEY);

        // Uncomment and put your Api and Chat servers endpoints if you want to point the sample
        // against your own server.
        //
        // QBSettings.getInstance().setEndpoints("https://your_api_endpoint.com", "your_chat_endpoint", ServiceZone.PRODUCTION);
        // QBSettings.getInstance().setZone(ServiceZone.PRODUCTION);
    }

    public synchronized QBResRequestExecutor getQbResRequestExecutor() {
        return qbResRequestExecutor == null
                ? qbResRequestExecutor = new QBResRequestExecutor()
                : qbResRequestExecutor;
    }


    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = getApplicationContext();
        instance = this;
        initFabric();
        checkAppCredentials();
        initCredentials();
    }

}
