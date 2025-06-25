package com.devmasterteam.mybooks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.devmasterteam.mybooks.entity.BookEntity
import com.devmasterteam.mybooks.repository.BookRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    // Acesso a dados
    private val repository = BookRepository.getInstance(application.applicationContext)

    //Busca todos os livros
    val bookList: LiveData<List<BookEntity>> = repository.getAllBooks().asLiveData()

    /**
     * Atualiza boolean de favorito
     * */
    fun favorite(bookId: Int) {

        viewModelScope.launch {
            // Atualiza boolean de favorito
            repository.toggleFavoriteStatus(bookId)
        }
    }

}