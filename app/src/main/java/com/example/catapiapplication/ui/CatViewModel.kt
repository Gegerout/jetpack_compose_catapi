package com.example.catapiapplication.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.catapiapplication.CatApp
import com.example.catapiapplication.data.Breeds
import com.example.catapiapplication.data.CatRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface CatUIState {
    data class Success(val breeds: List<Breeds>) : CatUIState
    object Error : CatUIState
    object Loading : CatUIState
}

class CatViewModel(private val catRepository: CatRepository) : ViewModel() {
    var catUIState: CatUIState by mutableStateOf(CatUIState.Loading)
        private set

    init {
        getBreeds()
    }

    fun getBreeds(limit: Int = 30, page: Int = 0) {
        viewModelScope.launch {
            catUIState = CatUIState.Loading
            catUIState = try {
                CatUIState.Success(catRepository.getBreeds(limit, page))
            } catch (e: IOException) {
                CatUIState.Error
            } catch (e: HttpException) {
                CatUIState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as CatApp)
                val catRepository = application.container.catRepository
                CatViewModel(catRepository = catRepository)
            }
        }
    }
}