package io.floofdoggo.youtubeplaylistscanner.controler;

import io.floofdoggo.youtubeplaylistscanner.sevice.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogicControler {

    @Autowired
    private ParserService parserService;

    @GetMapping("/")
    public String hello(){
        parserService.saveAll("UC8d8GkPcfQGa8lWAnqhElWg");
        return "index";
    }
}
