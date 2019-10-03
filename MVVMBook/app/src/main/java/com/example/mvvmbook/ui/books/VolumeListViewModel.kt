package com.example.mvvmbook.ui.books

import com.example.mvvmbook.base.BaseViewModel
import com.example.mvvmbook.network.VolumeApi
import javax.inject.Inject

class VolumeListViewModel:BaseViewModel() {
    @Inject
    lateinit var volumeApi: VolumeApi
}