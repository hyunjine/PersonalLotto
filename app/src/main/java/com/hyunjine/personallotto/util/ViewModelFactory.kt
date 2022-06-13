package com.hyunjine.personallotto.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hyunjine.personallotto.data.repo.Repository
import com.hyunjine.personallotto.view.home.HomeViewModel

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}