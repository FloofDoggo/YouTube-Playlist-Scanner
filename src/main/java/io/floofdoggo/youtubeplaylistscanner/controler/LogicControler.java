package io.floofdoggo.youtubeplaylistscanner.controler;

import io.floofdoggo.youtubeplaylistscanner.DAO.entity.UserEntity;
import io.floofdoggo.youtubeplaylistscanner.sevice.UserDetailServiceImpl;
import io.floofdoggo.youtubeplaylistscanner.sevice.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LogicControler {

    @Autowired
    private ParserService parserService;
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @GetMapping("/")
    public String hello(){
        //parserService.saveAll("UC8d8GkPcfQGa8lWAnqhElWg");
        return "index";
    }

    @GetMapping("/playlists")
    public String playlists(){
        return "playlists";
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
