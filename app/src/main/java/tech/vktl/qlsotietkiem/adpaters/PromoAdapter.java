package tech.vktl.qlsotietkiem.adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tech.vktl.qlsotietkiem.R;
import tech.vktl.qlsotietkiem.models.ModelPromo;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.PromoHolder>{

    Context context;
    List<ModelPromo> promoList;

    public PromoAdapter(Context context, List<ModelPromo> promoList) {
        this.context = context;
        this.promoList = promoList;
    }

    @NonNull
    @Override
    public PromoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_promo, parent, false);
        return new PromoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromoHolder holder, int position) {
        int resId = promoList.get(position).getResourceId();
        String title = promoList.get(position).getTitle();
        String content = promoList.get(position).getContent();

        holder.mImgV.setImageResource(resId);
        holder.mTvTitle.setText(title);
        holder.mTvContent.setText(content);
    }

    @Override
    public int getItemCount() {
        return promoList.size();
    }

    class PromoHolder extends RecyclerView.ViewHolder{

        TextView mTvTitle, mTvContent;
        ImageView mImgV;
        public PromoHolder(@NonNull View itemView) {
            super(itemView);
            mImgV = itemView.findViewById(R.id.ivNotiImg);
            mTvTitle = itemView.findViewById(R.id.tvNotiTitle);
            mTvContent = itemView.findViewById(R.id.tvNotiContent);
        }
    }
}
