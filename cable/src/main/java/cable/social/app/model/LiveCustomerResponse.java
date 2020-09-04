package cable.social.app.model;

/**
 * Created by Govind Kumar on 6/10/2020.
 * * PhpExpert
 * *  govind224556@gmail.com
 **/

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LiveCustomerResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private int statusCode;
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

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
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
        @SerializedName("plan_id")
        @Expose
        private String planId;
        @SerializedName("order_number")
        @Expose
        private String orderNumber;
        @SerializedName("payment_status")
        @Expose
        private String paymentStatus;
        @SerializedName("payment_mode")
        @Expose
        private String paymentMode;
        @SerializedName("subscribed_date")
        @Expose
        private String subscribedDate;
        @SerializedName("expired_date")
        @Expose
        private String expiredDate;
        @SerializedName("ip_address")
        @Expose
        private String ipAddress;
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

        public String getPlanId() {
            return planId;
        }

        public void setPlanId(String planId) {
            this.planId = planId;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        public String getPaymentMode() {
            return paymentMode;
        }

        public void setPaymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
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

        public String getIpAddress() {
            return ipAddress;
        }

        public void setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
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

    }
}

