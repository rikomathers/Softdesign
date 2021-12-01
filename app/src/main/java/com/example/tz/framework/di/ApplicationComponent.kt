package com.example.tz.framework.di

import android.app.Application
import android.content.Context
import com.example.tz.framework.MainFragmentFactory
import com.example.tz.framework.di.module.BalanceModule
import com.example.tz.framework.di.module.MainFragmentBuildersModule
import com.example.tz.framework.di.module.NetworkModule
import com.example.tz.framework.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Singleton

@InternalCoroutinesApi
@Singleton
@Component(
    modules = [
        NetworkModule::class,
        BalanceModule::class,
        ViewModelModule::class,
        MainFragmentBuildersModule::class
    ]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            @BindsInstance applicationContext: Context
        ): ApplicationComponent
    }
    fun provideMainFragmentFactory(): MainFragmentFactory
    @InternalCoroutinesApi
    fun mainComponent(): MainComponent.Factory
}