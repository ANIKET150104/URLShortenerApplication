package com.urlShortner.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.urlShortner.entity.UrlMapping;
import com.urlShortner.repo.UrlRepository;

@Service
public class UrlService {
    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public String shortenUrl(String originalUrl) {
        String base62 = Base64.getUrlEncoder().encodeToString(originalUrl.getBytes(StandardCharsets.UTF_8));
        base62 = base62.substring(0, 8); // limit length
        UrlMapping mapping = new UrlMapping();
        mapping.setShortUrl(base62);
        mapping.setOriginalUrl(originalUrl);
        repository.save(mapping);
        return base62;
    }

    public String getOriginalUrl(String shortUrl) {
        UrlMapping mapping = repository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
        mapping.setClickCount(mapping.getClickCount() + 1);
        repository.save(mapping);
        return mapping.getOriginalUrl();
    }
}