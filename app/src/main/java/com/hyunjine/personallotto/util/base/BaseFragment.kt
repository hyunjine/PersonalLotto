package com.hyunjine.personallotto.util.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import java.util.concurrent.atomic.AtomicBoolean

abstract class BaseFragment<T : ViewDataBinding, R : BaseViewModel> : Fragment() {
    /**
     * 레이아웃 설정
     */
    abstract val layoutResourceId: Int

    /**
     * onCreate()
     */

    protected lateinit var viewModel: R
    abstract fun setViewModel()

    /**
     * onCreateView()
     */
    private var _binding : T? = null
    protected val binding get() = _binding!!
    protected lateinit var navController : NavController

    /**
     * onViewCreated()
     */
    abstract fun initView()

    /**
     * onResume()
     */
    abstract fun onEvent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResourceId, container,false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(binding.root)
        initView()
        onEvent()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    protected fun backStack() = navController.popBackStack()
}