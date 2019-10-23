package com.example.bank.features.accounts.usecase

import com.example.bank.core.interactor.UseCase
import com.example.bank.features.accounts.repository.AccountsRepository
import com.example.bank.model.Account

class GetAccounts(private val accountsRepository: AccountsRepository): UseCase<List<Account>, GetAccounts.Params>() {
    override suspend fun run(params: Params) = accountsRepository.getAccounts()
    class Params

}