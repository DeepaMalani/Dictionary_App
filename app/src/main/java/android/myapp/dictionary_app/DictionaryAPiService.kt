package android.myapp.dictionary_app

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL = "https://api.dictionaryapi.dev/"

/**
 * Use the Retrofit builder to build a retrofit object using a GSON converter
 *
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


/**
 * A public interface that exposes the [getWordDetails] method
 */
interface DictionaryApiService {
    /**
     * Returns a Retrofit callback that delivers a List of WordDefinition
     *
     */

    @GET("api/v2/entries/en/{word}")
    fun getWordDetails(@Path("word") word: String): Call<List<WordDefinition>>

}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object DictionaryApi {
    val retrofitService : DictionaryApiService by lazy { retrofit.create(DictionaryApiService::class.java) }
}