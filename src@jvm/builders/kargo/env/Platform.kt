package builders.kargo.env

import java.io.File

internal actual object Platform {

    actual fun readFileOrNull(path: String): String? =
        runCatching { File(path).readText() }.getOrNull()

    actual fun getenv(key: String): String? =
        System.getenv(key)
}