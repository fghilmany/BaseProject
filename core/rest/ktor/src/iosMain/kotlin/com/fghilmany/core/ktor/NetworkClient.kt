package com.fghilmany.core.ktor

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

actual val ktorHttpClient: HttpClient
    get() = HttpClient(Darwin) {

    }