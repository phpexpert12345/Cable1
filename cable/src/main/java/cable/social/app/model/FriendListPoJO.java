package cable.social.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FriendListPoJO {


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
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class TokboxCredentials {

        @SerializedName("session_id")
        @Expose
        private String sessionId;
        @SerializedName("token")
        @Expose
        private String token;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

    }
    public class FriendList {

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
        @SerializedName("invite_status")
        @Expose
        private String inviteStatus;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

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

        public String getInviteStatus() {
            return inviteStatus;
        }

        public void setInviteStatus(String inviteStatus) {
            this.inviteStatus = inviteStatus;
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

    }

    public class Data {

        @SerializedName("tokboxCredentials")
        @Expose
        private TokboxCredentials tokboxCredentials;
        @SerializedName("friendLists")
        @Expose
        private List<FriendList> friendLists = null;

        public TokboxCredentials getTokboxCredentials() {
            return tokboxCredentials;
        }

        public void setTokboxCredentials(TokboxCredentials tokboxCredentials) {
            this.tokboxCredentials = tokboxCredentials;
        }

        public List<FriendList> getFriendLists() {
            return friendLists;
        }

        public void setFriendLists(List<FriendList> friendLists) {
            this.friendLists = friendLists;
        }

    }








    /*
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
        @SerializedName("friend_request.invite_status")
        @Expose
        private String friendRequestInviteStatus;
        @SerializedName("friend_request.created_at")
        @Expose
        private String friendRequestCreatedAt;
        @SerializedName("friend_request.updated_at")
        @Expose
        private String friendRequestUpdatedAt;

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

        public String getFriendRequestInviteStatus() {
            return friendRequestInviteStatus;
        }

        public void setFriendRequestInviteStatus(String friendRequestInviteStatus) {
            this.friendRequestInviteStatus = friendRequestInviteStatus;
        }

        public String getFriendRequestCreatedAt() {
            return friendRequestCreatedAt;
        }

        public void setFriendRequestCreatedAt(String friendRequestCreatedAt) {
            this.friendRequestCreatedAt = friendRequestCreatedAt;
        }

        public String getFriendRequestUpdatedAt() {
            return friendRequestUpdatedAt;
        }

        public void setFriendRequestUpdatedAt(String friendRequestUpdatedAt) {
            this.friendRequestUpdatedAt = friendRequestUpdatedAt;
        }

    }*/
}
