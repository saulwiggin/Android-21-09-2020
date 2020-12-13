package com.example.paywithbitcoin.ui.dashboard.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paywithbitcoin.R
import com.example.paywithbitcoin.database.DatabaseBitcoin
import kotlinx.android.synthetic.main.row_currency.view.*

class CurrencyAdapter(

    var currencys: List<Currency>

): RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {
    inner class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    var results: List<DatabaseBitcoin> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        // inflate layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_currency, parent, false)
        return CurrencyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currencys.size
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.itemView.apply {
            tvTitle.text = currencys[position].title
            Done.isChecked = currencys[position].isChecked
        }
    }

}