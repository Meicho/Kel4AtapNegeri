package Adapter

import Model.ModelGunung
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.atapnegeri.R
import com.example.atapnegeri.activities.DetailGunung

class ListGunungAdapter(private val context: Context, private val modelGunung:
List<ModelGunung>) : RecyclerView.Adapter<ListGunungAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_gunung, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelGunung[position]


        Glide.with(context)
            .load(data.strImageGunung)
            .into(holder.imageGunung)

        holder.tvNamaGunung.text = data.strNamaGunung
        holder.tvLokasiGunung.text = data.strLokasiGunung

        holder.cvListGunung.setOnClickListener {
            val intent = Intent(context, DetailGunung::class.java)
            context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return modelGunung.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvListGunung: CardView
        var imageGunung: ImageView
        var tvNamaGunung: TextView
        var tvLokasiGunung: TextView

        init {
            cvListGunung = itemView.findViewById(R.id.cvListGunung)
            imageGunung = itemView.findViewById(R.id.imageGunung)
            tvNamaGunung = itemView.findViewById(R.id.tvNamaGunung)
            tvLokasiGunung = itemView.findViewById(R.id.tvLokasiGunung)
        }
    }
}