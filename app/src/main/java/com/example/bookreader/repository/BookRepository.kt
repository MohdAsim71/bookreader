package com.example.bookreader.repository


import android.util.Log
import com.example.bookreader.data.Resource
import com.example.bookreader.model.Item
import com.example.bookreader.network.BooksApi
import com.example.bookreader.utils.Constants.TAG
import javax.inject.Inject
import kotlin.Exception

class BookRepository @Inject constructor(private val api: BooksApi) {
     suspend fun getBooks(searchQuery: String): Resource<List<Item>> {

          return try {
               Resource.Loading(data = true)

              val itemList = api.getAllBooks(searchQuery).items
               if (itemList.isNotEmpty()) Resource.Loading(data = false)
               Resource.Success(data = itemList)

          }catch (exception: Exception) {
               Log.e(TAG, "getBooks: ${exception.message.toString()}", )
               Resource.Error(message = exception.message.toString())
          }

     }

     suspend fun getBookInfo(bookId: String): Resource<Item> {
          val response = try {
               Resource.Loading(data = true)
               api.getBookInfo(bookId)

          }catch (exception: Exception){
               return Resource.Error(message = "An error occurred ${exception.message.toString()}")
          }
          Resource.Loading(data = false)
          return Resource.Success(data = response)
     }


}