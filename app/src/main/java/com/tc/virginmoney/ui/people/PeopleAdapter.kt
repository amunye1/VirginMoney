package com.tc.virginmoney.ui.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.tc.virginmoney.R
import com.tc.virginmoney.databinding.ItemPeopleUserBinding
import com.tc.virginmoney.ui.people.data.PeopleFactsItemModel
import com.tc.virginmoney.ui.rooms.RoomsAdapter

class PeopleAdapter(private val peopleData:ArrayList<PeopleFactsItemModel>):
    RecyclerView.Adapter<PeopleAdapter.CustomViewHolder>() {

    //this will be how each person is displayed in the list
    // This is a specialized tool (a ViewHolder) for displaying information about a person.

    class CustomViewHolder(view: View):RecyclerView.ViewHolder(view) {

        //this allows us to connect the item_people_user xml
        // and it allows us to connect it to the view
        val binding = ItemPeopleUserBinding.bind(view)


        //This allows us to setup the UI so that the elements that we want to
        //upload with different information can have that information
        //In other words it puts the information into the UI of XML
        fun setupUI(peopleFacts: PeopleFactsItemModel, position: Int){
            //Selects the email then select the specific elements we name
            //then we set the text to the data from the api
            binding.jobTitle.text = " ${peopleFacts.jobtitle}"
            binding.name.text = " ${peopleFacts.firstName} ${peopleFacts.lastName}"
            // We are displaying the person's (avatar) picture here.
            val avatarUrl = peopleFacts.avatar

            // Load the avatar image using Glide
            Glide.with(itemView.context)
                .load(avatarUrl)
                .placeholder(R.drawable.person_24px)
                // Optional: You can use a placeholder
                // image if for glide dosen t load
                .into(binding.ImageView1)

            // When someone clicks on the person's picture, we can make things happen, but it's empty for now.
            binding.ImageView1.setOnClickListener(){

            }


        }

    }
    // This is like setting up the tools and layout for displaying the list of people.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)  = CustomViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_people_user,parent,false)

    )
    // This is like showing a person's information on the screen.
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        val item = peopleData[position]

        // We use the specialized tool we created earlier to display the person's information.
        holder.setupUI(peopleData[position],position)
//        holder.itemView.setOnClickListener(onItemClick(item))
    }

    //get the size of the list we have and how much people
    //are in the list
    override fun getItemCount(): Int {
        return peopleData.size
    }

    //update the list when we scroll down
    // This is like adding more people to the list if we want to show more.

    fun updateList(peopleFacts: java.util.ArrayList<PeopleFactsItemModel>) {

        // We add new people to our list.

        peopleData.addAll(peopleFacts)

        // We tell the computer to refresh the list to show the new people.
        notifyDataSetChanged() // updates/reloads the changed data
    }


}