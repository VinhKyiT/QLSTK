package tech.vktl.qlsotietkiem.adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import tech.vktl.qlsotietkiem.R;
import tech.vktl.qlsotietkiem.models.ModelMyPlan;

public class MyPlanAdapter extends RecyclerView.Adapter<MyPlanAdapter.MyHolder> {

    List<ModelMyPlan> myPlanList;
    Context context;

    public MyPlanAdapter(Context context, List<ModelMyPlan> myPlanList){
        this.context = context;
        this.myPlanList = myPlanList;
    }

    public MyPlanAdapter() {

    }

    public void setData(List<ModelMyPlan> myPlanList){
        this.myPlanList = myPlanList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_my_plan, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        ModelMyPlan modelMyPlan = myPlanList.get(position);
        if (modelMyPlan == null){
            return;
        }
        holder.mPlanNameTv.setText(modelMyPlan.getPlanName());
        holder.mPlanTypeTv.setText(modelMyPlan.getPlanType());
        holder.mPlanProgressTv.setText(modelMyPlan.getPlanProgress());
        holder.mPlanProgressPb.setProgress(Integer.parseInt(modelMyPlan.getPlanProgress()));
    }

    @Override
    public int getItemCount() {
        if (myPlanList != null){
            return myPlanList.size();
        }
        return 0;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView mPlanTypeTv, mPlanNameTv, mPlanProgressTv;
        ProgressBar mPlanProgressPb;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mPlanNameTv = itemView.findViewById(R.id.planNameTv);
            mPlanTypeTv = itemView.findViewById(R.id.planTypeTv);
            mPlanProgressTv = itemView.findViewById(R.id.planProgressTv);
            mPlanProgressPb = itemView.findViewById(R.id.planProgressPb);
        }
    }
}
