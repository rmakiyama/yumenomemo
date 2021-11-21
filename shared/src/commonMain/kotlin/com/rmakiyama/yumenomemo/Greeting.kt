package com.rmakiyama.yumenomemo

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}