package nick.child_fragment_factories.ui.configurable

import android.content.Context
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.commit
import nick.child_fragment_factories.R
import javax.inject.Inject

class VariedOnboardingFragment @Inject constructor(
    private val configurationFactory: ConfigurationFactory,
    private val fragmentFactoryFactory: VariedFragmentFactory.Factory
) : Fragment(R.layout.delegate_fragment) {

    private val configurationClass get() = requireArguments().getSerializable(KEY_CONFIGURATION_CLASS) as Class<out OnboardingFragment.Configuration>

    override fun onAttach(context: Context) {
        val configuration = configurationFactory.create(configurationClass)
        childFragmentManager.fragmentFactory = fragmentFactoryFactory.create(configuration)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.commit {
            replace(R.id.container, OnboardingFragment::class.java, null)
        }
    }

    companion object {
        private const val KEY_CONFIGURATION_CLASS = "configuration_class"

        fun bundle(clazz: Class<out OnboardingFragment.Configuration>): Bundle {
            return bundleOf(KEY_CONFIGURATION_CLASS to clazz)
        }
    }
}

class VariedFragmentFactory(
    private val configuration: OnboardingFragment.Configuration
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return OnboardingFragment(configuration)
    }

    class Factory @Inject constructor() {
        fun create(configuration: OnboardingFragment.Configuration): VariedFragmentFactory {
            return VariedFragmentFactory(configuration)
        }
    }
}