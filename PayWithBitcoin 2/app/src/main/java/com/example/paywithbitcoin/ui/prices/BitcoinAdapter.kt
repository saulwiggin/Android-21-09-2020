package com.example.paywithbitcoin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paywithbitcoin.R
import com.example.paywithbitcoin.data.database.DatabaseBitcoin
import com.example.paywithbitcoin.databinding.RowCurrencyBinding

class BitcoinAdapter(val callback: BitcoinClick): RecyclerView.Adapter<BitcoinViewHolder>(){

    var results: List<DatabaseBitcoin> = emptyList()
        set(value) {
            field = value
            // countryFilterList = results
            // Notify any registered observers that the data set has changed. This will cause every
            // element in our RecyclerView to be invalidated.
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BitcoinViewHolder {
        val withDataBinding: RowCurrencyBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            BitcoinViewHolder.LAYOUT,
            parent,
            false
        )
        return BitcoinViewHolder(withDataBinding)
    }

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: BitcoinViewHolder, position: Int) {

    }
}

class BitcoinViewHolder(val viewDataBinding: RowCurrencyBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.row_currency
    }
}

class BitcoinClick(val block: (DatabaseBitcoin) -> Unit) {

    fun onClick(character: DatabaseBitcoin) = block(character)
}