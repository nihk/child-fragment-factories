package nick.child_fragment_factories.di

import androidx.navigation.NavController
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import nick.child_fragment_factories.ui.MainFragmentFactory

@EntryPoint
@InstallIn(ActivityComponent::class)
interface MainEntryPoint {
    val mainFragmentFactory: MainFragmentFactory
    val navController: NavController
}