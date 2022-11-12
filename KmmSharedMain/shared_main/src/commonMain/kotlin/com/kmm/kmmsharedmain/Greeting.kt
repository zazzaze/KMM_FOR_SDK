package com.kmm.kmmsharedmain

class Greeting {
    private val platform: Platform = getPlatform()

    fun greeting(): String {
        return "Hello, ${platform.name} from shared main!"
    }
}