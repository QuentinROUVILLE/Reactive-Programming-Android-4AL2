package com.qrouville.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            additives = null,
            nutritionFacts = NutritionFacts(
                energy = NutritionFactsItem(
                    unit = "kCal",
                    quantityPerPortion = "",
                    quantityPer100g = "293"
                ),
                fat = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "0,8"
                ),
                saturatedFattyAcid = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "0,1"
                ),
                carbohydrates = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "8,4"
                ),
                sugar = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "5,2"
                ),
                dietaryFibre = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "5,2"
                ),
                protein = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "4,2"
                ),
                salt = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "0,75"
                ),
                sodium = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "0,295"
                )
            )
        ),
        Product(
            name = "Nicciolata",
            brand = "Rigoni di Asiago",
            nutriscore = 'D',
            barcode = "8001505005707",
            quantity = "700 g",
            countries = listOf("Italie"),
            url = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            ingredients = listOf("Sucre de cane", "Huile de tournesole", "Poudre de lait", "Poudre de cacao 6,5%", "cocoa butter", "Extrait de vanille"),
            kiloCalories = 544.0,
            allergenic = null,
            additives = null,
            nutritionFacts = NutritionFacts(
                energy = NutritionFactsItem(
                    unit = "kCal",
                    quantityPerPortion = "",
                    quantityPer100g = "293"
                ),
                fat = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "0,8"
                ),
                saturatedFattyAcid = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "0,1"
                ),
                carbohydrates = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "8,4"
                ),
                sugar = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "5,2"
                ),
                dietaryFibre = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "5,2"
                ),
                protein = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "4,2"
                ),
                salt = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "0,75"
                ),
                sodium = NutritionFactsItem(
                    unit = "g",
                    quantityPerPortion = "",
                    quantityPer100g = "0,295"
                )
            )
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