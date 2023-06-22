package com.denizk0461.bsag.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.denizk0461.bsag.R
import com.denizk0461.bsag.databinding.ItemLineBinding
import com.denizk0461.bsag.databinding.ItemLineDiversionBinding
import com.denizk0461.bsag.model.Diversion
import com.denizk0461.bsag.model.Line
import com.denizk0461.bsag.model.LineWithDiversions
import com.denizk0461.bsag.util.AppDiffUtilCallback
import com.denizk0461.bsag.util.getConstrast
import com.denizk0461.bsag.util.getThemedColor

class LineDiversionAdapter(
    private val onClickListener: OnClickListener,
) : RecyclerView.Adapter<LineDiversionAdapter.LineDiversionViewHolder>() {

    private val items: MutableList<LineWithDiversions> = mutableListOf()
    private var expandedPosition = -1

    class LineDiversionViewHolder(val binding: ItemLineBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineDiversionViewHolder =
        LineDiversionViewHolder(
            ItemLineBinding.inflate(
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
        val inflater = LayoutInflater.from(context)

        val backgroundColor = context.theme.getThemedColor(item.line.color.webColor)
        val contrast = backgroundColor.getConstrast()

        var readCounter = 0
        var unreadCounter = 0

        if (expandedPosition != -1) {
            holder.binding.expandableContainer.visibility = if (expandedPosition == position) {
                View.VISIBLE
            } else {
                View.GONE
            }
        } else {
            holder.binding.expandableContainer.visibility = View.GONE
        }

        holder.binding.cardBackground.also { card ->
            card.backgroundTintList = ColorStateList.valueOf(backgroundColor)
            card.setOnClickListener {

//                val previousExpandedPosition = expandedPosition
//                expandedPosition = position
//                notifyItemChanged(previousExpandedPosition)

//                onClickListener.onLineClick(item.line)
//                TransitionManager.beginDelayedTransition(holder.binding.root.parent as ViewGroup)

                holder.binding.expandableContainer.also { container ->
                    when (container.visibility) {
                        View.VISIBLE -> {
                            holder.binding.imageArrowExpand.setImageResource(R.drawable.arrow_expand)
                            container.visibility = View.GONE
                        }
                        else -> {
                            holder.binding.imageArrowExpand.setImageResource(R.drawable.arrow_retract)
                            container.visibility = View.VISIBLE
                        }
                    }
//                    TransitionManager.beginDelayedTransition(holder.binding.root)

                    // Hides elements at the bottom of the list
                }
            }
        }

        holder.binding.imageArrowExpand.imageTintList = ColorStateList.valueOf(contrast)
        holder.binding.divider.dividerColor = contrast

        holder.binding.textLineName.also { name ->
            name.text = item.line.name
            name.setTextColor(contrast)
        }

        // clear diversion container
        holder.binding.containerDiversions.removeAllViews()

        item.diversions.forEach { diversion ->

            // Inflate the view binding for the diversion
            val diversionBinding = ItemLineDiversionBinding.inflate(inflater)

            diversionBinding.textTitle.text = diversion.title
            diversionBinding.textTitle.setTextColor(contrast)

            diversionBinding.textDescription.text = diversion.description
            diversionBinding.textDescription.setTextColor(contrast)

            diversionBinding.imageArrow.imageTintList = ColorStateList.valueOf(contrast)

            if (diversion.read) {
                readCounter += 1
            } else {
                unreadCounter += 1
            }

            holder.binding.containerDiversions.addView(diversionBinding.root)

            // set click listener
            // click opens sheet and read value (in fragment?)
        }

        holder.binding.textRead.text = readCounter.toString()
        holder.binding.textRead.setTextColor(contrast)
        holder.binding.textRead.compoundDrawableTintList = ColorStateList.valueOf(contrast)

        holder.binding.textUnread.text = unreadCounter.toString()
        holder.binding.textUnread.setTextColor(contrast)
        holder.binding.textUnread.compoundDrawableTintList = ColorStateList.valueOf(contrast)
    }

    /**
     * Updates the data and calculates the difference between the old dataset and the newly provided
     * dataset.
     *
     * @param newItems   new dataset to be displayed
     */
    fun setNewData(newItems: List<LineWithDiversions>) {
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
        fun onLineClick(line: Line)
        fun onDiversionClick(diversion: Diversion)
    }
}