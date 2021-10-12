package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @PostMapping("/addSong")
    public RedirectView addSong(String title, int length, int trackNumber, long id){
        Album album = albumRepository.findById(id).orElseThrow();
        Song song = new Song(title,length,trackNumber);
        songRepository.save(song);

        return new RedirectView("/albums/"+id+"/songs");
    }

    @GetMapping("/songs")
    public String songs(Model model){
        model.addAttribute("songs",songRepository.findAll());
        return "songs";
    }
    @GetMapping("/albums/{id}")
    public String getSongs(@PathVariable("id") long id , Model model){
        model.addAttribute("albums",albumRepository.findById(id).get());
        return("oneAlbum.html");
    }

}
