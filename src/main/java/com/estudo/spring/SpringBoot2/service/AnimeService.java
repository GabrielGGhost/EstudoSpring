package com.estudo.spring.SpringBoot2.service;

import com.estudo.spring.SpringBoot2.domain.Anime;
import com.estudo.spring.SpringBoot2.repository.AnimeRepository;
import com.estudo.spring.SpringBoot2.requests.AnimePostRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;
    public List<Anime> listAll(){
        return animeRepository.findAll();
    }

    public Anime findById(long id){
        return animeRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public Anime save(AnimePostRequestBody anime) {
        return animeRepository.save(Anime.builder().name(anime.getName()).build());
    }

    public void delete(long id) {
        animeRepository.delete(findById(id));
    }

    public void replace(Anime anime) {
        animeRepository.save(anime);
        delete(anime.getId());
    }
}
