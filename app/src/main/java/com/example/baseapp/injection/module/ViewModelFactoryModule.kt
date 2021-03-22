package com.example.baseapp.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.baseapp.injection.scope.ViewModelScope
import com.example.baseapp.ui.home.HomeVM
import com.example.baseapp.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

  @Binds
  abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory) : ViewModelProvider.Factory

  @Binds
  @IntoMap
  @ViewModelScope(HomeVM::class)
  abstract fun bindHomeVM(homeVM: HomeVM) : ViewModel
}