package cable.social.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Govind Kumar on 6/13/2020.
 * * PhpExpert
 * *  govind224556@gmail.com
 **/


public class CustomerInfo_pojo {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }




public class Datum {

    @SerializedName("customer_id")
    @Expose
    private String customerId;
    @SerializedName("customer_username")
    @Expose
    private String customerUsername;
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
    @SerializedName("customer_age")
    @Expose
    private String customerAge;
    @SerializedName("customer_profile_pic")
    @Expose
    private String customerProfilePic;
    @SerializedName("customer_gender")
    @Expose
    private String customerGender;
    @SerializedName("customer_country")
    @Expose
    private String customerCountry;
    @SerializedName("customer_state")
    @Expose
    private String customerState;
    @SerializedName("customer_city")
    @Expose
    private String customerCity;
    @SerializedName("customer_address")
    @Expose
    private String customerAddress;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("active_plan_id")
    @Expose
    private String activePlanId;
    @SerializedName("expire_plan_date")
    @Expose
    private String expirePlanDate;
    @SerializedName("plan_id")
    @Expose
    private String planId;
    @SerializedName("subscribed_date")
    @Expose
    private String subscribedDate;
    @SerializedName("expired_date")
    @Expose
    private String expiredDate;
    @SerializedName("plan_name")
    @Expose
    private String planName;
    @SerializedName("no_of_months")
    @Expose
    private String noOfMonths;
    @SerializedName("plan_price")
    @Expose
    private String planPrice;
    @SerializedName("plan_discount")
    @Expose
    private String planDiscount;
    @SerializedName("plan_currency")
    @Expose
    private String planCurrency;
    @SerializedName("number_of_video_play")
    @Expose
    private String numberOfVideoPlay;
    @SerializedName("subscribe_plan_status")
    @Expose
    private String subscribePlanStatus;
    @SerializedName("aboutus")
    @Expose
    private String aboutus;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("channel_name")
    @Expose
    private String channelName;
    @SerializedName("channel_icons")
    @Expose
    private String channelIcons;
    @SerializedName("channel_cover_image")
    @Expose
    private String channelCoverImage;
    @SerializedName("channel_logo")
    @Expose
    private String channelLogo;
    @SerializedName("channel_facebook_url")
    @Expose
    private String channelFacebookUrl;
    @SerializedName("channel_Instagram_url")
    @Expose
    private String channelInstagramUrl;
    @SerializedName("channel_twitter_url")
    @Expose
    private String channelTwitterUrl;
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
    @SerializedName("channel_logo_image_url")
    @Expose
    private String channelLogoImageUrl;
    @SerializedName("channel_logo_id")
    @Expose
    private String channelLogoId;
    @SerializedName("cover_profile_image")
    @Expose
    private String coverProfileImage;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
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

    public String getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(String customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerProfilePic() {
        return customerProfilePic;
    }

    public void setCustomerProfilePic(String customerProfilePic) {
        this.customerProfilePic = customerProfilePic;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActivePlanId() {
        return activePlanId;
    }

    public void setActivePlanId(String activePlanId) {
        this.activePlanId = activePlanId;
    }

    public String getExpirePlanDate() {
        return expirePlanDate;
    }

    public void setExpirePlanDate(String expirePlanDate) {
        this.expirePlanDate = expirePlanDate;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getSubscribedDate() {
        return subscribedDate;
    }

    public void setSubscribedDate(String subscribedDate) {
        this.subscribedDate = subscribedDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getNoOfMonths() {
        return noOfMonths;
    }

    public void setNoOfMonths(String noOfMonths) {
        this.noOfMonths = noOfMonths;
    }

    public String getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(String planPrice) {
        this.planPrice = planPrice;
    }

    public String getPlanDiscount() {
        return planDiscount;
    }

    public void setPlanDiscount(String planDiscount) {
        this.planDiscount = planDiscount;
    }

    public String getPlanCurrency() {
        return planCurrency;
    }

    public void setPlanCurrency(String planCurrency) {
        this.planCurrency = planCurrency;
    }

    public String getNumberOfVideoPlay() {
        return numberOfVideoPlay;
    }

    public void setNumberOfVideoPlay(String numberOfVideoPlay) {
        this.numberOfVideoPlay = numberOfVideoPlay;
    }

    public String getSubscribePlanStatus() {
        return subscribePlanStatus;
    }

    public void setSubscribePlanStatus(String subscribePlanStatus) {
        this.subscribePlanStatus = subscribePlanStatus;
    }

    public String getAboutus() {
        return aboutus;
    }

    public void setAboutus(String aboutus) {
        this.aboutus = aboutus;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
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

    public String getChannelFacebookUrl() {
        return channelFacebookUrl;
    }

    public void setChannelFacebookUrl(String channelFacebookUrl) {
        this.channelFacebookUrl = channelFacebookUrl;
    }

    public String getChannelInstagramUrl() {
        return channelInstagramUrl;
    }

    public void setChannelInstagramUrl(String channelInstagramUrl) {
        this.channelInstagramUrl = channelInstagramUrl;
    }

    public String getChannelTwitterUrl() {
        return channelTwitterUrl;
    }

    public void setChannelTwitterUrl(String channelTwitterUrl) {
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

    public String getChannelLogoImageUrl() {
        return channelLogoImageUrl;
    }

    public void setChannelLogoImageUrl(String channelLogoImageUrl) {
        this.channelLogoImageUrl = channelLogoImageUrl;
    }

    public String getChannelLogoId() {
        return channelLogoId;
    }

    public void setChannelLogoId(String channelLogoId) {
        this.channelLogoId = channelLogoId;
    }

    public String getCoverProfileImage() {
        return coverProfileImage;
    }

    public void setCoverProfileImage(String coverProfileImage) {
        this.coverProfileImage = coverProfileImage;
    }

}}