package com.example.bank.core.di

import com.example.bank.features.accounts.view.AccountAdapter
import com.example.bank.features.accounts.repository.AccountsRepository
import com.example.bank.features.accounts.repository.Repository
import com.example.bank.features.accounts.usecase.GetAccounts
import com.example.bank.features.accounts.view.AccountsFragment
import com.example.bank.features.accounts.viewmodel.GetAccountsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val applicationModule = module(override = true) {
    scope(named<AccountsFragment>()) {
        factory { AccountAdapter() }
    }
}

val useCaseModule = module {
    scope(named<AccountsFragment>()) {
        factory { GetAccounts(get()) }
    }
}

val repositoryModule = module {
    factory { Repository(get()) }
    factory<AccountsRepository> { AccountsRepository.Network(get())
    }
}

val viewModelModule = module {
    scope(named<AccountsFragment>()){
        viewModel {
            GetAccountsViewModel(get())
        }
    }
}

