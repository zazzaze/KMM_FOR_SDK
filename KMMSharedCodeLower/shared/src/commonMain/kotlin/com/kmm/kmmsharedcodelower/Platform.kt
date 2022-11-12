package com.kmm.kmmsharedcodelower

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform