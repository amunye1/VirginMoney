package com.tc.virginmoney.ui.rooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tc.virginmoney.databinding.FragmentRoomsBinding

class RoomsFragment : Fragment() {

    private var _binding: FragmentRoomsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val roomsViewModel =
            ViewModelProvider(this).get(RoomsViewModel::class.java)

        _binding = FragmentRoomsBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textRooms
//        roomsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}