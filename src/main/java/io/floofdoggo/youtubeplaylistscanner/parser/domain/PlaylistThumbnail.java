package io.floofdoggo.youtubeplaylistscanner.parser.domain;

public class PlaylistThumbnail {

    private MediumThumbnail medium;

    public PlaylistThumbnail(MediumThumbnail medium) {
        this.medium = medium;
    }

    public PlaylistThumbnail() {
    }

    public MediumThumbnail getMedium() {
        return medium;
    }

    public void setMedium(MediumThumbnail medium) {
        this.medium = medium;
    }

    public class MediumThumbnail {

        private String url;

        public MediumThumbnail(String url) {
            this.url = url;
        }

        public MediumThumbnail() {
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}


