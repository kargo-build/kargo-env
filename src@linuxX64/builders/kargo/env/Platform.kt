@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package builders.kargo.env

import kotlinx.cinterop.*
import platform.posix.*

@ExperimentalForeignApi
internal actual object Platform {

    actual fun readFileOrNull(path: String): String? {
        val file = fopen(path, "r") ?: return null

        return buildString {
            val buffer = ByteArray(1024)

            while (true) {
                val line = buffer.usePinned {
                    fgets(it.addressOf(0), buffer.size, file)
                } ?: break

                append(buffer.decodeToString().takeWhile { it != '\u0000' })
            }

            fclose(file)
        }
    }

    actual fun getenv(key: String): String? =
        platform.posix.getenv(key)?.toKString()
}