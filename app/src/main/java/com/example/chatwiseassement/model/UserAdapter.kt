package com.example.chatwiseassement.model

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chatwiseassement.databinding.ItemsBinding

class UserAdapter(val context: Context): RecyclerView.Adapter<UserAdapter.ItemsBindingView>() {
    lateinit var items:((UserItem) -> Unit)
    private var useritems=ArrayList<UserItem>()

    fun getMovieItems( movieItems:List<UserItem>){
        this.useritems=movieItems as ArrayList<UserItem>
        notifyDataSetChanged()
    }
    class ItemsBindingView(val binding: ItemsBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsBindingView {
        return ItemsBindingView(ItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemsBindingView, position: Int) {
        val data=useritems[position]
        Glide.with(context)
            .load(data.url)
            .into(holder.binding.image)

        holder.itemView.setOnClickListener {
            items.invoke(data)
        }


    }

    override fun getItemCount(): Int {
        return useritems.size
    }
}