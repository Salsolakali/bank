package com.example.bank.features.accounts.view

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bank.R
import com.example.bank.core.extensions.inflate
import com.example.bank.model.Account
import kotlinx.android.synthetic.main.item_account_row.view.*
import kotlin.properties.Delegates

class AccountAdapter : RecyclerView.Adapter<AccountAdapter.ViewHolder>(){

    internal var clickListener: (Account) -> Unit = { }
    internal var collection: List<Account> by Delegates.observable(emptyList()) {
            _, _, _ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_account_row))


    override fun getItemCount(): Int = collection.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position], clickListener)
        Log.e("ALBERTO", "onBindViewHolder")
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(account: Account, clickListener: (Account) -> Unit) {
            itemView.tvAccountName.text = account.accountName
            itemView.tvBalance.text = account.accountBalanceInCents.toString()
            itemView.tvIban.text = account.iban
            itemView.setOnClickListener { clickListener(account) }
        }
    }
}

