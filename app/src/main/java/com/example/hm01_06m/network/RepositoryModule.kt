package com.example.hm01_06m.network

import org.koin.dsl.module

val repositoryModule = module {
    single { Reprository(get()) }
    single { Reprository2(get()) }
}