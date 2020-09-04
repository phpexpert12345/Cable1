package cable.social.app.Interface;

import java.util.List;

import cable.social.app.model.AllNotificationModel;
import cable.social.app.model.FriendRequest;

public interface FreindRequestInterface {

    void RequestList(List<FriendRequest.Datum> list);
    void AllNotificationList(List<AllNotificationModel.Datum> list);
    void InviteResponse(String message);
}
