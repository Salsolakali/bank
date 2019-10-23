package com.example.bank.features.accounts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bank.core.platform.BaseViewModel
import com.example.bank.features.accounts.usecase.GetAccounts
import com.example.bank.model.Account

class GetAccountsViewModel(private val getAccounts: GetAccounts): BaseViewModel() {

    var accounts: MutableLiveData<List<Account>> = MutableLiveData()
    var filteredAccounts: List<Account> = listOf()

    fun getAccounts() = getAccounts.invoke(
        GetAccounts.Params()){it.either(::handleFailure, ::handleList)}

    private fun handleList(accounts: List<Account>) {
        this.accounts.value = accounts
        this.filteredAccounts = accounts
    }

    fun getAccountsFiltered() {
        var accountsTempList : MutableList<Account> = mutableListOf()
        for (account in filteredAccounts){
            if(account.isVisible){
                accountsTempList.add(account)
            }
        }
        this.accounts.value = accountsTempList
    }
}





