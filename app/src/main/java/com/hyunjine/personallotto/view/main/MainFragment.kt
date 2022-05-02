package com.hyunjine.personallotto.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.hyunjine.personallotto.R
import com.hyunjine.personallotto.data.remote.LottoClient
import com.hyunjine.personallotto.data.remote.LottoService
import com.hyunjine.personallotto.data.repo.Repository
import com.hyunjine.personallotto.databinding.FragmentMainBinding
import com.hyunjine.personallotto.util.ViewModelFactory
import com.hyunjine.personallotto.util.base.BaseFragment

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {
        val repository = Repository(LottoClient().getClient())
        viewModel = ViewModelProvider(this, ViewModelFactory(repository))[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container,false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(binding.root)
        initView()
    }

    private fun initView() {
        binding.viewModel = viewModel
        viewModel.getLottoNumber()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}