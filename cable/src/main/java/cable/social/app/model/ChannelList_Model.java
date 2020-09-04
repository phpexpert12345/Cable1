package cable.social.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//public class ChannelList_Model {
//    @SerializedName("status")
//    @Expose
//    private Boolean status;
//    @SerializedName("code")
//    @Expose
//    private Integer code;
//    @SerializedName("message")
//    @Expose
//    private String message;
//    @SerializedName("data")
//    @Expose
//    private List<Datum> data = null;
//
//    public Boolean getStatus() {
//        return status;
//    }
//
//    public void setStatus(Boolean status) {
//        this.status = status;
//    }
//
//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public List<Datum> getData() {
//        return data;
//    }
//
//    public void setData(List<Datum> data) {
//        this.data = data;
//    }
//
//    public class Datum{
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("customer_id")
//        @Expose
//        private Integer customerId;
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
//        private Object channelIcons;
//        @SerializedName("channel_cover_image")
//        @Expose
//        private String channelCoverImage;
//        @SerializedName("channel_logo")
//        @Expose
//        private String channelLogo;
//        @SerializedName("channel_facebook_url")
//        @Expose
//        private Object channelFacebookUrl;
//        @SerializedName("channel_Instagram_url")
//        @Expose
//        private Object channelInstagramUrl;
//        @SerializedName("channel_twitter_url")
//        @Expose
//        private Object channelTwitterUrl;
//        @SerializedName("total_views")
//        @Expose
//        private String totalViews;
//        @SerializedName("total_like")
//        @Expose
//        private String totalLike;
//        @SerializedName("total_dislike")
//        @Expose
//        private String totalDislike;
//        @SerializedName("total_ratings")
//        @Expose
//        private String totalRatings;
//        @SerializedName("total_subscribe")
//        @Expose
//        private String totalSubscribe;
//        @SerializedName("status")
//        @Expose
//        private Integer status;
//        @SerializedName("updated_at")
//        @Expose
//        private Object updatedAt;
//        @SerializedName("created_at")
//        @Expose
//        private Object createdAt;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public Integer getCustomerId() {
//            return customerId;
//        }
//
//        public void setCustomerId(Integer customerId) {
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
//        public Object getChannelIcons() {
//            return channelIcons;
//        }
//
//        public void setChannelIcons(Object channelIcons) {
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
//        public Object getChannelFacebookUrl() {
//            return channelFacebookUrl;
//        }
//
//        public void setChannelFacebookUrl(Object channelFacebookUrl) {
//            this.channelFacebookUrl = channelFacebookUrl;
//        }
//
//        public Object getChannelInstagramUrl() {
//            return channelInstagramUrl;
//        }
//
//        public void setChannelInstagramUrl(Object channelInstagramUrl) {
//            this.channelInstagramUrl = channelInstagramUrl;
//        }
//
//        public Object getChannelTwitterUrl() {
//            return channelTwitterUrl;
//        }
//
//        public void setChannelTwitterUrl(Object channelTwitterUrl) {
//            this.channelTwitterUrl = channelTwitterUrl;
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
//        public String getTotalRatings() {
//            return totalRatings;
//        }
//
//        public void setTotalRatings(String totalRatings) {
//            this.totalRatings = totalRatings;
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
//        public Integer getStatus() {
//            return status;
//        }
//
//        public void setStatus(Integer status) {
//            this.status = status;
//        }
//
//        public Object getUpdatedAt() {
//            return updatedAt;
//        }
//
//        public void setUpdatedAt(Object updatedAt) {
//            this.updatedAt = updatedAt;
//        }
//
//        public Object getCreatedAt() {
//            return createdAt;
//        }
//
//        public void setCreatedAt(Object createdAt) {
//            this.createdAt = createdAt;
//        }
//
//    }
//
//
//}
public class ChannelList_Model {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Data {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("customer_id")
        @Expose
        private Integer customerId;
        @SerializedName("channel_name")
        @Expose
        private String channelName;

        @SerializedName("channel_logo_id")
        @Expose
        private String channel_logo_id;


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
        @SerializedName("channel_logo_image_url")
        @Expose
        private String channelLogoImageUrl;

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

        public String getChannel_logo_id() {
            return channel_logo_id;
        }

        public void setChannel_logo_id(String channel_logo_id) {
            this.channel_logo_id = channel_logo_id;
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

        public String getChannelLogoImageUrl() {
            return channelLogoImageUrl;
        }

        public void setChannelLogoImageUrl(String channelLogoImageUrl) {
            this.channelLogoImageUrl = channelLogoImageUrl;
        }

    }
}