package com.example.cakesapimvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cakesapimvvm.recycler_adapters.CakesAdapter
import com.example.cakesapimvvm.database.DatabaseCake
import com.example.cakesapimvvm.databinding.FragmentFirstBinding
import com.example.cakesapimvvm.viewmodel.CakeListViewModel
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class FirstFragment : Fragment() {
    private var viewModelAdapter: CakesAdapter? = null

    private val viewModel: CakeListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentFirstBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        binding.setLifecycleOwner(viewLifecycleOwner)

        binding.viewmodel = viewModel
        viewModelAdapter = CakesAdapter()
        binding.root.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = viewModelAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserverToGetData();
    }

    fun setUpObserverToGetData() {
        viewModel.cakeListResults.observe(viewLifecycleOwner,
            Observer<List<DatabaseCake>> { cake ->
                cake.apply {
                    viewModelAdapter?.results = cake

                    // Timber.i(cake.get(2).title)
                }
            })
    }

}
