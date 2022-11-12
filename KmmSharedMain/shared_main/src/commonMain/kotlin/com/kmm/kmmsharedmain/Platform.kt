package com.kmm.kmmsharedmain

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform