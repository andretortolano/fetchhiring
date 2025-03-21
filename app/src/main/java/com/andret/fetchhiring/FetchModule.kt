package com.andret.fetchhiring

import com.andret.fetchhiring.data.ItemRemoteSource
import com.andret.fetchhiring.data.ItemRepository
import com.andret.fetchhiring.data.remote.RetrofitItemService
import com.andret.fetchhiring.data.remote.RetrofitItemSource
import com.andret.fetchhiring.data.wrapper.S3RetrofitWrapper
import com.andret.fetchhiring.domain.GetSortedItemsListUseCase
import com.andret.fetchhiring.domain.ItemProvider
import com.andret.fetchhiring.features.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object FetchModule {
    val module: Module = module {

        single { S3RetrofitWrapper.retrofit.create(RetrofitItemService::class.java) }

        single<ItemRemoteSource> { RetrofitItemSource(get()) }
        single<ItemProvider> { ItemRepository(get()) }

        single { GetSortedItemsListUseCase(get()) }

        viewModel { HomeViewModel(get()) }
    }
}