package com.evg_ivanoff.pizzashopnew.presentation.Menu.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evg_ivanoff.pizzashopnew.databinding.CategoryOneItemBinding

class CategoryItemAdapter(private val list: List<CategoryItem>) : RecyclerView.Adapter<CategoryItemAdapter.CategoryViewHolder>() {

//    private val list = mutableListOf<CategoryItem>()

    class CategoryViewHolder(private val binding: CategoryOneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryItem) {
            binding.btnCategory.textOn = item.name
            binding.btnCategory.textOff = item.name
            binding.btnCategory.isChecked = item.enabled
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CategoryOneItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

//    fun fillList() {
//        list.add(CategoryItem(0, "Pizza", false))
//        list.add(CategoryItem(1, "Combo", false))
//        list.add(CategoryItem(2, "Deserts", false))
//        list.add(CategoryItem(3, "Drinks", false))
//        notifyDataSetChanged()
//    }
}