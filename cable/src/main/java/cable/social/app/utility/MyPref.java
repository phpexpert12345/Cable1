package cable.social.app.utility;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;

public class MyPref {


    Context context;
    SharedPreferences sharedPreferences;
    private String userId, mobile, firebaseTokenId, isOnline, lng, lat;
    private String  userName, mailid, profileImage;
    private String city, state,apiToken;



    public String getApiToken() {
        return sharedPreferences.getString("apiToken", "");
    }

    public void setApiToken(String apiToken) {
        sharedPreferences.edit().putString("apiToken", apiToken).commit();
    }
    public String getDob() {
        return sharedPreferences.getString("dob", "");
    }

    public void setDob(String dob) {
        sharedPreferences.edit().putString("dob", dob).commit();
    }

    public String getIsOnline() {
        isOnline = sharedPreferences.getString("isOnline", "");
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
        sharedPreferences.edit().putString("isOnline", isOnline).commit();
    }

    public String getLng() {
        lng = sharedPreferences.getString("lng", "");
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
        sharedPreferences.edit().putString("lng", lng).commit();
    }

    public String getLat() {
        lat = sharedPreferences.getString("lat", "");
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
        sharedPreferences.edit().putString("lat", lat).commit();
    }




    public String getCity() {
        city = sharedPreferences.getString("city", "");
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        sharedPreferences.edit().putString("city", city).commit();
    }

    public String getState() {
        state = sharedPreferences.getString("state", "");
        return state;
    }

    public void setState(String state) {
        this.state = state;
        sharedPreferences.edit().putString("state", state).commit();
    }


    public String getProfileImage() {
        profileImage = sharedPreferences.getString("profileImage", "");
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        sharedPreferences.edit().putString("profileImage", profileImage).commit();
    }


    public String getFirebaseTokenId() {
        firebaseTokenId = sharedPreferences.getString("firebaseTokenId", "");
        return firebaseTokenId;
    }

    public void setFirebaseTokenId(String firebaseTokenId) {
        this.firebaseTokenId = firebaseTokenId;
        sharedPreferences.edit().putString("firebaseTokenId", firebaseTokenId).commit();
    }

    public String getMailid() {
        mailid = sharedPreferences.getString("mailid", "");
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
        sharedPreferences.edit().putString("mailid", mailid).commit();
    }


    public String getMobile() {
        mobile = sharedPreferences.getString("mobile", "");
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
        sharedPreferences.edit().putString("mobile", mobile).commit();
    }

    public String getUserName() {
        userName = sharedPreferences.getString("userName", "");
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        sharedPreferences.edit().putString("userName", userName).commit();
    }


    public String getUserId() {
        userId = sharedPreferences.getString("userId", "");
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        sharedPreferences.edit().putString("userId", userId).commit();
    }

    public MyPref(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("userinfo", Context.MODE_PRIVATE);

    }

    public void logOut() {
        sharedPreferences.edit().clear().commit();

    }

    public void logOut(Context context) {
        sharedPreferences.edit().clear().commit();
        deleteCache(context);

    }

    //for clearing cache of app
    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if (dir != null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }
}
