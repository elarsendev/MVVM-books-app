package com.example.mvvmbook.base

import androidx.lifecycle.ViewModel
import com.example.mvvmbook.injection.component.DaggerViewModelInjector
import com.example.mvvmbook.injection.component.ViewModelInjector
import com.example.mvvmbook.injection.module.NetworkModule
import com.example.mvvmbook.ui.books.VolumeListViewModel

abstract class BaseViewModel: ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()


    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this){
            is VolumeListViewModel -> injector.inject(this)
        }
    }
}