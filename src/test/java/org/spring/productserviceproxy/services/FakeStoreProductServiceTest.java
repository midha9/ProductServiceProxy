package org.spring.productserviceproxy.services;

import org.spring.productserviceproxy.clients.fakestore.client.FakeStoreClient;
import org.spring.productserviceproxy.clients.fakestore.dto.FakeStoreProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FakeStoreProductServiceTest {

    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Test
    public void Test_FakeStoreClient() {
        List<FakeStoreProductDto> result =  fakeStoreClient.getAllProducts();
        assertNotNull(result);
    }

}