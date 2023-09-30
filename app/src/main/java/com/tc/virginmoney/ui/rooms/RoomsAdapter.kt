package com.tc.virginmoney.ui.rooms

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tc.virginmoney.databinding.ItemRoomsUserBinding

class RoomsAdapter():RecyclerView.Adapter<RoomsAdapter.CustomViewHolder>() {
    class CustomViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val bind = ItemRoomsUserBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}