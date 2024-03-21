package org.technical.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.messages.types.Product;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchProductResponse {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("message")
    private String message;
    @JsonProperty("noOfItem")
    private Integer noOfItem;
    @JsonProperty("findItems")
    private List<Product> findItems;

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;}

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("noOfItem")
    public Integer getNoOfItem() {
        return noOfItem;
    }

    @JsonProperty("noOfItem")
    public void setNoOfItem(Integer noOfItem) {
        this.noOfItem = noOfItem;
    }

    @JsonProperty("findItems")
    public List<Product> getFindItems() {
        return findItems;
    }

    @JsonProperty("findItems")
    public void setFindItems(List<Product> findItems) {
        this.findItems = findItems;
    }


}
