package Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.atapnegeri.R

class PeralatanAdapter(private val context: Context, private val modelPeralatan:
List<ModelPeralatan>) : RecyclerView.Adapter<PeralatanAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListGunungAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_peralatan_tips, parent, false)
        return ListGunungAdapter.ViewHolder(view)
    }
}