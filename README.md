# kargo-env


## 📦 Installation

Add the dependency to your `kargo.toml` (or equivalent):

```yaml
sources:
  - github: kargo-build/kargo-env
    version: 1.0.0
```

> Uses Kargo dependency manager. Versions follow semantic versioning.

Lightweight .env loader for Kotlin Multiplatform, with simple parsing, environment variable support, and a clean, predictable API.

## ✨ Features

- Multiplatform (JVM + Native)
- Zero dependencies
- Simple `.env` parsing
- System environment override support
- Clean and minimal API

## 🚀 Usage

### Load `.env`

```kotlin
import kargo.env.Dotenv

Dotenv.load()
```

### Read variables

```kotlin
import kargo.env.env

val dbUrl = env("DB_URL")
val port = env("PORT", "8080")
```

## ⚙️ Behavior

- System environment variables take precedence over `.env`
- `.env` is optional
- Comments (`#`) and empty lines are ignored

## 📄 Example

```
DB_URL=postgres://localhost:5432/db
PORT=3000
SECRET_KEY="my-secret"
```