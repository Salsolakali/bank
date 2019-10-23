package com.example.bank.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Response {
    @SerializedName("accounts")
    @Expose
    lateinit var accounts: ArrayList<Account>

    @SerializedName("failedAccountTypes")
    lateinit var failedAccountTypes: String

    @SerializedName("returnCode")
    lateinit var returnCode: String
}
