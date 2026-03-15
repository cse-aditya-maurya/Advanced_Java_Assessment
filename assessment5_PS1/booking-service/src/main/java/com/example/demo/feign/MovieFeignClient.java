package com.example.demo.feign;

import com.example.demo.model.Movie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "MOVIE-SERVICE")
public interface MovieFeignClient {

    @GetMapping("/movies/{id}")
    Movie getMovie(@PathVariable("id") int id);

}