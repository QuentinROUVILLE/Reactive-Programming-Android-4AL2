package com.qrouville.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

import kotlinx.android.synthetic.main.fragment_container.*

class ProductNutritionFragment : Fragment() {
    override fun onCreateView(
            inflater:LayoutInflater,
            container:ViewGroup?,
            savedInstanceState:Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost = childFragmentManager.findFragmentById(R.id.product_details_nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(product_details_bottom_nav, navHost.navController)
    }
}
