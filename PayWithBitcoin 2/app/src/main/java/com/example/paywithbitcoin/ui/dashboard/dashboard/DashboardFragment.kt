package com.example.paywithbitcoin.ui.dashboard.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paywithbitcoin.R
import com.example.paywithbitcoin.database.DatabaseBitcoin
import com.example.paywithbitcoin.viewmodel.CurrencyViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.android.inject
import org.koin.ext.scope
import timber.log.Timber

class DashboardFragment : Fragment() {

    private val TAG = "Bitcoin Observe Adapter"
    private val viewModel: CurrencyViewModel by inject()

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

         // setUpObserverToGetData()

        var currencyList = mutableListOf(
            Currency("Bitcoin", true),
            Currency("Litecoin", false),
            Currency("Etherium", false)
        )

        val adapter = CurrencyAdapter(currencyList)
        rvCurrencys.adapter = adapter
        rvCurrencys.layoutManager = LinearLayoutManager(activity)

        btnCryptoButton.setOnClickListener {
            val title = etAddCrypto.text.toString()
            val currency = Currency(title, false)
            currencyList.add(currency)
            adapter.notifyItemInserted(currencyList.size - 1)
        }
    }

//    fun setUpObserverToGetData() {
//        viewModel.currencyResults.observe(viewLifecycleOwner,
//            Observer<List<DatabaseBitcoin>> { coin ->
//                coin.apply {
//                    val adapter = BitcoinAdapter(coin)
//
//                    Timber.d(TAG, coin.get(2).id)
//                }
//            })
//    }

    override fun onDestroy() {
        super.onDestroy()
        scope.close()
    }

}