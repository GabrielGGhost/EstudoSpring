package com.estudo.spring.SpringBoot2.service;

import com.estudo.spring.SpringBoot2.domain.Anime;
import com.estudo.spring.SpringBoot2.repository.AnimeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
public class AnimeService {

    List<Anime> animes = Arrays.asList(new Anime(1L,"One Piece"),
            new Anime(2L,"Demon Slayer"),
            new Anime(3L,"One Punch Man"),
            new Anime(4L,"Pokemon"));

    public List<Anime> listAll(){
        return animes;
    }

    public Anime findById(long id){
        return animes.stream()
                .filter(anime-> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }
}
