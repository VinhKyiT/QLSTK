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

import java.util.ArrayList;

import tech.vktl.qlsotietkiem.R;
import tech.vktl.qlsotietkiem.models.ModelMyPlan;

public class MyPlanAdapter extends RecyclerView.Adapter<MyPlanAdapter.MyHolder> {

    ArrayList<ModelMyPlan> myPlanList;
    Context context;

    public MyPlanAdapter(Context context, ArrayList<ModelMyPlan> myPlanList){
        this.context = context;
        this.myPlanList = myPlanList;
    }

    public MyPlanAdapter() {

    }

    public void setData(ArrayList<ModelMyPlan> myPlanList){
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

    }

    @Override
    public int getItemCount() {
        return myPlanList.size();
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
