package com.example.bank

import android.app.Application
import com.example.bank.core.di.applicationModule
import com.example.bank.core.di.repositoryModule
import com.example.bank.core.di.useCaseModule
import com.example.bank.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AndroidApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AndroidApplication)
            modules(listOf(
                applicationModule,
                useCaseModule,
                repositoryModule,
                viewModelModule))
        }
    }
}