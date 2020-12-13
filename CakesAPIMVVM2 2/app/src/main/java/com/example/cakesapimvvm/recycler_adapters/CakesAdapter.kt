package com.example.cakesapimvvm.recycler_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cakesapimvvm.R
import com.example.cakesapimvvm.database.DatabaseCake
import com.example.cakesapimvvm.databinding.RowCakeBinding

class CakesAdapter: RecyclerView.Adapter<CakesAdapter.CakesViewHolder>() {
    private var viewmodelAdapter: CakesAdapter? = null

    // CREATE THE VIEW HOLDER FOR CAKES BELOW

    var results: List<DatabaseCake> = emptyList()
    set(value){
        field = value
        // CAKES  FILTER LIST WITH TITLE,ETC REQUIRED HERE
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesViewHolder {
        val withDataBinding: RowCakeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CakesViewHolder.LAYOUT,
            parent,
            false
        )
            return CakesViewHolder(withDataBinding)
    }

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: CakesViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.results = results[position]
        }
    }

    class CakesViewHolder(val viewDataBinding: RowCakeBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.row_cake
        }
    }

    class CakeClick(val block: (DatabaseCake)->Unit){
        fun onClick(cake: DatabaseCake)= block(cake)
    }

}