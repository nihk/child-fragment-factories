package nick.child_fragment_factories.ui.configurable

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.navigation.NavController
import nick.child_fragment_factories.navigation.AppNavGraph
import javax.inject.Inject

class VariantA_OnboardingFragment @Inject constructor(
    fragmentFactory: VariantA_FragmentFactory
) : FragmentDelegate(fragmentFactory) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            replaceFragment(OnboardingFragment::class.java)
        }
    }
}

class VariantA_Configuration @Inject constructor(private val navController: NavController) : OnboardingFragment.Configuration {
    override val backgroundColor: Int = android.R.color.holo_orange_light

    override fun showOnboarding() {
        navController.navigate(AppNavGraph.Destination.greeting)
    }

    override fun goToOtherVariant() {
        navController.navigate(AppNavGraph.Destination.variantB)
    }
}

class VariantA_FragmentFactory @Inject constructor(private val configuration: VariantA_Configuration) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return OnboardingFragment(configuration)
    }
}