package nick.child_fragment_factories.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import nick.child_fragment_factories.R
import nick.child_fragment_factories.databinding.MainFragmentBinding
import nick.child_fragment_factories.navigation.AppNavGraph
import nick.child_fragment_factories.ui.configurable.VariantA_Configuration
import nick.child_fragment_factories.ui.configurable.VariantB_Configuration
import nick.child_fragment_factories.ui.configurable.VariedOnboardingFragment
import javax.inject.Inject

class MainFragment @Inject constructor() : Fragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = MainFragmentBinding.bind(view)
        binding.variantA.setOnClickListener {
            findNavController().navigate(AppNavGraph.Destination.varied, VariedOnboardingFragment.bundle(VariantA_Configuration::class.java))
        }
        binding.variantB.setOnClickListener {
            findNavController().navigate(AppNavGraph.Destination.varied, VariedOnboardingFragment.bundle(VariantB_Configuration::class.java))
        }
    }
}