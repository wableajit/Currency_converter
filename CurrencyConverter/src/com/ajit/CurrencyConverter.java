package com.ajit;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    // Method to get exchange rate based on hardcoded rates
    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        // Hardcoded exchange rates (example rates)
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD_USD", 1.0);  // Base currency to itself
        exchangeRates.put("USD_EUR", 0.84); // 1 USD = 0.84 EUR
        exchangeRates.put("USD_GBP", 0.73); // 1 USD = 0.73 GBP
        // Add more exchange rates as needed

        // Construct rate key
        String rateKey = baseCurrency + "_" + targetCurrency;

        // Check if rate exists
        if (exchangeRates.containsKey(rateKey)) {
            return exchangeRates.get(rateKey);
        } else {
            System.out.println("Exchange rate not found for the provided currencies.");
            return -1.0; // Indicate failure
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");

        // Currency selection
        System.out.print("Enter the base currency (e.g., USD, EUR, GBP): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency (e.g., USD, EUR, GBP): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Amount input
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Fetch exchange rate
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate != -1.0) {
            // Currency conversion
            double convertedAmount = amount * exchangeRate;

            // Display result
            System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
        }

        scanner.close();
    }
}



