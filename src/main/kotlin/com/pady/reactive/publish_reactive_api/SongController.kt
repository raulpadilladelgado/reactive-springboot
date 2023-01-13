package com.pady.reactive.publish_reactive_api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration.ofSeconds


@RestController
class SongController {

    @Autowired
    private lateinit var songRepository: SongRepository

    @GetMapping(value = ["/song/{name}"], produces = [TEXT_EVENT_STREAM_VALUE])
    fun getUserById(@PathVariable name: String): Flux<Song> {
        return songRepository.findAll().delayElements(ofSeconds(3))
    }

    @PostMapping("/song")
    fun saveSong(@RequestBody song: Song): Mono<Song> {
        return songRepository.save(song)
    }

}