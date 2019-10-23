package com.example.bank.features.accounts.repository


import com.example.bank.core.exception.Failure
import com.example.bank.core.funtional.Either
import com.example.bank.model.Account

interface AccountsRepository {

    fun getAccounts(): Either<Failure, List<Account>>

    class Network(private val repository: Repository): AccountsRepository {



        override fun getAccounts(): Either<Failure, List<Account>> {
            return try {

                val accounts = repository.getAccounts()
                if (accounts.isNullOrEmpty()){
                    Either.Left(Failure.CustomError(404, "No hemos podido encontrar la información"))
                }else {
                    Either.Right(accounts)
                }
            }catch (e: Exception) {
                Either.Left(Failure.CustomError(404, "No hemos podido encontrar la información"))
            }
        }
    }
}