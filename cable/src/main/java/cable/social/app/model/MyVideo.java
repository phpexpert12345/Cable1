package cable.social.app.model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MyVideo {

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
        @SerializedName("video_access")
        @Expose
        private String videoAccess;
        @SerializedName("movie_category")
        @Expose
        private String movieCategory;
        @SerializedName("genres")
        @Expose
        private String genres;
        @SerializedName("movie_actors")
        @Expose
        private String movieActors;
        @SerializedName("video_title")
        @Expose
        private String videoTitle;
        @SerializedName("video_description")
        @Expose
        private String videoDescription;
        @SerializedName("imdb_rating")
        @Expose
        private String imdbRating;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;
        @SerializedName("duration")
        @Expose
        private String duration;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("movie_by")
        @Expose
        private String movieBy;
        @SerializedName("customer_id")
        @Expose
        private String customerId;
        @SerializedName("video_type")
        @Expose
        private String videoType;
        @SerializedName("video_file")
        @Expose
        private String videoFile;
        @SerializedName("movie_thumbnail")
        @Expose
        private String movieThumbnail;
        @SerializedName("movie_poster")
        @Expose
        private String moviePoster;
        @SerializedName("download_enable")
        @Expose
        private String downloadEnable;
        @SerializedName("download_url")
        @Expose
        private String downloadUrl;
        @SerializedName("seo_title")
        @Expose
        private String seoTitle;
        @SerializedName("seo_description")
        @Expose
        private String seoDescription;
        @SerializedName("seo_keyword")
        @Expose
        private String seoKeyword;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("total_views")
        @Expose
        private String totalViews;
        @SerializedName("total_likes")
        @Expose
        private String totalLikes;
        @SerializedName("total_dislikes")
        @Expose
        private String totalDislikes;
        @SerializedName("average_rating")
        @Expose
        private String averageRating;
        @SerializedName("Comment_Allow")
        @Expose
        private String commentAllow;
        @SerializedName("movieLanguage")
        @Expose
        private String movieLanguage;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getVideoAccess() {
            return videoAccess;
        }

        public void setVideoAccess(String videoAccess) {
            this.videoAccess = videoAccess;
        }

        public String getMovieCategory() {
            return movieCategory;
        }

        public void setMovieCategory(String movieCategory) {
            this.movieCategory = movieCategory;
        }

        public String getGenres() {
            return genres;
        }

        public void setGenres(String genres) {
            this.genres = genres;
        }

        public String getMovieActors() {
            return movieActors;
        }

        public void setMovieActors(String movieActors) {
            this.movieActors = movieActors;
        }

        public String getVideoTitle() {
            return videoTitle;
        }

        public void setVideoTitle(String videoTitle) {
            this.videoTitle = videoTitle;
        }

        public String getVideoDescription() {
            return videoDescription;
        }

        public void setVideoDescription(String videoDescription) {
            this.videoDescription = videoDescription;
        }

        public String getImdbRating() {
            return imdbRating;
        }

        public void setImdbRating(String imdbRating) {
            this.imdbRating = imdbRating;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMovieBy() {
            return movieBy;
        }

        public void setMovieBy(String movieBy) {
            this.movieBy = movieBy;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getVideoType() {
            return videoType;
        }

        public void setVideoType(String videoType) {
            this.videoType = videoType;
        }

        public String getVideoFile() {
            return videoFile;
        }

        public void setVideoFile(String videoFile) {
            this.videoFile = videoFile;
        }

        public String getMovieThumbnail() {
            return movieThumbnail;
        }

        public void setMovieThumbnail(String movieThumbnail) {
            this.movieThumbnail = movieThumbnail;
        }

        public String getMoviePoster() {
            return moviePoster;
        }

        public void setMoviePoster(String moviePoster) {
            this.moviePoster = moviePoster;
        }

        public String getDownloadEnable() {
            return downloadEnable;
        }

        public void setDownloadEnable(String downloadEnable) {
            this.downloadEnable = downloadEnable;
        }

        public String getDownloadUrl() {
            return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }

        public String getSeoTitle() {
            return seoTitle;
        }

        public void setSeoTitle(String seoTitle) {
            this.seoTitle = seoTitle;
        }

        public String getSeoDescription() {
            return seoDescription;
        }

        public void setSeoDescription(String seoDescription) {
            this.seoDescription = seoDescription;
        }

        public String getSeoKeyword() {
            return seoKeyword;
        }

        public void setSeoKeyword(String seoKeyword) {
            this.seoKeyword = seoKeyword;
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

        public String getTotalViews() {
            return totalViews;
        }

        public void setTotalViews(String totalViews) {
            this.totalViews = totalViews;
        }

        public String getTotalLikes() {
            return totalLikes;
        }

        public void setTotalLikes(String totalLikes) {
            this.totalLikes = totalLikes;
        }

        public String getTotalDislikes() {
            return totalDislikes;
        }

        public void setTotalDislikes(String totalDislikes) {
            this.totalDislikes = totalDislikes;
        }

        public String getAverageRating() {
            return averageRating;
        }

        public void setAverageRating(String averageRating) {
            this.averageRating = averageRating;
        }

        public String getCommentAllow() {
            return commentAllow;
        }

        public void setCommentAllow(String commentAllow) {
            this.commentAllow = commentAllow;
        }

        public String getMovieLanguage() {
            return movieLanguage;
        }

        public void setMovieLanguage(String movieLanguage) {
            this.movieLanguage = movieLanguage;
        }

    }


}