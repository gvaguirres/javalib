package org.example.weather;

public class OutfitAdvisor {
    private final WeatherService weatherService;

    public OutfitAdvisor(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public String getClothingAdvice() {
        try {
            var temp = weatherService.getTemperature();
            if (temp < 0) return "Vinterjacka";
            if (temp > 15) return "T-shirt";
            return null;
        } catch (IllegalStateException e) {
            return "Jeans and Jacket";
        }
    }
}
