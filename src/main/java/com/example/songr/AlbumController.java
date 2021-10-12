package com.example.songr;

//import com.example.songr.repositories.SongrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
//import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

public class AlbumController {
    @Autowired
    SongrRepo songrRepo;

    @GetMapping("/albums")
    public String getAlbumList(Model model) {
        model.addAttribute("Albums", songrRepo.findAll());
        return "albums";
    }

    @PostMapping("/addAlbums")
    public RedirectView addAlbum(@ModelAttribute Album album, Model model) {
        model.addAttribute("Album", album);
        songrRepo.save(album);
        return new RedirectView("albums");
    }
}
