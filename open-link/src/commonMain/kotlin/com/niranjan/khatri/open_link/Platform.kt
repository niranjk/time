package com.niranjan.khatri.open_link

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform