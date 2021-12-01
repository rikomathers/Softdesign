package com.example.tz.framework.di.module

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.tz.framework.MainFragment
import com.example.tz.framework.MainFragmentFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import de.ordersmart.portal.framework.app.di.main.keys.MainFragmentKey
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@Module
abstract class MainFragmentBuildersModule {

    @Binds
    abstract fun bindFragmentFactory(mainFragmentFactory: MainFragmentFactory): FragmentFactory


    @Binds
    @IntoMap
    @MainFragmentKey(MainFragment::class)
    abstract fun bindAggregatorFragment(aggregatorFragment: MainFragment): Fragment
}