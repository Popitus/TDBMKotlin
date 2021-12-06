package com.example.tdbmkotlin.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tdbmkotlin.data.Repository
import com.example.tdbmkotlin.mappers.presentation.MoviePresentationMapper
import com.example.tdbmkotlin.model.presentation.MoviePresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: Repository,
                                         private val mapper: MoviePresentationMapper): ViewModel() {

    /** Properties **/
    private val _images: MutableLiveData<List<MoviePresentation>> by lazy {
        MutableLiveData<List<MoviePresentation>>()
    }
    val images: MutableLiveData<List<MoviePresentation>> get() = _images

    /** initialization **/
    init {
        getPopularMovies()
    }

    /** Functions **/
    private fun getPopularMovies(){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                repository.getPopularMovies()
            }
            val sortedResult = result.sortedByDescending { it.popularity }
            _images.postValue(mapper.mapDataToPresentation(sortedResult))
        }
    }

}