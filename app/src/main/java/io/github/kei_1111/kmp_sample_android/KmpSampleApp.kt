package io.github.kei_1111.kmp_sample_android

import android.app.Application
import io.github.kei_1111.kmp_sample_library.di.initKoin

class KmpSampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(this)
    }
}