package org.d3if4505.assesment1mobpro.ui.finall

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.d3if4505.assesment1mobpro.R
import org.d3if4505.assesment1mobpro.databinding.FragmentFinalBinding



class FragmentFinal : Fragment() {
    private lateinit var binding: FragmentFinalBinding
    private val args : FragmentFinalArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val text: TextView = binding.berhasil
        val total1: TextView = binding.total
        val tanggal: TextView = binding.tanggal
        val nama: TextView = binding.nama
        val args: FragmentFinalArgs by navArgs()

        text.text = args.text
        total1.text = args.total.toString()
        tanggal.text = args.tanggal
        nama.text = args.nama

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.bottom_nav_menu, menu)
    }


    }

