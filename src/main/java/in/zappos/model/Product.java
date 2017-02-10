package in.zappos.model;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("brandName")
    public String brandName;
    @SerializedName("thumbnailImageUrl")
    public String thumbnail;
    @SerializedName("productId")
    public String productId;
    @SerializedName("originalPrice")
    public String originalPrice;
    @SerializedName("styleId")
    public String styleId;
    @SerializedName("colorId")
    public String colorId;
    @SerializedName("price")
    public String price;
    @SerializedName("percentOff")
    public String percentOff;
    @SerializedName("productUrl")
    public String productUrl;
    @SerializedName("productName")
    public String productName;

    public Product(String brandName, String thumbnail, String productId, String originalPrice, String styleId, String colorId,
                   String price, String percentOff, String productUrl, String productName) {
        this.brandName = brandName;
        this.thumbnail = thumbnail;
        this.productId = productId;
        this.originalPrice = originalPrice;
        this.styleId = styleId;
        this.colorId = colorId;
        this.price = price;
        this.percentOff = percentOff;
        this.productUrl = productUrl;
        this.productName = productName;
    }

    public Product(String brandName, String price, String productName) {
        this.brandName = brandName;
        this.price = price;
        this.productName = productName;
    }

    public Product() {

    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getProductId() {
        return productId;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public String getStyleId() {
        return styleId;
    }

    public String getColorId() {
        return colorId;
    }

    public String getPrice() {
        return price;
    }

    public String getPercentOff() {
        return percentOff;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public String getProductName() {
        return productName;
    }
}
