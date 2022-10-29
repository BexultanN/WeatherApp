package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemReselectedListener {

            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.news -> replaceFragment(NewsFragment())
                R.id.search -> replaceFragment(SearchFragment())
                R.id.about -> replaceFragment(AboutFragment())

                else ->{

                }
            }

            true

        }

    }

    private fun replaceFragment(fragment: Fragment){
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout, fragment)
            fragmentTransaction.commit()
    }
    
}
