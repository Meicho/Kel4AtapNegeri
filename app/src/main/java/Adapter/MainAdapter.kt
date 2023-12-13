package Adapter

import Model.ModelMain
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
import com.example.atapnegeri.activities.ListGunung

class MainAdapter(private val context: Context?, private val modelMain: List<ModelMain>) :
RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var imageLokasiDrawable = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelMain[position]

        holder.tvLokasi.text = data.strLokasi

        if (data.strLokasi == "Jawa Timur")
            imageLokasiDrawable = R.drawable.ic_jatim
        else if (data.strLokasi == "Jawa Tengah")
            imageLokasiDrawable = R.drawable.ic_jateng
        else if (data.strLokasi == "Jawa Barat")
            imageLokasiDrawable = R.drawable.ic_jabar
        else if (data.strLokasi == "Luar Pulau Jawa")
            imageLokasiDrawable = R.drawable.ic_luar_jawa

        holder.imagelokasi.setImageResource(imageLokasiDrawable)

        val onClickListener = holder.cvListLokasi.setOnClickListener {
            val intent = Intent(context, ListGunung::class.java)
            intent.putExtra(ListGunung.LIST_GUNUNG, modelMain[position])
            context?.startActivity(intent)
        }

        class ViewHolder(item: View) : RecyclerView.ViewHolder(itemView) {
            var cvListLokasi: CardView
            var tvLokasi: TextView
            var imageLokasi: ImageView

            init {
                cvListLokasi = itemView.cvListLokasi
                tvLokasi = itemView.tvLokasi
                imageLokasi = itemView.imageLokasi
            }
        }


    }
    override fun getItemCount(): Int {
        return modelMain.size
    }

}