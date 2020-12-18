package com.example.paywithbitcoin.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paywithbitcoin.R
import com.example.paywithbitcoin.data.domain.model.ShitCoin
import com.example.paywithbitcoin.ui.dashboard.model.CurrencyState
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.android.inject

class DashboardFragment : Fragment() {

    private val TAG = "Bitcoin Observe Adapter"
    private val viewModel: DashboardViewModel by inject()
    private var currencyList = emptyList<ShitCoin>()

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val adapter = CurrencyAdapter(currencyList)
        rvCurrencys.adapter = adapter
        rvCurrencys.layoutManager = LinearLayoutManager(activity)

        btnCryptoButton.setOnClickListener {
            val title = etAddCrypto.text.toString()
            val currency = CurrencyState(title, false)
            adapter.notifyItemInserted(currencyList.size - 1)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
    }

}