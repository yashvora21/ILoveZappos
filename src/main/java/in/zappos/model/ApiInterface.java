package in.zappos.model;

import in.zappos.controller.ProductResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("Search")
    Call<ProductResponse> getProducts(@Query("term") String term, @Query("key") String key);

}
