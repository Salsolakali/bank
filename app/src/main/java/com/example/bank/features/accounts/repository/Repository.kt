package com.example.bank.features.accounts.repository

import android.app.Activity
import android.content.Context
import com.example.bank.core.navigation.NavigationActivity
import com.example.bank.model.Account
import com.example.bank.model.Response
import com.google.gson.Gson
import java.io.IOException
import java.nio.charset.Charset


class Repository (private val contex: Context) {
    private val FILE = "response.json"


    fun getAccounts():List<Account>{
        val jsonString = getAssetsJSON(FILE)
        val gson = Gson()
        val response = gson.fromJson(jsonString, Response::class.java)
        return response.accounts
    }

    fun getAssetsJSON(fileName: String): String? {
        var json: String? = null
        try {
            val inputStream = contex.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.defaultCharset())

        } catch (e: IOException) {
            e.printStackTrace()
        }

        return json
    }


}