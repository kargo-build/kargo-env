package builders.kargo.env

object Dotenv {

    private val envVars = mutableMapOf<String, String>()

    fun load(path: String = ".env") {
        val content = Platform.readFileOrNull(path) ?: return

        envVars.clear()
        envVars.putAll(Parser.parse(content))
    }

    operator fun get(key: String): String? =
        envVars[key]
}