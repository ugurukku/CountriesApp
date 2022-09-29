package com.worldApp.network;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.worldApp.entity.Country;
import com.worldApp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Repository(value = "countryRepo")
public class APIConnectionImpl implements APIConnectionInter {

    public List<Country> getCountries() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/natiqhaciyef/Country-JSON/main/Country%20API%20kit/Country%20API.json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            //check if connect is made
            int response = connection.getResponseCode();
            if (response != 200) {
                throw new RuntimeException("HttpResponseCode: " + response);
            }

            StringBuilder informationString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                informationString.append(scanner.nextLine());
            }
            scanner.close();

            JsonMapper mapper = new JsonMapper();
           List<Country> countries = Arrays
                   .asList(mapper.readValue(informationString.toString(), Country[].class));

           return countries;

        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
}
