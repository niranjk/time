package com.niranjan.khatri.open_link

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

public actual object Linker {

    public actual fun openLink(url: String) {
        val application = UIApplication.sharedApplication
        val nsurl = NSURL(string = url)
        if (!application.canOpenURL(nsurl)) {
            println("Unable to open url: $url")
            return
        }

        application.openURL(nsurl)
    }
}