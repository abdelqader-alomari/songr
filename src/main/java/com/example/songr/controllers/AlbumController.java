package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.models.Song;
import com.example.songr.repositories.AlbumRepository;
import com.example.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;


    @GetMapping("/albums")
    public String getAlbumList(Model model) {
        model.addAttribute("album", albumRepository.findAll());
        return "albums";
    }
    @GetMapping("/addAlbum")
    public String addAlbumForm(){
        return "addAlbum";
    }

    @PostMapping("/addAlbum")
    public RedirectView addAlbum(@ModelAttribute Album album, Model model) {
        model.addAttribute("Album", album);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

    @GetMapping("/oneAlbum")
    public String getOneAlbum(@RequestParam Long id , Model model){
        Album album = albumRepository.findById(id).get();
        model.addAttribute("album" , album);
        List<Song> albumSongs = songRepository.findAllByAlbum(album);
        model.addAttribute("songs" , albumSongs);
        return "oneAlbum";
    }

}
