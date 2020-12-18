package com.example.paywithbitcoin.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paywithbitcoin.R
import com.example.paywithbitcoin.data.domain.model.ShitCoin
import kotlinx.android.synthetic.main.row_currency.view.*

class CurrencyAdapter(

    var currencys: List<ShitCoin>

): RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {
    inner class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    var results: List<ShitCoin> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_currency, parent, false)
        return CurrencyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currencys.size
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.itemView.apply {
            tvTitle.text = currencys[position].name
        }
    }

}