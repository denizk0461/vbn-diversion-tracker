package com.denizk0461.bsag.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.denizk0461.bsag.databinding.ItemLineDiversionBinding
import com.denizk0461.bsag.model.Line
import com.denizk0461.bsag.util.AppDiffUtilCallback
import com.denizk0461.bsag.util.getConstrast
import com.denizk0461.bsag.util.getThemedColor

class LineDiversionAdapter(
//    private val onClickListener: OnClickListener,
) : RecyclerView.Adapter<LineDiversionAdapter.LineDiversionViewHolder>() {

    private val items: MutableList<Line> = mutableListOf()

    class LineDiversionViewHolder(val binding: ItemLineDiversionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineDiversionViewHolder =
        LineDiversionViewHolder(
            ItemLineDiversionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: LineDiversionViewHolder, position: Int) {
        // Retrieve item for current position
        val item = items[position]

        val context = holder.binding.root.context

        val backgroundColor = context.theme.getThemedColor(item.color.webColor)

//        holder.binding.linearLayout.setBackgroundColor(backgroundColor)
        holder.binding.cardBackground.backgroundTintList = ColorStateList.valueOf(backgroundColor)

        holder.binding.text.text = "${item.name} (${item.vehicleType.name})"
        holder.binding.text.setTextColor(backgroundColor.getConstrast())
    }

    /**
     * Updates the data and calculates the difference between the old dataset and the newly provided
     * dataset.
     *
     * @param newItems   new dataset to be displayed
     */
    fun setNewData(newItems: List<Line>) {
        // Calculate the difference between the old list and the new list
        val diffResult = DiffUtil.calculateDiff(AppDiffUtilCallback(items, newItems))

        // Remove all items from the list
        items.clear()

        // Add all items from the new list
        items.addAll(newItems)

        // Tell the DiffUtil which items have changed between the two lists
        diffResult.dispatchUpdatesTo(this)
    }

    interface OnClickListener {
        fun onClick()
    }
}