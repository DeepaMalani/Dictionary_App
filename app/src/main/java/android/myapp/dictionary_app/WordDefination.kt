package android.myapp.dictionary_app
import com.google.gson.annotations.SerializedName

/*
Classes used to convert API response to Kotlin objects
 */
class WordDefinition(
    @SerializedName("word")
    val word:String? = "",
    @SerializedName("meanings")
    val meanings:List<Meanings>?,
)
class Meanings(
    @SerializedName("partOfSpeech")
    val partOfSpeech:String? = "",
    @SerializedName("definitions")
    val definitions:List<Definition>,
)
 class Definition(
    @SerializedName("definition")
    val definition:String?,
    @SerializedName("example")
    val example:String? = "",
 )