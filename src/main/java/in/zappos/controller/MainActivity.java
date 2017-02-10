package in.zappos.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.List;

import in.zappos.model.Product;
import in.zappos.model.ProductObjectAdapter;
import in.zappos.R;
import in.zappos.model.ApiClient;
import in.zappos.model.ApiInterface;
import in.zappos.view.ProductView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    public static final String term = "nike";
    public static final String key = "b743e26728e16b81da139182bb2094357c31d331";

    Product product;

    List<Product> products;

    public static int no_of_products = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_main);

        //textView = (TextView) findViewById(R.id.text);

        recyclerView = (RecyclerView) findViewById(R.id.rv);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<ProductResponse> call = apiInterface.getProducts(getIntent().getStringExtra("query"), key);
        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                products = response.body().getResults();
                no_of_products = products.size();

                GetData.getData(products);

                ArrayList<Product> products1 = new ArrayList<Product>();

                for (int i = 0; i < 10; i++) {

                    product = new Product(GetData.brandName[i], GetData.thumbnail[i], GetData.productId[i], GetData.originalPrice[i],
                            GetData.styleId[i], GetData.colorId[i], GetData.price[i], GetData.percentOff[i], GetData.productUrl[i],
                            GetData.productName[i]);
                            products1.add(product);
                }

                ProductObjectAdapter productObjectAdapter = new ProductObjectAdapter(products1);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(productObjectAdapter);
                Toast.makeText(MainActivity.this, "Showing top "+products.size() + " products", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {

            }
        });

        recyclerView.addOnItemTouchListener(new Rec_Touch(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void click(int position, View v) {
                Intent intent = new Intent(getApplicationContext(), ProductView.class);
                intent.putExtra("position", position + "");
                startActivity(intent);
            }

            @Override
            public void longClick(int position, View v) {

            }
        }));



    }

    public interface ClickListener {
        void click(int position, View v);

        void longClick(int position, View v);
    }

    public static class Rec_Touch implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private MainActivity.ClickListener clickListener;

        public Rec_Touch(Context context, final RecyclerView recyclerView1, final MainActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View v = recyclerView1.findChildViewUnder(e.getX(), e.getY());
                    if (v != null && clickListener != null) {
                        clickListener.longClick(recyclerView1.getChildAdapterPosition(v), v);
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View view = rv.findChildViewUnder(e.getX(), e.getY());
            if (view != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.click(rv.getChildAdapterPosition(view), view);
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }


}
