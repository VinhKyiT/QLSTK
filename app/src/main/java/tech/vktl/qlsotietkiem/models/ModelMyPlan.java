package tech.vktl.qlsotietkiem.models;

public class ModelMyPlan {
    String planType, planName, planProgress;

    public ModelMyPlan(String planType, String planName, String planProgress) {
        this.planType = planType;
        this.planName = planName;
        this.planProgress = planProgress;
    }

    public ModelMyPlan() {
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanProgress() {
        return planProgress;
    }

    public void setPlanProgress(String planProgress) {
        this.planProgress = planProgress;
    }
}
