package com.estudo.spring.SpringBoot2.service;

import com.estudo.spring.SpringBoot2.domain.Anime;
import com.estudo.spring.SpringBoot2.repository.AnimeRepository;
import com.estudo.spring.SpringBoot2.requests.AnimePostRequestBody;
import com.estudo.spring.SpringBoot2.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;
    public List<Anime> listAll(){
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadException(long id){
        Anime anime = animeRepository.findById(id)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
        return anime;
    }

    public Anime save(AnimePostRequestBody anime) {
        return animeRepository.save(Anime.builder().name(anime.getName()).build());
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadException(id));
    }

    public void replace(AnimePutRequestBody anime) {
        Anime savedAnime = findByIdOrThrowBadException(anime.getId());
        animeRepository.save(Anime.builder()
                                .id(anime.getId())
                                .name(anime.getName())
                                .build());
    }
}
