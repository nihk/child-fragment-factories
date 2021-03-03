package nick.child_fragment_factories.ui.configurable

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.navigation.NavController
import dagger.hilt.android.qualifiers.ActivityContext
import nick.child_fragment_factories.R
import nick.child_fragment_factories.navigation.AppNavGraph
import javax.inject.Inject

class VariantB_OnboardingFragment @Inject constructor(
    fragmentFactory: VariantB_FragmentFactory
) : FragmentDelegate(fragmentFactory) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            replaceFragment(OnboardingFragment::class.java)
        }
    }
}

class VariantB_Configuration @Inject constructor(
    @ActivityContext private val context: Context,
    private val navController: NavController
) : OnboardingFragment.Configuration {
    override val backgroundColor: Int = R.color.teal_200

    override fun showOnboarding() {
        Toast.makeText(context, "Welcome to the app", Toast.LENGTH_SHORT)
            .show()
    }

    override fun goToOtherVariant() {
        navController.navigate(AppNavGraph.Destination.variantA)
    }
}

class VariantB_FragmentFactory @Inject constructor(private val configuration: VariantB_Configuration) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return OnboardingFragment(configuration)
    }
}