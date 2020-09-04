package cable.social.app.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//public class SeriesList {
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
//public class Data {
//
//    @SerializedName("seasons")
//    @Expose
//    private List<Season> seasons = null;
//
//    public List<Season> getSeasons() {
//        return seasons;
//    }
//
//    public void setSeasons(List<Season> seasons) {
//        this.seasons = seasons;
//    }
//
//}
//
//
//public class Episode {
//
//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("video_access")
//    @Expose
//    private String videoAccess;
//    @SerializedName("movie_language")
//    @Expose
//    private Integer movieLanguage;
//    @SerializedName("movie_category")
//    @Expose
//    private Integer movieCategory;
//    @SerializedName("genres")
//    @Expose
//    private Object genres;
//    @SerializedName("movie_actors")
//    @Expose
//    private Object movieActors;
//    @SerializedName("video_title")
//    @Expose
//    private String videoTitle;
//    @SerializedName("video_description")
//    @Expose
//    private Object videoDescription;
//    @SerializedName("imdb_rating")
//    @Expose
//    private Object imdbRating;
//    @SerializedName("release_date")
//    @Expose
//    private String releaseDate;
//    @SerializedName("duration")
//    @Expose
//    private String duration;
//    @SerializedName("status")
//    @Expose
//    private Object status;
//    @SerializedName("movie_by")
//    @Expose
//    private Object movieBy;
//    @SerializedName("customer_id")
//    @Expose
//    private Integer customerId;
//    @SerializedName("video_type")
//    @Expose
//    private String videoType;
//    @SerializedName("video_file")
//    @Expose
//    private String videoFile;
//    @SerializedName("movie_thumbnail")
//    @Expose
//    private String movieThumbnail;
//    @SerializedName("movie_poster")
//    @Expose
//    private String moviePoster;
//    @SerializedName("download_enable")
//    @Expose
//    private Object downloadEnable;
//    @SerializedName("download_url")
//    @Expose
//    private Object downloadUrl;
//    @SerializedName("seo_title")
//    @Expose
//    private Object seoTitle;
//    @SerializedName("seo_description")
//    @Expose
//    private Object seoDescription;
//    @SerializedName("seo_keyword")
//    @Expose
//    private Object seoKeyword;
//    @SerializedName("created_at")
//    @Expose
//    private String createdAt;
//    @SerializedName("updated_at")
//    @Expose
//    private String updatedAt;
//    @SerializedName("total_views")
//    @Expose
//    private Object totalViews;
//    @SerializedName("total_likes")
//    @Expose
//    private Object totalLikes;
//    @SerializedName("total_dislikes")
//    @Expose
//    private Object totalDislikes;
//    @SerializedName("average_rating")
//    @Expose
//    private Object averageRating;
//    @SerializedName("Comment_Allow")
//    @Expose
//    private Object commentAllow;
//    @SerializedName("season_type")
//    @Expose
//    private Object seasonType;
//    @SerializedName("channel_id")
//    @Expose
//    private Integer channelId;
//    @SerializedName("channel_name")
//    @Expose
//    private String channelName;
//    @SerializedName("channel_logo_image_url")
//    @Expose
//    private String channelLogoImageUrl;
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("season_id")
//    @Expose
//    private Integer seasonId;
//    @SerializedName("video_id")
//    @Expose
//    private Integer videoId;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getVideoAccess() {
//        return videoAccess;
//    }
//
//    public void setVideoAccess(String videoAccess) {
//        this.videoAccess = videoAccess;
//    }
//
//    public Integer getMovieLanguage() {
//        return movieLanguage;
//    }
//
//    public void setMovieLanguage(Integer movieLanguage) {
//        this.movieLanguage = movieLanguage;
//    }
//
//    public Integer getMovieCategory() {
//        return movieCategory;
//    }
//
//    public void setMovieCategory(Integer movieCategory) {
//        this.movieCategory = movieCategory;
//    }
//
//    public Object getGenres() {
//        return genres;
//    }
//
//    public void setGenres(Object genres) {
//        this.genres = genres;
//    }
//
//    public Object getMovieActors() {
//        return movieActors;
//    }
//
//    public void setMovieActors(Object movieActors) {
//        this.movieActors = movieActors;
//    }
//
//    public String getVideoTitle() {
//        return videoTitle;
//    }
//
//    public void setVideoTitle(String videoTitle) {
//        this.videoTitle = videoTitle;
//    }
//
//    public Object getVideoDescription() {
//        return videoDescription;
//    }
//
//    public void setVideoDescription(Object videoDescription) {
//        this.videoDescription = videoDescription;
//    }
//
//    public Object getImdbRating() {
//        return imdbRating;
//    }
//
//    public void setImdbRating(Object imdbRating) {
//        this.imdbRating = imdbRating;
//    }
//
//    public String getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(String releaseDate) {
//        this.releaseDate = releaseDate;
//    }
//
//    public String getDuration() {
//        return duration;
//    }
//
//    public void setDuration(String duration) {
//        this.duration = duration;
//    }
//
//    public Object getStatus() {
//        return status;
//    }
//
//    public void setStatus(Object status) {
//        this.status = status;
//    }
//
//    public Object getMovieBy() {
//        return movieBy;
//    }
//
//    public void setMovieBy(Object movieBy) {
//        this.movieBy = movieBy;
//    }
//
//    public Integer getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Integer customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getVideoType() {
//        return videoType;
//    }
//
//    public void setVideoType(String videoType) {
//        this.videoType = videoType;
//    }
//
//    public String getVideoFile() {
//        return videoFile;
//    }
//
//    public void setVideoFile(String videoFile) {
//        this.videoFile = videoFile;
//    }
//
//    public String getMovieThumbnail() {
//        return movieThumbnail;
//    }
//
//    public void setMovieThumbnail(String movieThumbnail) {
//        this.movieThumbnail = movieThumbnail;
//    }
//
//    public String getMoviePoster() {
//        return moviePoster;
//    }
//
//    public void setMoviePoster(String moviePoster) {
//        this.moviePoster = moviePoster;
//    }
//
//    public Object getDownloadEnable() {
//        return downloadEnable;
//    }
//
//    public void setDownloadEnable(Object downloadEnable) {
//        this.downloadEnable = downloadEnable;
//    }
//
//    public Object getDownloadUrl() {
//        return downloadUrl;
//    }
//
//    public void setDownloadUrl(Object downloadUrl) {
//        this.downloadUrl = downloadUrl;
//    }
//
//    public Object getSeoTitle() {
//        return seoTitle;
//    }
//
//    public void setSeoTitle(Object seoTitle) {
//        this.seoTitle = seoTitle;
//    }
//
//    public Object getSeoDescription() {
//        return seoDescription;
//    }
//
//    public void setSeoDescription(Object seoDescription) {
//        this.seoDescription = seoDescription;
//    }
//
//    public Object getSeoKeyword() {
//        return seoKeyword;
//    }
//
//    public void setSeoKeyword(Object seoKeyword) {
//        this.seoKeyword = seoKeyword;
//    }
//
//    public String getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(String createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public String getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(String updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public Object getTotalViews() {
//        return totalViews;
//    }
//
//    public void setTotalViews(Object totalViews) {
//        this.totalViews = totalViews;
//    }
//
//    public Object getTotalLikes() {
//        return totalLikes;
//    }
//
//    public void setTotalLikes(Object totalLikes) {
//        this.totalLikes = totalLikes;
//    }
//
//    public Object getTotalDislikes() {
//        return totalDislikes;
//    }
//
//    public void setTotalDislikes(Object totalDislikes) {
//        this.totalDislikes = totalDislikes;
//    }
//
//    public Object getAverageRating() {
//        return averageRating;
//    }
//
//    public void setAverageRating(Object averageRating) {
//        this.averageRating = averageRating;
//    }
//
//    public Object getCommentAllow() {
//        return commentAllow;
//    }
//
//    public void setCommentAllow(Object commentAllow) {
//        this.commentAllow = commentAllow;
//    }
//
//    public Object getSeasonType() {
//        return seasonType;
//    }
//
//    public void setSeasonType(Object seasonType) {
//        this.seasonType = seasonType;
//    }
//
//    public Integer getChannelId() {
//        return channelId;
//    }
//
//    public void setChannelId(Integer channelId) {
//        this.channelId = channelId;
//    }
//
//    public String getChannelName() {
//        return channelName;
//    }
//
//    public void setChannelName(String channelName) {
//        this.channelName = channelName;
//    }
//
//    public String getChannelLogoImageUrl() {
//        return channelLogoImageUrl;
//    }
//
//    public void setChannelLogoImageUrl(String channelLogoImageUrl) {
//        this.channelLogoImageUrl = channelLogoImageUrl;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getSeasonId() {
//        return seasonId;
//    }
//
//    public void setSeasonId(Integer seasonId) {
//        this.seasonId = seasonId;
//    }
//
//    public Integer getVideoId() {
//        return videoId;
//    }
//
//    public void setVideoId(Integer videoId) {
//        this.videoId = videoId;
//    }
//
//}
//
//public class Season {
//
//    @SerializedName("season_id")
//    @Expose
//    private Integer seasonId;
//    @SerializedName("season_number")
//    @Expose
//    private Integer seasonNumber;
//    @SerializedName("season_title")
//    @Expose
//    private String seasonTitle;
//    @SerializedName("air_date")
//    @Expose
//    private String airDate;
//    @SerializedName("customer_id")
//    @Expose
//    private Integer customerId;
//    @SerializedName("episodes")
//    @Expose
//    private List<Episode> episodes = null;
//
//    public Integer getSeasonId() {
//        return seasonId;
//    }
//
//    public void setSeasonId(Integer seasonId) {
//        this.seasonId = seasonId;
//    }
//
//    public Integer getSeasonNumber() {
//        return seasonNumber;
//    }
//
//    public void setSeasonNumber(Integer seasonNumber) {
//        this.seasonNumber = seasonNumber;
//    }
//
//    public String getSeasonTitle() {
//        return seasonTitle;
//    }
//
//    public void setSeasonTitle(String seasonTitle) {
//        this.seasonTitle = seasonTitle;
//    }
//
//    public String getAirDate() {
//        return airDate;
//    }
//
//    public void setAirDate(String airDate) {
//        this.airDate = airDate;
//    }
//
//    public Integer getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Integer customerId) {
//        this.customerId = customerId;
//    }
//
//    public List<Episode> getEpisodes() {
//        return episodes;
//    }
//
//    public void setEpisodes(List<Episode> episodes) {
//        this.episodes = episodes;
//    }
//
//}
//
//
//
//
//}

