package builders.kargo.env

internal object Parser {

    fun parse(content: String): Map<String, String> {
        return content
            .lines()
            .mapNotNull(::parseLine)
            .toMap()
    }

    private fun parseLine(line: String): Pair<String, String>? {
        val trimmed = line.trim()

        if (trimmed.isEmpty() || trimmed.startsWith("#")) return null

        val idx = trimmed.indexOf('=')
        if (idx <= 0) return null

        val key = trimmed.substring(0, idx).trim()
        val value = trimmed.substring(idx + 1).trim()

        return key to unquote(value)
    }

    private fun unquote(value: String): String {
        return if (
            (value.startsWith('"') && value.endsWith('"')) ||
            (value.startsWith('\'') && value.endsWith('\''))
        ) {
            value.substring(1, value.length - 1)
        } else value
    }
}