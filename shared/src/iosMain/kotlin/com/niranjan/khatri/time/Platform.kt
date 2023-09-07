package com.niranjan.khatri.time

import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import platform.CoreGraphics.CGRectGetHeight
import platform.CoreGraphics.CGRectGetWidth
import platform.Foundation.NSLog
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.stringWithCString
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceIdiomPad
import platform.UIKit.UIUserInterfaceIdiomPhone
import platform.posix.uname
import platform.posix.utsname

actual class Platform actual constructor(){
    actual val operatingSystemName = when (UIDevice.currentDevice.userInterfaceIdiom){
        UIUserInterfaceIdiomPhone -> "iOS"
        UIUserInterfaceIdiomPad -> "iPadOS"
        else -> kotlin.native.Platform.osFamily.name
    }
    actual val operatingSystemVersion = UIDevice.currentDevice.systemVersion
    actual val cpuType: String = kotlin.native.Platform.cpuArchitecture.name
    actual val deviceModel: String
        get(){
            memScoped {
                val systemInfo: utsname = alloc()
                uname(systemInfo.ptr)
                return NSString.stringWithCString(systemInfo.machine, encoding = NSUTF8StringEncoding) ?: "---"
            }
        }
    actual val screenInfo: ScreenInfo? = ScreenInfo()

    actual fun printSystemInfo() {
        NSLog(
            "($operatingSystemName; $operatingSystemVersion; $cpuType ; $deviceModel;" +
                    "${screenInfo?.width}x${screenInfo?.height}x${screenInfo?.density})"
        )
    }

}

actual class ScreenInfo actual constructor(){

    actual val width: Int = CGRectGetWidth(UIScreen.mainScreen.nativeBounds).toInt()
    actual val height: Int = CGRectGetHeight(UIScreen.mainScreen.nativeBounds).toInt()
    actual val density: Int = UIScreen.mainScreen.scale.toInt()

}