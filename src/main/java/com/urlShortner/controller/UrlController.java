package com.urlShortner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.urlShortner.service.UrlService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "REST APIs of the Application")
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> shorten(@RequestParam String url) {
        return ResponseEntity.ok(urlService.shortenUrl(url));
    }

    @GetMapping("/{shortUrl}")
    public RedirectView redirect(@PathVariable String shortUrl) {
        String original = urlService.getOriginalUrl(shortUrl);
        return new RedirectView(original);
    }
}