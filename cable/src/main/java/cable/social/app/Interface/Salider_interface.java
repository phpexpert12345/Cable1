package cable.social.app.Interface;

import cable.social.app.model.Slider_model;

import java.util.ArrayList;

public interface Salider_interface {
    void slider_list(ArrayList<Slider_model.SliderList> list);
    void recent_video(ArrayList<Slider_model.RecentVideo> list);
    void primevideo_list(ArrayList<Slider_model.PremiumVideoList> list);

    void FreeVideo_list(ArrayList<Slider_model.FreeVideoList> list);


    void SocialCommunityUser_list(ArrayList<Slider_model.SocialCommunityUser> list);
    void MyCommunityUsersList_list(ArrayList<Slider_model.MyCommunityUsersList> list);

}
