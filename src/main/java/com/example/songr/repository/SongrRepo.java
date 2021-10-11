package com.example.songr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SongerRepo extends CrudRepository<Album, Long> {

}
