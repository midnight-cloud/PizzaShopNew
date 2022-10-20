package com.evg_ivanoff.pizzashopnew.presentation.Menu.banner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.evg_ivanoff.pizzashopnew.R
import com.evg_ivanoff.pizzashopnew.databinding.BannerOneItemBinding

class BannerItemAdapter : RecyclerView.Adapter<BannerItemAdapter.BannerViewHolder>() {
    private val bunnerList = listOf<BannerItem>(
        BannerItem(0, "banner_1", R.drawable.bunner),
        BannerItem(1, "banner_2", R.drawable.bunner),
        BannerItem(2, "banner_3", R.drawable.bunner)
    )

    class BannerViewHolder(private val binding: BannerOneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: BannerItem) {
                binding.bunnerImage.load(item.recourceId)
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = BannerOneItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(bunnerList[position])
    }

    override fun getItemCount() = bunnerList.size
}