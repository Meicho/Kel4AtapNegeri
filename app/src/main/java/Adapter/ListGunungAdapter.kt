package Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.atapnegeri.R

class ListGunungAdapter(private val context: Context, private val modelGunung:
List<ModelGunung>) : RecyclerView.Adapter<ListGunungAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_gunung, parent, false)
        return ViewHolder(view)
    }
}