package org.example.weather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class OutfitAdvisorTest {

    @Mock //weatherService = Mockito.mock(WeatherService.class); esto lo necesitamos hacer en cada test, pero con @Mock nos ahorramos el escribirlo en cada test
    WeatherService weatherService;

    @InjectMocks
    OutfitAdvisor advisor;

//    @BeforeEach otra opción es tener un beforeEach, antes de cada test se ejecutará el mockito de weatherService
//    void setUp(){
//        weatherService = Mockito.mock(WeatherService.class);
//    }

//    @BeforeEach
//    public void setUp(){
//        advisor = new OutfitAdvisor(weatherService);
//    }

    @Test
    void freezingTemps(){
//        OutfitAdvisor advisor = new OutfitAdvisor(weatherService);
//        para crear un objeto advisor, necesitamos una referencia de weather service y esto es la dependency inyection, se hace a través del konstruktor
//        podemos tener un beforeEach con un setUp para crear el objeto antes de cada test
//        otra opción es tener un @InjectMocks

        Mockito.when(weatherService.getTemperature()).thenReturn((float) -5.0);
        String advice = advisor.getClothingAdvice();
        assertThat(advice).isEqualTo("Vinterjacka");
    }

    @Test
    void summerTemps(){

        Mockito.when(weatherService.getTemperature()).thenReturn((float) 16.0);
        String advice = advisor.getClothingAdvice();
        assertThat(advice).isEqualTo("T-shirt");
    }

    @Test
    void defaultAdviceWhenNoTempData(){
        Mockito.when(weatherService.getTemperature())
                .thenThrow(new IllegalStateException()); //configuración para atrapar la excepción cuando no hay una temperatura

        assertThat(advisor.getClothingAdvice())
                .isEqualTo("Jeans and Jacket");
    }
}
