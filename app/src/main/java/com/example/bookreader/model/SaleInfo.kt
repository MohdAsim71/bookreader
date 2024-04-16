package com.example.bookreader.model

import com.example.bookreader.model.ListPrice
import com.example.bookreader.model.Offer
import com.example.bookreader.model.RetailPriceX

data class SaleInfo(
    val buyLink: String,
    val country: String,
    val isEbook: Boolean,
    val listPrice: ListPrice,
    val offers: List<Offer>,
    val retailPrice: RetailPriceX,
    val saleability: String
)