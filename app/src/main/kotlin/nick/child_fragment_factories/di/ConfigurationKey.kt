package nick.child_fragment_factories.di

import dagger.MapKey
import nick.child_fragment_factories.ui.configurable.OnboardingFragment
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ConfigurationKey(val value: KClass<out OnboardingFragment.Configuration>)
