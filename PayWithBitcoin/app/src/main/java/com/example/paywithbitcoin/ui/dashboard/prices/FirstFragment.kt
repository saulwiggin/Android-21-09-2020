package com.example.paywithbitcoin.ui.dashboard.prices

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.paywithbitcoin.databinding.FragmentFirstBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.paywithbitcoin.R
import com.example.paywithbitcoin.adapters.BitcoinAdapter
import com.example.paywithbitcoin.database.DatabaseBitcoin
import timber.log.Timber

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {

    private lateinit var myPriceListener: LiveData<List<DatabaseBitcoin>>

    private var viewModelAdapater: BitcoinAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myPriceListener.observe(viewLifecycleOwner, Observer<List<DatabaseBitcoin>> { price: List<DatabaseBitcoin>? ->
            // Update the UI. Inflate fragment according to https://stackoverflow.com/questions/60167410/no-data-in-recycler-view-in-fragment
            Log.d("observable price", price.toString())
            Timber.d("Hello User and welcome to Bitcoin")

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)

        // link data binding to recycler view -  see MVVM braking bad
        val binding: FragmentFirstBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)



    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}