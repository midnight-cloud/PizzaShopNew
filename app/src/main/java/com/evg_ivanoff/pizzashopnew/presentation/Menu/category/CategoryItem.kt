package com.evg_ivanoff.pizzashopnew.presentation.Menu.category

data class CategoryItem(
    val id: Int,
    val name: String,
    var enabled: Boolean
): Comparable<CategoryItem> {
    override fun compareTo(other: CategoryItem): Int = name.compareTo(other.name)
}
