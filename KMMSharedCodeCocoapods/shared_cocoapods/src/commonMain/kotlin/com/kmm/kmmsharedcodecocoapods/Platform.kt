package com.kmm.kmmsharedcodecocoapods

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform