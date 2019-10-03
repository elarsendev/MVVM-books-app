package com.example.mvvmbook.injection.component

import com.example.mvvmbook.injection.module.NetworkModule
import com.example.mvvmbook.ui.books.VolumeListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified VolumeListViewModel.
     * @param volumeListViewModel VolumeListViewModel in which to inject the dependencies
     */
    fun inject(volumeListViewModel: VolumeListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}
