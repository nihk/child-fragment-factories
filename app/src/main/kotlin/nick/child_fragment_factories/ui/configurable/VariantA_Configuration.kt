package nick.child_fragment_factories.ui.configurable

import androidx.navigation.NavController
import nick.child_fragment_factories.navigation.AppNavGraph
import javax.inject.Inject

class VariantA_Configuration @Inject constructor(private val navController: NavController) : OnboardingFragment.Configuration {
    override val backgroundColor: Int = android.R.color.holo_orange_light

    override fun showOnboarding() {
        navController.navigate(AppNavGraph.Destination.greeting)
    }

    override fun goToOtherVariant() {
        navController.navigate(AppNavGraph.Destination.varied, VariedOnboardingFragment.bundle(VariantB_Configuration::class.java))
    }
}