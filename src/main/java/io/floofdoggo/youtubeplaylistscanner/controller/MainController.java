package io.floofdoggo.youtubeplaylistscanner.controller;

import io.floofdoggo.youtubeplaylistscanner.DAO.entity.UserEntity;
import io.floofdoggo.youtubeplaylistscanner.service.DatabaseService;
import io.floofdoggo.youtubeplaylistscanner.service.UserDetailServiceImpl;
import io.floofdoggo.youtubeplaylistscanner.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private DatabaseService databaseService;
    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Autowired
    private YoutubeService youtubeService;

    @GetMapping("/")
    private String homePage() {
        //parserService.saveAllPlaylistContent("UC8d8GkPcfQGa8lWAnqhElWg");
        //parserService.saveOnePlaylistContent("PLK5M7v9HFwfU68UhMIpzv9B-71nrdXbwA");
        //parserService.test();
        return "index";
    }

    @GetMapping("/playlists")
    public String playlists(Model model){
        //parserService.saveAllPlaylistContent("UC8d8GkPcfQGa8lWAnqhElWg");
        model.addAttribute("playlists", databaseService.getCurrentUserPlaylists());
        model.addAttribute("playlistId", new String());
        model.addAttribute("channelId", new String());
        return "playlists";
    }

    @PostMapping("/playlistid")
    public String addPlaylistByPlaylistId(@ModelAttribute("playlistId") String playlistId, Model model){
        databaseService.saveOnePlaylistContent(playlistId);
        return "redirect:/playlists";
    }

    @PostMapping("/channelid")
    public String addPlaylistByChannelId(@ModelAttribute("channelId") String channelId, Model model){
        databaseService.saveAllPlaylistContent(channelId);
        return "redirect:/playlists";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        UserEntity userEntity = new UserEntity();
        model.addAttribute("userEntity", userEntity);
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("userEntity") @Valid UserEntity userEntity,
                                      BindingResult result){
        UserEntity existingUser = userDetailService.findUserByUsername(userEntity.getUsername());
        if(existingUser == null){
            userDetailService.saveUser(userEntity);
        }
        if(result.hasErrors()){
            return "register";
        }
        return "index";
    }
}
