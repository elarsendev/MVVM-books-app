package com.example.mvvmbook.ui.books

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.mvvmbook.base.BaseViewModel
import com.example.mvvmbook.network.VolumeApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class VolumeListViewModel:BaseViewModel() {
    @Inject
    lateinit var volumeApi: VolumeApi

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init {
        loadVolumes()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadVolumes() {
        subscription = volumeApi.getVolumesSearch("cars")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{onRetrieveVolumeListStart()}
            .doOnTerminate{onRetrieveVolumeListFinish()}
            .subscribe(
                {onRetrieveVolumeListSuccess()},
                {onRetrieveVolumeListError()}
            )
    }

    private fun onRetrieveVolumeListStart(){
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrieveVolumeListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveVolumeListSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun onRetrieveVolumeListError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}