package nick.child_fragment_factories.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.dialog
import androidx.navigation.fragment.fragment
import dagger.hilt.android.AndroidEntryPoint
import nick.child_fragment_factories.R
import nick.child_fragment_factories.di.MainEntryPoint
import nick.child_fragment_factories.navigation.AppNavGraph
import nick.child_fragment_factories.ui.configurable.VariedOnboardingFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.main_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        val entryPoint = entryPoint<MainEntryPoint>()
        supportFragmentManager.fragmentFactory = entryPoint.mainFragmentFactory
        super.onCreate(savedInstanceState)
        createNavGraph(entryPoint.navController)
    }

    private fun createNavGraph(navController: NavController) {
        navController.graph = navController.createGraph(
            id = AppNavGraph.id,
            startDestination = AppNavGraph.Destination.main
        ) {
            fragment<MainFragment>(AppNavGraph.Destination.main)
            fragment<VariedOnboardingFragment>(AppNavGraph.Destination.varied)
            dialog<GreetingDialogFragment>(AppNavGraph.Destination.greeting)
        }

    }
}