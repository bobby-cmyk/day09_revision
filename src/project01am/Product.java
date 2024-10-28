package project01am;

import java.util.Date;

public class Product {
    private long id;
    private String prodName;
    private String prodDesc;
    private String prodCat;
    private float price;
    private Date createdDate;

    public Product(long id, String prodName, String prodDesc, String prodCat, float price) {
        this.id = id;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodCat = prodCat;
        this.price = price;
        this.createdDate = Date.from(java.time.ZonedDateTime.now().toInstant());
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getProdName() {
        return prodName;
    }
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
    public String getProdDesc() {
        return prodDesc;
    }
    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }
    public String getProdCat() {
        return prodCat;
    }
    public void setProdCat(String prodCat) {
        this.prodCat = prodCat;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", prodCat=" + prodCat
                + ", price=" + price + ", createdDate=" + createdDate + "]";
    }

    
    
}
