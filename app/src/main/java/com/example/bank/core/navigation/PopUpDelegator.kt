package com.example.bank.core.navigation

import com.example.bank.core.funtional.DialogCallback

interface PopUpDelegator {

    fun showErrorWithRetry(title: String, message: String, positiveText: String,
                           negativeText: String, callback: DialogCallback
    )
}