package android.myapp.dictionary_app

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var btnSearch: Button
    lateinit var editTextSearch: EditText
    lateinit var viewModel: DictionaryViewModel
    lateinit var viewModelFactory:DictionaryViewModelFactory
    lateinit var query: String
    lateinit var textViewWord: TextView
    lateinit var textViewHeading: TextView
    lateinit var definitionsList: RecyclerView
    lateinit var textViewDefinition: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

        // get reference to textviews
        textViewWord = findViewById<TextView>(R.id.txt_word)
        textViewDefinition = findViewById<TextView>(R.id.txt_Definition)
        textViewHeading = findViewById<TextView>(R.id.txt_heading)
         // get reference to edit text
          editTextSearch = findViewById<EditText>(R.id.edit_text_query)
        // get reference to button
        btnSearch = findViewById<Button>(R.id.btn_search)

        //get reference to recyclerview
        definitionsList = findViewById<RecyclerView>(R.id.recyclerview_definitions)
        definitionsList.layoutManager = LinearLayoutManager(this)



        // set on-click listener
        btnSearch.setOnClickListener {
            query = editTextSearch.text.toString()
            viewModel.getWordDetails(query)
            }

        //call to bind views
        bindData()

    }
    /*
      Bind data and views and setting up LiveData observation relationship
     */
    private fun bindData(){
        query = ""
        viewModelFactory = DictionaryViewModelFactory(query)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(DictionaryViewModel::class.java)

        //Setting up LiveData observation relationship
        viewModel.response?.observe(this, Observer {
            if (it!=null){

                //set view's visibility and display data
                setViewsVisibility(true)
                textViewWord.setText(it.word)
                //Get word definitions and bind to the recyclerview
                val adapter = it.meanings?.get(0)?.let { it1 -> WordDefinitionAdapter(it1.definitions) }
                definitionsList.adapter = adapter
            }else{
                //Hide views, since no data for the input query
                setViewsVisibility(false)
                textViewHeading.setText("No Results Found")
                setViewsVisibility(false)
            }

        })
    }
    /*
     When there is no definition for the input word (data is null), hide the recyclerview and header view,
     otherwise show it.
     */
    private fun setViewsVisibility(status:Boolean){
        if(status){
            textViewWord.visibility = View.VISIBLE
            definitionsList.visibility = View.VISIBLE
            textViewDefinition.visibility = View.VISIBLE
            textViewHeading.visibility = View.GONE
        }
        else
        {
            textViewWord.visibility = View.GONE
            definitionsList.visibility = View.GONE
            textViewDefinition.visibility = View.GONE
            textViewHeading.visibility = View.VISIBLE
        }
    }

}