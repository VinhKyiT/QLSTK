package tech.vktl.qlsotietkiem.models;

public class ModelPromo {
    private int resourceId;
    private String title, content;

    public ModelPromo(int resourceId, String title, String content) {
        this.resourceId = resourceId;
        this.title = title;
        this.content = content;
    }

    public ModelPromo() {
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
