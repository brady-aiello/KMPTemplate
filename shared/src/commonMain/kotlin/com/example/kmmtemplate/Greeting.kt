package com.example.kmmtemplate

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}