public class SeriesList {

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

        @SerializedName("seasons")
        @Expose
        private List<Season> seasons = null;

        public List<Season> getSeasons() {
            return seasons;
        }

        public void setSeasons(List<Season> seasons) {
            this.seasons = seasons;
        }

        public class Season {

            @SerializedName("season_id")
            @Expose
            private Integer seasonId;
            @SerializedName("season_number")
            @Expose
            private String seasonNumber;
            @SerializedName("season_title")
            @Expose
            private String seasonTitle;
            @SerializedName("air_date")
            @Expose
            private String airDate;
            @SerializedName("customer_id")
            @Expose
            private Integer customerId;
            @SerializedName("episodes")
            @Expose
            private List<Episode> episodes = null;

            public Integer getSeasonId() {
                return seasonId;
            }

            public void setSeasonId(Integer seasonId) {
                this.seasonId = seasonId;
            }

            public String getSeasonNumber() {
                return seasonNumber;
            }

            public void setSeasonNumber(String seasonNumber) {
                this.seasonNumber = seasonNumber;
            }

            public String getSeasonTitle() {
                return seasonTitle;
            }

            public void setSeasonTitle(String seasonTitle) {
                this.seasonTitle = seasonTitle;
            }

            public String getAirDate() {
                return airDate;
            }

            public void setAirDate(String airDate) {
                this.airDate = airDate;
            }

            public Integer getCustomerId() {
                return customerId;
            }

            public void setCustomerId(Integer customerId) {
                this.customerId = customerId;
            }

            public List<Episode> getEpisodes() {
                return episodes;
            }

            public void setEpisodes(List<Episode> episodes) {
                this.episodes = episodes;
            }


            public class Episode {

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
                @SerializedName("categoryName")
                @Expose
                private String categoryName;
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

                public String getCategoryName() {
                    return categoryName;
                }

                public void setCategoryName(String categoryName) {
                    this.categoryName = categoryName;
                }

                public String getVideoLike() {
                    return videoLike;
                }

                public void setVideoLike(String videoLike) {
                    this.videoLike = videoLike;
                }

            }


        }
    }

}