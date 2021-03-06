package com.example.tdbmkotlin.ui.tvshows

import android.content.Intent
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tdbmkotlin.data.Repository
import com.example.tdbmkotlin.mappers.presentation.TvShowPresentationMapper
import com.example.tdbmkotlin.model.presentation.TvShowPresentation
import com.example.tdbmkotlin.ui.MainActivity
import com.keepcoding.imgram.Properties
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(private val repository: Repository,
                                          private val mapper: TvShowPresentationMapper): ViewModel(){

    /** Properties **/
    private val _images: MutableLiveData<List<TvShowPresentation>> by lazy {
        MutableLiveData<List<TvShowPresentation>>()
    }
    val images: MutableLiveData<List<TvShowPresentation>> get() = _images

    /** initialization **/
    init {
        getTvShows()
    }

    /** Private Functions **/
    private fun getTvShows(){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                repository.getTvShows()
            }
            val sortedResult= result.sortedByDescending { it.voted }
            _images.postValue(mapper.mapDataToPresentation(sortedResult))
        }
    }

}
