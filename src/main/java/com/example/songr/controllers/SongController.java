package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.repositories.AlbumRepository;
import com.example.songr.models.Song;
import com.example.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/songs")
    public String songs(Model model){
        model.addAttribute("songs",songRepository.findAll());
        return "songs";
    }

//    @GetMapping("/nosong")
//    public String getNoSong(){
//        return "noSongs";
//    }


    @PostMapping("/addsong")
    public RedirectView addSong(@RequestParam String title, int length , int trackNumber , Long id , Model model){
        Album song = albumRepository.findById(id).get();
        List<Song> albumSongs = songRepository.findAllByAlbum(song);
        if (song.getSongCount() > albumSongs.size()){
            Song addNewSong = new Song(title , length , trackNumber , song);
            songRepository.save(addNewSong);
            return new RedirectView("/oneAlbum?id="+id) ;
        }else {
            return new RedirectView ("the album is full");
        }
    }

}
