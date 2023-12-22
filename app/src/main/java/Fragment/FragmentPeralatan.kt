package Fragment

import Adapter.PeralatanAdapter
import Model.ModelPeralatan
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.atapnegeri.R
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.StandardCharsets

class FragmentPeralatan : Fragment() {

    var modelPeralatan: MutableList<ModelPeralatan> = ArrayList()
    lateinit var peralatanAdapter: PeralatanAdapter
    lateinit var rvPeralatan: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_peralatan, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        rvPeralatan = view.findViewById(R.id.rvPeralatan)

        peralatanAdapter = PeralatanAdapter(requireContext(), modelPeralatan)
        rvPeralatan.setLayoutManager(LinearLayoutManager(context))
        rvPeralatan.setAdapter(peralatanAdapter)
        rvPeralatan.setHasFixedSize(true)

        getPeralatanGunung()
    }
    private fun getPeralatanGunung() {
        try {
            val stream = requireContext().assets.open("peralatan.json")
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            val strContent = String(buffer, StandardCharsets.UTF_8)
            try {
                val jsonObject = JSONObject(strContent)
                val jsonArray = jsonObject.getJSONArray("peralatan")
                for (i in 0 until jsonArray.length()) {
                    val jsonObjectData = jsonArray.getJSONObject(i)
                    val dataApi = ModelPeralatan()
                    dataApi.strNamaPeralatan = jsonObjectData.getString("nama")
                    dataApi.strImagePeralatan = jsonObjectData.getString("image_url")
                    dataApi.strTipePeralatan = jsonObjectData.getString("tipe")
                    dataApi.strDeskripsiPeralatan = jsonObjectData.getString("deskripsi")
                    dataApi.strTipsPeralatan = jsonObjectData.getString("tips")
                    modelPeralatan.add(dataApi)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        } catch (ignored: IOException) {
            Toast.makeText(context, "Oops, ada yang tidak beres. Coba ulangi beberapa saat lagi.", Toast.LENGTH_SHORT).show()
        }
    }
}