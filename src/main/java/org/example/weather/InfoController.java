package org.example.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class InfoController  {

    public void get_wea_inf(){
        try {
            // Replace "YOUR_API_ENDPOINT" with the actual API endpoint
            String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41";

            // Create URL object
            URL url = new URL(apiUrl);

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Set timeout
            connection.setConnectTimeout(5000); // 5 seconds
            connection.setReadTimeout(5000);    // 5 seconds

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Reading the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Handle the response as needed
                System.out.println("API Response: " + response.toString());
            } else {
                System.out.println("API request failed. Response Code: " + responseCode);
            }

            // Close connection
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void get_cordinantes(){

    }
}
