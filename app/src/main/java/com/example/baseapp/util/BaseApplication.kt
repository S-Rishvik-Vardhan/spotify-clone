package com.example.baseapp.util

import com.example.baseapp.injection.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {
  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerAppComponent.factory().create(this, applicationContext)
  }
}