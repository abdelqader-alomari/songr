package com.example.songr.repository;

import com.example.songr.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface SongrRepository extends CrudRepository<Album, Long> {

}
