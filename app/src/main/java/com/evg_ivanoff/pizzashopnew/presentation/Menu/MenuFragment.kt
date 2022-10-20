package com.evg_ivanoff.pizzashopnew.presentation.Menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.evg_ivanoff.pizzashopnew.databinding.FragmentMenuBinding
import com.evg_ivanoff.pizzashopnew.presentation.Menu.banner.BannerItemAdapter
import com.evg_ivanoff.pizzashopnew.presentation.Menu.category.CategoryItem
import com.evg_ivanoff.pizzashopnew.presentation.Menu.category.CategoryItemAdapter
import com.evg_ivanoff.pizzashopnew.presentation.Menu.category.CategoryViewModel

class MenuFragment : Fragment(), CategoryItemAdapter.OnItemClickListener {

    private lateinit var adapter_categories: CategoryItemAdapter
    private lateinit var adapter_banners: BannerItemAdapter
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
            it?.let { adapter_categories.submitList(it.sortedBy { it.name }) }
        }
        setupRecyclerCategories()
        setupRecyclerBunners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerCategories() {
        binding.rvMenuCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter_categories = CategoryItemAdapter(this@MenuFragment)
        binding.rvMenuCategory.adapter = adapter_categories
    }

    private fun setupRecyclerBunners() {
        binding.rvBannerMain.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter_banners = BannerItemAdapter()
        binding.rvBannerMain.adapter = adapter_banners
    }

    companion object {

        fun newInstance(): MenuFragment {
            return MenuFragment()
        }
    }

    override fun onItemClick(item: CategoryItem) {
        categoryViewModel.categories.value?.get(item.id)?.enabled =
            categoryViewModel.categories.value?.get(item.id)?.enabled != true
        adapter_categories.sortByEnabled(categoryViewModel.categories.value!!.sortedWith(compareBy({ !it.enabled }, { it.name })))
    }

    //TODO: при переходе на другой фрагмент и возврате обратно на мейн, пропадают категории
}