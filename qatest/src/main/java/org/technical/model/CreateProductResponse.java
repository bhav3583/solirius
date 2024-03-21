package org.technical.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateProductResponse {
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("message")
    private String message;
    @JsonProperty("savedProduct")
    private SavedProduct savedProduct;

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("savedProduct")
    public SavedProduct getSavedProduct() {
        return savedProduct;
    }

    @JsonProperty("savedProduct")
    public void setSavedProduct(SavedProduct savedProduct) {
        this.savedProduct = savedProduct;
    }

}
