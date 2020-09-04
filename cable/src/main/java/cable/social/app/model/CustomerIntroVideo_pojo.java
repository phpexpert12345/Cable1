package cable.social.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomerIntroVideo_pojo {
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

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("customer_id")
        @Expose
        private String customerId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("summary")
        @Expose
        private String summary;
        @SerializedName("intro_video")
        @Expose
        private String introVideo;
        @SerializedName("intro_thumnail")
        @Expose
        private String introThumnail;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("live_started_at")
        @Expose
        private String liveStartedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getIntroVideo() {
            return introVideo;
        }

        public void setIntroVideo(String introVideo) {
            this.introVideo = introVideo;
        }

        public String getIntroThumnail() {
            return introThumnail;
        }

        public void setIntroThumnail(String introThumnail) {
            this.introThumnail = introThumnail;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLiveStartedAt() {
            return liveStartedAt;
        }

        public void setLiveStartedAt(String liveStartedAt) {
            this.liveStartedAt = liveStartedAt;
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
}
