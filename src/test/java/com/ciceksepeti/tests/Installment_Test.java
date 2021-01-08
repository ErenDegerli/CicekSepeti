package com.ciceksepeti.tests;

import com.ciceksepeti.domains.clients.InstallmentClient;
import io.qameta.allure.Description;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Tag("Integration")
@DisplayName("Cicek Sepeti Test Cases")
@ExtendWith(TestListener.class)
public class Installment_Test {

    private final InstallmentClient installmentClient;
    private final Logger logger;

    public Installment_Test() {
        installmentClient = new InstallmentClient();
        logger = Logger.getLogger(Installment_Test.class);
    }

    @Test
    @DisplayName("GET Null Installment Option")
    @Description("GET Installment Option with Null Value and See the StatusCode 500")
    public void getNull() {
        logger.info("Getting status code of Null Installment Option and Assert it with 500 Http Status Code");
        assertEquals(500, installmentClient.getNullInstallmentStatusCode());
    }

    @Test
    @DisplayName("GET No Installment Options")
    @Description("GET No Installment Option Size of the List and Check Each Record in it contains productGroupId:2, installment:false and installmentText does not contain: Taksit")
    public void getWithoutInstallment() throws IOException {
        logger.info("Check if all products under installment=0 endpoint have productGroupId:2, installment:false and installmentText does not contain: Taksit");
        assertEquals(installmentClient.getProductsWithoutInstallmentOptionTotalNumber(),
                    installmentClient.getActualProductNumberWithoutInstallmentOption());
    }

    @Test
    @DisplayName("GET Installment Options")
    @Description("GET Installment Option Size of the List and Check Each Record in it contains productGroupId:1, installment:true and installmentText contains: Taksit")
    public void getInstallment() throws IOException {
        logger.info("Check if all products under installment=1 endpoint have productGroupId:1, installment:true and installmentText contains: Taksit");
        assertEquals(installmentClient.getProductsWithInstallmentOptionTotalNumber(),
                installmentClient.getActualProductNumberWithInstallmentOption());
    }
}
