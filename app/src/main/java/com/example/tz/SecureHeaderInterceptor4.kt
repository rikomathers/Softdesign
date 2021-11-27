
import android.text.TextUtils

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.*


class SecureHeadersInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val header: String = request.header(BEARER_TOKEN_TEMPLATE)?:""
        val requestBuilder: Request.Builder = request.newBuilder()
        if (TextUtils.isEmpty(header)) {
            val headerContent = TOKEN
            val tokenHeader: String =
                java.lang.String.format(Locale.US, BEARER_TOKEN_TEMPLATE, headerContent)
            requestBuilder.removeHeader("Bearer")
            requestBuilder.addHeader("Bearer", tokenHeader)
        }
        return chain.proceed(requestBuilder.build())
    }

    companion object {
        private const val BEARER_TOKEN_TEMPLATE = "Bearer %s"
        private const val TOKEN =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYwZTBhNzU2NTBlZmYwM2M4NGU3ZTA1YiIsInJvbGUiOiJzdXBlcmFkbWluIiwib3duZXIiOiJzdXBlcmFkbWluIiwiaWF0IjoxNjI1NDA1NDA1LCJleHAiOjE2MjYwMTAyMDV9.B6Y2JXfF28g62QdQCf577L3sLMcAOY95RSKhcCGWrXU"
    }
}