package cable.social.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubscribePlans_model {
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("SubscribePlansList")
    @Expose
    private List<SubscribePlansList> subscribePlansList = null;

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

    public List<SubscribePlansList> getSubscribePlansList() {
        return subscribePlansList;
    }

    public void setSubscribePlansList(List<SubscribePlansList> subscribePlansList) {
        this.subscribePlansList = subscribePlansList;
    }

    public class SubscribePlansList{
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("plan_name")
        @Expose
        private String planName;
        @SerializedName("Number_of_days")
        @Expose
        private String numberOfDays;
        @SerializedName("Currency")
        @Expose
        private String currency;
        @SerializedName("actual_plan_price")
        @Expose
        private String actualPlanPrice;
        @SerializedName("plan_discount_price")
        @Expose
        private String planDiscountPrice;
        @SerializedName("TotalVideoPlay")
        @Expose
        private String totalVideoPlay;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getPlanName() {
            return planName;
        }

        public void setPlanName(String planName) {
            this.planName = planName;
        }

        public String getNumberOfDays() {
            return numberOfDays;
        }

        public void setNumberOfDays(String numberOfDays) {
            this.numberOfDays = numberOfDays;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getActualPlanPrice() {
            return actualPlanPrice;
        }

        public void setActualPlanPrice(String actualPlanPrice) {
            this.actualPlanPrice = actualPlanPrice;
        }

        public String getPlanDiscountPrice() {
            return planDiscountPrice;
        }

        public void setPlanDiscountPrice(String planDiscountPrice) {
            this.planDiscountPrice = planDiscountPrice;
        }

        public String getTotalVideoPlay() {
            return totalVideoPlay;
        }

        public void setTotalVideoPlay(String totalVideoPlay) {
            this.totalVideoPlay = totalVideoPlay;
        }

    }

}
