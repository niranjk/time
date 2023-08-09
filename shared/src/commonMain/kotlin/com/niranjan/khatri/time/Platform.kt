package com.niranjan.khatri.time

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform