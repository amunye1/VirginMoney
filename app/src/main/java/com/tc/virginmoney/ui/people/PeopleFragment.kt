package com.tc.virginmoney.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tc.virginmoney.databinding.FragmentPeopleBinding
import com.tc.virginmoney.ui.people.data.PeopleFactsItemModel


class PeopleFragment : Fragment() {

    private var _binding: FragmentPeopleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    // This property is a reference to a UI element in our Fragment.
    // It's like a container that holds the views we'll use.
    private val binding get() = _binding!!

    // This is where the Fragment's user interface is created.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // We're setting up a ViewModel to manage data for this Fragment.

        val peopleViewModel =
            ViewModelProvider(this).get(PeopleViewModel::class.java)

        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // We're observing changes in the data and updating the UI when data changes.
        peopleViewModel._peopleFacts.observe(viewLifecycleOwner){
            it?.let{
                // We're updating the UI with the new data.
                showData(it)
            }
        }

        // We're asking the ViewModel to fetch the data.
        peopleViewModel.getPeopleFacts()
        return root
    }


    // This method is responsible for showing the data on the screen.
    private fun showData(it: ArrayList<PeopleFactsItemModel>) {
        // We're setting up a RecyclerView, a component for displaying lists of data.
        binding.peeoplerecyclerview.apply {
            val adapter = PeopleAdapter(it)
            // We're assigning the adapter to the RecyclerView to display the data.
            binding.peeoplerecyclerview.adapter = adapter // Set the adapter here
            // We're choosing how to arrange the items in the list (linear layout in this case).
            binding.peeoplerecyclerview.layoutManager = LinearLayoutManager(context)

            adapter.updateList(it)
        }
    }

    // This is called when the Fragment's view is destroyed.
    override fun onDestroyView() {
        super.onDestroyView()
        // We're cleaning up by setting the UI container to null.
        _binding = null
    }
}