package android.myapp.dictionary_app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/*
Using factory class can pass data into DictionaryViewModel
 */
class DictionaryViewModelFactory(private val word:String) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DictionaryViewModel::class.java)) {
            return DictionaryViewModel(word) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}