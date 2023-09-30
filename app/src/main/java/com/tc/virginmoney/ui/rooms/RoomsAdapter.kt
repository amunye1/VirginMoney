package com.tc.virginmoney.ui.rooms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tc.virginmoney.R
import com.tc.virginmoney.databinding.ItemRoomsUserBinding
import com.tc.virginmoney.ui.rooms.data.RoomFactsItemModel

class RoomsAdapter(private val roomData:ArrayList<RoomFactsItemModel>):
    RecyclerView.Adapter<RoomsAdapter.CustomViewHolder>() {
    class CustomViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val binding = ItemRoomsUserBinding.bind(view)
        fun setupUI(roomFacts: RoomFactsItemModel){
            binding.roomNumber.text =roomFacts.id
            binding.isOccupied.text = roomFacts.isOccupied.toString()
            binding.occupancy.text= roomFacts.maxOccupancy.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  CustomViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_rooms_user,parent,false))



    override fun getItemCount() = roomData.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.setupUI(roomData.get(position))
    }

    fun updateRoom(roomDetails: java.util.ArrayList<RoomFactsItemModel>){
        roomData.addAll(roomDetails)
        notifyDataSetChanged()
    }
}