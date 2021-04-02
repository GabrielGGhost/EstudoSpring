package com.estudo.spring.SpringBoot2.controller;

import com.estudo.spring.SpringBoot2.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.estudo.spring.SpringBoot2.domain.Anime;

import javax.xml.ws.Response;
import java.util.List;


@RestController
@RequestMapping("/animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    final AnimeService animeService = new AnimeService();

    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id){
        return ResponseEntity.ok(animeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody Anime anime){
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }
}
