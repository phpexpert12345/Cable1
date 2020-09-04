package cable.social.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Govind Kumar on 6/25/2020.
 * * PhpExpert
 * *  govind224556@gmail.com
 **/
public class ArrayListCustomerId {
    @SerializedName("customer_id")
    @Expose
    private ArrayList<String> customer_id;
    public ArrayListCustomerId(ArrayList<String> customer_id) {
        this.customer_id=customer_id;
    }
}
