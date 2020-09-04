package cable.social.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Slider_model {

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("SliderList")
    @Expose
    private List<SliderList> sliderList = null;
    @SerializedName("PremiumVideoList")
    @Expose
    private List<PremiumVideoList> premiumVideoList = null;
    @SerializedName("FreeVideoList")
    @Expose
    private List<FreeVideoList> freeVideoList = null;
    @SerializedName("SocialCommunityUsers")
    @Expose
    private List<SocialCommunityUser> socialCommunityUsers = null;
    @SerializedName("MyCommunityUsersList")
    @Expose
    private List<MyCommunityUsersList> myCommunityUsersList = null;

    @SerializedName("recentVideos")
    @Expose
    private List<RecentVideo> recentVideos = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<SliderList> getSliderList() {
        return sliderList;
    }

    public void setSliderList(List<SliderList> sliderList) {
        this.sliderList = sliderList;
    }

    public List<PremiumVideoList> getPremiumVideoList() {
        return premiumVideoList;
    }

    public void setPremiumVideoList(List<PremiumVideoList> premiumVideoList) {
        this.premiumVideoList = premiumVideoList;
    }

    public List<FreeVideoList> getFreeVideoList() {
        return freeVideoList;
    }

    public void setFreeVideoList(List<FreeVideoList> freeVideoList) {
        this.freeVideoList = freeVideoList;
    }

    public List<SocialCommunityUser> getSocialCommunityUsers() {
        return socialCommunityUsers;
    }

    public void setSocialCommunityUsers(List<SocialCommunityUser> socialCommunityUsers) {
        this.socialCommunityUsers = socialCommunityUsers;
    }

    public List<MyCommunityUsersList> getMyCommunityUsersList() {
        return myCommunityUsersList;
    }

    public void setMyCommunityUsersList(List<MyCommunityUsersList> myCommunityUsersList) {
        this.myCommunityUsersList = myCommunityUsersList;
    }

    public List<RecentVideo> getRecentVideos() {
        return recentVideos;
    }

    public void setRecentVideos(List<RecentVideo> myrecentVideos) {
        this.recentVideos = myrecentVideos;
    }

    public class SliderList{
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("slider_title")
        @Expose
        private String sliderTitle;
        @SerializedName("slider_image")
        @Expose
        private String sliderImage;
        @SerializedName("slider_description")
        @Expose
        private String sliderDescription;
        @SerializedName("movie_list_id")
        @Expose
        private String movieListId;
        @SerializedName("show_list_id")
        @Expose
        private String showListId;
        @SerializedName("sports_list_id")
        @Expose
        private String sportsListId;
        @SerializedName("live_tv_list_id")
        @Expose
        private String liveTvListId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSliderTitle() {
            return sliderTitle;
        }

        public void setSliderTitle(String sliderTitle) {
            this.sliderTitle = sliderTitle;
        }

        public String getSliderImage() {
            return sliderImage;
        }

        public void setSliderImage(String sliderImage) {
            this.sliderImage = sliderImage;
        }

        public String getSliderDescription() {
            return sliderDescription;
        }

        public void setSliderDescription(String sliderDescription) {
            this.sliderDescription = sliderDescription;
        }

        public String getMovieListId() {
            return movieListId;
        }

        public void setMovieListId(String movieListId) {
            this.movieListId = movieListId;
        }

        public String getShowListId() {
            return showListId;
        }

        public void setShowListId(String showListId) {
            this.showListId = showListId;
        }

        public String getSportsListId() {
            return sportsListId;
        }

        public void setSportsListId(String sportsListId) {
            this.sportsListId = sportsListId;
        }

        public String getLiveTvListId() {
            return liveTvListId;
        }

        public void setLiveTvListId(String liveTvListId) {
            this.liveTvListId = liveTvListId;
        }
    }

//    public class SocialCommunityUser{
//
//        @SerializedName("id")
//        @Expose
//        private String id;
//        @SerializedName("customer_id")
//        @Expose
//        private String customerId;
//        @SerializedName("channel_name")
//        @Expose
//        private String channelName;
//        @SerializedName("channel_category")
//        @Expose
//        private String channelCategory;
//        @SerializedName("channel_description")
//        @Expose
//        private String channelDescription;
//        @SerializedName("channel_icons")
//        @Expose
//        private String channelIcons;
//        @SerializedName("channel_cover_image")
//        @Expose
//        private String channelCoverImage;
//        @SerializedName("channel_logo")
//        @Expose
//        private String channelLogo;
//        @SerializedName("total_views")
//        @Expose
//        private String totalViews;
//        @SerializedName("total_like")
//        @Expose
//        private String totalLike;
//        @SerializedName("total_dislike")
//        @Expose
//        private String totalDislike;
//        @SerializedName("total_subscribe")
//        @Expose
//        private String totalSubscribe;
//        @SerializedName("total_ratings")
//        @Expose
//        private String totalRatings;
//        @SerializedName("channel_facebook_url")
//        @Expose
//        private String channelFacebookUrl;
//        @SerializedName("channel_twitter_url")
//        @Expose
//        private String channelTwitterUrl;
//        @SerializedName("customer_name")
//        @Expose
//        private String customerName;
//        @SerializedName("customer_last_name")
//        @Expose
//        private String customerLastName;
//        @SerializedName("customer_email")
//        @Expose
//        private String customerEmail;
//        @SerializedName("customer_mobile_number")
//        @Expose
//        private String customerMobileNumber;
//        @SerializedName("customer_profile_pic")
//        @Expose
//        private String customerProfilePic;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getCustomerId() {
//            return customerId;
//        }
//
//        public void setCustomerId(String customerId) {
//            this.customerId = customerId;
//        }
//
//        public String getChannelName() {
//            return channelName;
//        }
//
//        public void setChannelName(String channelName) {
//            this.channelName = channelName;
//        }
//
//        public String getChannelCategory() {
//            return channelCategory;
//        }
//
//        public void setChannelCategory(String channelCategory) {
//            this.channelCategory = channelCategory;
//        }
//
//        public String getChannelDescription() {
//            return channelDescription;
//        }
//
//        public void setChannelDescription(String channelDescription) {
//            this.channelDescription = channelDescription;
//        }
//
//        public String getChannelIcons() {
//            return channelIcons;
//        }
//
//        public void setChannelIcons(String channelIcons) {
//            this.channelIcons = channelIcons;
//        }
//
//        public String getChannelCoverImage() {
//            return channelCoverImage;
//        }
//
//        public void setChannelCoverImage(String channelCoverImage) {
//            this.channelCoverImage = channelCoverImage;
//        }
//
//        public String getChannelLogo() {
//            return channelLogo;
//        }
//
//        public void setChannelLogo(String channelLogo) {
//            this.channelLogo = channelLogo;
//        }
//
//        public String getTotalViews() {
//            return totalViews;
//        }
//
//        public void setTotalViews(String totalViews) {
//            this.totalViews = totalViews;
//        }
//
//        public String getTotalLike() {
//            return totalLike;
//        }
//
//        public void setTotalLike(String totalLike) {
//            this.totalLike = totalLike;
//        }
//
//        public String getTotalDislike() {
//            return totalDislike;
//        }
//
//        public void setTotalDislike(String totalDislike) {
//            this.totalDislike = totalDislike;
//        }
//
//        public String getTotalSubscribe() {
//            return totalSubscribe;
//        }
//
//        public void setTotalSubscribe(String totalSubscribe) {
//            this.totalSubscribe = totalSubscribe;
//        }
//
//        public String getTotalRatings() {
//            return totalRatings;
//        }
//
//        public void setTotalRatings(String totalRatings) {
//            this.totalRatings = totalRatings;
//        }
//
//        public String getChannelFacebookUrl() {
//            return channelFacebookUrl;
//        }
//
//        public void setChannelFacebookUrl(String channelFacebookUrl) {
//            this.channelFacebookUrl = channelFacebookUrl;
//        }
//
//        public String getChannelTwitterUrl() {
//            return channelTwitterUrl;
//        }
//
//        public void setChannelTwitterUrl(String channelTwitterUrl) {
//            this.channelTwitterUrl = channelTwitterUrl;
//        }
//
//        public String getCustomerName() {
//            return customerName;
//        }
//
//        public void setCustomerName(String customerName) {
//            this.customerName = customerName;
//        }
//
//        public String getCustomerLastName() {
//            return customerLastName;
//        }
//
//        public void setCustomerLastName(String customerLastName) {
//            this.customerLastName = customerLastName;
//        }
//
//        public String getCustomerEmail() {
//            return customerEmail;
//        }
//
//        public void setCustomerEmail(String customerEmail) {
//            this.customerEmail = customerEmail;
//        }
//
//        public String getCustomerMobileNumber() {
//            return customerMobileNumber;
//        }
//
//        public void setCustomerMobileNumber(String customerMobileNumber) {
//            this.customerMobileNumber = customerMobileNumber;
//        }
//
//        public String getCustomerProfilePic() {
//            return customerProfilePic;
//        }
//
//        public void setCustomerProfilePic(String customerProfilePic) {
//            this.customerProfilePic = customerProfilePic;
//        }
//    }
public class SocialCommunityUser {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("customer_id")
    @Expose
    private Integer customerId;
    @SerializedName("channel_name")
    @Expose
    private String channelName;
    @SerializedName("channel_category")
    @Expose
    private String channelCategory;
    @SerializedName("channel_description")
    @Expose
    private Object channelDescription;
    @SerializedName("channel_icons")
    @Expose
    private Object channelIcons;
    @SerializedName("channel_cover_image")
    @Expose
    private Object channelCoverImage;
    @SerializedName("channel_logo")
    @Expose
    private String channelLogo;
    @SerializedName("channel_facebook_url")
    @Expose
    private Object channelFacebookUrl;
    @SerializedName("channel_Instagram_url")
    @Expose
    private Object channelInstagramUrl;
    @SerializedName("channel_twitter_url")
    @Expose
    private Object channelTwitterUrl;
    @SerializedName("total_views")
    @Expose
    private String totalViews;
    @SerializedName("total_like")
    @Expose
    private String totalLike;
    @SerializedName("total_dislike")
    @Expose
    private String totalDislike;
    @SerializedName("total_ratings")
    @Expose
    private String totalRatings;
    @SerializedName("total_subscribe")
    @Expose
    private String totalSubscribe;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("channel_logo_id")
    @Expose
    private Object channelLogoId;
    @SerializedName("channel_logo_image_url")
    @Expose
    private Object channelLogoImageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelCategory() {
        return channelCategory;
    }

    public void setChannelCategory(String channelCategory) {
        this.channelCategory = channelCategory;
    }

    public Object getChannelDescription() {
        return channelDescription;
    }

    public void setChannelDescription(Object channelDescription) {
        this.channelDescription = channelDescription;
    }

    public Object getChannelIcons() {
        return channelIcons;
    }

    public void setChannelIcons(Object channelIcons) {
        this.channelIcons = channelIcons;
    }

    public Object getChannelCoverImage() {
        return channelCoverImage;
    }

    public void setChannelCoverImage(Object channelCoverImage) {
        this.channelCoverImage = channelCoverImage;
    }

    public String getChannelLogo() {
        return channelLogo;
    }

    public void setChannelLogo(String channelLogo) {
        this.channelLogo = channelLogo;
    }

    public Object getChannelFacebookUrl() {
        return channelFacebookUrl;
    }

    public void setChannelFacebookUrl(Object channelFacebookUrl) {
        this.channelFacebookUrl = channelFacebookUrl;
    }

    public Object getChannelInstagramUrl() {
        return channelInstagramUrl;
    }

    public void setChannelInstagramUrl(Object channelInstagramUrl) {
        this.channelInstagramUrl = channelInstagramUrl;
    }

    public Object getChannelTwitterUrl() {
        return channelTwitterUrl;
    }

    public void setChannelTwitterUrl(Object channelTwitterUrl) {
        this.channelTwitterUrl = channelTwitterUrl;
    }

    public String getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(String totalViews) {
        this.totalViews = totalViews;
    }

    public String getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(String totalLike) {
        this.totalLike = totalLike;
    }

    public String getTotalDislike() {
        return totalDislike;
    }

    public void setTotalDislike(String totalDislike) {
        this.totalDislike = totalDislike;
    }

    public String getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(String totalRatings) {
        this.totalRatings = totalRatings;
    }

    public String getTotalSubscribe() {
        return totalSubscribe;
    }

    public void setTotalSubscribe(String totalSubscribe) {
        this.totalSubscribe = totalSubscribe;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getChannelLogoId() {
        return channelLogoId;
    }

    public void setChannelLogoId(Object channelLogoId) {
        this.channelLogoId = channelLogoId;
    }

    public Object getChannelLogoImageUrl() {
        return channelLogoImageUrl;
    }

    public void setChannelLogoImageUrl(Object channelLogoImageUrl) {
        this.channelLogoImageUrl = channelLogoImageUrl;
    }

}


    public class MyCommunityUsersList{
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("customer_id")
        @Expose
        private String customerId;
        @SerializedName("channel_name")
        @Expose
        private String channelName;
        @SerializedName("channel_category")
        @Expose
        private String channelCategory;
        @SerializedName("channel_description")
        @Expose
        private String channelDescription;
        @SerializedName("channel_icons")
        @Expose
        private String channelIcons;
        @SerializedName("channel_cover_image")
        @Expose
        private String channelCoverImage;
        @SerializedName("channel_logo")
        @Expose
        private String channelLogo;
        @SerializedName("total_views")
        @Expose
        private String totalViews;
        @SerializedName("total_like")
        @Expose
        private String totalLike;
        @SerializedName("total_dislike")
        @Expose
        private String totalDislike;
        @SerializedName("total_subscribe")
        @Expose
        private String totalSubscribe;
        @SerializedName("total_ratings")
        @Expose
        private String totalRatings;
        @SerializedName("channel_facebook_url")
        @Expose
        private String channelFacebookUrl;
        @SerializedName("channel_twitter_url")
        @Expose
        private String channelTwitterUrl;
        @SerializedName("customer_name")
        @Expose
        private String customerName;
        @SerializedName("customer_last_name")
        @Expose
        private String customerLastName;
        @SerializedName("customer_email")
        @Expose
        private String customerEmail;
        @SerializedName("customer_mobile_number")
        @Expose
        private String customerMobileNumber;
        @SerializedName("customer_profile_pic")
        @Expose
        private String customerProfilePic;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getChannelCategory() {
            return channelCategory;
        }

        public void setChannelCategory(String channelCategory) {
            this.channelCategory = channelCategory;
        }

        public String getChannelDescription() {
            return channelDescription;
        }

        public void setChannelDescription(String channelDescription) {
            this.channelDescription = channelDescription;
        }

        public String getChannelIcons() {
            return channelIcons;
        }

        public void setChannelIcons(String channelIcons) {
            this.channelIcons = channelIcons;
        }

        public String getChannelCoverImage() {
            return channelCoverImage;
        }

        public void setChannelCoverImage(String channelCoverImage) {
            this.channelCoverImage = channelCoverImage;
        }

        public String getChannelLogo() {
            return channelLogo;
        }

        public void setChannelLogo(String channelLogo) {
            this.channelLogo = channelLogo;
        }

        public String getTotalViews() {
            return totalViews;
        }

        public void setTotalViews(String totalViews) {
            this.totalViews = totalViews;
        }

        public String getTotalLike() {
            return totalLike;
        }

        public void setTotalLike(String totalLike) {
            this.totalLike = totalLike;
        }

        public String getTotalDislike() {
            return totalDislike;
        }

        public void setTotalDislike(String totalDislike) {
            this.totalDislike = totalDislike;
        }

        public String getTotalSubscribe() {
            return totalSubscribe;
        }

        public void setTotalSubscribe(String totalSubscribe) {
            this.totalSubscribe = totalSubscribe;
        }

        public String getTotalRatings() {
            return totalRatings;
        }

        public void setTotalRatings(String totalRatings) {
            this.totalRatings = totalRatings;
        }

        public String getChannelFacebookUrl() {
            return channelFacebookUrl;
        }

        public void setChannelFacebookUrl(String channelFacebookUrl) {
            this.channelFacebookUrl = channelFacebookUrl;
        }

        public String getChannelTwitterUrl() {
            return channelTwitterUrl;
        }

        public void setChannelTwitterUrl(String channelTwitterUrl) {
            this.channelTwitterUrl = channelTwitterUrl;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerLastName() {
            return customerLastName;
        }

        public void setCustomerLastName(String customerLastName) {
            this.customerLastName = customerLastName;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public String getCustomerMobileNumber() {
            return customerMobileNumber;
        }

        public void setCustomerMobileNumber(String customerMobileNumber) {
            this.customerMobileNumber = customerMobileNumber;
        }

        public String getCustomerProfilePic() {
            return customerProfilePic;
        }

        public void setCustomerProfilePic(String customerProfilePic) {
            this.customerProfilePic = customerProfilePic;
        }

    }

    public class PremiumVideoList{
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("movie_actor")
        @Expose
        private List<MovieActor> movieActor = null;
        @SerializedName("movie_category")
        @Expose
        private String movieCategory;
        @SerializedName("total_views")
        @Expose
        private String totalViews;
        @SerializedName("total_likes")
        @Expose
        private String totalLikes;
        @SerializedName("total_dislikes")
        @Expose
        private String totalDislikes;
        @SerializedName("average_rating")
        @Expose
        private String averageRating;
        @SerializedName("movie_category_name")
        @Expose
        private String movieCategoryName;
        @SerializedName("movie_language")
        @Expose
        private String movieLanguage;
        @SerializedName("video_title")
        @Expose
        private String videoTitle;
        @SerializedName("video_description")
        @Expose
        private String videoDescription;
        @SerializedName("imdb_rating")
        @Expose
        private String imdbRating;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;
        @SerializedName("duration")
        @Expose
        private String duration;
        @SerializedName("movie_by")
        @Expose
        private String movieBy;
        @SerializedName("video_type")
        @Expose
        private String videoType;
        @SerializedName("video_file")
        @Expose
        private String videoFile;
        @SerializedName("movie_thumbnail")
        @Expose
        private String movieThumbnail;
        @SerializedName("movie_poster")
        @Expose
        private String moviePoster;
        @SerializedName("download_enable")
        @Expose
        private String downloadEnable;
        @SerializedName("seo_title")
        @Expose
        private String seoTitle;
        @SerializedName("seo_description")
        @Expose
        private String seoDescription;
        @SerializedName("seo_keyword")
        @Expose
        private String seoKeyword;
        @SerializedName("Comment_Allow")
        @Expose
        private String commentAllow;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<MovieActor> getMovieActor() {
            return movieActor;
        }

        public void setMovieActor(List<MovieActor> movieActor) {
            this.movieActor = movieActor;
        }

        public String getMovieCategory() {
            return movieCategory;
        }

        public void setMovieCategory(String movieCategory) {
            this.movieCategory = movieCategory;
        }

        public String getTotalViews() {
            return totalViews;
        }

        public void setTotalViews(String totalViews) {
            this.totalViews = totalViews;
        }

        public String getTotalLikes() {
            return totalLikes;
        }

        public void setTotalLikes(String totalLikes) {
            this.totalLikes = totalLikes;
        }

        public String getTotalDislikes() {
            return totalDislikes;
        }

        public void setTotalDislikes(String totalDislikes) {
            this.totalDislikes = totalDislikes;
        }

        public String getAverageRating() {
            return averageRating;
        }

        public void setAverageRating(String averageRating) {
            this.averageRating = averageRating;
        }

        public String getMovieCategoryName() {
            return movieCategoryName;
        }

        public void setMovieCategoryName(String movieCategoryName) {
            this.movieCategoryName = movieCategoryName;
        }

        public String getMovieLanguage() {
            return movieLanguage;
        }

        public void setMovieLanguage(String movieLanguage) {
            this.movieLanguage = movieLanguage;
        }

        public String getVideoTitle() {
            return videoTitle;
        }

        public void setVideoTitle(String videoTitle) {
            this.videoTitle = videoTitle;
        }

        public String getVideoDescription() {
            return videoDescription;
        }

        public void setVideoDescription(String videoDescription) {
            this.videoDescription = videoDescription;
        }

        public String getImdbRating() {
            return imdbRating;
        }

        public void setImdbRating(String imdbRating) {
            this.imdbRating = imdbRating;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getMovieBy() {
            return movieBy;
        }

        public void setMovieBy(String movieBy) {
            this.movieBy = movieBy;
        }

        public String getVideoType() {
            return videoType;
        }

        public void setVideoType(String videoType) {
            this.videoType = videoType;
        }

        public String getVideoFile() {
            return videoFile;
        }

        public void setVideoFile(String videoFile) {
            this.videoFile = videoFile;
        }

        public String getMovieThumbnail() {
            return movieThumbnail;
        }

        public void setMovieThumbnail(String movieThumbnail) {
            this.movieThumbnail = movieThumbnail;
        }

        public String getMoviePoster() {
            return moviePoster;
        }

        public void setMoviePoster(String moviePoster) {
            this.moviePoster = moviePoster;
        }

        public String getDownloadEnable() {
            return downloadEnable;
        }

        public void setDownloadEnable(String downloadEnable) {
            this.downloadEnable = downloadEnable;
        }

        public String getSeoTitle() {
            return seoTitle;
        }

        public void setSeoTitle(String seoTitle) {
            this.seoTitle = seoTitle;
        }

        public String getSeoDescription() {
            return seoDescription;
        }

        public void setSeoDescription(String seoDescription) {
            this.seoDescription = seoDescription;
        }

        public String getSeoKeyword() {
            return seoKeyword;
        }

        public void setSeoKeyword(String seoKeyword) {
            this.seoKeyword = seoKeyword;
        }

        public String getCommentAllow() {
            return commentAllow;
        }

        public void setCommentAllow(String commentAllow) {
            this.commentAllow = commentAllow;
        }

        class MovieActor{
            @SerializedName("actor_name")
            @Expose
            private String actorName;
            @SerializedName("actor_image")
            @Expose
            private String actorImage;

            public String getActorName() {
                return actorName;
            }

            public void setActorName(String actorName) {
                this.actorName = actorName;
            }

            public String getActorImage() {
                return actorImage;
            }

            public void setActorImage(String actorImage) {
                this.actorImage = actorImage;
            }

        }

    }

    public class FreeVideoList{
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("movie_actor")
        @Expose
        private List<MovieActor_> movieActor = null;
        @SerializedName("movie_category")
        @Expose
        private String movieCategory;
        @SerializedName("total_views")
        @Expose
        private String totalViews;
        @SerializedName("total_likes")
        @Expose
        private String totalLikes;
        @SerializedName("total_dislikes")
        @Expose
        private String totalDislikes;
        @SerializedName("average_rating")
        @Expose
        private String averageRating;
        @SerializedName("movie_category_name")
        @Expose
        private String movieCategoryName;
        @SerializedName("movie_language")
        @Expose
        private String movieLanguage;
        @SerializedName("video_title")
        @Expose
        private String videoTitle;
        @SerializedName("video_description")
        @Expose
        private String videoDescription;
        @SerializedName("imdb_rating")
        @Expose
        private String imdbRating;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;
        @SerializedName("duration")
        @Expose
        private String duration;
        @SerializedName("movie_by")
        @Expose
        private String movieBy;
        @SerializedName("video_type")
        @Expose
        private String videoType;
        @SerializedName("video_file")
        @Expose
        private String videoFile;
        @SerializedName("movie_thumbnail")
        @Expose
        private String movieThumbnail;
        @SerializedName("movie_poster")
        @Expose
        private String moviePoster;
        @SerializedName("download_enable")
        @Expose
        private String downloadEnable;
        @SerializedName("seo_title")
        @Expose
        private String seoTitle;
        @SerializedName("seo_description")
        @Expose
        private String seoDescription;
        @SerializedName("seo_keyword")
        @Expose
        private String seoKeyword;
        @SerializedName("Comment_Allow")
        @Expose
        private String commentAllow;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<MovieActor_> getMovieActor() {
            return movieActor;
        }

        public void setMovieActor(List<MovieActor_> movieActor) {
            this.movieActor = movieActor;
        }

        public String getMovieCategory() {
            return movieCategory;
        }

        public void setMovieCategory(String movieCategory) {
            this.movieCategory = movieCategory;
        }

        public String getTotalViews() {
            return totalViews;
        }

        public void setTotalViews(String totalViews) {
            this.totalViews = totalViews;
        }

        public String getTotalLikes() {
            return totalLikes;
        }

        public void setTotalLikes(String totalLikes) {
            this.totalLikes = totalLikes;
        }

        public String getTotalDislikes() {
            return totalDislikes;
        }

        public void setTotalDislikes(String totalDislikes) {
            this.totalDislikes = totalDislikes;
        }

        public String getAverageRating() {
            return averageRating;
        }

        public void setAverageRating(String averageRating) {
            this.averageRating = averageRating;
        }

        public String getMovieCategoryName() {
            return movieCategoryName;
        }

        public void setMovieCategoryName(String movieCategoryName) {
            this.movieCategoryName = movieCategoryName;
        }

        public String getMovieLanguage() {
            return movieLanguage;
        }

        public void setMovieLanguage(String movieLanguage) {
            this.movieLanguage = movieLanguage;
        }

        public String getVideoTitle() {
            return videoTitle;
        }

        public void setVideoTitle(String videoTitle) {
            this.videoTitle = videoTitle;
        }

        public String getVideoDescription() {
            return videoDescription;
        }

        public void setVideoDescription(String videoDescription) {
            this.videoDescription = videoDescription;
        }

        public String getImdbRating() {
            return imdbRating;
        }

        public void setImdbRating(String imdbRating) {
            this.imdbRating = imdbRating;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getMovieBy() {
            return movieBy;
        }

        public void setMovieBy(String movieBy) {
            this.movieBy = movieBy;
        }

        public String getVideoType() {
            return videoType;
        }

        public void setVideoType(String videoType) {
            this.videoType = videoType;
        }

        public String getVideoFile() {
            return videoFile;
        }

        public void setVideoFile(String videoFile) {
            this.videoFile = videoFile;
        }

        public String getMovieThumbnail() {
            return movieThumbnail;
        }

        public void setMovieThumbnail(String movieThumbnail) {
            this.movieThumbnail = movieThumbnail;
        }

        public String getMoviePoster() {
            return moviePoster;
        }

        public void setMoviePoster(String moviePoster) {
            this.moviePoster = moviePoster;
        }

        public String getDownloadEnable() {
            return downloadEnable;
        }

        public void setDownloadEnable(String downloadEnable) {
            this.downloadEnable = downloadEnable;
        }

        public String getSeoTitle() {
            return seoTitle;
        }

        public void setSeoTitle(String seoTitle) {
            this.seoTitle = seoTitle;
        }

        public String getSeoDescription() {
            return seoDescription;
        }

        public void setSeoDescription(String seoDescription) {
            this.seoDescription = seoDescription;
        }

        public String getSeoKeyword() {
            return seoKeyword;
        }

        public void setSeoKeyword(String seoKeyword) {
            this.seoKeyword = seoKeyword;
        }

        public String getCommentAllow() {
            return commentAllow;
        }

        public void setCommentAllow(String commentAllow) {
            this.commentAllow = commentAllow;
        }
class MovieActor_{
    @SerializedName("actor_name")
    @Expose
    private String actorName;
    @SerializedName("actor_image")
    @Expose
    private String actorImage;

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorImage() {
        return actorImage;
    }

    public void setActorImage(String actorImage) {
        this.actorImage = actorImage;
    }

}

    }


    public class RecentVideo {

        @SerializedName("video_id")
        @Expose
        private String videoId;
        @SerializedName("video_access")
        @Expose
        private String videoAccess;
        @SerializedName("movie_category")
        @Expose
        private String movieCategory;
        @SerializedName("genres")
        @Expose
        private String genres;
        @SerializedName("movie_actors")
        @Expose
        private String movieActors;
        @SerializedName("video_title")
        @Expose
        private String videoTitle;
        @SerializedName("video_description")
        @Expose
        private String videoDescription;
        @SerializedName("imdb_rating")
        @Expose
        private String imdbRating;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;
        @SerializedName("duration")
        @Expose
        private String duration;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("movie_by")
        @Expose
        private String movieBy;
        @SerializedName("customer_id")
        @Expose
        private String customerId;
        @SerializedName("video_type")
        @Expose
        private String videoType;
        @SerializedName("video_file")
        @Expose
        private String videoFile;
        @SerializedName("movie_thumbnail")
        @Expose
        private String movieThumbnail;
        @SerializedName("movie_poster")
        @Expose
        private String moviePoster;
        @SerializedName("download_enable")
        @Expose
        private String downloadEnable;
        @SerializedName("download_url")
        @Expose
        private String downloadUrl;
        @SerializedName("seo_title")
        @Expose
        private String seoTitle;
        @SerializedName("seo_description")
        @Expose
        private String seoDescription;
        @SerializedName("seo_keyword")
        @Expose
        private String seoKeyword;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("total_views")
        @Expose
        private String totalViews;
        @SerializedName("total_likes")
        @Expose
        private String totalLikes;
        @SerializedName("total_dislikes")
        @Expose
        private String totalDislikes;
        @SerializedName("average_rating")
        @Expose
        private String averageRating;
        @SerializedName("Comment_Allow")
        @Expose
        private String commentAllow;
        @SerializedName("movieLanguage")
        @Expose
        private String movieLanguage;
        @SerializedName("watch_duration")
        @Expose
        private String watchDuration;

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }

        public String getVideoAccess() {
            return videoAccess;
        }

        public void setVideoAccess(String videoAccess) {
            this.videoAccess = videoAccess;
        }

        public String getMovieCategory() {
            return movieCategory;
        }

        public void setMovieCategory(String movieCategory) {
            this.movieCategory = movieCategory;
        }

        public String getGenres() {
            return genres;
        }

        public void setGenres(String genres) {
            this.genres = genres;
        }

        public String getMovieActors() {
            return movieActors;
        }

        public void setMovieActors(String movieActors) {
            this.movieActors = movieActors;
        }

        public String getVideoTitle() {
            return videoTitle;
        }

        public void setVideoTitle(String videoTitle) {
            this.videoTitle = videoTitle;
        }

        public String getVideoDescription() {
            return videoDescription;
        }

        public void setVideoDescription(String videoDescription) {
            this.videoDescription = videoDescription;
        }

        public String getImdbRating() {
            return imdbRating;
        }

        public void setImdbRating(String imdbRating) {
            this.imdbRating = imdbRating;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMovieBy() {
            return movieBy;
        }

        public void setMovieBy(String movieBy) {
            this.movieBy = movieBy;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getVideoType() {
            return videoType;
        }

        public void setVideoType(String videoType) {
            this.videoType = videoType;
        }

        public String getVideoFile() {
            return videoFile;
        }

        public void setVideoFile(String videoFile) {
            this.videoFile = videoFile;
        }

        public String getMovieThumbnail() {
            return movieThumbnail;
        }

        public void setMovieThumbnail(String movieThumbnail) {
            this.movieThumbnail = movieThumbnail;
        }

        public String getMoviePoster() {
            return moviePoster;
        }

        public void setMoviePoster(String moviePoster) {
            this.moviePoster = moviePoster;
        }

        public String getDownloadEnable() {
            return downloadEnable;
        }

        public void setDownloadEnable(String downloadEnable) {
            this.downloadEnable = downloadEnable;
        }

        public String getDownloadUrl() {
            return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }

        public String getSeoTitle() {
            return seoTitle;
        }

        public void setSeoTitle(String seoTitle) {
            this.seoTitle = seoTitle;
        }

        public String getSeoDescription() {
            return seoDescription;
        }

        public void setSeoDescription(String seoDescription) {
            this.seoDescription = seoDescription;
        }

        public String getSeoKeyword() {
            return seoKeyword;
        }

        public void setSeoKeyword(String seoKeyword) {
            this.seoKeyword = seoKeyword;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getTotalViews() {
            return totalViews;
        }

        public void setTotalViews(String totalViews) {
            this.totalViews = totalViews;
        }

        public String getTotalLikes() {
            return totalLikes;
        }

        public void setTotalLikes(String totalLikes) {
            this.totalLikes = totalLikes;
        }

        public String getTotalDislikes() {
            return totalDislikes;
        }

        public void setTotalDislikes(String totalDislikes) {
            this.totalDislikes = totalDislikes;
        }

        public String getAverageRating() {
            return averageRating;
        }

        public void setAverageRating(String averageRating) {
            this.averageRating = averageRating;
        }

        public String getCommentAllow() {
            return commentAllow;
        }

        public void setCommentAllow(String commentAllow) {
            this.commentAllow = commentAllow;
        }

        public String getMovieLanguage() {
            return movieLanguage;
        }

        public void setMovieLanguage(String movieLanguage) {
            this.movieLanguage = movieLanguage;
        }

        public String getWatchDuration() {
            return watchDuration;
        }

        public void setWatchDuration(String watchDuration) {
            this.watchDuration = watchDuration;
        }
    }






}