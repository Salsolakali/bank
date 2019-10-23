package com.example.bank.features.accounts.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bank.core.exception.Failure
import com.example.bank.R
import com.example.bank.core.extensions.observe
import com.example.bank.core.extensions.failure
import com.example.bank.core.extensions.onClick
import com.example.bank.core.funtional.DialogCallback
import com.example.bank.core.platform.BaseFragment
import com.example.bank.features.accounts.viewmodel.GetAccountsViewModel
import com.example.bank.model.Account
import kotlinx.android.synthetic.main.fragment_accounts.*
import org.koin.android.scope.currentScope


class AccountsFragment : BaseFragment() {
    override fun layoutId(): Int = R.layout.fragment_accounts

    private val accountsAdapter: AccountAdapter by currentScope.inject()
    private val getAccountsViewModel: GetAccountsViewModel by currentScope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(getAccountsViewModel){
            observe(accounts, ::renderAccountList)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeListeners()
        loadAccounts()
    }


    private fun initializeViews() {
        accountsList.layoutManager = LinearLayoutManager(activity)
        accountsList.adapter = accountsAdapter
    }


    private fun initializeListeners() {
        switchHidden.onClick {
            if (switchHidden.isChecked){
                getAccountsViewModel.getAccounts()
            }
            else{
                getAccountsViewModel.getAccountsFiltered()
            }
        }
    }

    private fun loadAccounts() {
        showProgress()
        getAccountsViewModel.getAccounts()
    }

    private fun renderAccountList(accounts: List<Account>?) {
        accountsAdapter.collection = accounts.orEmpty()
        hideProgress()
    }

    private fun handleFailure(failure: Failure?) {
        when(failure) {
            is Failure.CustomError -> renderFailure(failure.errorCode, failure.errorMessage)
            else -> renderFailure(0, "")
        }
    }

    private fun renderFailure(errorCode: Int, errorMessage: String?) {
        hideProgress()
        showError(errorCode, errorMessage, object : DialogCallback {
            override fun onAccept() {
                loadAccounts()
            }

            override fun onDecline() {
                onBackPressed()
            }
        })
    }


}
