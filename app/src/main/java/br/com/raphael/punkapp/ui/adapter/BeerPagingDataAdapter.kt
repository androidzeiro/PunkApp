package br.com.raphael.punkapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.raphael.punkapp.data.model.response.BeerResponse
import br.com.raphael.punkapp.databinding.ItemBeerBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy

class BeerPagingDataAdapter(
    private val clickListener: (beer: BeerResponse) -> Unit
) : PagingDataAdapter<BeerResponse, BeerPagingDataAdapter.BeerViewHolder>(BeerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        return BeerViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(item, clickListener)
        }
    }

    class BeerViewHolder private constructor(
        private val binding: ItemBeerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(beer: BeerResponse, clickListener: (beer: BeerResponse) -> Unit) {
            binding.apply {
                Glide
                    .with(binding.imageBeer)
                    .load(beer.imageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .dontTransform()
                    .dontAnimate()
                    .into(binding.imageBeer)
                textName.text = beer.name
                textTagline.text = beer.tagline
                buttonShowDetail.setOnClickListener {
                    clickListener.invoke(beer)
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): BeerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemBeerBinding.inflate(layoutInflater, parent, false)
                return BeerViewHolder(binding)
            }
        }
    }
}

class BeerDiffCallback : DiffUtil.ItemCallback<BeerResponse>() {
    override fun areItemsTheSame(
        oldItem: BeerResponse,
        newItem: BeerResponse
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: BeerResponse,
        newItem: BeerResponse
    ): Boolean {
        return oldItem.id == newItem.id
    }
}