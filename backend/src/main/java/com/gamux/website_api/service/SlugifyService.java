package com.gamux.website_api.service;

import org.springframework.stereotype.Service;

import com.github.slugify.Slugify;

@Service
public class SlugifyService {
    private final Slugify slugify = Slugify.builder().lowerCase(false).build();

    public String toSlug(String key) {
        return slugify.slugify(key);
    }
}
