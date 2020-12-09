package tech.vktl.qlsotietkiem.adpaters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tech.vktl.qlsotietkiem.MainActivity;
import tech.vktl.qlsotietkiem.PlanCreateAct;
import tech.vktl.qlsotietkiem.R;
import tech.vktl.qlsotietkiem.models.ModelPlan;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.PlanViewHolder> {

    private List<ModelPlan> mPlans;
    private Context context;

    public void setData(List<ModelPlan> mPlans){
        this.mPlans = mPlans;
        notifyDataSetChanged();
    }

    public PlanAdapter() {
    }

    public PlanAdapter(Context context, List<ModelPlan> mPlans) {
        this.context = context;
        this.mPlans = mPlans;
    }

    @NonNull
    @Override
    public PlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_plans, parent, false);
        return new PlanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanViewHolder holder, int position) {
        ModelPlan modelPlan = mPlans.get(position);
        if (modelPlan == null){
            return;
        }
        holder.mPlanImageIv.setImageResource(modelPlan.getResourceId());
        holder.mPNameTv.setText(modelPlan.getName());
        holder.mItemPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, PlanCreateAct.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mPlans != null){
            return mPlans.size();
        }
        return 0;
    }

    public class PlanViewHolder extends RecyclerView.ViewHolder {
        private ImageView mPlanImageIv;
        private TextView mPNameTv;
        CardView mItemPlan;
        public PlanViewHolder(@NonNull View itemView) {
            super(itemView);
            mPlanImageIv = itemView.findViewById(R.id.planImageIv);
            mPNameTv = itemView.findViewById(R.id.pNameTv);
            mItemPlan = itemView.findViewById(R.id.itemPlan);
        }
    }
}
