package ru.mirea.populationcensus

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController

class UserProfile : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user_profile, container, false)

        val userProfile = view.findViewById<TextView>(R.id.userProfile)
        val exitProfile = view.findViewById<ConstraintLayout>(R.id.exitProfile)

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val login = sharedPref?.getString("login", "Пользователь")
        if (login != "Пользователь"){
            userProfile.text = login
        }
        exitProfile.setOnClickListener {
            val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
            sharedPref?.edit()?.remove("login")?.apply()

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.containerFragment,Profile())
                ?.commit()
            Toast.makeText(context, "Вы вышли из аккаунта!", Toast.LENGTH_SHORT)
                .show()
        }

        return view
    }
}