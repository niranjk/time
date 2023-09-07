package com.niranjan.khatri.time

expect class Platform(){
    val operatingSystemName: String
    val operatingSystemVersion : String
    val cpuType : String
    val deviceModel : String
    val screenInfo : ScreenInfo?
    fun printSystemInfo()
}

expect class ScreenInfo(){
    val width : Int
    val height: Int
    val density: Int
}