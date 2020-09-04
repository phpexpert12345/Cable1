package cable.social.app.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category_model {
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("CategoyList")
    @Expose
    private List<CategoyList> categoyList = null;

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

    public List<CategoyList> getCategoyList() {
        return categoyList;
    }

    public void setCategoyList(List<CategoyList> categoyList) {
        this.categoyList = categoyList;
    }
public class CategoyList implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("categoryPhoto")
    @Expose
    private String categoryPhoto;

    protected CategoyList(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        categoryName = in.readString();
        categoryPhoto = in.readString();
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryPhoto() {
        return categoryPhoto;
    }

    public void setCategoryPhoto(String categoryPhoto) {
        this.categoryPhoto = categoryPhoto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(categoryName);
        parcel.writeString(categoryPhoto);
        parcel.writeInt(id);

    }


    public final Creator<CategoyList> CREATOR = new Creator<CategoyList>() {
        @Override
        public CategoyList createFromParcel(Parcel in) {
            return new CategoyList(in);
        }

        @Override
        public CategoyList[] newArray(int size) {
            return new CategoyList[size];
        }
    };

}
}
