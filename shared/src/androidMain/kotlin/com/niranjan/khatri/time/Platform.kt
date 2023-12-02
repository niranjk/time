package com.niranjan.khatri.time

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.roundToInt

actual class Platform actual constructor(){
    actual val operatingSystemName = "Android"

    actual val operatingSystemVersion = "${Build.VERSION.SDK_INT}"
    actual val cpuType = "${Build.SUPPORTED_ABIS.firstOrNull() ?: "---"}"
    actual val deviceModel = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val screenInfo: ScreenInfo? = ScreenInfo()

    actual fun printSystemInfo() {
        Log.d(
            "Android Platform",
            "($operatingSystemName; $operatingSystemVersion; $deviceModel; $cpuType ;" +
                    "${screenInfo?.width}x${screenInfo?.height}x${screenInfo?.density} "
        )
    }

}

actual class ScreenInfo actual constructor(){

    private val metrics = Resources.getSystem().displayMetrics
    actual val width: Int = metrics.widthPixels
    actual val height: Int = metrics.heightPixels
    actual val density: Int = metrics.density.roundToInt()
}