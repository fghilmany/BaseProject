package com.fghilmany.core.ktor

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform