package com.bbgo.module_project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bbgo.module_project.repository.ProjectRepository

/**
 *  author: wangyb
 *  date: 3/29/21 9:47 PM
 *  description: todo
 */

class ProjectViewModelFactory(private val repository: ProjectRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProjectViewModel(repository) as T
    }
}