package org.example.price;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PriceWatcherTest {

    @Mock
    PriceService priceService;

    @Mock
    NotificationService notificationService;

    @InjectMocks
    PriceWatcher priceWatcher;


    @Test
    void sendNotificationWhenPriceLowerThanThreshold(){

        Mockito.when(priceService.getPrice("T-shirt")) //para que acepte cualquier tipo de input y no poner solo por ej "T-shirt" podemos tener Mockito.anu()
                .thenReturn(95);
//        Mockito.when(priceService.getPrice("Vinterjacka"))  se puede simular distintos comportamientos
//                .thenReturn(1000);

        priceWatcher.checkPrices();

        Mockito.verify(notificationService,  //aquí el mockito actúa como un spy
                 Mockito.times(1))
                .notify("T-shirt", 95);
    }
}
