package tech.vktl.qlsotietkiem.models;

import android.widget.ImageView;

public class ModelNotification {
    private String notiTitle, notiContent, notiDate;
    private boolean readStatus;

    public ModelNotification(String notiTitle, String notiContent, String notiDate, boolean readStatus) {
        this.notiTitle = notiTitle;
        this.notiContent = notiContent;
        this.notiDate = notiDate;
        this.readStatus = readStatus;
    }

    public ModelNotification() {
    }

    public String getNotiTitle() {
        return notiTitle;
    }

    public void setNotiTitle(String notiTitle) {
        this.notiTitle = notiTitle;
    }

    public String getNotiContent() {
        return notiContent;
    }

    public void setNotiContent(String notiContent) {
        this.notiContent = notiContent;
    }

    public String getNotiDate() {
        return notiDate;
    }

    public void setNotiDate(String notiDate) {
        this.notiDate = notiDate;
    }

    public boolean isReadStatus() {
        return readStatus;
    }

    public void setReadStatus(boolean readStatus) {
        this.readStatus = readStatus;
    }
}
