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
    protected open fun setClient() { }
    protected open fun setRepository() { }

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
    protected val isInit: AtomicBoolean = AtomicBoolean(true)
    abstract fun viewInitialize()

    /**
     * onResume()
     */
    abstract fun viewEvent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setClient()
        setRepository()
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
        viewInitialize()
    }

    override fun onResume() {
        super.onResume()
        viewEvent()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    protected fun backStack() = navController.popBackStack()
}