package in.zappos.controller;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import in.zappos.model.Product;

public class ProductResponse {

    @SerializedName("originalTerm")
    private String originalTerm;
    @SerializedName("results")
    private List<Product> results;

    public ProductResponse(String originalTerm){
        this.originalTerm = originalTerm;
    }

    public String getOriginalTerm() {
        return originalTerm;
    }

    public List<Product> getResults() {
        return results;
    }

    public void setResults(List<Product> results) {
        this.results = results;
    }

    public void setOriginalTerm(String originalTerm) {
        this.originalTerm = originalTerm;
    }
}