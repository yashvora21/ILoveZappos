package in.zappos.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import in.zappos.controller.GetData;
import in.zappos.controller.MainActivity;
import in.zappos.model.Product;
import in.zappos.R;
import in.zappos.databinding.ProductViewBinding;

public class ProductView extends AppCompatActivity {
    static int add=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int position = Integer.parseInt(getIntent().getStringExtra("position"));

        ProductViewBinding productViewBinding = DataBindingUtil.setContentView(this, R.layout.product_view);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
        Product product = new Product(GetData.brandName[position], GetData.thumbnail[position], GetData.productId[position],
                GetData.originalPrice[position], GetData.styleId[position], GetData.colorId[position], GetData.price[position],
                GetData.percentOff[position], GetData.productUrl[position], GetData.productName[position]);

        productViewBinding.setProduct(product);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(add==0) {
                    YoYo.with(Techniques.RotateIn)
                            .duration(900)
                            .playOn(findViewById(R.id.add));
                    Toast.makeText(ProductView.this, "Product added to cart", Toast.LENGTH_SHORT).show();
                    fab.setImageResource(R.mipmap.add);
                    add=1;
                }
                else{
                       YoYo.with(Techniques.Bounce)
                                .duration(900)
                                .playOn(findViewById(R.id.add));
                                Toast.makeText(ProductView.this, "Product removed from cart", Toast.LENGTH_SHORT).show();
                    fab.setImageResource(R.mipmap.cart);
                        add=0;
                }
            }
        });
    }


}
