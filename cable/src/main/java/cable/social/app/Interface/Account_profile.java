package cable.social.app.Interface;

import cable.social.app.model.CustomerInfo_pojo;

import java.util.ArrayList;

public interface Account_profile {

    void account_profile(ArrayList<CustomerInfo_pojo.Datum> customerdump);
    void Subscrbe(String msg);

}
