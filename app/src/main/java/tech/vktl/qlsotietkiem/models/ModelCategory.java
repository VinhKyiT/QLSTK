package tech.vktl.qlsotietkiem.models;

import java.util.ArrayList;
import java.util.List;

public class ModelCategory {

    private String cateName;
    private List<ModelPlan> mPlanList;
    private List<ModelMyPlan> myPlanList;

    public ModelCategory(String cateName, List<ModelPlan> mPlanList) {
        this.cateName = cateName;
        this.mPlanList = mPlanList;
    }

    public ModelCategory() {
    }


    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public List<ModelPlan> getPlanList() {
        return mPlanList;
    }

    public void setMyPlanList(List<ModelPlan> mPlanList) {
        this.mPlanList = mPlanList;
    }
}
