package com.example.bookreader.screens.search

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookreader.data.Resource
import com.example.bookreader.model.Item
import com.example.bookreader.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksSearchViewModel @Inject constructor(private val repository: BookRepository)
    : ViewModel() {
        var list: List<Item> by mutableStateOf(listOf())
      var isLoading: Boolean by mutableStateOf(true)
    init {
        loadBooks()
    }

    private fun loadBooks() {
        searchBooks("android")
    }

     fun searchBooks(query: String) {
        viewModelScope.launch(Dispatchers.Default) {

             if (query.isEmpty()){
                 return@launch
             }
            val response = repository.getBooks(query)
            Log.e("DATA", "${response.data}", )

            try {
                when(val response = repository.getBooks(query)) {
                     is Resource.Success -> {
                          list = response.data!!
                         if (list.isNotEmpty()) isLoading = false
                         Log.e("NetworkData", "$list", )

                     }
                    is Resource.Error -> {
                        isLoading = false
                        Log.e("Network", "searchBooks: Failed getting books", )
                    }
                    else -> {isLoading = false}
                }

            }catch (exception: Exception){
                isLoading = false
                Log.d("Network", "searchBooks: ${exception.message.toString()}")
            }

        }


    }


}