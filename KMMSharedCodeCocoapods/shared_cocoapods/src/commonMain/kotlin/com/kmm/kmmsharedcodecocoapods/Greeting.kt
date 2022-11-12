package com.kmm.kmmsharedcodecocoapods

class Greeting {
    private val platform: Platform = getPlatform()

    fun greeting(): String {
        return "Hello, ${platform.name} from shared_cocoapods!"
    }
}