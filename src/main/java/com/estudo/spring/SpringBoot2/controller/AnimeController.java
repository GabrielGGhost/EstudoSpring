package com.estudo.spring.SpringBoot2.controller;

import com.estudo.spring.SpringBoot2.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estudo.spring.SpringBoot2.domain.Anime;
import com.estudo.spring.SpringBoot2.util.DateUtil;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    private DateUtil dtUtil = new DateUtil();

    @GetMapping
    public List<Anime> list(){
        log.info(dtUtil.toDBDate(LocalDateTime.now()));
        final AnimeService animeService = new AnimeService();
        
        return animeService.listAll();
    }


}
