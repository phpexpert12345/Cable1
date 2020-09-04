package cable.social.app.Interface;

import java.util.ArrayList;

import cable.social.app.model.ChannelCategory_Pojo;
import cable.social.app.model.ChannelLogoList;

public interface ChannelCategory_interface {
//    void channelCategory(ArrayList<ChannelCategory_Pojo.Datum> list);
    void channel_logo_list(ArrayList<ChannelLogoList.Datum> list);
    void addChannel(String response);

}
