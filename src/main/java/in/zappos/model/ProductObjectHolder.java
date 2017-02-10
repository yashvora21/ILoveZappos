package in.zappos.model;

import android.support.v7.widget.RecyclerView;

import in.zappos.databinding.DataBindingLayoutBinding;
import in.zappos.model.Product;

public class ProductObjectHolder extends RecyclerView.ViewHolder {

    private DataBindingLayoutBinding dataBindingLayoutBinding;

    public ProductObjectHolder(DataBindingLayoutBinding binding) {
        super(binding.getRoot());
        dataBindingLayoutBinding = binding;
    }

    public void bindConnection(Product product) {
        dataBindingLayoutBinding.setProduct(product);
    }

}
