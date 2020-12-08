package tech.vktl.qlsotietkiem.models;

public class ModelUser {
    String id, username, password, rights, hoten, dienthoai, diachi, imageProfile;

    public ModelUser() {
    }

    public ModelUser(String id, String username, String password, String rights, String hoten, String dienthoai, String diachi, String imageProfile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rights = rights;
        this.hoten = hoten;
        this.dienthoai = dienthoai;
        this.diachi = diachi;
        this.imageProfile = imageProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }
}
