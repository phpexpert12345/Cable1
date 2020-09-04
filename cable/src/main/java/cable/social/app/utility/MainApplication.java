package cable.social.app.utility;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;

import androidx.multidex.MultiDexApplication;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.firebase.FirebaseApp;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import retrofit2.Retrofit;

public class MainApplication extends MultiDexApplication {

    static ProgressDialog progress;

    public static Retrofit retrofit;
    public static Boolean onride = false;

    public static Retrofit retrofit2;
    private Socket mSocket;


    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        FirebaseApp.initializeApp(this);
        try {
           // mSocket = IO.socket("https://socket-io-chat.now.sh/");
            mSocket = IO.socket("http://safarisharedservices.com:3000");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }



    }


    public Socket getSocket() {
        return mSocket;
    }



    public static boolean isNetworkAvailable(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }




    public static void hideProg(Activity ac) {
        progress.hide();
    }


}
