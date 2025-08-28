package com.alxnophis.kmpmovies

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val isDebug: Boolean = BuildConfig.DEBUG
}

actual fun getPlatform(): Platform = AndroidPlatform()
