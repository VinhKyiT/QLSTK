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

import tech.vktl.qlsotietkiem.R;
import tech.vktl.qlsotietkiem.models.ModelCategory;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    private Context context;
    private ArrayList<ModelCategory> modelCategoryList;
    private ModelCategory modelCategory;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ModelCategory> modelCategoryList){
        this.modelCategoryList = modelCategoryList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        modelCategory = modelCategoryList.get(position);
        if (modelCategory == null){
            return;
        }
        holder.mCateNameTv.setText(modelCategory.getCateName());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.mCateRecv.setLayoutManager(linearLayoutManager);

        MyPlanAdapter myPlanAdapter = new MyPlanAdapter();
        myPlanAdapter.setData(modelCategory.getMyPlanArrayList());
        holder.mCateRecv.setAdapter(myPlanAdapter);
    }

    @Override
    public int getItemCount() {
        return modelCategoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView mCateNameTv;
        RecyclerView mCateRecv;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mCateNameTv = itemView.findViewById(R.id.categoryNameTv);
            mCateRecv = itemView.findViewById(R.id.categoryRecv);
        }
    }
}
