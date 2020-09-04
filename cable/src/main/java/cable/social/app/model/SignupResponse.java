
package cable.social.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SignupResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("userInfo")
    @Expose
    private UserInfo userInfo;
    @SerializedName("token")
    @Expose
    private String token;

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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public class UserInfo {

        @SerializedName("id")
        @Expose
        private Integer id;
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
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("mobile_verify")
        @Expose
        private String mobileVerify;
        @SerializedName("email_verify")
        @Expose
        private String emailVerify;
        @SerializedName("Mobile_OTP")
        @Expose
        private String mobileOTP;
        @SerializedName("pin_number")
        @Expose
        private String pinNumber;
        @SerializedName("active_plan_id")
        @Expose
        private String activePlanId;
        @SerializedName("expire_plan_date")
        @Expose
        private String expirePlanDate;
        @SerializedName("join_ip_adress")
        @Expose
        private String joinIpAdress;
        @SerializedName("channel_name")
        @Expose
        private String channelName;
        @SerializedName("channel_logo")
        @Expose
        private String channelLogo;
        @SerializedName("user_type")
        @Expose
        private String userType;
        @SerializedName("fcm_token")
        @Expose
        private String fcmToken;
        @SerializedName("device_type")
        @Expose
        private String deviceType;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMobileVerify() {
            return mobileVerify;
        }

        public void setMobileVerify(String mobileVerify) {
            this.mobileVerify = mobileVerify;
        }

        public String getEmailVerify() {
            return emailVerify;
        }

        public void setEmailVerify(String emailVerify) {
            this.emailVerify = emailVerify;
        }

        public String getMobileOTP() {
            return mobileOTP;
        }

        public void setMobileOTP(String mobileOTP) {
            this.mobileOTP = mobileOTP;
        }

        public String getPinNumber() {
            return pinNumber;
        }

        public void setPinNumber(String pinNumber) {
            this.pinNumber = pinNumber;
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

        public String getJoinIpAdress() {
            return joinIpAdress;
        }

        public void setJoinIpAdress(String joinIpAdress) {
            this.joinIpAdress = joinIpAdress;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getChannelLogo() {
            return channelLogo;
        }

        public void setChannelLogo(String channelLogo) {
            this.channelLogo = channelLogo;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getFcmToken() {
            return fcmToken;
        }

        public void setFcmToken(String fcmToken) {
            this.fcmToken = fcmToken;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

    }
}