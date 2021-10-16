package com.example.songr.repositories;

import com.example.songr.models.Album;
import com.example.songr.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song,Integer > {
    List<Song> findAllByAlbum(Album album);

}
