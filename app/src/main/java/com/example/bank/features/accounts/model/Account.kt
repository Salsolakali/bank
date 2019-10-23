package com.example.bank.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Account {

    @SerializedName("accountBalanceInCents")
    @Expose
    var accountBalanceInCents: Int = 0

    @SerializedName("accountCurrency")
    @Expose
    var accountCurrency: String = ""

    @SerializedName("accountId")
    @Expose
    var accountId: String = ""

    @SerializedName("accountName")
    @Expose
    var accountName: String = ""

    @SerializedName("accountNumber")
    @Expose
    var accountNumber: String = ""

    @SerializedName("accountType")
    @Expose
    var accountType: String = ""

    @SerializedName("alias")
    @Expose
    var alias: String = ""

    @SerializedName("iban")
    @Expose
    var iban: String = ""

    @SerializedName("isVisible")
    @Expose
    var isVisible: Boolean = false

    @SerializedName("linkedAccountId")
    @Expose
    var linkedAccountId: Int = 0

    @SerializedName("productName")
    @Expose
    var productName: String = ""

    @SerializedName("productType")
    @Expose
    var productType: Int = 0

    @SerializedName("savingsTargetReached")
    @Expose
    var savingsTargetReached: Int = 0

    @SerializedName("targetAmountInCents")
    @Expose
    var targetAmountInCents: Int = 0

}
