package Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.atapnegeri.R
import com.example.atapnegeri.activities.DetailPeralatan

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
}