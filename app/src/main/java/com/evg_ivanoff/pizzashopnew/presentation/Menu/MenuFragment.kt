package com.evg_ivanoff.pizzashopnew.presentation.Menu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.evg_ivanoff.pizzashopnew.databinding.FragmentMenuBinding
import com.evg_ivanoff.pizzashopnew.presentation.Menu.category.CategoryItem
import com.evg_ivanoff.pizzashopnew.presentation.Menu.category.CategoryItemAdapter
import com.google.android.material.snackbar.Snackbar

class MenuFragment : Fragment(), CategoryItemAdapter.OnItemClickListener {

    private val categories = listOf<CategoryItem>(
        CategoryItem(0, "Pizza", false),
        CategoryItem(1, "Combo", false),
        CategoryItem(2, "Deserts", false),
        CategoryItem(3, "Drinks", false)
    )
    private lateinit var adapter: CategoryItemAdapter

    private var _binding: FragmentMenuBinding? = null
    val binding: FragmentMenuBinding
        get() = _binding ?: throw RuntimeException("FragmentMenuBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvMenuCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter = CategoryItemAdapter(categories.sorted(), this@MenuFragment)
        binding.rvMenuCategory.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance(): MenuFragment {
            return MenuFragment()
        }
    }

    override fun onItemClick(item: CategoryItem) {
        categories[item.id].enabled = categories[item.id].enabled != true
        adapter.sortByEnabled(categories.sortedWith(compareBy({ !it.enabled }, { it.name })))
    }
}