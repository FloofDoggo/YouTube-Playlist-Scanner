package io.floofdoggo.youtubeplaylistscanner.parser.domain;

public class VideoSnippet {

    private Video snippet;

    public VideoSnippet(Video snippet) {
        this.snippet = snippet;
    }

    public VideoSnippet() {
    }

    public Video getSnippet() {
        return snippet;
    }

    public void setSnippet(Video snippet) {
        this.snippet = snippet;
    }
}
