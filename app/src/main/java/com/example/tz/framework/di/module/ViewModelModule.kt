package com.example.tz.framework.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tz.framework.di.ViewModelFactory
import com.example.tz.framework.di.ViewModelKey
import com.example.tz.framework.presentation.BalanceViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindVMFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BalanceViewModel::class)
    abstract fun bindViewModel(balanceViewModel: BalanceViewModel): BalanceViewModel

}