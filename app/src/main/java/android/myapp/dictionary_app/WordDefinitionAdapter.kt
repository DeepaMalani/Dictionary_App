package android.myapp.dictionary_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*
 An adapter used to bind recyclerview data(definitions)
 */


class WordDefinitionAdapter(private val mList: List<Definition>) : RecyclerView.Adapter<WordDefinitionAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the view that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.definition_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]
        // sets the text  from our itemHolder class
       holder.textViewDefinition.setText( (position+1).toString() + ". " +itemsViewModel.definition)


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to the text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val textViewDefinition: TextView = itemView.findViewById(R.id.txt_view_definition)
    }
}
