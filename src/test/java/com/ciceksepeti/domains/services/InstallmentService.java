package com.ciceksepeti.domains.services;

import com.ciceksepeti.core.client.RestClient;
import com.ciceksepeti.domains.response.Products;
import java.io.IOException;
import java.util.List;

public class InstallmentService extends RestClient {

    private final String endpoint;

    public InstallmentService() {
        endpoint = "test/installment=";
    }

    public List<Products> getProductsWithoutInstallmentOption() throws IOException {
        return getProductsAsJavaObject(endpoint + 0).result.data.products;
    }

    public int getActualProductNumberWithoutInstallmentOption() throws IOException {
        List<Products> productsWithoutInstallment = getProductsWithoutInstallmentOption();
        return (int) productsWithoutInstallment.stream().filter(product -> !product.installment && !product.installmentText.contains("Taksit") && product.productGroupId == 2).count();
    }

    public List<Products> getProductsWithInstallmentOption() throws IOException {
        return getProductsAsJavaObject(endpoint + 1).result.data.products;
    }

    public int getActualProductNumberWithInstallmentOption() throws IOException {
        List<Products> productsWithoutInstallment = getProductsWithInstallmentOption();
        return (int) productsWithoutInstallment.stream().filter(product -> product.installment && product.installmentText.contains("Taksit") && product.productGroupId == 1).count();
    }

    public int getStatusCodeOfNullInstallmentOption() {
        return get(endpoint).getStatusCode();
    }
}