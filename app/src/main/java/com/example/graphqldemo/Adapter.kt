package com.example.graphqldemo

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.GetLocQuery
import com.google.android.material.textview.MaterialTextView
import java.text.DecimalFormat

class Adapter(
    var activity: Activity,
    var arrayList: ArrayList<GetLocQuery.Result>,

) : RecyclerView.Adapter<Adapter.myviewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapter.myviewHolder {
        return myviewHolder(
            LayoutInflater.from(activity).inflate(R.layout.coloumn_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Adapter.myviewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {

        return arrayList.size
    }

    inner class myviewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        var text1 = itemView.findViewById<TextView>(R.id.text1)
        var text2 = itemView.findViewById<TextView>(R.id.text2)
        var text3 = itemView.findViewById<TextView>(R.id.text3)
        var text4 = itemView.findViewById<TextView>(R.id.text4)
        var text5 = itemView.findViewById<TextView>(R.id.text5)

        fun bind(position: Int) {
            var array = arrayList[position]

            text2.text = "Name :"+array.name
            text3.text = "Type :"+array.type
            text4.text = "Dimention :"+array.dimension
            text5.text = "Created :"+array.created
            text1.text = "Created :"+array.id

        }
    }





}