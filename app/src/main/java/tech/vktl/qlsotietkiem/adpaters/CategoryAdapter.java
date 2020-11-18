package tech.vktl.qlsotietkiem.adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tech.vktl.qlsotietkiem.R;
import tech.vktl.qlsotietkiem.models.ModelCategory;
import tech.vktl.qlsotietkiem.models.ModelPlan;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    private Context context;
    private List<ModelCategory> modelCategories;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ModelCategory> modelCategories){
        this.modelCategories = modelCategories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        ModelCategory modelCategory = modelCategories.get(position);
        if (modelCategory == null){
            return;
        }
        holder.mCategoryNameTv.setText(modelCategory.getCateName());

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.mCategoryRecv.setLayoutManager(layoutManager);

        PlanAdapter planAdapter = new PlanAdapter();
        planAdapter.setData(modelCategory.getPlanList());
        holder.mCategoryRecv.setAdapter(planAdapter);
    }

    @Override
    public int getItemCount() {
        if (modelCategories != null){
            return modelCategories.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

       private TextView mCategoryNameTv;
       private RecyclerView mCategoryRecv;

       public CategoryViewHolder(@NonNull View itemView) {
           super(itemView);
           mCategoryNameTv = itemView.findViewById(R.id.categoryNameTv);
           mCategoryRecv = itemView.findViewById(R.id.categoryRecv);
       }
   }
}
