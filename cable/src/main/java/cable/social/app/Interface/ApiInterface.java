package cable.social.app.Interface;


import cable.social.app.model.AllNotificationModel;
import cable.social.app.model.ArrayListCustomerId;
import cable.social.app.model.CategorySubList;
import cable.social.app.model.Category_model;
import cable.social.app.model.ChannelCategory_Pojo;
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
import cable.social.app.model.Logout_model;
import cable.social.app.model.MyVideo;
import cable.social.app.model.SeasonSeries;
import cable.social.app.model.SeriesList;
import cable.social.app.model.SignupResponse;
import cable.social.app.model.Slider_model;
import cable.social.app.model.SubscribePlans_model;
import cable.social.app.model.UserList;
import cable.social.app.model.UserName;
import cable.social.app.model.VideoDetailModel;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiInterface {

    @Headers("apikey:base64:ATC+vljhHr3GdKMD7j69utCF+hUoaISYHwyFxBhOztI=")
    @GET("home/page")
    Call<Slider_model> slider_list(@Header("Authorization") String string);


    @Headers("apikey:base64:ATC+vljhHr3GdKMD7j69utCF+hUoaISYHwyFxBhOztI=")
    @GET("category/list")
    Call<Category_model> category_list(@Header("Authorization") String token);



    @Headers("apikey:base64:ATC+vljhHr3GdKMD7j69utCF+hUoaISYHwyFxBhOztI=")
    @GET("showEpisodeCategory")
    Call<Category_model> category_listEpisode(@Header("Authorization") String token);

    @FormUrlEncoded
    @POST("activecustomerList")
    Call<UserList> ActiveCustomerList(@Header("apikey") String api_key, @Header("Authorization") String token,@Field("customer_id") String customer_id);



    @Headers("apikey:base64:ATC+vljhHr3GdKMD7j69utCF+hUoaISYHwyFxBhOztI=")
    @FormUrlEncoded
    @POST("videolistbyVideoType")
    Call<MyVideo> my_video_list(@Header("Authorization") String string,@Field("customer_id") String customer_id,@Field("video_type") String video_type);


    @Headers("apikey:base64:ATC+vljhHr3GdKMD7j69utCF+hUoaISYHwyFxBhOztI=")
    @GET("subscription/plan")
    Call<SubscribePlans_model> subscribe_list(@Header("Authorization") String auth);


    @Headers("apikey:base64:ATC+vljhHr3GdKMD7j69utCF+hUoaISYHwyFxBhOztI=")
    @FormUrlEncoded
    @POST("app-registration")
    Call<SignupResponse> SignupUser(@FieldMap HashMap<String, String> hashMap);


    @Headers("apikey:base64:ATC+vljhHr3GdKMD7j69utCF+hUoaISYHwyFxBhOztI=")
    @FormUrlEncoded
    @POST("checkExistUsername")
    Call<UserName> CheckUserName(@FieldMap HashMap<String, String> hashMap);

/*

    @Headers("apikey:base64:ATC+vljhHr3GdKMD7j69utCF+hUoaISYHwyFxBhOztI=")
    @FormUrlEncoded
    @POST("app-login")
    Call<LoginResponse> loginUser(@FieldMap HashMap<String, String> hashMap);
*/


    @FormUrlEncoded
    @POST("app-login")
    Call<LoginResponse> loginUser(@Header("apikey") String string, @FieldMap HashMap<String, String> hashMap);

    @FormUrlEncoded
    @POST("customerInfo")
    Call<CustomerInfo_pojo> customerInfo(@Header("apikey") String string, @Header("Authorization") String auth, @Field("customer_id") String customer_id);


    @FormUrlEncoded
    @POST("app-logout")
    Call<Logout_model> app_logout(@Header("apikey") String string, @Header("Authorization") String auth, @Field("token") String token);

    @FormUrlEncoded
    @POST("channelList")
    Call<ChannelList_Model> channelList(@Header("apikey") String string, @Header("Authorization") String token, @Field("customer_id") String customer_id);


    @GET("channelCategory")
    Call<ChannelCategory_Pojo> channelCategory(@Header("apikey") String string, @Header("Authorization") String auth);

    @GET("channeLogolList")
    Call<ChannelLogoList> channel_logo_list(@Header("apikey") String string, @Header("Authorization") String auth);

    @FormUrlEncoded
    @POST("videolistbyCatId")
    Call<CategorySubList> channelSubCategory(@Header("apikey") String string, @Header("Authorization")  String auth,@Field("category_id") String category_id);

    @FormUrlEncoded
    @POST("video-detailById")
    Call<VideoDetailModel> videodetailById(@Header("apikey") String string, @Header("Authorization") String token,@Field("customer_id") String customer_id, @Field("video_id") String video_id);


    @FormUrlEncoded
    @POST("videoLike")
    Call<CustomerFriendAcceptReject> videoLike(@Header("apikey") String string, @Header("Authorization") String token, @Field("video_id") String video_id, @Field("customer_id") String customer_id,@Field("video_like") String like);


    @FormUrlEncoded
    @POST("customerIntroVideo")
    Call<CustomerIntroVideo_pojo> customerIntroVideo(@Header("apikey") String string, @Header("Authorization") String token, @Field("customer_id") String s);


    @Multipart
    @POST("customerIntroVideoCreate")
    Call<CustomerIntroVideoCreate_pojo> customerIntroVideoCreate(@Header("apikey") String string, @Part("customer_id") RequestBody customer_id,
                                                                 @Part("title")RequestBody title,
                                                                 @Part("summary")RequestBody summary,
                                                                 @Part("live_started_at")RequestBody live_started_at,
                                                                 @Part("token")RequestBody token,
                                                                 @Part MultipartBody.Part  video,
                                                                 @Part MultipartBody.Part  image);

    @Multipart
    @POST("video-save")
    Call<CustomerIntroVideoCreate_pojo> customerVideoSave(@Header("apikey") String string,
                                                                 @Part("customer_id") RequestBody customer_id,
                                                                 @Part("episode_title")RequestBody title,
                                                                 @Part("video_title")RequestBody video_title,
                                                                 @Part("movie_category")RequestBody summary,
                                                                 @Part("duration")RequestBody live_started_at,
                                                                 @Part("movie_language")RequestBody movie_language,
                                                                 @Part("video_access")RequestBody video_access,
                                                                 @Part("video_description")RequestBody video_description,
                                                                 @Part("release_date")RequestBody release_date,
                                                                 @Part("video_type")RequestBody video_type,
                                                                 @Part("token")RequestBody token,
                                                                 @Part MultipartBody.Part  video,
                                                                 @Part MultipartBody.Part  image,
                                                                 @Part MultipartBody.Part  poster);




    @Multipart
    @POST("video-save")
    Call<CustomerIntroVideoCreate_pojo> uploadMovies(@Header("apikey") String string,
                                                       @Part("customer_id") RequestBody customer_id,
                                                       @Part("video_title")RequestBody title,
                                                       @Part("movie_category")RequestBody summary,
                                                       @Part("duration")RequestBody live_started_at,
                                                       @Part("movie_language")RequestBody movie_language,
                                                       @Part("video_access")RequestBody video_access,
                                                       @Part("video_description")RequestBody video_description,
                                                       @Part("release_date")RequestBody release_date,
                                                       @Part("video_type")RequestBody video_type,
                                                       @Part("token")RequestBody token,
                                                       @Part MultipartBody.Part  video,
                                                       @Part MultipartBody.Part  image,
                                                       @Part MultipartBody.Part  poster);


    @GET("livecustomerList")
    Call<LiveCustomerResponse> livecustomerList(@Header("apikey") String string, @Header("Authorization") String auth);


    @FormUrlEncoded
    @POST("invite-lists")
    Call<Invite_lists_Model> invite_list(@Header("apikey") String string, @Field("token") String token);

    @FormUrlEncoded
    @POST("invitationSend")
    Call<Invite_lists_Model> invitationSend(@Header("apikey") String string,@Header("Authorization") String auth,@Body ArrayListCustomerId ages);

    @Multipart
    @POST("customerProfile")
    Call<CustomerProfilePicPOJO> customerProfilePics(@Header("apikey") String string,@Header("Authorization") String auth,
                                                     @Part("customer_id") RequestBody customer_id,
                                                     @Part("customer_name") RequestBody customer_name,
                                                     @Part("customer_username") RequestBody customer_last_name,
                                                     @Part MultipartBody.Part cover_profile_image);


    @FormUrlEncoded
    @POST("friendRequestSend")
    Call<CustomerProfilePicPOJO> friendRequestSend(@Header("apikey") String string,@Header("Authorization") String auth,
                                                   @Field("login_customer_id_sender") String login_customer_id_sender,
                                                    @Field("customer_id_to_sent") String customer_id_to_sent);


    @FormUrlEncoded
    @POST("friendList")
    Call<FriendListModel> MyFriendList(@Header("apikey") String string, @Header("Authorization") String auth, @Field("customer_id") String customer_id);

    @FormUrlEncoded
    @POST("seasons")
    Call<SeriesList> getSeriesList(@Header("apikey") String string, @Header("Authorization") String auth, @Field("customer_id") String customer_id,@Field("series_id") String series_id);

    @FormUrlEncoded
    @POST("videoHistoryStore")
    Call<FriendListPoJO> RecentVideo(@Header("apikey") String string, @Header("Authorization") String auth,
                                    @Field("customer_id") String customer_id,@Field("video_id") String video_id,@Field("watch_duration") String duration);



    @FormUrlEncoded
    @POST("invitedNotificationList")
    Call<InvitedNotificationListPOJO> invitedNotificationList(@Header("apikey") String string, @Header("Authorization") String auth,
                                                              @Field("customer_id") String customer_id);

    @FormUrlEncoded
    @POST("friendRequestAction")
    Call<CustomerProfilePicPOJO> friendRequestAction(@Header("apikey") String string, @Header("Authorization") String auth,
                                                              @Field("customer_id") String customer_id,
                                                    @Field("status") String invite_status,
                                                    @Field("login_id") String login_id);



    @Multipart
    @POST("customerProfilePic")
    Call<CustomerProfilePicPOJO> customerProfilePic(@Header("apikey") String string, @Header("Authorization") String auth, @Part("customer_id")RequestBody customer_id, @Part MultipartBody.Part  image);


    @Multipart
    @POST("addChannel")
    Call<ResponseBody> addChannel(@Part MultipartBody.Part  image, @Header("apikey") String string, @Header("Authorization") String auth, @Part("customer_id") RequestBody customer_id,
                                  @Part("channel_name") RequestBody channelname,
                                  @Part("channel_category") RequestBody channelcategory,
                                  @Part("customer_username") RequestBody customer_username,
                                  @Part("channel_logo_id") RequestBody channel_logo_id

    );



    @FormUrlEncoded
    @POST("invitedNotificationList")
    Call<FriendRequest> getFreindRequest(@Header("apikey") String string, @Header("Authorization") String token, @Field("customer_id") String customer_id);


    @FormUrlEncoded
    @POST("allNotificationList")
    Call<AllNotificationModel> getAllNotification(@Header("apikey") String string, @Header("Authorization") String token, @Field("customer_id") String customer_id);


    @FormUrlEncoded
    @POST("friendRequestAction")
    Call<CustomerFriendAcceptReject> getFreindRequestResponse(@Header("apikey") String string, @Header("Authorization") String token, @Field("login_id") String login_id, @Field("status") String status, @Field("customer_id") String customer_id);

    @FormUrlEncoded
    @POST("friendRequestSend")
    Call<FriendRequestSent> FriendRequestSend(@Header("apikey") String apikey, @Header("Authorization") String token, @Field("login_customer_id_sender") String customer_id, @Field("customer_id_to_sent") String friend_id);

    @FormUrlEncoded
    @POST("channelSubscribe")
    Call<CustomerFriendAcceptReject> UserSubscribe(@Header("apikey") String apikey, @Header("Authorization") String token, @Field("customer_id") String customer_id, @Field("channel_id") String channel_id);

    @FormUrlEncoded
    @POST("changePassword")
    Call<CustomerFriendAcceptReject> saveNewPassword(@Header("apikey") String apikey, @Header("Authorization") String token, @Field("customer_id") String customer_id, @Field("old_password") String old_password,@Field("password") String password,@Field("password_confirmation") String password_confirmation);


    @FormUrlEncoded
    @POST("seasonSeries")
    Call<SeasonSeries> getSeasonSeries(@Header("apikey") String apikey, @Header("Authorization") String token, @Field("customer_id") String customer_id);






    @Multipart
    @POST("video-save")
    Call<CustomerIntroVideoCreate_pojo> uploadNewSeries(@Header("apikey") String string,
                                                       @Header("token")RequestBody tooken,
                                                       @Part("video_title")RequestBody video_title,
                                                       @Part("customer_id") RequestBody customer_id,
                                                       @Part("movie_category")RequestBody summary,
                                                       @Part MultipartBody.Part  image,
                                                       @Part MultipartBody.Part  video,
                                                       @Part("video_access")RequestBody video_access,
                                                       @Part("release_date")RequestBody release_date,
                                                       @Part("movie_language")RequestBody movie_language,
                                                       @Part("season_number")RequestBody season_number,
                                                       @Part("season_title")RequestBody season_title,
                                                       @Part MultipartBody.Part  poster,
                                                       @Part("season_description")RequestBody video_description,
                                                       @Part("air_date")RequestBody air_date,
                                                       @Part("video_type")RequestBody video_type,
                                                       @Part("series_name")RequestBody series_name,
//                                                                 @Part("season_id")RequestBody season_id,
//                                                                 @Part("duration")RequestBody live_started_at,
                                                       @Part("token")RequestBody token
    );



    @Multipart
    @POST("video-save")
    Call<CustomerIntroVideoCreate_pojo> uploadNewSeason(@Header("apikey") String string,
                                                        @Header("token")RequestBody tooken,
                                                        @Part("video_title")RequestBody video_title,
                                                        @Part("customer_id") RequestBody customer_id,
                                                        @Part("movie_category")RequestBody summary,
                                                        @Part MultipartBody.Part  image,
                                                        @Part MultipartBody.Part  video,
                                                        @Part("video_access")RequestBody video_access,
                                                        @Part("release_date")RequestBody release_date,
                                                        @Part("movie_language")RequestBody movie_language,
                                                        @Part("season_number")RequestBody season_number,
                                                        @Part("season_title")RequestBody season_title,
                                                        @Part MultipartBody.Part  poster,
                                                        @Part("season_description")RequestBody video_description,
                                                        @Part("air_date")RequestBody air_date,
                                                        @Part("video_type")RequestBody video_type,
                                                        @Part("series_id")RequestBody series_id,
//                                                                 @Part("season_id")RequestBody season_id,
//                                                                 @Part("duration")RequestBody live_started_at,
                                                        @Part("token")RequestBody token
    );



    @Multipart
    @POST("video-save")
    Call<CustomerIntroVideoCreate_pojo> uploadNewEpisode(@Header("apikey") String string,
                                                        @Header("token")RequestBody tooken,
                                                        @Part("video_title")RequestBody video_title,
                                                        @Part("customer_id") RequestBody customer_id,
                                                        @Part("movie_category")RequestBody summary,
                                                        @Part MultipartBody.Part  image,
                                                        @Part MultipartBody.Part  video,
                                                        @Part("video_access")RequestBody video_access,
                                                        @Part("release_date")RequestBody release_date,
                                                        @Part("movie_language")RequestBody movie_language,
                                                         @Part("video_type")RequestBody video_type,
                                                         @Part("series_id")RequestBody series_id,
                                                         @Part("season_id")RequestBody season_id,
//                                                                 @Part("duration")RequestBody live_started_at,
                                                        @Part("token")RequestBody token
    );







}
