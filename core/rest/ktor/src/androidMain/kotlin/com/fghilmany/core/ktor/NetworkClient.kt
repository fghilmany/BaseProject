package com.fghilmany.core.ktor

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import co.touchlab.kermit.Logger as kermitLogger

@OptIn(ExperimentalSerializationApi::class)
actual val ktorHttpClient: HttpClient
    get() = HttpClient(OkHttp) {
        //Timeout plugin to set up timeout milliseconds for client
        install(HttpTimeout) {
            socketTimeoutMillis = 60_000
            requestTimeoutMillis = 60_000
        }
        //Logging plugin combined with kermit(KMP Logger library)
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
            logger = object: Logger {
                override fun log(message: String) {
                    kermitLogger.d(null , "KtorClient") {
                        message
                    }
                }
            }
        }
        //We can configure the BASE_URL and also
        //the deafult headers by defaultRequest builder
        defaultRequest {
            header("Content-Type", "application/json")
            header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMGEzMTk3ZTVjYTA4ZWVjMzA3ODMzNTdiMTgzMjk5OCIsInN1YiI6IjVjNGE5NjJlOTI1MTQxMGUxYjU3MDEzMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Eozsx0ksKNOFQgfnK46MsSRO8A4nmqsrAc3MjQpq4CM")
            url("https://api.themoviedb.org/3/")
        }
        //ContentNegotiation plugin for negotiationing media types between the client and server
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                explicitNulls = false
            })
        }
    }