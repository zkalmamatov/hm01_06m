package com.example.hm01_06m.viewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { FragmentViewModel(get()) }
    viewModel { SecondViewModel(get()) }
}