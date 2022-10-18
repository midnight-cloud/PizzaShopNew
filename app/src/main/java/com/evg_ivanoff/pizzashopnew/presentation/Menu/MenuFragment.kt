package com.evg_ivanoff.pizzashopnew.presentation.Menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.evg_ivanoff.pizzashopnew.databinding.FragmentMenuBinding
import com.evg_ivanoff.pizzashopnew.presentation.Menu.category.CategoryItem
import com.evg_ivanoff.pizzashopnew.presentation.Menu.category.CategoryItemAdapter

class MenuFragment : Fragment() {

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

        val categories = listOf<CategoryItem>(
            CategoryItem(0, "Pizza", false),
            CategoryItem(1, "Combo", false),
            CategoryItem(2, "Deserts", false),
            CategoryItem(3, "Drinks", false)
        )
        binding.rvMenuCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvMenuCategory.adapter = CategoryItemAdapter(categories)
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
}