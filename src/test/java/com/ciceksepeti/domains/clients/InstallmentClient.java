package com.ciceksepeti.domains.clients;

import com.ciceksepeti.domains.services.InstallmentService;
import com.ciceksepeti.tests.TestListener;
import org.apache.log4j.Logger;

import java.io.IOException;

public class InstallmentClient {

    private final InstallmentService installmentService;
    private final Logger LOGGER = Logger.getLogger(InstallmentClient.class);

    public InstallmentClient() {
        installmentService = new InstallmentService();
    }

    public int getNullInstallmentStatusCode() {
        return installmentService.getStatusCodeOfNullInstallmentOption();
    }

    public int getProductsWithoutInstallmentOptionTotalNumber() throws IOException {
        int size = installmentService.getProductsWithoutInstallmentOption().size();
        LOGGER.info("Total Number of Products Without Installment Option is " + size);
        return size;
    }

    public int getActualProductNumberWithoutInstallmentOption() throws IOException {
        int size = installmentService.getActualProductNumberWithoutInstallmentOption();
        LOGGER.info("Actual Number of Products Without Installment Option is " + size);
        return size;
    }

    public int getProductsWithInstallmentOptionTotalNumber() throws IOException {
        int size = installmentService.getProductsWithInstallmentOption().size();
        LOGGER.info("Total Number of Products With Installment Option is " + size);
        return size;
    }

    public int getActualProductNumberWithInstallmentOption() throws IOException {
        int size = installmentService.getActualProductNumberWithInstallmentOption();
        LOGGER.info("Actual Number of Products Without Installment Option is " + size);
        return size;
    }
}
