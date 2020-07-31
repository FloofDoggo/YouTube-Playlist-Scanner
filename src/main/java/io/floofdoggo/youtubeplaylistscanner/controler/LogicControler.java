package io.floofdoggo.youtubeplaylistscanner.controler;

import io.floofdoggo.youtubeplaylistscanner.DAO.UserRepository;
import io.floofdoggo.youtubeplaylistscanner.DAO.entity.UserEntity;
import io.floofdoggo.youtubeplaylistscanner.sevice.AccountService;
import io.floofdoggo.youtubeplaylistscanner.sevice.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogicControler {

    @Autowired
    private ParserService parserService;
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String hello(){
        accountService.saveUser(new UserEntity("Grzesiek", "123123", "gmail@gmail.com", 1));
        //parserService.saveAll("UC8d8GkPcfQGa8lWAnqhElWg");
        return "index";
    }

    @GetMapping("/playlists")
    public String playlists(){
        return "playlists";
    }
}
