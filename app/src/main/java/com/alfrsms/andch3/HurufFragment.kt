package com.alfrsms.andch3

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfrsms.andch3.databinding.FragmentHurufBinding

class HurufFragment : Fragment() {

    // binding
    private var _binding: FragmentHurufBinding? = null
    private val binding get() = _binding!!

    private lateinit var onDataPass: OnDataPass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentHurufBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
    }

    private fun setUpAdapter() {

        val list = resources.getStringArray(R.array.huruf).toList()

        val adapter = HurufAdapter()
        val layoutManager = LinearLayoutManager(requireContext())

        binding.rvHuruf.adapter = adapter
        binding.rvHuruf.layoutManager = layoutManager

        adapter.submitData(list)

        adapter.setOnItemClickCallback(object : OnItemClickCallback{
            override fun onItemClicked(data: String) {
                val action = HurufFragmentDirections.actionHurufFragmentToKataFragment(data)
                findNavController().navigate(action)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}