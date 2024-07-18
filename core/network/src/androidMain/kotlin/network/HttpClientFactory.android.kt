package network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.*
actual fun createPlatformHttpClient(): HttpClient {
    return HttpClient(OkHttp) {
        engine {
            config {
                followRedirects(true)
            }
        }
    }
}


