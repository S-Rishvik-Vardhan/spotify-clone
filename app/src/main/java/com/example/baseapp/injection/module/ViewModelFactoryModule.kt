package com.example.baseapp.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.baseapp.injection.scope.ViewModelKey
import com.example.baseapp.ui.auth.login.LoginVM
import com.example.baseapp.ui.auth.signup.SignUpVM
import com.example.baseapp.ui.home.HomeVM
import com.example.baseapp.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

  @Binds
  abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

  @Binds
  @IntoMap
  @ViewModelKey(HomeVM::class)
  abstract fun bindHomeVM(homeVM: HomeVM): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(LoginVM::class)
  abstract fun bindLoginVM(loginVM: LoginVM): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(SignUpVM::class)
  abstract fun bindSignUpVM(signUpVM: SignUpVM): ViewModel

}