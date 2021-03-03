package nick.child_fragment_factories.ui.configurable

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import nick.child_fragment_factories.R
import nick.child_fragment_factories.databinding.OnboardingFragmentBinding

class OnboardingFragment(private val configuration: Configuration) : Fragment(R.layout.onboarding_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = OnboardingFragmentBinding.bind(view)
        binding.background.setBackgroundColor(ContextCompat.getColor(view.context, configuration.backgroundColor))
        binding.showOnboarding.setOnClickListener {
            configuration.showOnboarding()
        }
        binding.goToOtherVariant.setOnClickListener {
            configuration.goToOtherVariant()
        }
    }

    interface Configuration {
        val backgroundColor: Int
        fun showOnboarding()
        fun goToOtherVariant()
    }
}