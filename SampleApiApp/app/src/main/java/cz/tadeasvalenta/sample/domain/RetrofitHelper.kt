package cz.tadeasvalenta.sample.domain

import com.squareup.moshi.Moshi
import cz.tadeasvalenta.sample.domain.adapters.LiveDataCallAdapterFactory
import cz.tadeasvalenta.sample.constants.NetworkConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    val instance: IApi by lazy {
        val moshi = Moshi.Builder().build()
        val okHttpClient = OkHttpClient.Builder().apply {
            connectTimeout(NetworkConstants.CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            writeTimeout(NetworkConstants.WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            readTimeout(NetworkConstants.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        }.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(NetworkConstants.API_ENDPOINT)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
        retrofit.create(IApi::class.java)
    }
}
