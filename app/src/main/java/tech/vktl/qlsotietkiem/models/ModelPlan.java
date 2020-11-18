package tech.vktl.qlsotietkiem.models;

public class ModelPlan {
    private int resourceId;
    private String name;

    public ModelPlan(int resourceId, String name) {
        this.resourceId = resourceId;
        this.name = name;
    }

    public ModelPlan() {
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
