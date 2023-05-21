package org.d3if4505.assesment1mobpro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.d3if4505.assesment1mobpro.ui.history.HistoryFragment
import org.d3if4505.assesment1mobpro.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val homeFragment = HomeFragment()
        val historyFragment = HistoryFragment()

        setCurrentFragment(homeFragment)

        var bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.order->setCurrentFragment(homeFragment)
                R.id.history->setCurrentFragment(historyFragment)

            }
            true
        }


    }
    private fun setCurrentFragment(fragment: Fragment)= supportFragmentManager.beginTransaction().apply {
        replace(R.id.container,fragment)
        commit()
    }

}