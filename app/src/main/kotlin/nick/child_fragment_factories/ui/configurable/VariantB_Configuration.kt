package nick.child_fragment_factories.ui.configurable

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import dagger.hilt.android.qualifiers.ActivityContext
import nick.child_fragment_factories.R
import nick.child_fragment_factories.navigation.AppNavGraph
import javax.inject.Inject

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
        navController.navigate(AppNavGraph.Destination.varied, VariedOnboardingFragment.bundle(VariantA_Configuration::class.java))
    }
}