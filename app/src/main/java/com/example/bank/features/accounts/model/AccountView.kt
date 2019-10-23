package com.example.bank.features.accounts.model

import java.io.Serializable

data class AccountView(
    val accountBalanceInCents: Int,
    val accountCurrency: String,
    val accountId: String,
    val accountName: String,
    val accountNumber: String,
    val accountType: String,
    val alias: String,
    val iban: String,
    val isVisible: Boolean,
    val linkedAccountId: Int,
    val productName: String,
    val productType: Int,
    val savingsTargetReached: Int,
    val targetAmountInCents: Int


) : Serializable {
    companion object {
        fun empty() : AccountView =
            AccountView(
                0,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                false,
                0,
                "",
                0,
                0,
                0
            )
    }

}