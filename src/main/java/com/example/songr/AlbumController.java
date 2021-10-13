package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class AlbumController {
    @Autowired
    SongrRepository AlbumRepository;


//    Album albums[] = {
//            new Album("MyWay", "Frank Sinatra", 10, 1947,
//                    "https://th.bing.com/th/id/R.30f669b2967e9ab95bf74268c52f0f8a?rik=my6BBb79N6n%2bLQ&pid=ImgRaw&r=0"),
//            new Album("L-O-V-E", "Nat King Cole", 16, 2558,
//                    "https://th.bing.com/th/id/R.23144b7b337175c9b7b23c0ce35e2b32?rik=Ep0xStSXR3jxJw&riu=http%3a%2f%2fcps-static.rovicorp.com%2f3%2fJPG_400%2fMI0000%2f012%2fMI0000012214.jpg%3fpartner%3dallrovi.com&ehk=LczjV1TPUSSnn3bSm0ERWB0xlTjYucj7ts4deE16LLI%3d&risl=&pid=ImgRaw&r=0"),
//            new Album("parachutes", "Coldplay", 10, 2489,
//                    "https://th.bing.com/th/id/R.7df771f6610835736b113a810e301ead?rik=FO0S7N69jpw6qQ&riu=http%3a%2f%2f3.bp.blogspot.com%2f-wJ1hDEcCWkA%2fUUYpYtbpvuI%2fAAAAAAAABxM%2fimRLmzbjRV4%2fs1600%2fcoldplay-parachutes_cd.jpg&ehk=lxmfBlkqGj9bBNNDZn7B1TM%2bQ2RAi5vVlNZ7hbn%2bt2M%3d&risl=&pid=ImgRaw&r=0") };
//
//    @GetMapping("/albums")
//    public String albums(Model model) {
//        model.addAttribute("album", albums);
//        return "albums";
//    }
    // 1- get data from database and store them in array list
    // 2- add 3 elements,

    @GetMapping("/albums")
    public String getAlbumList(Model model) {
        model.addAttribute("album", AlbumRepository.findAll());
        return "albums";
    }
    @GetMapping("/addAlbum")
    public String addAlbumForm(){
        return "addAlbum";
    }

    @PostMapping("/addAlbum")
    public RedirectView addAlbum(@ModelAttribute Album album, Model model) {
        model.addAttribute("Album", album);
        AlbumRepository.save(album);
        return new RedirectView("/albums");
    }
}
