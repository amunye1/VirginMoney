package com.tc.virginmoney.ui.rooms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tc.virginmoney.R
import com.tc.virginmoney.databinding.ItemRoomsUserBinding
import com.tc.virginmoney.ui.rooms.data.RoomFactsItemModel


// This adapter manages and displays a list of rooms.
class RoomsAdapter(private val roomData:ArrayList<RoomFactsItemModel>):
    RecyclerView.Adapter<RoomsAdapter.CustomViewHolder>() {

    // This is a specialized ViewHolder class for setting up room views.
    class CustomViewHolder(view: View):RecyclerView.ViewHolder(view) {

        // This binding object helps with data binding.
        val binding = ItemRoomsUserBinding.bind(view)
        fun setupUI(roomFacts: RoomFactsItemModel){
            // We're adding a room number to the view.
            binding.roomNumber.text =roomFacts.id
            // We're indicating if the room is occupied or not.
            binding.isOccupied.text = roomFacts.isOccupied.toString()
            // We're indicating if the room is occupied or not.
            binding.occupancy.text= roomFacts.maxOccupancy.toString()

        }


    }

    // This method creates a new room view with the right decorations.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  CustomViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_rooms_user,parent,false))


    // This method tells us how many rooms are in the list.
    override fun getItemCount() = roomData.size

    // This method decorates each room view with the right data.
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.setupUI(roomData.get(position))
    }

    // This method adds more rooms to the list and updates the display.
    fun updateRoom(roomDetails: java.util.ArrayList<RoomFactsItemModel>){
        roomData.addAll(roomDetails)
        notifyDataSetChanged()
    }
}