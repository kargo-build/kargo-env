package build.kargo.env

fun env(key: String): String? =
    Platform.getenv(key) ?: Dotenv[key]

fun env(key: String, default: String): String =
    env(key) ?: default