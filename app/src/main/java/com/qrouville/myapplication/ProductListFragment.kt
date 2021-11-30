package com.qrouville.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductListFragment : Fragment() {
    private val products = listOf(
        Product(
            name = "Petits pois et carottes",
            brand = "Cassegrain",
            nutriscore = 'E',
            barcode = "3083680085304",
            quantity = "400 g (280 g net égoutté)",
            countries = listOf("France", "Japon", "Suisse"),
            url = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            ingredients = listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
            kiloCalories = 234.0,
            allergenic = null,
            additives = null
        ),
        Product(
            name = "Petits pois et carottes",
            brand = "Cassegraine",
            nutriscore = 'E',
            barcode = "3083680085304",
            quantity = "400 g (280 g net égoutté)",
            countries = listOf("France", "Japon", "Suisse"),
            url = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            ingredients = listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
            kiloCalories = 234.0,
            allergenic = null,
            additives = null
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.activity_product_list,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        product_list.run {
            layoutManager = GridLayoutManager(requireContext(), 1)
            adapter = ListAdapter(products, object: OnItemClickedListener {
                override fun onItemClicked(product: Product) {
                    Toast.makeText(activity, products.toString(),Toast.LENGTH_SHORT).show()
                    findNavController().navigate(
                        ProductListFragmentDirections.actionListFragmentToDetailsFragment(
                            product = product
                        )
                    )
                }
            })
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }
}