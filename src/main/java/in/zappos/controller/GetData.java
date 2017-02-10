package in.zappos.controller;

import java.util.List;

import in.zappos.model.Product;

public class GetData {

    public static String brandName[] = new String[10];
    public static String thumbnail[] = new String[10];
    public static String productId[] = new String[10];
    public static String originalPrice[] = new String[10];
    public static String styleId[] = new String[10];
    public static String colorId[] = new String[10];
    public static String price[] = new String[10];
    public static String percentOff[] = new String[10];
    public static String productUrl[] = new String[10];
    public static String productName[] = new String[10];

    public static void getData(List<Product> products) {
        for (int i = 0; i < MainActivity.no_of_products; i++) {
            brandName[i] = products.get(i).getBrandName();
            thumbnail[i] = products.get(i).getThumbnail();
            productId[i] = products.get(i).getProductId();
            originalPrice[i] = products.get(i).getOriginalPrice();
            styleId[i] = products.get(i).getStyleId();
            colorId[i] = products.get(i).getColorId();
            price[i] = products.get(i).getPrice();
            percentOff[i] = products.get(i).getPercentOff();
            productUrl[i] = products.get(i).getProductUrl();
            productName[i] = products.get(i).getProductName();
        }
    }

}
