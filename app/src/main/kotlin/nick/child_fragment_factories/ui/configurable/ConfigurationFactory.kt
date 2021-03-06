package nick.child_fragment_factories.ui.configurable

import javax.inject.Inject
import javax.inject.Provider

class ConfigurationFactory @Inject constructor(
    private val map: Map<Class<out OnboardingFragment.Configuration>, @JvmSuppressWildcards Provider<OnboardingFragment.Configuration>>
) {

    fun create(clazz: Class<out OnboardingFragment.Configuration>): OnboardingFragment.Configuration {
        return requireNotNull(map[clazz]?.get())
    }
}