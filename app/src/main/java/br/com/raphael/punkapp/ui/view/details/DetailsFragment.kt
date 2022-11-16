package br.com.raphael.punkapp.ui.view.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.raphael.punkapp.R
import br.com.raphael.punkapp.databinding.FragmentDetailsBinding
import br.com.raphael.punkapp.ui.base.BaseFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLayout()
        setupListeners()
    }

    private fun setupLayout() {
        val beer = args.beer

        binding.apply {
            Glide
                .with(imageBeer)
                .load(beer.imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .dontTransform()
                .dontAnimate()
                .into(imageBeer)

            textName.text = beer.name
            textTagline.text = beer.tagline
            textFirstBrewed.text = getString(R.string.first_brewed, beer.firstBrewed)
            textDescription.text = getString(R.string.description, beer.description)
            var foodPairingText = ""
            beer.foodPairing.forEachIndexed { index, foodPairing ->
                foodPairingText += if (index == beer.foodPairing.lastIndex) {
                    foodPairing
                } else {
                    "$foodPairing\n"
                }
            }
            textFoodPairing.text = getString(R.string.food_pairing, foodPairingText)
            textBrewersTips.text = getString(R.string.brewers_tips, beer.brewersTips)
        }
    }

    private fun setupListeners() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}