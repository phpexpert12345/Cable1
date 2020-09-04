package cable.social.app.Interface;

import java.util.List;

import cable.social.app.model.MyVideo;

public interface VideoFetched_interface {
    void Fetched(List<MyVideo.Datum> list);
}
