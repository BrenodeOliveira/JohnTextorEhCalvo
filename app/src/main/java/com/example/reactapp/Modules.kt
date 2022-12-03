package com.example.reactapp

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
    factory {
        HttpClient(retrofit = ApiService.initRetrofit())
    }

    factory {
        get<HttpClient>().create(
            service = Service::class.java
        )
    }

    viewModel {
        MainViewModel(service = get())
    }
}