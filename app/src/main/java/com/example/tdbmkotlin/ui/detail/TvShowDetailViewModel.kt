package com.example.tdbmkotlin.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tdbmkotlin.data.Repository
import com.example.tdbmkotlin.mappers.presentation.TvShowPresentationMapper
import com.example.tdbmkotlin.model.presentation.TvShowPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TvShowDetailViewModel @Inject constructor(private val repository: Repository,
                                                private val mapper: TvShowPresentationMapper): ViewModel() {

    /** Properties **/
    private val _images: MutableLiveData<List<TvShowPresentation>> by lazy {
        MutableLiveData<List<TvShowPresentation>>()
    }
    val images: MutableLiveData<List<TvShowPresentation>> get() = _images

    /** Functions **/
    fun getTvShowById(id: Long) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                //TODO: llamada a repositorio
                repository.getTvShowById(id)
            }
            //TODO: Recogida de datos
            _images.postValue(mapper.mapNetWorkToPresentation(result))

        }
    }


}