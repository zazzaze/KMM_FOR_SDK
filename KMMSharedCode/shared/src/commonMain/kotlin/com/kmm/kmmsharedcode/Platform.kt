package com.kmm.kmmsharedcode

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform