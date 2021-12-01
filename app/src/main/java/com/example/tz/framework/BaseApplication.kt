package com.example.tz.framework

import android.app.Application
import com.example.tz.framework.di.ApplicationComponent
import com.example.tz.framework.di.DaggerApplicationComponent
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class BaseApplication : Application() {

    var appComponent: ApplicationComponent = DaggerApplicationComponent
        .factory()
        .create(
            application = this,
            applicationContext = this
        )


}