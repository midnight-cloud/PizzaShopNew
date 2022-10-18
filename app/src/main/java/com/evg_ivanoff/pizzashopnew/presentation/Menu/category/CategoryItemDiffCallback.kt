package com.evg_ivanoff.pizzashopnew.presentation.Menu.category

import androidx.recyclerview.widget.DiffUtil

class CategoryItemDiffCallback: DiffUtil.ItemCallback<CategoryItem>() {
    override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
        return oldItem == newItem
    }
}