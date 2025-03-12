import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thedomain.benboyceassessment.Country
import com.thedomain.benboyceassessment.R

class CountryAdapter (private val dataSet: List<Country>, private val context: Context) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
        //
        //     * Country object contains:
        //     * capital
        //     * code
        //     * Currency - Object class
        //     * flag
        //     * Language - Object class
        //     * name
        //

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Define click listener for the ViewHolder's View
        val nameTV: TextView = view.findViewById(R.id.name)
        val regionTV: TextView = view.findViewById(R.id.region)
        val codeTV: TextView = view.findViewById(R.id.code)
        val captialTV: TextView = view.findViewById(R.id.capital)
        val flagIV: ImageView = view.findViewById(R.id.flag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.country, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        holder.nameTV.text = dataSet[position].name
        holder.regionTV.text = dataSet[position].region
        holder.codeTV.text = dataSet[position].code
        holder.captialTV.text = dataSet[position].capital

        Glide
            .with(context)
            .load(dataSet[position].flag)
            .into(holder.flagIV)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}