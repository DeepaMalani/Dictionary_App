package android.myapp.dictionary_app

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
ViewModel for the Main activity that display API response
 */
class DictionaryViewModel(word:String) : ViewModel(){

    // The internal MutableLiveData  that stores the most recent response
    private val _response = MutableLiveData<WordDefinition>()

    // The external immutable LiveData for the response
    val response: LiveData<WordDefinition>
        get() = _response

    // A function which calls the API and gets response
    fun getWordDetails(word:String) {
        DictionaryApi.retrofitService.getWordDetails(word).enqueue( object: Callback<List<WordDefinition>> {
            override fun onFailure(call: Call<List<WordDefinition>>, t: Throwable) {
                _response.value = null
            }

            override fun onResponse(call: Call<List<WordDefinition>>, response: Response<List<WordDefinition>>) {
                _response.value = response?.body()?.get(0)

            }
        })


    }



}