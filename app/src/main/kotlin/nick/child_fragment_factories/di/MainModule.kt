package nick.child_fragment_factories.di

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap
import nick.child_fragment_factories.R
import nick.child_fragment_factories.ui.MainFragment
import nick.child_fragment_factories.ui.configurable.VariantA_OnboardingFragment
import nick.child_fragment_factories.ui.configurable.VariantB_OnboardingFragment

@Module
@InstallIn(ActivityComponent::class)
abstract class MainModule {

    companion object {
        @Provides
        fun navController(activity: Activity): NavController {
            val navHostFragment = (activity as AppCompatActivity).supportFragmentManager
                .findFragmentById(R.id.navHostContainer) as NavHostFragment
            return navHostFragment.navController
        }
    }

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    abstract fun mainFragment(mainFragment: MainFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(VariantB_OnboardingFragment::class)
    abstract fun variantB(variantB: VariantB_OnboardingFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(VariantA_OnboardingFragment::class)
    abstract fun variantA(variantA: VariantA_OnboardingFragment): Fragment
}