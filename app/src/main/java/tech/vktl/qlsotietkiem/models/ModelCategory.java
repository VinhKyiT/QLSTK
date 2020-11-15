package tech.vktl.qlsotietkiem.models;

import java.util.ArrayList;

public class ModelCategory {

    private String cateName;
    private ArrayList<ModelMyPlan> myPlanArrayList;

    public ModelCategory(String cateName, ArrayList<ModelMyPlan> myPlanArrayList) {
        this.cateName = cateName;
        this.myPlanArrayList = myPlanArrayList;
    }

    public ModelCategory() {
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public ArrayList<ModelMyPlan> getMyPlanArrayList() {
        return myPlanArrayList;
    }

    public void setMyPlanArrayList(ArrayList<ModelMyPlan> myPlanArrayList) {
        this.myPlanArrayList = myPlanArrayList;
    }
}
