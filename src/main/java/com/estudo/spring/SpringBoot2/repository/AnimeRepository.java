package com.estudo.spring.SpringBoot2.repository;

import com.estudo.spring.SpringBoot2.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
