package cable.social.app.Interface;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import cable.social.app.activity.EpisodInfoActivity;
import cable.social.app.activity.LoginActivity;
import cable.social.app.activity.MainActivity;
import cable.social.app.fragment.MyTotalSeries;
import cable.social.app.model.AllNotificationModel;
import cable.social.app.model.ArrayListCustomerId;
import cable.social.app.model.CategorySubList;
import cable.social.app.model.Category_model;
import cable.social.app.model.ChannelList_Model;
import cable.social.app.model.ChannelLogoList;
import cable.social.app.model.CustomerFriendAcceptReject;
import cable.social.app.model.CustomerInfo_pojo;
import cable.social.app.model.CustomerIntroVideoCreate_pojo;
import cable.social.app.model.CustomerIntroVideo_pojo;
import cable.social.app.model.CustomerProfilePicPOJO;
import cable.social.app.model.FriendListModel;
import cable.social.app.model.FriendListPoJO;
import cable.social.app.model.FriendRequest;
import cable.social.app.model.FriendRequestSent;
import cable.social.app.model.Invite_lists_Model;
import cable.social.app.model.InvitedNotificationListPOJO;
import cable.social.app.model.LiveCustomerResponse;
import cable.social.app.model.LoginResponse;
import cable.social.app.model.MyVideo;
import cable.social.app.model.SeasonSeries;
import cable.social.app.model.SeriesList;
import cable.social.app.model.SignupResponse;
import cable.social.app.model.Slider_model;
import cable.social.app.model.SubscribePlans_model;
import cable.social.app.model.UserList;
import cable.social.app.model.UserName;
import cable.social.app.model.VideoDetailModel;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebapiCall {

    ProgressDialog pd;

    public void dailogshow(Context context) {
        pd = new ProgressDialog(context);
        pd.setMessage("loading...");
        pd.setCancelable(false);
        pd.show();
    }

    public void dailoghide(Context context) {
        pd.dismiss();
    }

    private void tokenExpired(Context context) {
        GlobalClass.showtost(context, "Token Has Expired...");
        Intent intent = new Intent(context.getApplicationContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void sliderlist(final Context context, final Salider_interface salider_interface, String token) {
        dailogshow(context);
        Call<Slider_model> userpost_responseCall = ApiClient.getClient().slider_list("Bearer " + token);
        userpost_responseCall.enqueue(new Callback<Slider_model>() {
            @Override
            public void onResponse(Call<Slider_model> call, Response<Slider_model> response) {

                if (response.isSuccessful()) {
                    dailoghide(context);

                    if (response.code() == 200) {

                        // GlobalClass.showtost(context,""+response.body().getMessage());
                        salider_interface.slider_list((ArrayList<Slider_model.SliderList>) response.body().getSliderList());
                        salider_interface.recent_video((ArrayList<Slider_model.RecentVideo>) response.body().getRecentVideos());
                        salider_interface.primevideo_list((ArrayList<Slider_model.PremiumVideoList>) response.body().getPremiumVideoList());

                        salider_interface.FreeVideo_list((ArrayList<Slider_model.FreeVideoList>) response.body().getFreeVideoList());
                        salider_interface.SocialCommunityUser_list((ArrayList<Slider_model.SocialCommunityUser>) response.body().getSocialCommunityUsers());
                        salider_interface.MyCommunityUsersList_list((ArrayList<Slider_model.MyCommunityUsersList>) response.body().getMyCommunityUsersList());


                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        GlobalClass.showtost(context, "Try Again...");
                    }
                } else {
                     dailoghide(context);
                    GlobalClass.showtost(context, "Token Has Expired...");
                    Intent intent = new Intent(context.getApplicationContext(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);


                }
            }


            @Override
            public void onFailure(Call<Slider_model> call, Throwable t) {

                // dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "On Error." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void category_list(final Context context, final Category_interface category_interface, String token) {
        dailogshow(context);
        Call<Category_model> userpost_responseCall = ApiClient.getClient().category_list("Bearer " + token);
        userpost_responseCall.enqueue(new Callback<Category_model>() {
            @Override
            public void onResponse(Call<Category_model> call, Response<Category_model> response) {
                dailoghide(context);
                if (response.code() == 200) {
                    // GlobalClass.showtost(context,""+response.body().getMessage());
                    category_interface.category_list((ArrayList<Category_model.CategoyList>) response.body().getCategoyList());
                } else if (response.code() == 401) {
                    tokenExpired(context);
                } else {
                    GlobalClass.showtost(context, "" + response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<Category_model> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }



    public void category_listEpisode(final Context context, final Category_interface category_interface, String token) {
        dailogshow(context);
        Call<Category_model> userpost_responseCall = ApiClient.getClient().category_listEpisode("Bearer " + token);
        userpost_responseCall.enqueue(new Callback<Category_model>() {
            @Override
            public void onResponse(Call<Category_model> call, Response<Category_model> response) {
                dailoghide(context);
                if (response.code() == 200) {
                    // GlobalClass.showtost(context,""+response.body().getMessage());
                    category_interface.category_list((ArrayList<Category_model.CategoyList>) response.body().getCategoyList());
                } else if (response.code() == 401) {
                    tokenExpired(context);
                } else {
                    GlobalClass.showtost(context, "" + response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<Category_model> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }












    public void ActiveUserList(final Context context, final User_list category_interface, String token,String customer_id) {
        dailogshow(context);
        Call<UserList> userpost_responseCall = ApiClient.getClient().ActiveCustomerList(GlobalClass.apikey,"Bearer " + token, customer_id);
        userpost_responseCall.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                dailoghide(context);
                if (response.code() == 200) {
                    // GlobalClass.showtost(context,""+response.body().getMessage());
                    category_interface.UserList((ArrayList<UserList.Datum>) response.body().getData());
                } else if (response.code() == 401) {
                    tokenExpired(context);
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }






    public void my_video_list(final Context context, final VideoFetched_interface videoFetched_interface, String token, String user_id, String videoType) {
        dailogshow(context);
        Call<MyVideo> userpost_responseCall = ApiClient.getClient().my_video_list("Bearer " + token, user_id, videoType);
        userpost_responseCall.enqueue(new Callback<MyVideo>() {
            @Override
            public void onResponse(Call<MyVideo> call, Response<MyVideo> response) {
                dailoghide(context);
                if (response.code() == 200) {
                    // GlobalClass.showtost(context,""+response.body().getMessage());

                    videoFetched_interface.Fetched((ArrayList<MyVideo.Datum>) response.body().getData());
                } else if (response.code() == 401) {
                    tokenExpired(context);
                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<MyVideo> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void subscribe_list_list(final Context context, final SubscribePlans_inteface subscribePlans_inteface, String token) {
        dailogshow(context);
        Call<SubscribePlans_model> userpost_responseCall = ApiClient.getClient().subscribe_list("Bearer " + token);
        userpost_responseCall.enqueue(new Callback<SubscribePlans_model>() {
            @Override
            public void onResponse(Call<SubscribePlans_model> call, Response<SubscribePlans_model> response) {
                dailoghide(context);
                if (response.code() == 200) {

                    // GlobalClass.showtost(context,""+response.body().getMessage());
                    subscribePlans_inteface.subscribe_list((ArrayList<SubscribePlans_model.SubscribePlansList>) response.body().getSubscribePlansList());
                } else if (response.code() == 401) {
                    tokenExpired(context);
                } else {
                    GlobalClass.showtost(context, "" + response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<SubscribePlans_model> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void SignupApi(final Context context, HashMap<String, String> hashMap, SignUp_interface signUp_interface) {
        dailogshow(context);
        Call<SignupResponse> userpost_responseCall = ApiClient.getClient().SignupUser(hashMap);
        userpost_responseCall.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                dailoghide(context);
                if (response.code() == 200) {


                    CSPreferences.putString(context, "tooken", response.body().getToken());
                    CSPreferences.putString(context, "auth_key", response.body().getUserInfo().getId().toString());
                    CSPreferences.putString(context, "name", response.body().getUserInfo().getCustomerName());
                    CSPreferences.putString(context, "last_name", response.body().getUserInfo().getCustomerLastName());
                    CSPreferences.putString(context, "email", response.body().getUserInfo().getCustomerEmail());
                    CSPreferences.putString(context, "ActivePlanId", response.body().getUserInfo().getActivePlanId());
                    CSPreferences.putString(context, "imageprofile", String.valueOf(response.body().getUserInfo().getCustomerProfilePic()));
                    CSPreferences.putString(context, "user_name", String.valueOf(response.body().getUserInfo().getCustomerUsername()));


                    signUp_interface.Sucess();


                } else {
                    GlobalClass.showtost(context, "" + response.message());
                }
            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void checkUserEmail(final Context context, HashMap<String, String> hashMap, SignUp_interface signUp_interface) {
//        dailogshow(context);
        Call<UserName> userpost_responseCall = ApiClient.getClient().CheckUserName(hashMap);
        userpost_responseCall.enqueue(new Callback<UserName>() {
            @Override
            public void onResponse(Call<UserName> call, Response<UserName> response) {
//                dailoghide(context);
                if (response.code() == 200) {
                    // GlobalClass.showtost(context, "" + response.body().getMessage());
//                    new SweetAlertDialog(context).setTitleText(response.body().getMessage()).show();

//                    Log.d("Response", String.valueOf(response.body().getStatusCode()));

//                    assert response.body() != null;
                    signUp_interface.ValidUserName(0, "User name is available");

                } else {
//                    GlobalClass.showtost(context, "" + response.message());
//                    signUp_interface.ValidUserName(response.body().getStatusCode(),response.body().getMessage());
                    signUp_interface.ValidUserName(1, "User name is not available");


                }
            }

            @Override
            public void onFailure(Call<UserName> call, Throwable t) {

//                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void LoginApi(final Context context, HashMap<String, String> hashMap) {
        dailogshow(context);
        Call<LoginResponse> userpost_responseCall = ApiClient.getClient().loginUser(GlobalClass.apikey, hashMap);
        userpost_responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                dailoghide(context);

                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
//                    new SweetAlertDialog(context)
//                            .setTitleText(response.body().getMessage())
//                            .show();

                        // GlobalClass.showtost(context, "" + response.body().getMessage());
                        //if (response.body().getStatus().equals("SUCCESS")) {

                        CSPreferences.putString(context, "tooken", String.valueOf(response.body().getToken()));
                        CSPreferences.putString(context, "auth_key", String.valueOf(response.body().getData().getId()));
                        CSPreferences.putString(context, "user_id_for_video", String.valueOf(response.body().getData().getId()));
                        CSPreferences.putString(context, "name", String.valueOf(response.body().getData().getCustomerUsername()));
                        CSPreferences.putString(context, "email", String.valueOf(response.body().getData().getCustomerEmail()));
                        CSPreferences.putString(context, "phone", String.valueOf(response.body().getData().getPinNumber()));
                        CSPreferences.putString(context, "ActivePlanId", String.valueOf(response.body().getData().getActivePlanId()));
                        CSPreferences.putString(context, "imageprofile", String.valueOf(response.body().getData().getCustomerProfilePic()));
                        CSPreferences.putString(context, "user_name", String.valueOf(response.body().getData().getCustomerUsername()));

                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);



                  /*} else {
                        //CSPreferences.putString(context,"auth_key",response.body().getProfile().getSessionId());

                        //   Intent intent = new Intent(context, EmpLoginView.class);
                        //  context.startActivity(intent);
                    }*/




                /*    CSPreferences.putString(context,"auth_key",response.body().getData().getAuthKey());
                    CSPreferences.putString(context,"id",response.body().getData().getUser().getId().toString());
                    CSPreferences.putString(context,"name",response.body().getData().getUser().getName());
                    CSPreferences.putString(context,"last_name",response.body().getData().getUser().getLastName());
                    CSPreferences.putString(context,"email",response.body().getData().getUser().getEmail());
                    CSPreferences.putString(context,"type",response.body().getData().getUser().getType());
     */            // CSPreferences.putString(context,"otp",response.body().getData().getUser().getOtp().toString());

                    } else {
                        GlobalClass.showtost(context, "" + response.body().getMessage());
                    }
                } else {
                    GlobalClass.showtost(context, "" + response.message());

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void customerInfo(final Context context, String auth, String customerid, final Account_profile account_profile) {
        dailogshow(context);
        Call<CustomerInfo_pojo> userpost_responseCall = ApiClient.getClient().customerInfo(GlobalClass.apikey, "Bearer " + auth, customerid);
        userpost_responseCall.enqueue(new Callback<CustomerInfo_pojo>() {
            @Override
            public void onResponse(Call<CustomerInfo_pojo> call, Response<CustomerInfo_pojo> response) {
                dailoghide(context);

                if (response.body().getStatus().equals("SUCCESS")) {

                    account_profile.account_profile((ArrayList<CustomerInfo_pojo.Datum>) response.body().getData());

                    // GlobalClass.showtost(context, "" + response.body().getMessage());
                    //if (response.body().getStatus().equals("SUCCESS")) {

                  /*} else {
                        //CSPreferences.putString(context,"auth_key",response.body().getProfile().getSessionId());

                        //   Intent intent = new Intent(context, EmpLoginView.class);
                        //  context.startActivity(intent);
                    }*/

                /*    CSPreferences.putString(context,"auth_key",response.body().getData().getAuthKey());
                    CSPreferences.putString(context,"id",response.body().getData().getUser().getId().toString());
                    CSPreferences.putString(context,"name",response.body().getData().getUser().getName());
                    CSPreferences.putString(context,"last_name",response.body().getData().getUser().getLastName());
                    CSPreferences.putString(context,"email",response.body().getData().getUser().getEmail());
                    CSPreferences.putString(context,"type",response.body().getData().getUser().getType());
     */            // CSPreferences.putString(context,"otp",response.body().getData().getUser().getOtp().toString());

                } else if (response.code() == 401) {
                    tokenExpired(context);
                } else {
                    GlobalClass.showtost(context, "" + response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<CustomerInfo_pojo> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void channelList(final Context context, String toacken, String customerid, final Chanal_list_interface chanal_list_interface) {
//        dailogshow(context);
        Call<ChannelList_Model> userpost_responseCall = ApiClient.getClient().channelList(GlobalClass.apikey, "Bearer " + toacken, customerid);
        userpost_responseCall.enqueue(new Callback<ChannelList_Model>() {
            @Override
            public void onResponse(Call<ChannelList_Model> call, Response<ChannelList_Model> response) {
//                dailoghide(context);

                Log.d("Response", response.toString());

                if (response.code() == 200) {


                    chanal_list_interface.chanallist((response.body().getData()));


                } else if (response.code() == 401) {
                    tokenExpired(context);
                } else {
                    chanal_list_interface.chanallist((response.body().getData()));
                    GlobalClass.showtost(context, "" + response.body().getMessage());
//                    notfound.setVisibility(View.VISIBLE);
//                    notfound.setText(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ChannelList_Model> call, Throwable t) {

//                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void updateProfile(final Context context, String auth, RequestBody customerid, RequestBody firstname,RequestBody username,MultipartBody.Part cover_profile_image) {
        dailogshow(context);
        Call<CustomerProfilePicPOJO> userpost_responseCall = ApiClient.getClient().customerProfilePics(GlobalClass.apikey, "Bearer " + auth, customerid, firstname, username,cover_profile_image);
        userpost_responseCall.enqueue(new Callback<CustomerProfilePicPOJO>() {
            @Override
            public void onResponse(Call<CustomerProfilePicPOJO> call, Response<CustomerProfilePicPOJO> response) {
                dailoghide(context);
                if (response.isSuccessful()) {


                    if (response.body().getStatusCode() == 200) {
                        GlobalClass.showtost(context, "" + response.body().getMessage());

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else if (response.body().getStatusCode() == 500) {
                        GlobalClass.showtost(context, "" + response.body().getMessage());

                    } else {
                        GlobalClass.showtost(context, " something went wrong please.Try after sometimes");

                    }
                } else if(response.code() == 409){
                    GlobalClass.showtost(context, "UserName already Registered" );

                }

            }

            @Override
            public void onFailure(Call<CustomerProfilePicPOJO> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void addChannel(final Context context, MultipartBody.Part part, String auth, RequestBody customerid, RequestBody channelname, RequestBody channelCategory, RequestBody user_name, RequestBody channel_logo_id, final ChannelCategory_interface channelCategory_interface) {
        dailogshow(context);
        Call userpost_responseCall = ApiClient.getClient().addChannel(part, GlobalClass.apikey, "Bearer " + auth, customerid, channelname, channelCategory, user_name, channel_logo_id);
        userpost_responseCall.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                dailoghide(context);
                try {
                    if (response.code() == 200 || response.code() == 201) {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("code", "200");
                        jsonObject.put("status", "OK");
                        jsonObject.put("message", "Channel Successfully Created");
                        channelCategory_interface.addChannel(jsonObject.toString());

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("code", "201");
                        jsonObject.put("status", "Failed");
                        jsonObject.put("message", "Channel Creation Failed");
                        channelCategory_interface.addChannel(jsonObject.toString());
                    }

                } catch (Exception e) {

                }


            }

            @Override
            public void onFailure(Call call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


//    public void channelCategory(final Context context, String auth, final ChannelCategory_interface channelCategory_interface) {
//        dailogshow(context);
//        Call<ChannelCategory_Pojo> userpost_responseCall = ApiClient.getClient().channelCategory(GlobalClass.apikey, "Bearer " + auth);
//        userpost_responseCall.enqueue(new Callback<ChannelCategory_Pojo>() {
//            @Override
//            public void onResponse(Call<ChannelCategory_Pojo> call, Response<ChannelCategory_Pojo> response) {
//                dailoghide(context);
//
//                if (response.code() == 200) {
//
//                    channelCategory_interface.channelCategory((ArrayList<ChannelCategory_Pojo.Datum>) response.body().getData());
//
//                } else if (response.code() == 401) {
//                    GlobalClass.showtost(context, "" + response.body().getMessage());
//
//                } else {
//                    GlobalClass.showtost(context, " something went wrong please.Try after sometimes");
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ChannelCategory_Pojo> call, Throwable t) {
//
//                dailoghide(context);
//                t.printStackTrace();
//                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
//                Log.d("dddddd", "onFailure: " + t.getMessage());
//            }
//        });
//    }


    public void channel_logo_list(final Context context, String auth, final ChannelCategory_interface channelCategory_interface) {
        dailogshow(context);
        Call<ChannelLogoList> channelLogoList = ApiClient.getClient().channel_logo_list(GlobalClass.apikey, "Bearer " + auth);
        channelLogoList.enqueue(new Callback<ChannelLogoList>() {
            @Override
            public void onResponse(Call<ChannelLogoList> call, Response<ChannelLogoList> response) {
                dailoghide(context);

                if (response.code() == 200) {

                    channelCategory_interface.channel_logo_list((ArrayList<ChannelLogoList.Datum>) response.body().getData());

                } else if (response.code() == 401) {
                    tokenExpired(context);
                } else {
                    GlobalClass.showtost(context, " something went wrong please.Try after sometimes");

                }
            }

            @Override
            public void onFailure(Call<ChannelLogoList> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void channelSubCategory(final Context context, String auth, final CategorySubcat_interface categorySubcat_interface, String id) {
        dailogshow(context);
        Call<CategorySubList> userpost_responseCall = ApiClient.getClient().channelSubCategory(GlobalClass.apikey, "Bearer " + auth, id);
        userpost_responseCall.enqueue(new Callback<CategorySubList>() {
            @Override
            public void onResponse(Call<CategorySubList> call, Response<CategorySubList> response) {
                dailoghide(context);

                if (response.code() == 200) {
                    if ((ArrayList<CategorySubList.Datum>) response.body().getData() != null)
                        categorySubcat_interface.categorysub_list((ArrayList<CategorySubList.Datum>) response.body().getData());

                } else if (response.code() == 401) {
                    tokenExpired(context);
                } else {
                    GlobalClass.showtost(context, " something went wrong please.Try after sometimes");

                }
            }

            @Override
            public void onFailure(Call<CategorySubList> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void video_detailById(final Context context, String auth,String customer_id, String videoid, final Video_detail_Interfae video_detail_interfae) {
        dailogshow(context);
        Call<VideoDetailModel> userpost_responseCall = ApiClient.getClient().videodetailById(GlobalClass.apikey, "Bearer " + auth,customer_id, videoid);
        userpost_responseCall.enqueue(new Callback<VideoDetailModel>() {
            @Override
            public void onResponse(Call<VideoDetailModel> call, Response<VideoDetailModel> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.code() == 200) {

                        video_detail_interfae.videolist((VideoDetailModel.Data) response.body().getData());
                        video_detail_interfae.videolistdata((ArrayList<VideoDetailModel.Data.SimilarVideo>) response.body().getData().getSimilarVideos());
                        video_detail_interfae.invite_data((ArrayList<VideoDetailModel.Data.InviteList>) response.body().getData().getInviteList());
//                        video_detail_interfae.season_list((ArrayList<VideoDetailModel.Data.SeasonsList>) response.body().getData().getSeasonsLists());
//                        video_detail_interfae.genric_data((ArrayList<VideoDetailModel.Data.Genre>) response.body().getData().getGenres());
                    }
                } else if (response.code() == 401) {
                    tokenExpired(context);
                }

            }

            @Override
            public void onFailure(Call<VideoDetailModel> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void customerIntroVideo(final Context context, String auth, String category_id, final CustomerIntroVideo_interface videolistbyCatId_interface) {
        dailogshow(context);
        Call<CustomerIntroVideo_pojo> userpost_responseCall = ApiClient.getClient().customerIntroVideo(GlobalClass.apikey, "Bearer " + auth, category_id);
        userpost_responseCall.enqueue(new Callback<CustomerIntroVideo_pojo>() {
            @Override
            public void onResponse(Call<CustomerIntroVideo_pojo> call, Response<CustomerIntroVideo_pojo> response) {

                if (response.isSuccessful()) {
                    dailoghide(context);
                    if (response.code() == 200) {
                        videolistbyCatId_interface.CustomerIntroVideo((ArrayList<CustomerIntroVideo_pojo.Datum>) response.body().getData());

                    }
                } else if (response.code() == 401) {
                    tokenExpired(context);
                } else {
                    dailoghide(context);
                    GlobalClass.showtost(context, "Token Has Expired..." + response.body().getMessage());
                    Intent intent = new Intent(context.getApplicationContext(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);


                }
            }

            @Override
            public void onFailure(Call<CustomerIntroVideo_pojo> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void customerIntroVideoCreate(final Context context, RequestBody customer_id, RequestBody tital,
                                         RequestBody summary, RequestBody live_started_at, RequestBody token, MultipartBody.Part video, MultipartBody.Part image, final VideoUploadInterface videoUploadInterface) {
        dailogshow(context);
        Call<CustomerIntroVideoCreate_pojo> userpost_responseCall =
                ApiClient.getClient().customerIntroVideoCreate(GlobalClass.apikey, customer_id, tital, summary, live_started_at, token, video, image);
        userpost_responseCall.enqueue(new Callback<CustomerIntroVideoCreate_pojo>() {
            @Override
            public void onResponse(Call<CustomerIntroVideoCreate_pojo> call, Response<CustomerIntroVideoCreate_pojo> response) {

                if (response.isSuccessful()) {
                    dailoghide(context);

                    if (response.code() == 200) {
                        GlobalClass.showtost(context, "" + response.body().getMessage());
                        videoUploadInterface.closeActivity();

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        GlobalClass.showtost(context, "" + response.body().getMessage());
                        videoUploadInterface.closeActivity();

                    }


                } else {
                    dailoghide(context);
                    GlobalClass.showtost(context, "" + response.message());
                }
            }


            @Override
            public void onFailure(Call<CustomerIntroVideoCreate_pojo> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void uploadMovieVideo(final Context context, RequestBody customer_id, RequestBody tital, RequestBody movie_category, RequestBody duration, RequestBody movie_language, RequestBody video_access,
                                 RequestBody video_description, RequestBody release_date, RequestBody video_type, RequestBody token, MultipartBody.Part video, MultipartBody.Part image, MultipartBody.Part cover, final VideoUploadInterface videoUploadInterface) {
        dailogshow(context);
        Call<CustomerIntroVideoCreate_pojo> userpost_responseCall =
                ApiClient.getClient().customerVideoSave(GlobalClass.apikey, customer_id, tital,tital, movie_category, duration, movie_language, video_access, video_description, release_date, video_type, token, image, cover, video);
        userpost_responseCall.enqueue(new Callback<CustomerIntroVideoCreate_pojo>() {
            @Override
            public void onResponse(Call<CustomerIntroVideoCreate_pojo> call, Response<CustomerIntroVideoCreate_pojo> response) {

                if (response.isSuccessful()) {
                    dailoghide(context);

                    if (response.code() == 200) {
                        GlobalClass.showtost(context, "" + response.body().getMessage());
                        videoUploadInterface.closeActivity();

                    } else {
                        GlobalClass.showtost(context, "" + response.body().getMessage());

                        Log.d("VideoResponse", response.toString());

                    }


                } else if (response.code() == 401) {
                    dailoghide(context);
                    tokenExpired(context);
                } else {
                    dailoghide(context);
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
//                    Toast.makeText(context, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                        GlobalClass.showtost(context, "" + jObjError.getString("message"));

                    } catch (Exception e) {
//                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                        GlobalClass.showtost(context, "" + e.getMessage());

                    }

                    GlobalClass.showtost(context, "" + response.message());
                    Log.d("VideoResponse", response.toString());

                }
            }


            @Override
            public void onFailure(Call<CustomerIntroVideoCreate_pojo> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }










// public void uploadMovies(final Context context, RequestBody customer_id, RequestBody tital, RequestBody movie_category, RequestBody duration, RequestBody movie_language, RequestBody video_access,
//                               RequestBody video_description, RequestBody release_date, RequestBody video_type, RequestBody token, MultipartBody.Part video, MultipartBody.Part image, MultipartBody.Part cover, final VideoUploadInterface videoUploadInterface) {
//        dailogshow(context);
//        Call<CustomerIntroVideoCreate_pojo> userpost_responseCall =
//                ApiClient.getClient().customerVideoSave(GlobalClass.apikey, customer_id, tital, movie_category, duration, movie_language, video_access, video_description, release_date, video_type, token, image, cover, video);
//        userpost_responseCall.enqueue(new Callback<CustomerIntroVideoCreate_pojo>() {
//            @Override
//            public void onResponse(Call<CustomerIntroVideoCreate_pojo> call, Response<CustomerIntroVideoCreate_pojo> response) {
//
//                if (response.isSuccessful()) {
//                    dailoghide(context);
//
//                    if (response.code() == 200) {
//                        GlobalClass.showtost(context, "" + response.body().getMessage());
//                        videoUploadInterface.closeActivity();
//
//                    } else if (response.code() == 401) {
//                        tokenExpired(context);
//                    } else {
//                        GlobalClass.showtost(context, "" + response.body().getMessage());
//
//                        Log.d("VideoResponse", response.toString());
//
//                    }
//
//
//                } else {
//                    dailoghide(context);
//                    try {
//                        JSONObject jObjError = new JSONObject(response.errorBody().string());
////                    Toast.makeText(context, jObjError.getString("message"), Toast.LENGTH_LONG).show();
//                        GlobalClass.showtost(context, "" + jObjError.getString("message"));
//
//                    } catch (Exception e) {
////                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
//                        GlobalClass.showtost(context, "" + e.getMessage());
//
//                    }
//
//                    GlobalClass.showtost(context, "" + response.message());
//                    Log.d("VideoResponse", response.toString());
//
//                }
//            }
//
//
//            @Override
//            public void onFailure(Call<CustomerIntroVideoCreate_pojo> call, Throwable t) {
//
//                dailoghide(context);
//                t.printStackTrace();
//                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
//                Log.d("dddddd", "onFailure: " + t.getMessage());
//            }
//        });
//    }


    public void livecustomerList(final Context context, String token, final LiveCustomer_interface liveCustomer_interface) {
        dailogshow(context);
        Call<LiveCustomerResponse> userpost_responseCall = ApiClient.getClient().livecustomerList(GlobalClass.apikey, "Bearer " + token);
        userpost_responseCall.enqueue(new Callback<LiveCustomerResponse>() {
            @Override
            public void onResponse(Call<LiveCustomerResponse> call, Response<LiveCustomerResponse> response) {
                if (response.isSuccessful()) {
                    dailoghide(context);


                    if (response.code() == 200) {

                        assert response.body() != null;
                        if(response.body().getData().size()>0) {
                            liveCustomer_interface.channelCategory((ArrayList<LiveCustomerResponse.Datum>) response.body().getData());
                        }
                        GlobalClass.showtost(context, response.body().getMessage());


                    } else {
                        GlobalClass.showtost(context, " something went wrong please.Try after sometimes");

                    }
                } else if (response.code() == 401) {
                    dailoghide(context);
                    tokenExpired(context);
                } else {
                    dailoghide(context);
                    GlobalClass.showtost(context, "Token Has Expired..." + response.message());


//                    Intent intent = new Intent(context.getApplicationContext(), LoginActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);


                }

            }

            @Override
            public void onFailure(Call<LiveCustomerResponse> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    public void invite_list(final Context context, String auth, final Invite_list_interface invite_list_interface) {
        dailogshow(context);
        Call<Invite_lists_Model> userpost_responseCall = ApiClient.getClient().invite_list(GlobalClass.apikey, auth);
        userpost_responseCall.enqueue(new Callback<Invite_lists_Model>() {
            @Override
            public void onResponse(Call<Invite_lists_Model> call, Response<Invite_lists_Model> response) {
                if (response.isSuccessful()) {
                    dailoghide(context);


                    if (response.code() == 200) {
                        invite_list_interface.invite_list_interface((ArrayList<Invite_lists_Model.Datum>) response.body().getData());

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        GlobalClass.showtost(context, " something went wrong please.Try after sometimes");

                    }
                } else {
                    dailoghide(context);
                    GlobalClass.showtost(context, "Token Has Expired..." + response.body().getMessage());
                    Intent intent = new Intent(context.getApplicationContext(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);


                }

            }

            @Override
            public void onFailure(Call<Invite_lists_Model> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void invitationSend(final Context context, String auth, ArrayListCustomerId id, TextView textView) {
        dailogshow(context);
        Call<Invite_lists_Model> userpost_responseCall = ApiClient.getClient().invitationSend(GlobalClass.apikey, "Bearer " + auth, id);
        userpost_responseCall.enqueue(new Callback<Invite_lists_Model>() {
            @Override
            public void onResponse(Call<Invite_lists_Model> call, Response<Invite_lists_Model> response) {
                if (response.isSuccessful()) {
                    dailoghide(context);


                    if (response.code() == 200) {
                        textView.setText("Pending");
                        GlobalClass.showtost(context, "" + response.body().getMessage());

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        GlobalClass.showtost(context, " something went wrong please.Try after sometimes");

                    }
                } else {
                    dailoghide(context);
//                    GlobalClass.showtost(context, "Token Has Expired..." + response.body().getMessage());


                }

            }

            @Override
            public void onFailure(Call<Invite_lists_Model> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void customerProfilePic(final Context context, String auth, RequestBody customer_id, MultipartBody.Part image) {
        dailogshow(context);
        Call<CustomerProfilePicPOJO> userpost_responseCall = ApiClient.getClient().customerProfilePic(GlobalClass.apikey, "Bearer " + auth, customer_id, image);
        userpost_responseCall.enqueue(new Callback<CustomerProfilePicPOJO>() {
            @Override
            public void onResponse(Call<CustomerProfilePicPOJO> call, Response<CustomerProfilePicPOJO> response) {
                if (response.isSuccessful()) {
                    dailoghide(context);


                    if (response.code() == 200) {

                        GlobalClass.showtost(context, "" + response.body().getMessage());

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        GlobalClass.showtost(context, " something went wrong please.Try after sometimes");

                    }
                } else {
                    dailoghide(context);
//                    GlobalClass.showtost(context, "Token Has Expired..." + response.body().getMessage());


                }

            }

            @Override
            public void onFailure(Call<CustomerProfilePicPOJO> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


//    public void customerProfilePicfirstname(final Context context, String auth, String customerid, String firstname, String lastname, Button submit) {
//        dailogshow(context);
//        Call<CustomerProfilePicPOJO> userpost_responseCall = ApiClient.getClient().customerProfilePics(GlobalClass.apikey, "Bearer " + auth,customerid,firstname,lastname);
//        userpost_responseCall.enqueue(new Callback<CustomerProfilePicPOJO>() {
//            @Override
//            public void onResponse(Call<CustomerProfilePicPOJO> call, Response<CustomerProfilePicPOJO> response) {
//                if (response.isSuccessful()) {
//                    dailoghide(context);
//
//
//                    if (response.code() == 200) {
//
//                        GlobalClass.showtost(context, "" + response.body().getMessage());
//                        submit.setVisibility(View.GONE);
//                    } else if (response.code() == 401) {
//                        GlobalClass.showtost(context, "" + response.body().getMessage());
//
//                    } else {
//                        GlobalClass.showtost(context, " something went wrong please.Try after sometimes");
//
//                    }
//                } else {
//                    dailoghide(context);
////                    GlobalClass.showtost(context, "Token Has Expired..." + response.body().getMessage());
//
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<CustomerProfilePicPOJO> call, Throwable t) {
//
//                dailoghide(context);
//                t.printStackTrace();
//                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
//                Log.d("dddddd", "onFailure: " + t.getMessage());
//            }
//        });
//    }


    public void friendRequestSend(final Context context, String auth, String login_customer_id_sender, String customer_id_to_sent) {
        dailogshow(context);
        Call<CustomerProfilePicPOJO> userpost_responseCall = ApiClient.getClient().friendRequestSend(GlobalClass.apikey, "Bearer " + auth, login_customer_id_sender, customer_id_to_sent);
        userpost_responseCall.enqueue(new Callback<CustomerProfilePicPOJO>() {
            @Override
            public void onResponse(Call<CustomerProfilePicPOJO> call, Response<CustomerProfilePicPOJO> response) {
                if (response.isSuccessful()) {
                    dailoghide(context);


                    if (response.code() == 200) {

                        GlobalClass.showtost(context, "" + response.body().getMessage());

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else if (response.code() == 500) {
                        GlobalClass.showtost(context, "" + response.body().getMessage());

                    } else {
                        GlobalClass.showtost(context, " something went wrong please.Try after sometimes");

                    }
                } else {
                    dailoghide(context);
//                    GlobalClass.showtost(context, "Token Has Expired..." + response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<CustomerProfilePicPOJO> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void MyFriendList(final Context context, String auth, String customer_id, FriendList friendList) {
        dailogshow(context);
        Call<FriendListModel> userpost_responseCall = ApiClient.getClient().MyFriendList(GlobalClass.apikey, "Bearer " + auth, customer_id);
        userpost_responseCall.enqueue(new Callback<FriendListModel>() {
            @Override
            public void onResponse(Call<FriendListModel> call, Response<FriendListModel> response) {
                if (response.isSuccessful()) {
                    dailoghide(context);

                    if (response.code() == 200) {
                        assert response.body() != null;
                        if (!(response.body().getData() == null)) {
//                            friendListInterface.tokboxcredentialsInterface(response.body().getData().getTokboxCredentials());
//                            friendListInterface.friendListInterface((ArrayList<FriendListPoJO.FriendList>) response.body().getData().getFriendLists());
                            friendList.FriendList((List<FriendListModel.Data.FriendList>) response.body().getData().getFriendLists());
//                            GlobalClass.showtost(context, "" + response.body().getMessage());
                        }
                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        GlobalClass.showtost(context, " something went wrong please.Try after sometimes");

                    }
                } else {
                    dailoghide(context);
//                    GlobalClass.showtost(context, "Token Has Expired..." + response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<FriendListModel> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void RecentVideo(final Context context, String auth, String customer_id, String video_id) {
//        dailogshow(context);
        Call<FriendListPoJO> userpost_responseCall = ApiClient.getClient().RecentVideo(GlobalClass.apikey, "Bearer " + auth, customer_id, video_id, "1:00");
        userpost_responseCall.enqueue(new Callback<FriendListPoJO>() {
            @Override
            public void onResponse(Call<FriendListPoJO> call, Response<FriendListPoJO> response) {
                if (response.isSuccessful()) {
//                    dailoghide(context);
                    if (response.code() == 200 || response.code() == 201) {
//                        friendListInterface.tokboxcredentialsInterface(response.body().getData().getTokboxCredentials());
//                        friendListInterface.friendListInterface((ArrayList<FriendListPoJO.FriendList>)response.body().getData().getFriendLists());
//                        GlobalClass.showtost(context, "Saved" + response.body().getMessage());

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        GlobalClass.showtost(context, " something went wrong please.Try after sometimes");

                    }
                } else {
                    dailoghide(context);
//                    GlobalClass.showtost(context, "Token Has Expired..." + response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<FriendListPoJO> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    // Notifaction List

    public void invitedNotificationList(final Context context, String auth, String customer_id, InvitedNotificationListInterface invitedNotificationListInterface, TextView notfound) {
        dailogshow(context);
        Call<InvitedNotificationListPOJO> userpost_responseCall = ApiClient.getClient().invitedNotificationList(GlobalClass.apikey, "Bearer " + auth, customer_id);
        userpost_responseCall.enqueue(new Callback<InvitedNotificationListPOJO>() {
            @Override
            public void onResponse(Call<InvitedNotificationListPOJO> call, Response<InvitedNotificationListPOJO> response) {
                if (response.isSuccessful()) {
                    dailoghide(context);
                    if (response.code() == 200) {
                        invitedNotificationListInterface.invitedNotificationListInterface((ArrayList<InvitedNotificationListPOJO.Datum>) response.body().getData());
                        GlobalClass.showtost(context, "" + response.body().getMessage());

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        GlobalClass.showtost(context, " something went wrong please.Try after sometimes");
                    }
                } else {
                    dailoghide(context);
//                    GlobalClass.showtost(context, "Token Has Expired..." + response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<InvitedNotificationListPOJO> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void friendRequestAction(final Context context, String auth, String customer_id, String invite_status, String login_id, TextView notfound) {
        dailogshow(context);
        Call<CustomerProfilePicPOJO> userpost_responseCall = ApiClient.getClient().friendRequestAction(GlobalClass.apikey, "Bearer " + auth, customer_id, invite_status, login_id);
        userpost_responseCall.enqueue(new Callback<CustomerProfilePicPOJO>() {
            @Override
            public void onResponse(Call<CustomerProfilePicPOJO> call, Response<CustomerProfilePicPOJO> response) {
                if (response.isSuccessful()) {
                    dailoghide(context);


                    if (response.code() == 200) {
                        GlobalClass.showtost(context, "" + response.body().getMessage());

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        GlobalClass.showtost(context, " something went wrong please.Try after sometimes");

                    }
                } else {
                    dailoghide(context);
//                    GlobalClass.showtost(context, "Token Has Expired..." + response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<CustomerProfilePicPOJO> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }



    public void getSeasons(SeriesInterface seriesInterface, Context context, String tooken,String customer_id,String series_id) {
        dailogshow(context);
        Call<SeriesList> userpost_responseCall = ApiClient.getClient().getSeriesList(GlobalClass.apikey, "Bearer " + tooken, customer_id,series_id);
        userpost_responseCall.enqueue(new Callback<SeriesList>() {
            @Override
            public void onResponse(Call<SeriesList> call, Response<SeriesList> response) {
                if (response.isSuccessful()) {
                    dailoghide(context);

                    if (response.code() == 200) {
                        assert response.body() != null;
//                        if (!(response.body().getData() == null)) {
//                            seriesInterface.tokboxcredentialsInterface(response.body().getData().getTokboxCredentials());
//                            seriesInterface.friendListInterface((ArrayList<FriendListPoJO.FriendList>) response.body().getData().getFriendLists());
//                        if(!response.body().getStatusCode().equals("400")) {
                            seriesInterface.SeriesList(response.body().getData().getSeasons());
//                        }
//                            GlobalClass.showtost(context, "" + response.body().getMessage());
//                        }

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        GlobalClass.showtost(context, " something went wrong please.Try after sometimes");

                    }
                } else {
                    dailoghide(context);
//                    GlobalClass.showtost(context, "Token Has Expired..." + response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<SeriesList> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.toString());
            }
        });

    }





    public void getFriendRequest(final Context context, String auth, String customer_id, final FreindRequestInterface freindRequestInterface) {
        dailogshow(context);
        Call<FriendRequest> userpost_responseCall = ApiClient.getClient().getFreindRequest(GlobalClass.apikey, "Bearer " + auth, customer_id);
        userpost_responseCall.enqueue(new Callback<FriendRequest>() {
            @Override
            public void onResponse(Call<FriendRequest> call, Response<FriendRequest> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.code() == 200) {
                        freindRequestInterface.RequestList(response.body().getData());
                    }
                } else if (response.code() == 401) {
                    tokenExpired(context);
                }
            }

            @Override
            public void onFailure(Call<FriendRequest> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.toString());
            }
        });
    }


    public void getAllNotification(final Context context, String auth, String videoid, final FreindRequestInterface freindRequestInterface) {
        dailogshow(context);
        Call<AllNotificationModel> userpost_responseCall = ApiClient.getClient().getAllNotification(GlobalClass.apikey, "Bearer " + auth, videoid);
        userpost_responseCall.enqueue(new Callback<AllNotificationModel>() {
            @Override
            public void onResponse(Call<AllNotificationModel> call, Response<AllNotificationModel> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.code() == 200) {
                        freindRequestInterface.AllNotificationList(response.body().getData());
                    }
                } else if (response.code() == 401) {
                    tokenExpired(context);
                }
            }

            @Override
            public void onFailure(Call<AllNotificationModel> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }



    public void FriendRequestAction(final Context context, String auth, String login_id,String invite_status, String customer_id , FreindRequestInterface frienRequestinterface) {
        dailogshow(context);
        Call<CustomerFriendAcceptReject> friendAcceptRejectCall = ApiClient.getClient().getFreindRequestResponse(GlobalClass.apikey, "Bearer " + auth, login_id,invite_status,customer_id);
        friendAcceptRejectCall.enqueue(new Callback<CustomerFriendAcceptReject>() {
            @Override
            public void onResponse(Call<CustomerFriendAcceptReject> call, Response<CustomerFriendAcceptReject> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.code() == 200) {

                        frienRequestinterface.InviteResponse(response.body().getMessage());
                    }
                } else if (response.code() == 401) {
                    tokenExpired(context);
                }else{
                    GlobalClass.showtost(context, response.message());
                }

            }

            @Override
            public void onFailure(Call<CustomerFriendAcceptReject> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }



    public void FriendRequestSend(final Context context, String auth,String customer_id, String friend_id,User_list user_list_interface,int position) {
        dailogshow(context);
        Call<FriendRequestSent> friendAcceptRejectCall = ApiClient.getClient().FriendRequestSend(GlobalClass.apikey, "Bearer " + auth,customer_id,friend_id);
        friendAcceptRejectCall.enqueue(new Callback<FriendRequestSent>() {
            @Override
            public void onResponse(Call<FriendRequestSent> call, Response<FriendRequestSent> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.body().getStatusCode()==200) {

                        GlobalClass.showtost(context, response.body().getMessage());
                        user_list_interface.RequestSent(position);

                    }
                } else if (response.code() == 401) {
                    tokenExpired(context);
                }else{
                    GlobalClass.showtost(context, response.message());
                }
            }

            @Override
            public void onFailure(Call<FriendRequestSent> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void VideoLike(final Context context, String auth, String videoid,String customer_id, final Video_detail_Interfae video_detail_interfae) {
        dailogshow(context);
        Call<CustomerFriendAcceptReject> userpost_responseCall = ApiClient.getClient().videoLike(GlobalClass.apikey, "Bearer " + auth, videoid,customer_id,"1");
        userpost_responseCall.enqueue(new Callback<CustomerFriendAcceptReject>() {
            @Override
            public void onResponse(Call<CustomerFriendAcceptReject> call, Response<CustomerFriendAcceptReject> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.code() == 200) {

                        video_detail_interfae.videoLike(response.body().getMessage());
                    }
                } else if (response.code() == 401) {
                    tokenExpired(context);
                }

            }

            @Override
            public void onFailure(Call<CustomerFriendAcceptReject> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void UserSubscribe(final Context context, String auth,String customer_id, final String channel_id, Account_profile account_profile) {
        dailogshow(context);
        Call<CustomerFriendAcceptReject> userpost_responseCall = ApiClient.getClient().UserSubscribe(GlobalClass.apikey, "Bearer " + auth, customer_id,channel_id);
        userpost_responseCall.enqueue(new Callback<CustomerFriendAcceptReject>() {
            @Override
            public void onResponse(Call<CustomerFriendAcceptReject> call, Response<CustomerFriendAcceptReject> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.code() == 200) {

                        account_profile.Subscrbe(response.body().getMessage());
                    }
                } else if (response.code() == 401) {
                    tokenExpired(context);
                }else if (response.code() == 409){
                    GlobalClass.showtost(context,"Channel already Subscibed");
                }

            }

            @Override
            public void onFailure(Call<CustomerFriendAcceptReject> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void saveNewPassword(final Context context, String auth,String customer_id, final String oldpassword, String newPassword,String new_confirm_password,EditPassword editPassword) {
        dailogshow(context);
        Call<CustomerFriendAcceptReject> userpost_responseCall = ApiClient.getClient().saveNewPassword(GlobalClass.apikey, "Bearer " + auth, customer_id,oldpassword,newPassword,new_confirm_password);
        userpost_responseCall.enqueue(new Callback<CustomerFriendAcceptReject>() {
            @Override
            public void onResponse(Call<CustomerFriendAcceptReject> call, Response<CustomerFriendAcceptReject> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.code() == 200) {

                        editPassword.PasswordChanged(response.body().getMessage());
                    }
                } else if (response.code() == 401) {
                    tokenExpired(context);
                }else if (response.code() == 409){
                    GlobalClass.showtost(context,response.message());
                }

            }

            @Override
            public void onFailure(Call<CustomerFriendAcceptReject> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void getSeasonSeries(Context context, cable.social.app.Interface.SeasonSeries myTotalSeries, String tooken, String customer_id) {

        dailogshow(context);
        Call<SeasonSeries> userpost_responseCall = ApiClient.getClient().getSeasonSeries(GlobalClass.apikey, "Bearer " + tooken, customer_id);
        userpost_responseCall.enqueue(new Callback<SeasonSeries>() {
            @Override
            public void onResponse(Call<SeasonSeries> call, Response<SeasonSeries> response) {
                dailoghide(context);

                if (response.isSuccessful()) {

                    if (response.code() == 200) {

                        myTotalSeries.SeasonData(response.body().getData());
                    }
                } else if (response.code() == 401) {
                    tokenExpired(context);
                }else if (response.code() == 409){
                    GlobalClass.showtost(context,response.message());
                }

            }

            @Override
            public void onFailure(Call<SeasonSeries> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }





    public void uploadNewSeries(final Context context,RequestBody token,RequestBody video_title, RequestBody customer_id, RequestBody movie_category,MultipartBody.Part image,MultipartBody.Part video,RequestBody video_access,RequestBody release_date,RequestBody language, RequestBody season_number,RequestBody season_title,MultipartBody.Part cover,RequestBody season_description,RequestBody air_date,RequestBody video_type,  RequestBody series_name,final VideoUploadInterface videoUploadInterface) {
        dailogshow(context);
        Call<CustomerIntroVideoCreate_pojo> userpost_responseCall =
                ApiClient.getClient().uploadNewSeries(GlobalClass.apikey,token,video_title,customer_id,movie_category,image,video,video_access,release_date,language,season_number,season_title,cover,season_description,air_date,video_type,series_name, token);
        userpost_responseCall.enqueue(new Callback<CustomerIntroVideoCreate_pojo>() {
            @Override
            public void onResponse(Call<CustomerIntroVideoCreate_pojo> call, Response<CustomerIntroVideoCreate_pojo> response) {

                if (response.isSuccessful()) {
                    dailoghide(context);

                    if (response.code() == 200) {
                        GlobalClass.showtost(context, "" + response.body().getMessage());
                        videoUploadInterface.closeActivity();

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        GlobalClass.showtost(context, "" + response.body().getMessage());

                        Log.d("VideoResponse", response.toString());

                    }


                } else {
                    dailoghide(context);
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
//                    Toast.makeText(context, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                        GlobalClass.showtost(context, "" + jObjError.getString("message"));

                    } catch (Exception e) {
//                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                        GlobalClass.showtost(context, "" + e.getMessage());

                    }

                    GlobalClass.showtost(context, "" + response.message());
                    Log.d("VideoResponse", response.toString());

                }
            }


            @Override
            public void onFailure(Call<CustomerIntroVideoCreate_pojo> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


        public void uploadNewSeason(final Context context,RequestBody token,RequestBody video_title, RequestBody customer_id, RequestBody movie_category,MultipartBody.Part image,MultipartBody.Part video,RequestBody video_access,RequestBody release_date,RequestBody language, RequestBody season_number,RequestBody season_title,MultipartBody.Part cover,RequestBody season_description,RequestBody air_date,RequestBody video_type,  RequestBody series_id,final VideoUploadInterface videoUploadInterface) {
        dailogshow(context);
        Call<CustomerIntroVideoCreate_pojo> userpost_responseCall =
                ApiClient.getClient().uploadNewSeason(GlobalClass.apikey,token,video_title,customer_id,movie_category,image,video,video_access,release_date,language,season_number,season_title,cover,season_description,air_date,video_type,series_id, token);
        userpost_responseCall.enqueue(new Callback<CustomerIntroVideoCreate_pojo>() {
            @Override
            public void onResponse(Call<CustomerIntroVideoCreate_pojo> call, Response<CustomerIntroVideoCreate_pojo> response) {

                if (response.isSuccessful()) {
                    dailoghide(context);

                    if (response.code() == 200) {
                        GlobalClass.showtost(context, "" + response.body().getMessage());
                        videoUploadInterface.closeActivity();

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        GlobalClass.showtost(context, "" + response.body().getMessage());

                        Log.d("VideoResponse", response.toString());
                    }


                } else {
                    dailoghide(context);
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
//                    Toast.makeText(context, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                        GlobalClass.showtost(context, "" + jObjError.getString("message"));

                    } catch (Exception e) {
//                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                        GlobalClass.showtost(context, "" + e.getMessage());

                    }

                    GlobalClass.showtost(context, "" + response.message());
                    Log.d("VideoResponse", response.toString());

                }
            }


            @Override
            public void onFailure(Call<CustomerIntroVideoCreate_pojo> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }



    public void uploadNewEpisode(final Context context,RequestBody token,RequestBody video_title, RequestBody customer_id, RequestBody movie_category,MultipartBody.Part image,MultipartBody.Part video,RequestBody video_access,RequestBody release_date,RequestBody language, RequestBody series_id,RequestBody season_id,RequestBody video_type,final VideoUploadInterface videoUploadInterface) {
        dailogshow(context);
        Call<CustomerIntroVideoCreate_pojo> userpost_responseCall =
                ApiClient.getClient().uploadNewEpisode(GlobalClass.apikey,token,video_title,customer_id,movie_category,image,video,video_access,release_date,language,video_type,series_id,season_id, token);
        userpost_responseCall.enqueue(new Callback<CustomerIntroVideoCreate_pojo>() {
            @Override
            public void onResponse(Call<CustomerIntroVideoCreate_pojo> call, Response<CustomerIntroVideoCreate_pojo> response) {

                if (response.isSuccessful()) {
                    dailoghide(context);

                    if (response.code() == 200) {
                        GlobalClass.showtost(context, "" + response.body().getMessage());
                        videoUploadInterface.closeActivity();

                    } else if (response.code() == 401) {
                        tokenExpired(context);
                    } else {
                        GlobalClass.showtost(context, "" + response.body().getMessage());

                        Log.d("VideoResponse", response.toString());

                    }


                } else {
                    dailoghide(context);
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
//                    Toast.makeText(context, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                        GlobalClass.showtost(context, "" + jObjError.getString("message"));

                    } catch (Exception e) {
//                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                        GlobalClass.showtost(context, "" + e.getMessage());

                    }

                    GlobalClass.showtost(context, "" + response.message());
                    Log.d("VideoResponse", response.toString());

                }
            }


            @Override
            public void onFailure(Call<CustomerIntroVideoCreate_pojo> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }










}
