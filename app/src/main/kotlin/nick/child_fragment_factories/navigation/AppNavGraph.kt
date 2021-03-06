package nick.child_fragment_factories.navigation

object AppNavGraph {
    private var counter = 1
    val id = counter++

    object Destination {
        val main = counter++
        val varied = counter++
        val greeting = counter++
    }
}