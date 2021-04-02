package com.estudo.spring.SpringBoot2.service;

import com.estudo.spring.SpringBoot2.domain.Anime;
import com.estudo.spring.SpringBoot2.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AnimeService {

    public List<Anime> listAll(){
        return Arrays.asList(new Anime(1L,"One Piece"),
                new Anime(2L,"Demon Slayer"),
                new Anime(3L,"One Punch Man"),
                new Anime(4L,"Pokemon"));
    }
}
