package io.floofdoggo.youtubeplaylistscanner.parser.domain;

import java.util.List;

// class are nested by its JSON hierarchy
public class PlaylistJSON {

    private String nextPageToken;
    private List<Playlists> items;

    public PlaylistJSON(String nextPageToken, List<Playlists> items) {
        this.nextPageToken = nextPageToken;
        this.items = items;
    }

    public PlaylistJSON() {
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<Playlists> getItems() {
        return items;
    }

    public void setItems(List<Playlists> items) {
        this.items = items;
    }

    public static class Playlists {

        private String id;
        private PlaylistSnippet snippet;

        public Playlists() {
        }

        public Playlists(String id, PlaylistSnippet snippet) {
            this.id = id;
            this.snippet = snippet;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public PlaylistSnippet getSnippet() {
            return snippet;
        }

        public void setSnippet(PlaylistSnippet snippet) {
            this.snippet = snippet;
        }

        public static class PlaylistSnippet {

            private PlaylistTitle title;
            private PlaylistThumbnail thumbnails;

            public PlaylistSnippet(PlaylistTitle playlistTitle, PlaylistThumbnail thumbnails) {
                this.title = playlistTitle;
                this.thumbnails = thumbnails;
            }

            public PlaylistSnippet() {
            }

            public PlaylistTitle getTitle() {
                return title;
            }

            public void setTitle(PlaylistTitle title) {
                this.title = title;
            }

            public PlaylistThumbnail getThumbnails() {
                return thumbnails;
            }

            public void setThumbnails(PlaylistThumbnail thumbnails) {
                this.thumbnails = thumbnails;
            }
        }

        public static class PlaylistTitle {

            private String title;

            public PlaylistTitle(String title) {
                this.title = title;
            }

            public PlaylistTitle() {
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class PlaylistThumbnail {

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

            public static class MediumThumbnail {

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
    }
}
