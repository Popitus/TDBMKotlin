package com.example.tdbmkotlin.ui.detail

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tdbmkotlin.data.Repository
import com.example.tdbmkotlin.mappers.presentation.TvShowPresentationMapper
import com.example.tdbmkotlin.model.presentation.TvShowPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class TvShowDetailViewModel @Inject constructor(private val repository: Repository,
                                                private val mapper: TvShowPresentationMapper): ViewModel() {

    /** Properties **/
    private val _images: MutableLiveData<TvShowPresentation> by lazy {
        MutableLiveData<TvShowPresentation>()
    }
    val images: MutableLiveData<TvShowPresentation> get() = _images

    private val _imagesRecommendation: MutableLiveData<List<TvShowPresentation>> by lazy {
        MutableLiveData<List<TvShowPresentation>>()
    }
    val imagesRecommendation: MutableLiveData<List<TvShowPresentation>> get() = _imagesRecommendation

    private var coroutine: Job? = null

    /** Functions **/
    fun getTvShowById(id: Long) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getTvShowRecommendationById(id)
                repository.getTvShowById(id)
            }
            _images.postValue(mapper.mapNetWorkToPresentation(result))
        }
    }

    fun getTvShowRecommendationById(id: Long) {
        viewModelScope.launch {
            val result = async(Dispatchers.IO) {
                return@async repository.getTvShowRecommendationById(id)
            }
            _imagesRecommendation.postValue(mapper.mapNetWorkToPresentation(result.await()))
        }
    }

    fun launch(context: AppCompatActivity) {


    }




}