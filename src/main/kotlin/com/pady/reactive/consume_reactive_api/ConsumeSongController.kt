package com.pady.reactive.consume_reactive_api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import java.time.Duration

@RestController
class ConsumeSongController {

    @GetMapping("/consume")
    fun consumeAll() {
        val response = WebClient.builder()
            .baseUrl(SONGS_URL)
            .build()
            .get()
            .retrieve()
            .bodyToFlux(Map::class.java)
        response.subscribe { song ->
            println(song)
        }
    }

    @GetMapping("/consume-only-two")
    fun consumeOnlyTwo() {
        val response = WebClient.builder()
            .baseUrl(SONGS_URL)
            .build()
            .get()
            .retrieve()
            .bodyToFlux(Map::class.java)
        response.take(2).subscribe { song ->
            println(song)
        }
    }

    @GetMapping("/consume-for-five-seconds")
    fun consumeForFiveSeconds() {
        val response = WebClient.builder()
            .baseUrl(SONGS_URL)
            .build()
            .get()
            .retrieve()
            .bodyToFlux(Map::class.java)
        response.take(Duration.ofSeconds(5)).subscribe { song ->
            println(song)
        }
    }

}

private const val SONGS_URL = "http://127.0.0.1:8080/song/hola"
