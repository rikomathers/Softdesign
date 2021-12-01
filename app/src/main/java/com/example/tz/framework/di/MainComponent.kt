package com.example.tz.framework.di

import com.example.tz.framework.MainNavHostFragment
import com.example.tz.framework.di.module.BalanceModule
import com.example.tz.framework.di.module.MainFragmentBuildersModule
import com.example.tz.framework.di.module.NetworkModule
import com.example.tz.framework.di.module.ViewModelModule
import dagger.Subcomponent
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Singleton

@InternalCoroutinesApi
@Subcomponent(
    modules = [
        NetworkModule::class,
        BalanceModule::class,
        ViewModelModule::class,
        MainFragmentBuildersModule::class
    ]
)
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): MainComponent
    }

    fun inject(mainNavHostFragment: MainNavHostFragment)

}