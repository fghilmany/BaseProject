package com.fghilmany.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform