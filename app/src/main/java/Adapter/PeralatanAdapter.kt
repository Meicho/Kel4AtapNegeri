package Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.atapnegeri.R
import com.example.atapnegeri.activities.DetailPeralatan

class PeralatanAdapter(private val context: Context, private val modelPeralatan:
List<ModelPeralatan>) : RecyclerView.Adapter<PeralatanAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_peralatan_tips, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeralatanAdapter.ViewHolder, position: Int) {
        val data = modelPeralatan[position]

       Glide.with(context)
           .load(data.strImagePeralatan)
           .load(holder.imagePeralatan)

        holder.tvNamaAlat.text = data.strNamaPeralatan
        holder.tvTipeAlat.text = data.strTipePeralatan

        holder.cvListPeralatan.setOnClickListener {
            val intent = Intent(context, DetailPeralatan::class.java)
            intent.putExtra(DetailPeralatan.DETAIL_PERALATAN, modelPeralatan[position])
            context.startActivity(intent)

        }

    }
    override fun getItemCount(): Int {
        return modelPeralatan.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var cvListPeralatan: CardView
        var imagePeralatan: ImageView
        var tvNamaAlat: TextView
        var tvTipeAlat: TextView

        init {
            cvListPeralatan = itemView.cvListPeralatan
            imagePeralatan = itemView.imagePeralatan
            tvNamaAlat = itemView.tvNamaAlat
            tvTipeAlat = itemView.tvTipeAlat
        }
    }
}