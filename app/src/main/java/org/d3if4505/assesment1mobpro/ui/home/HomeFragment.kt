package org.d3if4505.assesment1mobpro.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.d3if4505.assesment1mobpro.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.submit.setOnClickListener { submitPesanan() }

    }

    fun submitPesanan(){

        //HARGA MAKANAN
        val harga_kentanggoreng = 25000
        val harga_cordonbleu = 40000
        val harga_chickenkatsu = 35000

        //HARGA MINUMAN
        val harga_kopisusu = 10000
        val harga_matchalatte = 10000
        val harga_vsixty = 15000

        if (!binding.kentanggoreng.isChecked && !binding.cordonbleu.isChecked && !binding.chickenkatsu.isChecked
            && !binding.kopisusu.isChecked && !binding.matchalatte.isChecked && !binding.vsixty.isChecked
        ) {
            Toast.makeText(
                requireContext(),
                "Silahkan Pilih Makanan dan Minuman",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            var text = ""
            var totOrder = 0
            var discount = 0
            if (binding.kentanggoreng.isChecked) {
                val hasil = "Kentang Goreng"
                val jml: Int = binding.jumlahkentanggoreng.text.toString().toInt()
                val cal: Int = jml * harga_kentanggoreng
                text += "$jml\t\t$hasil\t\t\t\t\t\t\t\t\tRp. $cal\n\n"
                totOrder += cal
            }
            if (binding.cordonbleu.isChecked) {
                val hasil = "Cordon Bleu"
                val jml: Int = binding.jumlahcordonbleu.text.toString().toInt()
                val cal: Int = jml * harga_cordonbleu
                text += "$jml\t\t$hasil\t\t\t\t\t\t\t\t\tRp. $cal\n\n"
                totOrder += cal
            }
            if (binding.chickenkatsu.isChecked) {
                val hasil = "Cichken Katsu "
                val jml: Int = binding.jumlahchickenkatsu.text.toString().toInt()
                val cal: Int = jml * harga_chickenkatsu
                text += "$jml\t\t$hasil\t\t\t\t\t\t\t\t\tRp. $cal\n\n"
                totOrder += cal
            }

            //MINUMAN
            if (binding.kopisusu.isChecked) {
                val hasil = "Kopi Susu "
                val jml: Int = binding.jumlahkopisusu.text.toString().toInt()
                val cal: Int = jml * harga_kopisusu
                text += "$jml\t\t$hasil\t\t\t\t\t\t\t\t\tRp. $cal\n\n"
                totOrder += cal
            }
            if (binding.matchalatte.isChecked) {
                val hasil = "Matcha Latte "
                val jml: Int = binding.jumlahmatchalatte.text.toString().toInt()
                val cal: Int = jml * harga_matchalatte
                text += "$jml\t\t$hasil\t\t\t\t\t\t\t\t\tRp. $cal\n\n"
                totOrder += cal
            }
            if (binding.vsixty.isChecked) {
                val hasil = "V60 "
                val jml: Int = binding.jumlahvsixty.text.toString().toInt()
                val cal: Int = jml * harga_vsixty
                text += "$jml\t\t$hasil\t\t\t\t\t\t\t\t\tRp. $cal\n\n"
                totOrder += cal
            }
            if (totOrder > 100000) {
                discount = 10000
            }
            val total = text
            val semua = totOrder

            val tglPesan = binding.tanggalpesan.text.toString()
            val namaPesan = binding.inputname.text.toString()
            val passData = HomeFragmentDirections.actionNavigationHomeToNavigationFinal(
                total,
                tglPesan,
                namaPesan,
                semua
            )
            findNavController().navigate(passData)
        }
    }
}