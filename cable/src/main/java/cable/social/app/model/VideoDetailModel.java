package cable.social.app.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


//public class VideoDetailModel {
//
//    @SerializedName("status")
//    @Expose
//    private String status;
//    @SerializedName("status_code")
//    @Expose
//    private Integer statusCode;
//    @SerializedName("message")
//    @Expose
//    private String message;
//    @SerializedName("data")
//    @Expose
//    private Data data;
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Integer getStatusCode() {
//        return statusCode;
//    }
//
//    public void setStatusCode(Integer statusCode) {
//        this.statusCode = statusCode;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Data getData() {
//        return data;
//    }
//
//    public void setData(Data data) {
//        this.data = data;
//    }
//
//
//    public class Data {
//
//        @SerializedName("video_details")
//        @Expose
//        private VideoDetails videoDetails;
//        @SerializedName("genres")
//        @Expose
//        private List<Genre> genres = null;
//        @SerializedName("invite_list")
//        @Expose
//        private List<InviteList> inviteList = null;
//        @SerializedName("seasonsLists")
//        @Expose
//        private List<SeasonsList> seasonsLists = null;
//        @SerializedName("similar_videos")
//        @Expose
//        private List<SimilarVideo> similarVideos = null;
//
//        public VideoDetails getVideoDetails() {
//            return videoDetails;
//        }
//
//        public void setVideoDetails(VideoDetails videoDetails) {
//            this.videoDetails = videoDetails;
//        }
//
//        public List<Genre> getGenres() {
//            return genres;
//        }
//
//        public void setGenres(List<Genre> genres) {
//            this.genres = genres;
//        }
//
//        public List<InviteList> getInviteList() {
//            return inviteList;
//        }
//
//        public void setInviteList(List<InviteList> inviteList) {
//            this.inviteList = inviteList;
//        }
//
//        public List<SeasonsList> getSeasonsLists() {
//            return seasonsLists;
//        }
//
//        public void setSeasonsLists(List<SeasonsList> seasonsLists) {
//            this.seasonsLists = seasonsLists;
//        }
//
//        public List<SimilarVideo> getSimilarVideos() {
//            return similarVideos;
//        }
//
//        public void setSimilarVideos(List<SimilarVideo> similarVideos) {
//            this.similarVideos = similarVideos;
//        }
//
//
//        public class Genre {
//
//            @SerializedName("genres_name")
//            @Expose
//            private String genresName;
//            @SerializedName("genres_image")
//            @Expose
//            private String genresImage;
//
//            public String getGenresName() {
//                return genresName;
//            }
//
//            public void setGenresName(String genresName) {
//                this.genresName = genresName;
//            }
//
//            public String getGenresImage() {
//                return genresImage;
//            }
//
//            public void setGenresImage(String genresImage) {
//                this.genresImage = genresImage;
//            }
//
//        }
//
//
//        public class InviteList {
//
//            @SerializedName("customer_id")
//            @Expose
//            private String customerId;
//            @SerializedName("customer_username")
//            @Expose
//            private String customerUsername;
//            @SerializedName("customer_name")
//            @Expose
//            private String customerName;
//            @SerializedName("customer_last_name")
//            @Expose
//            private String customerLastName;
//            @SerializedName("customer_email")
//            @Expose
//            private String customerEmail;
//            @SerializedName("customer_profile_pic")
//            @Expose
//            private String customerProfilePic;
//            @SerializedName("invite_status")
//            @Expose
//            private String inviteStatus;
//
//            public String getCustomerId() {
//                return customerId;
//            }
//
//            public void setCustomerId(String customerId) {
//                this.customerId = customerId;
//            }
//
//            public String getCustomerUsername() {
//                return customerUsername;
//            }
//
//            public void setCustomerUsername(String customerUsername) {
//                this.customerUsername = customerUsername;
//            }
//
//            public String getCustomerName() {
//                return customerName;
//            }
//
//            public void setCustomerName(String customerName) {
//                this.customerName = customerName;
//            }
//
//            public String getCustomerLastName() {
//                return customerLastName;
//            }
//
//            public void setCustomerLastName(String customerLastName) {
//                this.customerLastName = customerLastName;
//            }
//
//            public String getCustomerEmail() {
//                return customerEmail;
//            }
//
//            public void setCustomerEmail(String customerEmail) {
//                this.customerEmail = customerEmail;
//            }
//
//            public String getCustomerProfilePic() {
//                return customerProfilePic;
//            }
//
//            public void setCustomerProfilePic(String customerProfilePic) {
//                this.customerProfilePic = customerProfilePic;
//            }
//
//            public String getInviteStatus() {
//                return inviteStatus;
//            }
//
//            public void setInviteStatus(String inviteStatus) {
//                this.inviteStatus = inviteStatus;
//            }
//
//        }
//
//
//        public class SeasonsList {
//
//            @SerializedName("id")
//            @Expose
//            private Integer id;
//            @SerializedName("season_type")
//            @Expose
//            private String seasonType;
//            @SerializedName("season_title")
//            @Expose
//            private String seasonTitle;
//            @SerializedName("season_description")
//            @Expose
//            private String seasonDescription;
//            @SerializedName("season_image")
//            @Expose
//            private String seasonImage;
//            @SerializedName("season_thumbnail")
//            @Expose
//            private String seasonThumbnail;
//            @SerializedName("flag")
//            @Expose
//            private Integer flag;
//            @SerializedName("created_at")
//            @Expose
//            private String createdAt;
//            @SerializedName("updated_at")
//            @Expose
//            private String updatedAt;
//
//            public Integer getId() {
//                return id;
//            }
//
//            public void setId(Integer id) {
//                this.id = id;
//            }
//
//            public String getSeasonType() {
//                return seasonType;
//            }
//
//            public void setSeasonType(String seasonType) {
//                this.seasonType = seasonType;
//            }
//
//            public String getSeasonTitle() {
//                return seasonTitle;
//            }
//
//            public void setSeasonTitle(String seasonTitle) {
//                this.seasonTitle = seasonTitle;
//            }
//
//            public String getSeasonDescription() {
//                return seasonDescription;
//            }
//
//            public void setSeasonDescription(String seasonDescription) {
//                this.seasonDescription = seasonDescription;
//            }
//
//            public String getSeasonImage() {
//                return seasonImage;
//            }
//
//            public void setSeasonImage(String seasonImage) {
//                this.seasonImage = seasonImage;
//            }
//
//            public String getSeasonThumbnail() {
//                return seasonThumbnail;
//            }
//
//            public void setSeasonThumbnail(String seasonThumbnail) {
//                this.seasonThumbnail = seasonThumbnail;
//            }
//
//            public Integer getFlag() {
//                return flag;
//            }
//
//            public void setFlag(Integer flag) {
//                this.flag = flag;
//            }
//
//            public String getCreatedAt() {
//                return createdAt;
//            }
//
//            public void setCreatedAt(String createdAt) {
//                this.createdAt = createdAt;
//            }
//
//            public String getUpdatedAt() {
//                return updatedAt;
//            }
//
//            public void setUpdatedAt(String updatedAt) {
//                this.updatedAt = updatedAt;
//            }
//
//        }
//
//
//        public class SimilarVideo {
//
//            @SerializedName("id")
//            @Expose
//            private String id;
//            @SerializedName("video_access")
//            @Expose
//            private String videoAccess;
//            @SerializedName("movie_category")
//            @Expose
//            private String movieCategory;
//            @SerializedName("genres")
//            @Expose
//            private String genres;
//            @SerializedName("movie_actors")
//            @Expose
//            private String movieActors;
//            @SerializedName("video_title")
//            @Expose
//            private String videoTitle;
//            @SerializedName("video_description")
//            @Expose
//            private String videoDescription;
//            @SerializedName("imdb_rating")
//            @Expose
//            private String imdbRating;
//            @SerializedName("release_date")
//            @Expose
//            private String releaseDate;
//            @SerializedName("duration")
//            @Expose
//            private String duration;
//            @SerializedName("status")
//            @Expose
//            private String status;
//            @SerializedName("movie_by")
//            @Expose
//            private String movieBy;
//            @SerializedName("customer_id")
//            @Expose
//            private String customerId;
//            @SerializedName("video_type")
//            @Expose
//            private String videoType;
//            @SerializedName("video_file")
//            @Expose
//            private String videoFile;
//            @SerializedName("movie_thumbnail")
//            @Expose
//            private String movieThumbnail;
//            @SerializedName("movie_poster")
//            @Expose
//            private String moviePoster;
//            @SerializedName("download_enable")
//            @Expose
//            private String downloadEnable;
//            @SerializedName("download_url")
//            @Expose
//            private String downloadUrl;
//            @SerializedName("seo_title")
//            @Expose
//            private String seoTitle;
//            @SerializedName("seo_description")
//            @Expose
//            private String seoDescription;
//            @SerializedName("seo_keyword")
//            @Expose
//            private String seoKeyword;
//            @SerializedName("created_at")
//            @Expose
//            private String createdAt;
//            @SerializedName("updated_at")
//            @Expose
//            private String updatedAt;
//            @SerializedName("total_views")
//            @Expose
//            private String totalViews;
//            @SerializedName("total_likes")
//            @Expose
//            private String totalLikes;
//            @SerializedName("total_dislikes")
//            @Expose
//            private String totalDislikes;
//            @SerializedName("average_rating")
//            @Expose
//            private String averageRating;
//            @SerializedName("Comment_Allow")
//            @Expose
//            private String commentAllow;
//            @SerializedName("movieLanguage")
//            @Expose
//            private String movieLanguage;
//
//            public String getId() {
//                return id;
//            }
//
//            public void setId(String id) {
//                this.id = id;
//            }
//
//            public String getVideoAccess() {
//                return videoAccess;
//            }
//
//            public void setVideoAccess(String videoAccess) {
//                this.videoAccess = videoAccess;
//            }
//
//            public String getMovieCategory() {
//                return movieCategory;
//            }
//
//            public void setMovieCategory(String movieCategory) {
//                this.movieCategory = movieCategory;
//            }
//
//            public String getGenres() {
//                return genres;
//            }
//
//            public void setGenres(String genres) {
//                this.genres = genres;
//            }
//
//            public String getMovieActors() {
//                return movieActors;
//            }
//
//            public void setMovieActors(String movieActors) {
//                this.movieActors = movieActors;
//            }
//
//            public String getVideoTitle() {
//                return videoTitle;
//            }
//
//            public void setVideoTitle(String videoTitle) {
//                this.videoTitle = videoTitle;
//            }
//
//            public String getVideoDescription() {
//                return videoDescription;
//            }
//
//            public void setVideoDescription(String videoDescription) {
//                this.videoDescription = videoDescription;
//            }
//
//            public String getImdbRating() {
//                return imdbRating;
//            }
//
//            public void setImdbRating(String imdbRating) {
//                this.imdbRating = imdbRating;
//            }
//
//            public String getReleaseDate() {
//                return releaseDate;
//            }
//
//            public void setReleaseDate(String releaseDate) {
//                this.releaseDate = releaseDate;
//            }
//
//            public String getDuration() {
//                return duration;
//            }
//
//            public void setDuration(String duration) {
//                this.duration = duration;
//            }
//
//            public String getStatus() {
//                return status;
//            }
//
//            public void setStatus(String status) {
//                this.status = status;
//            }
//
//            public String getMovieBy() {
//                return movieBy;
//            }
//
//            public void setMovieBy(String movieBy) {
//                this.movieBy = movieBy;
//            }
//
//            public String getCustomerId() {
//                return customerId;
//            }
//
//            public void setCustomerId(String customerId) {
//                this.customerId = customerId;
//            }
//
//            public String getVideoType() {
//                return videoType;
//            }
//
//            public void setVideoType(String videoType) {
//                this.videoType = videoType;
//            }
//
//            public String getVideoFile() {
//                return videoFile;
//            }
//
//            public void setVideoFile(String videoFile) {
//                this.videoFile = videoFile;
//            }
//
//            public String getMovieThumbnail() {
//                return movieThumbnail;
//            }
//
//            public void setMovieThumbnail(String movieThumbnail) {
//                this.movieThumbnail = movieThumbnail;
//            }
//
//            public String getMoviePoster() {
//                return moviePoster;
//            }
//
//            public void setMoviePoster(String moviePoster) {
//                this.moviePoster = moviePoster;
//            }
//
//            public String getDownloadEnable() {
//                return downloadEnable;
//            }
//
//            public void setDownloadEnable(String downloadEnable) {
//                this.downloadEnable = downloadEnable;
//            }
//
//            public String getDownloadUrl() {
//                return downloadUrl;
//            }
//
//            public void setDownloadUrl(String downloadUrl) {
//                this.downloadUrl = downloadUrl;
//            }
//
//            public String getSeoTitle() {
//                return seoTitle;
//            }
//
//            public void setSeoTitle(String seoTitle) {
//                this.seoTitle = seoTitle;
//            }
//
//            public String getSeoDescription() {
//                return seoDescription;
//            }
//
//            public void setSeoDescription(String seoDescription) {
//                this.seoDescription = seoDescription;
//            }
//
//            public String getSeoKeyword() {
//                return seoKeyword;
//            }
//
//            public void setSeoKeyword(String seoKeyword) {
//                this.seoKeyword = seoKeyword;
//            }
//
//            public String getCreatedAt() {
//                return createdAt;
//            }
//
//            public void setCreatedAt(String createdAt) {
//                this.createdAt = createdAt;
//            }
//
//            public String getUpdatedAt() {
//                return updatedAt;
//            }
//
//            public void setUpdatedAt(String updatedAt) {
//                this.updatedAt = updatedAt;
//            }
//
//            public String getTotalViews() {
//                return totalViews;
//            }
//
//            public void setTotalViews(String totalViews) {
//                this.totalViews = totalViews;
//            }
//
//            public String getTotalLikes() {
//                return totalLikes;
//            }
//
//            public void setTotalLikes(String totalLikes) {
//                this.totalLikes = totalLikes;
//            }
//
//            public String getTotalDislikes() {
//                return totalDislikes;
//            }
//
//            public void setTotalDislikes(String totalDislikes) {
//                this.totalDislikes = totalDislikes;
//            }
//
//            public String getAverageRating() {
//                return averageRating;
//            }
//
//            public void setAverageRating(String averageRating) {
//                this.averageRating = averageRating;
//            }
//
//            public String getCommentAllow() {
//                return commentAllow;
//            }
//
//            public void setCommentAllow(String commentAllow) {
//                this.commentAllow = commentAllow;
//            }
//
//            public String getMovieLanguage() {
//                return movieLanguage;
//            }
//
//            public void setMovieLanguage(String movieLanguage) {
//                this.movieLanguage = movieLanguage;
//            }
//
//        }
//
//
//        public class VideoDetails {
//
//            @SerializedName("id")
//            @Expose
//            private String id;
//            @SerializedName("video_access")
//            @Expose
//            private String videoAccess;
//            @SerializedName("movie_category")
//            @Expose
//            private String movieCategory;
//            @SerializedName("genres")
//            @Expose
//            private String genres;
//            @SerializedName("movie_actors")
//            @Expose
//            private String movieActors;
//            @SerializedName("video_title")
//            @Expose
//            private String videoTitle;
//            @SerializedName("video_description")
//            @Expose
//            private String videoDescription;
//            @SerializedName("imdb_rating")
//            @Expose
//            private String imdbRating;
//            @SerializedName("release_date")
//            @Expose
//            private String releaseDate;
//            @SerializedName("duration")
//            @Expose
//            private String duration;
//            @SerializedName("status")
//            @Expose
//            private String status;
//            @SerializedName("movie_by")
//            @Expose
//            private String movieBy;
//            @SerializedName("customer_id")
//            @Expose
//            private String customerId;
//            @SerializedName("video_type")
//            @Expose
//            private String videoType;
//            @SerializedName("video_file")
//            @Expose
//            private String videoFile;
//            @SerializedName("movie_thumbnail")
//            @Expose
//            private String movieThumbnail;
//            @SerializedName("movie_poster")
//            @Expose
//            private String moviePoster;
//            @SerializedName("download_enable")
//            @Expose
//            private String downloadEnable;
//            @SerializedName("download_url")
//            @Expose
//            private String downloadUrl;
//            @SerializedName("seo_title")
//            @Expose
//            private String seoTitle;
//            @SerializedName("seo_description")
//            @Expose
//            private String seoDescription;
//            @SerializedName("seo_keyword")
//            @Expose
//            private String seoKeyword;
//            @SerializedName("created_at")
//            @Expose
//            private String createdAt;
//            @SerializedName("updated_at")
//            @Expose
//            private String updatedAt;
//            @SerializedName("total_views")
//            @Expose
//            private String totalViews;
//            @SerializedName("total_likes")
//            @Expose
//            private String totalLikes;
//            @SerializedName("total_dislikes")
//            @Expose
//            private String totalDislikes;
//            @SerializedName("average_rating")
//            @Expose
//            private String averageRating;
//            @SerializedName("Comment_Allow")
//            @Expose
//            private String commentAllow;
//            @SerializedName("movieLanguage")
//            @Expose
//            private String movieLanguage;
//
//            public String getId() {
//                return id;
//            }
//
//            public void setId(String id) {
//                this.id = id;
//            }
//
//            public String getVideoAccess() {
//                return videoAccess;
//            }
//
//            public void setVideoAccess(String videoAccess) {
//                this.videoAccess = videoAccess;
//            }
//
//            public String getMovieCategory() {
//                return movieCategory;
//            }
//
//            public void setMovieCategory(String movieCategory) {
//                this.movieCategory = movieCategory;
//            }
//
//            public String getGenres() {
//                return genres;
//            }
//
//            public void setGenres(String genres) {
//                this.genres = genres;
//            }
//
//            public String getMovieActors() {
//                return movieActors;
//            }
//
//            public void setMovieActors(String movieActors) {
//                this.movieActors = movieActors;
//            }
//
//            public String getVideoTitle() {
//                return videoTitle;
//            }
//
//            public void setVideoTitle(String videoTitle) {
//                this.videoTitle = videoTitle;
//            }
//
//            public String getVideoDescription() {
//                return videoDescription;
//            }
//
//            public void setVideoDescription(String videoDescription) {
//                this.videoDescription = videoDescription;
//            }
//
//            public String getImdbRating() {
//                return imdbRating;
//            }
//
//            public void setImdbRating(String imdbRating) {
//                this.imdbRating = imdbRating;
//            }
//
//            public String getReleaseDate() {
//                return releaseDate;
//            }
//
//            public void setReleaseDate(String releaseDate) {
//                this.releaseDate = releaseDate;
//            }
//
//            public String getDuration() {
//                return duration;
//            }
//
//            public void setDuration(String duration) {
//                this.duration = duration;
//            }
//
//            public String getStatus() {
//                return status;
//            }
//
//            public void setStatus(String status) {
//                this.status = status;
//            }
//
//            public String getMovieBy() {
//                return movieBy;
//            }
//
//            public void setMovieBy(String movieBy) {
//                this.movieBy = movieBy;
//            }
//
//            public String getCustomerId() {
//                return customerId;
//            }
//
//            public void setCustomerId(String customerId) {
//                this.customerId = customerId;
//            }
//
//            public String getVideoType() {
//                return videoType;
//            }
//
//            public void setVideoType(String videoType) {
//                this.videoType = videoType;
//            }
//
//            public String getVideoFile() {
//                return videoFile;
//            }
//
//            public void setVideoFile(String videoFile) {
//                this.videoFile = videoFile;
//            }
//
//            public String getMovieThumbnail() {
//                return movieThumbnail;
//            }
//
//            public void setMovieThumbnail(String movieThumbnail) {
//                this.movieThumbnail = movieThumbnail;
//            }
//
//            public String getMoviePoster() {
//                return moviePoster;
//            }
//
//            public void setMoviePoster(String moviePoster) {
//                this.moviePoster = moviePoster;
//            }
//
//            public String getDownloadEnable() {
//                return downloadEnable;
//            }
//
//            public void setDownloadEnable(String downloadEnable) {
//                this.downloadEnable = downloadEnable;
//            }
//
//            public String getDownloadUrl() {
//                return downloadUrl;
//            }
//
//            public void setDownloadUrl(String downloadUrl) {
//                this.downloadUrl = downloadUrl;
//            }
//
//            public String getSeoTitle() {
//                return seoTitle;
//            }
//
//            public void setSeoTitle(String seoTitle) {
//                this.seoTitle = seoTitle;
//            }
//
//            public String getSeoDescription() {
//                return seoDescription;
//            }
//
//            public void setSeoDescription(String seoDescription) {
//                this.seoDescription = seoDescription;
//            }
//
//            public String getSeoKeyword() {
//                return seoKeyword;
//            }
//
//            public void setSeoKeyword(String seoKeyword) {
//                this.seoKeyword = seoKeyword;
//            }
//
//            public String getCreatedAt() {
//                return createdAt;
//            }
//
//            public void setCreatedAt(String createdAt) {
//                this.createdAt = createdAt;
//            }
//
//            public String getUpdatedAt() {
//                return updatedAt;
//            }
//
//            public void setUpdatedAt(String updatedAt) {
//                this.updatedAt = updatedAt;
//            }
//
//            public String getTotalViews() {
//                return totalViews;
//            }
//
//            public void setTotalViews(String totalViews) {
//                this.totalViews = totalViews;
//            }
//
//            public String getTotalLikes() {
//                return totalLikes;
//            }
//
//            public void setTotalLikes(String totalLikes) {
//                this.totalLikes = totalLikes;
//            }
//
//            public String getTotalDislikes() {
//                return totalDislikes;
//            }
//
//            public void setTotalDislikes(String totalDislikes) {
//                this.totalDislikes = totalDislikes;
//            }
//
//            public String getAverageRating() {
//                return averageRating;
//            }
//
//            public void setAverageRating(String averageRating) {
//                this.averageRating = averageRating;
//            }
//
//            public String getCommentAllow() {
//                return commentAllow;
//            }
//
//            public void setCommentAllow(String commentAllow) {
//                this.commentAllow = commentAllow;
//            }
//
//            public String getMovieLanguage() {
//                return movieLanguage;
//            }
//
//            public void setMovieLanguage(String movieLanguage) {
//                this.movieLanguage = movieLanguage;
//            }
//        }
//    }
//}


public class VideoDetailModel {

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
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Data {

        @SerializedName("video_details")
        @Expose
        private VideoDetails videoDetails;
        @SerializedName("genres")
        @Expose
        private List<Genre> genres = null;
        @SerializedName("invite_list")
        @Expose
        private List<InviteList> inviteList = null;
        @SerializedName("seasonsLists")
        @Expose
        private List<Object> seasonsLists = null;
        @SerializedName("similar_videos")
        @Expose
        private List<SimilarVideo> similarVideos = null;

        public VideoDetails getVideoDetails() {
            return videoDetails;
        }

        public void setVideoDetails(VideoDetails videoDetails) {
            this.videoDetails = videoDetails;
        }

        public List<Genre> getGenres() {
            return genres;
        }

        public void setGenres(List<Genre> genres) {
            this.genres = genres;
        }

        public List<InviteList> getInviteList() {
            return inviteList;
        }

        public void setInviteList(List<InviteList> inviteList) {
            this.inviteList = inviteList;
        }

        public List<Object> getSeasonsLists() {
            return seasonsLists;
        }

        public void setSeasonsLists(List<Object> seasonsLists) {
            this.seasonsLists = seasonsLists;
        }

        public List<SimilarVideo> getSimilarVideos() {
            return similarVideos;
        }

        public void setSimilarVideos(List<SimilarVideo> similarVideos) {
            this.similarVideos = similarVideos;
        }


        public class InviteList {

            @SerializedName("customer_id")
            @Expose
            private String customerId;
            @SerializedName("customer_username")
            @Expose
            private String customerUsername;
            @SerializedName("customer_name")
            @Expose
            private String customerName;
            @SerializedName("customer_last_name")
            @Expose
            private String customerLastName;
            @SerializedName("customer_email")
            @Expose
            private String customerEmail;
            @SerializedName("customer_profile_pic")
            @Expose
            private String customerProfilePic;
            @SerializedName("invite_status")
            @Expose
            private String inviteStatus;

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getCustomerUsername() {
                return customerUsername;
            }

            public void setCustomerUsername(String customerUsername) {
                this.customerUsername = customerUsername;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public String getCustomerLastName() {
                return customerLastName;
            }

            public void setCustomerLastName(String customerLastName) {
                this.customerLastName = customerLastName;
            }

            public String getCustomerEmail() {
                return customerEmail;
            }

            public void setCustomerEmail(String customerEmail) {
                this.customerEmail = customerEmail;
            }

            public String getCustomerProfilePic() {
                return customerProfilePic;
            }

            public void setCustomerProfilePic(String customerProfilePic) {
                this.customerProfilePic = customerProfilePic;
            }

            public String getInviteStatus() {
                return inviteStatus;
            }

            public void setInviteStatus(String inviteStatus) {
                this.inviteStatus = inviteStatus;
            }

        }


        public class SimilarVideo {

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
            @SerializedName("channel_id")
            @Expose
            private String channelId;
            @SerializedName("channel_name")
            @Expose
            private String channelName;
            @SerializedName("channel_logo_image_url")
            @Expose
            private String channelLogoImageUrl;
            @SerializedName("video_like")
            @Expose
            private String videoLike;

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

            public String getChannelId() {
                return channelId;
            }

            public void setChannelId(String channelId) {
                this.channelId = channelId;
            }

            public String getChannelName() {
                return channelName;
            }

            public void setChannelName(String channelName) {
                this.channelName = channelName;
            }

            public String getChannelLogoImageUrl() {
                return channelLogoImageUrl;
            }

            public void setChannelLogoImageUrl(String channelLogoImageUrl) {
                this.channelLogoImageUrl = channelLogoImageUrl;
            }

            public String getVideoLike() {
                return videoLike;
            }

            public void setVideoLike(String videoLike) {
                this.videoLike = videoLike;
            }

        }


        public class VideoDetails {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("video_access")
            @Expose
            private String videoAccess;
            @SerializedName("movie_category")
            @Expose
            private String movieCategory;

            @SerializedName("categoryName")
            @Expose
            private String categoryName;
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
            @SerializedName("channel_id")
            @Expose
            private String channelId;
            @SerializedName("channel_name")
            @Expose
            private String channelName;
            @SerializedName("channel_logo_image_url")
            @Expose
            private String channelLogoImageUrl;
            @SerializedName("video_like")
            @Expose
            private String videoLike;

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

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
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

            public String getChannelId() {
                return channelId;
            }

            public void setChannelId(String channelId) {
                this.channelId = channelId;
            }

            public String getChannelName() {
                return channelName;
            }

            public void setChannelName(String channelName) {
                this.channelName = channelName;
            }

            public String getChannelLogoImageUrl() {
                return channelLogoImageUrl;
            }

            public void setChannelLogoImageUrl(String channelLogoImageUrl) {
                this.channelLogoImageUrl = channelLogoImageUrl;
            }

            public String getVideoLike() {
                return videoLike;
            }

            public void setVideoLike(String videoLike) {
                this.videoLike = videoLike;
            }

        }

        public class Genre {

            @SerializedName("genres_name")
            @Expose
            private String genresName;
            @SerializedName("genres_image")
            @Expose
            private String genresImage;

            public String getGenresName() {
                return genresName;
            }

            public void setGenresName(String genresName) {
                this.genresName = genresName;
            }

            public String getGenresImage() {
                return genresImage;
            }

            public void setGenresImage(String genresImage) {
                this.genresImage = genresImage;
            }

        }
    }
}