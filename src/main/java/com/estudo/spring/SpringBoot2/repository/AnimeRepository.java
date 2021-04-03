package com.estudo.spring.SpringBoot2.repository;

import com.estudo.spring.SpringBoot2.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
