package com.evg_ivanoff.pizzashopnew.presentation.Menu.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryViewModel: ViewModel() {

    val categories = MutableLiveData<List<CategoryItem>>()

    init {
        val list = listOf<CategoryItem>(
            CategoryItem(0, "Pizza", false),
            CategoryItem(1, "Combo", false),
            CategoryItem(2, "Deserts", false),
            CategoryItem(3, "Drinks", false)
        )
        categories.value = list
    }
}