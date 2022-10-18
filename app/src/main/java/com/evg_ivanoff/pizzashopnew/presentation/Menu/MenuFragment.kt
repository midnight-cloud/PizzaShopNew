package com.evg_ivanoff.pizzashopnew.presentation.Menu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.evg_ivanoff.pizzashopnew.databinding.FragmentMenuBinding
import com.evg_ivanoff.pizzashopnew.presentation.Menu.category.CategoryItem
import com.evg_ivanoff.pizzashopnew.presentation.Menu.category.CategoryItemAdapter
import com.evg_ivanoff.pizzashopnew.presentation.Menu.category.CategoryViewModel
import com.google.android.material.snackbar.Snackbar

class MenuFragment : Fragment(), CategoryItemAdapter.OnItemClickListener {

    private lateinit var adapter: CategoryItemAdapter
    private val categoryViewModel: CategoryViewModel by activityViewModels()

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

        categoryViewModel.categories.observe(activity as LifecycleOwner) {
            it?.let { adapter.submitList(it.sortedBy { it.name }) }
        }
        setupRecyclerCategories()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerCategories() {
        binding.rvMenuCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter = CategoryItemAdapter(this@MenuFragment)
        binding.rvMenuCategory.adapter = adapter
    }

    companion object {

        fun newInstance(): MenuFragment {
            return MenuFragment()
        }
    }

    override fun onItemClick(item: CategoryItem) {
        categoryViewModel.categories.value?.get(item.id)?.enabled =
            categoryViewModel.categories.value?.get(item.id)?.enabled != true
        adapter.sortByEnabled(categoryViewModel.categories.value!!.sortedWith(compareBy({ !it.enabled }, { it.name })))
    }
}