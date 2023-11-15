package mx.com.abarrotepopeye.constant;

public class ConstantsUrl {

    public static final String URL = "/popeye/api";

    public static final String APLICATION_JSON = "application/json";

    //PRODUCTS
    public static final String GET_PRODUCTS = "/get/products";
    public static final String GET_PRODUCT = "/get/product/{productID}";
    public static final String SAVE_PRODUCT = "/save/product";
    public static final String UPDATE_PRODUCT = "/update/product";
    public static final String SAVE_PRODUCTS = "/save/products";
    public static final String UPDATE_PRODUCTS = "/update/products";

    //CATEGORIES
    public static final String GET_CATEGORIES= "/get/categories";
    public static final String GET_CATEGORY = "/get/category/{categoryID}";
    public static final String SAVE_CATEGORY = "/save/category";
    public static final String UPDATE_CATEGORY = "/update/category";
    public static final String SAVE_CATEGORIES = "/save/categories";
    public static final String UPDATE_CATEGORIES = "/update/categories";

    private ConstantsUrl(){}


}
