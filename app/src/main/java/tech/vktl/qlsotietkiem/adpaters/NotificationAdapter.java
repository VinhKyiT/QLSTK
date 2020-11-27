package tech.vktl.qlsotietkiem.adpaters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tech.vktl.qlsotietkiem.NotificationDetailAct;
import tech.vktl.qlsotietkiem.R;
import tech.vktl.qlsotietkiem.models.ModelNotification;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotiViewHolder>{

    List<ModelNotification> notificationList;
    Context context;

    public NotificationAdapter(Context context, List<ModelNotification> notificationList) {
        this.notificationList = notificationList;
        this.context = context;
    }


    @NonNull
    @Override
    public NotiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_noti, parent, false);

        return new NotiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotiViewHolder holder, int position) {
        String title = notificationList.get(position).getNotiTitle();
        String content = notificationList.get(position).getNotiContent();
        String date = notificationList.get(position).getNotiDate();

        boolean isRead = notificationList.get(position).isReadStatus();

        holder.notiTitleTv.setText(title);
        holder.notiContentTv.setText(content);
        holder.notiDateTv.setText(date);
        if (isRead){
            holder.readStatusIv.setImageResource(R.drawable.ic_read);
        }else holder.readStatusIv.setImageResource(R.drawable.ic_unread);

        holder.notiItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NotificationDetailAct.class);
                context.startActivity(intent);
                notificationList.get(position).setReadStatus(true);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    class NotiViewHolder extends RecyclerView.ViewHolder{

        TextView notiTitleTv, notiContentTv, notiDateTv;
        ImageView readStatusIv;
        LinearLayout notiItem;

        public NotiViewHolder(@NonNull View itemView) {
            super(itemView);
            notiTitleTv = itemView.findViewById(R.id.notifiTitleTv);
            notiContentTv = itemView.findViewById(R.id.notifiContentTv);
            notiDateTv = itemView.findViewById(R.id.notifiDateTv);
            readStatusIv = itemView.findViewById(R.id.readStatusIv);
            notiItem = itemView.findViewById(R.id.notiItemLinear);
        }
    }
}
