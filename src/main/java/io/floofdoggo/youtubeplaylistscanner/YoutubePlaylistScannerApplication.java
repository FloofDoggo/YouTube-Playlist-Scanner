package io.floofdoggo.youtubeplaylistscanner;

import io.floofdoggo.youtubeplaylistscanner.parser.YoutubeParser;
import io.floofdoggo.youtubeplaylistscanner.sevice.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class YoutubePlaylistScannerApplication {
	public static void main(String[] args){
		SpringApplication.run(YoutubePlaylistScannerApplication.class, args);
	}
}
