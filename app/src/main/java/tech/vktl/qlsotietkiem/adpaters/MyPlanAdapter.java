package tech.vktl.qlsotietkiem.adpaters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tech.vktl.qlsotietkiem.models.ModelMyPlan;

public class MyPlanAdapter extends RecyclerView.Adapter<MyPlanAdapter.MyHolder> {

    ArrayList<ModelMyPlan> myPlanList;
    Context context;

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return myPlanList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        public MyHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
