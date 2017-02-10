package in.zappos.model;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.zappos.R;
import in.zappos.databinding.DataBindingLayoutBinding;

public class ProductObjectAdapter extends RecyclerView.Adapter<ProductObjectHolder> {

    private ArrayList<Product> products;

    public ProductObjectAdapter(ArrayList<Product> products) {
        super();
        this.products = products;
    }

    @Override
    public ProductObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            DataBindingLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.data_binding_layout, parent, false);
            return new ProductObjectHolder(binding);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public void onBindViewHolder(ProductObjectHolder holder, int position) {
        holder.bindConnection(products.get(position));
    }
}
