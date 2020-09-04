package cable.social.app.Interface;

import cable.social.app.model.VideoDetailModel;

import java.util.ArrayList;

public interface Video_detail_Interfae {
    void videolist(VideoDetailModel.Data model);

    void videolistdata(ArrayList<VideoDetailModel.Data.SimilarVideo> list);
    void invite_data(ArrayList<VideoDetailModel.Data.InviteList> list);
    void genric_data(ArrayList<VideoDetailModel.Data.Genre> list);
//    void season_list(ArrayList<VideoDetailModel.Data.SeasonsList> list);
    void videoLike(String msg);

}
