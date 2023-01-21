package com.example.kmptemplate

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}