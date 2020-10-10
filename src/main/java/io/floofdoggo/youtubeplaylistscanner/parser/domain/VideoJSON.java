package io.floofdoggo.youtubeplaylistscanner.parser.domain;

import java.util.List;

// class are nested by its JSON hierarchy
public class VideoJSON {

    private String nextPageToken;
    private List<Videos> items;

    public VideoJSON(String nextPageToken, List<Videos> items) {
        this.nextPageToken = nextPageToken;
        this.items = items;
    }

    public VideoJSON() {
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<Videos> getItems() {
        return items;
    }

    public void setItems(List<Videos> items) {
        this.items = items;
    }

    public static class Videos {

        private Snippet snippet;

        public Videos(Snippet snippet) {
            this.snippet = snippet;
        }

        public Videos() {
        }

        public Snippet getSnippet() {
            return snippet;
        }

        public void setSnippet(Snippet snippet) {
            this.snippet = snippet;
        }

        public static class Snippet {

            private String title;
            private ResourceId resourceId;

            public Snippet(String title, ResourceId resourceId) {
                this.title = title;
                this.resourceId = resourceId;
            }

            public Snippet() {
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public ResourceId getResourceId() {
                return resourceId;
            }

            public void setResourceId(ResourceId resourceId) {
                this.resourceId = resourceId;
            }

            public static class ResourceId {

                private String videoId;

                public ResourceId(String videoId) {
                    this.videoId = videoId;
                }

                public ResourceId() {
                }

                public String getVideoId() {
                    return videoId;
                }

                public void setVideoId(String videoId) {
                    this.videoId = videoId;
                }
            }
        }
    }
}
