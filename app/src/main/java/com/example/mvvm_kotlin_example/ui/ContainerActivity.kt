package com.example.mvvm_kotlin_example.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.mvvm_kotlin_example.R
import com.example.mvvm_kotlin_example.ui.menu.MenuFragment

/**
 * Created by Sarsenov Yerlan on 03.11.2020.
 */
class ContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_container)
        if (savedInstanceState == null) {
            val frag = MenuFragment()
            changeFragment(fragment = frag)
        }
    }

    fun changeFragment(fragment: BaseFragment) {
        val addToBackStack = supportFragmentManager.findFragmentById(R.id.fragmentContainer) != null
        val transaction: FragmentTransaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(fragment.javaClass.simpleName)
        }
        transaction.commit()
    }

}