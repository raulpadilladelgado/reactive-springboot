package com.pady.reactive.publish_reactive_api

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface SongRepository : R2dbcRepository<Song, Int>
