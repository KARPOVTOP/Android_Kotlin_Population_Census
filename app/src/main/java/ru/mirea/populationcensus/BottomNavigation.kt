package ru.mirea.populationcensus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigation : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_bottom_navigation, container, false)

        val menu = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        menu.selectedItemId = R.id.homeFragment

        menu.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.homeFragment -> {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.containerFragment,HomeFragment())
                        ?.commit()
                }
                R.id.listOfForm -> {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.containerFragment,ListOfForm())
                        ?.commit()
                }
                R.id.infoOfApp -> {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.containerFragment,InfoOfApp())
                        ?.commit()
                }
                R.id.profileFragment -> {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.containerFragment,Profile())
                        ?.commit()
                }
            }
            true
        }

        return view
    }


}