package io.floofdoggo.youtubeplaylistscanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class YoutubePlaylistScannerApplication {
	public static void main(String[] args){
		SpringApplication.run(YoutubePlaylistScannerApplication.class, args);
		//YoutubeParser youtubeParser = new YoutubeParser();

		//List<Playlist> playlists = youtubeParser.getPlaylists("UCWTA5Yd0rAkQt5-9etIFoBA");
		//List<Video> videos = youtubeParser.getPlaylistVideos("PLK5M7v9HFwfWiAHoO391nTgGWCjDQlplB");

		//playlists.stream().forEach(x -> System.out.println(x.getTitle() + "\t" + x.getId() + "\t" + x.getThumbnailUrl()));
		//videos.stream().forEach(x -> System.out.println(x.getTitle()+ "\t" + x.getVideoId()));
	}
}
