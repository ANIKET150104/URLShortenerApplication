package com.urlShortner.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urlShortner.entity.UrlMapping;

@Repository
public interface UrlRepository extends JpaRepository<UrlMapping, Long> {
    Optional<UrlMapping> findByShortUrl(String shortUrl);
}
