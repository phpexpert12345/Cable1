package cable.social.app.model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChannelLogoList {

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
    private List<Datum> data = null;

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

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }




public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("channel_logo_name")
    @Expose
    private String channelLogoName;
    @SerializedName("channel_logo_image")
    @Expose
    private String channelLogoImage;
    @SerializedName("channel_logo_description")
    @Expose
    private String channelLogoDescription;
    @SerializedName("channel_status")
    @Expose
    private Integer channelStatus;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelLogoName() {
        return channelLogoName;
    }

    public void setChannelLogoName(String channelLogoName) {
        this.channelLogoName = channelLogoName;
    }

    public String getChannelLogoImage() {
        return channelLogoImage;
    }

    public void setChannelLogoImage(String channelLogoImage) {
        this.channelLogoImage = channelLogoImage;
    }

    public String getChannelLogoDescription() {
        return channelLogoDescription;
    }

    public void setChannelLogoDescription(String channelLogoDescription) {
        this.channelLogoDescription = channelLogoDescription;
    }

    public Integer getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(Integer channelStatus) {
        this.channelStatus = channelStatus;
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