package builders.kargo.env

internal expect object Platform {
    fun readFileOrNull(path: String): String?
    fun getenv(key: String): String?
}