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

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = modelGunung[position]

        Glide.with(context)
            .load(data.strImageGunung)
            .into(holder.imageGunung)

        holder.tvNamaGunung.text = data.strNamaGunung
        holder.tvLokasiGunung.text = data.strLokasiGunung

        holder.cvListGunung.setOnClickListener {
            val intent = Intent(context, DetailGunungActivity::class.java)
            intent.putExtra(DetailGunungActivity.DETAIL_GUNUNG, modelGunung[position])
            context.startActivity(intent)
        }
    }

}