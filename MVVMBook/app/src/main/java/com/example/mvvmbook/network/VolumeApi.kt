package com.example.mvvmbook.network

import com.example.mvvmbook.model.Volume
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface VolumeApi {

    /**
     * Get the list of volumes by a search
     */
    @GET("/volumes")
    fun getVolumesSearch(@Query("q") search: String): Observable<List<Volume>>

}