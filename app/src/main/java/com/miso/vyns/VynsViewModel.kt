package com.miso.vyns

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miso.vyns.model.VynsAlbum
import com.miso.vyns.network.VynsApi
import kotlinx.coroutines.launch

class VynsViewModel: ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _lstAlbums = MutableLiveData<List<VynsAlbum>>()
    val lstAlbums: LiveData<List<VynsAlbum>> = _lstAlbums

    private val _album = MutableLiveData<VynsAlbum>()
    val album: LiveData<VynsAlbum> = _album

    init {
        getVynsAlbums()
    }

    //private
    fun getVynsAlbums() {
        viewModelScope.launch {
            try {
                val listResult = VynsApi.retrofitService.getAlbums()
                _album.value=listResult[0]
                _lstAlbums.value=listResult
                _status.value = "Success: ${listResult.size} Vynilos Albums retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }

        }
    }
}