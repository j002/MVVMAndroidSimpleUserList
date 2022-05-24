package com.fr.djibril.listusermvvm.ui.user.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fr.djibril.listusermvvm.R
import com.fr.djibril.listusermvvm.models.ResponseUserListItem

class UserListAdapter(private var items: List<ResponseUserListItem?>?, val context: Context) :
    RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_user_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val user = items!![position]

        holder.nameUser.text = user!!.name
        holder.jobTitle.text = user.jobTitle

        holder.ivIsOld.let {
            if (user.isOld!!) {
                Glide.with(context)
                    .load(ContextCompat.getDrawable(context, R.drawable.valid))
                    .into(it)
            } else {
                Glide.with(context)
                    .load(ContextCompat.getDrawable(context, R.drawable.invalid))
                    .into(it)
            }
        }
    }

    override fun getItemCount() = items!!.size

    fun setList(list: List<ResponseUserListItem?>?) {
        items = list
        notifyDataSetChanged()
    }
}

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivUSer: ImageView = view.findViewById(R.id.tv_name_user)
    val ivIsOld: ImageView = view.findViewById(R.id.iv_is_old)
    val nameUser: TextView = view.findViewById(R.id.tv_name_user)
    val jobTitle: TextView = view.findViewById(R.id.tv_job_title_user)
}
