package org.example.price;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PriceWatcherTest {

    @Mock
    PriceService priceService;

    @Mock
    NotificationService notificationService;

    @InjectMocks
    PriceWatcher priceWatcher;


    @Test
    void sendNotificationWhenPriceLowerThanThreshold() {

        Mockito.when(priceService.getPrice("T-shirt")) //para que acepte cualquier tipo de input y no poner solo por ej "T-shirt" podemos tener Mockito.anu()
                .thenReturn(95);
//        Mockito.when(priceService.getPrice("Vinterjacka"))  se puede simular distintos comportamientos
//                .thenReturn(1000);

        priceWatcher.checkPrices();

        Mockito.verify(notificationService,  //aquí el mockito actúa como un spy
                        Mockito.times(1))
                .notify("T-shirt", 95);
    }

    @Test
    @Tag("slow")
        //se le puede poner tags por ej slow / fast
        //cuando ejecutamos los test, podríamos poner ejecutar solo los lentos por ej
        //uno elige estos tags y uno elige el nombre de cómo agruparlos
        //arriba donde se le da ejecutar a los test -> edit configurations -> all packages podemos cambiar a tags -> !slow (que se ejecuten todos menos los con tag de lentos)
        //también se puede hacer en el terminal con mvn -> mvn test -Dgroups='!slow' con comillas o si queremos solo ese test sería -> mvn test -Dgroups=slow
    void throwsExceptionWhenPriceServiceIsUnavailable() {

        Mockito.when(priceService.getPrice("T-shirt"))
                .thenThrow(new RuntimeException("Something went wrong"));

        var exception = assertThrows(RuntimeException.class, //vi kollar att det kastas en runtime exception class när vi kör checkPrices
                () -> priceWatcher.checkPrices());
        assertThat(exception).hasMessage("Error when checking prices");
    }
}
