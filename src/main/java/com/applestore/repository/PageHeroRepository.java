package com.applestore.repository;

import com.applestore.entity.PageHero;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageHeroRepository extends JpaRepository<PageHero, Long> {

    Optional<PageHero> findByPageSlug(String pageSlug);
}
