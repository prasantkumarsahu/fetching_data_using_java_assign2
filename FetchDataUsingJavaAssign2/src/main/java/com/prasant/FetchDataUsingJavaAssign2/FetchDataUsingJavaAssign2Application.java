package com.prasant.FetchDataUsingJavaAssign2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class FetchDataUsingJavaAssign2Application {

	public static void main(String[] args) throws Exception {
		URL url = new URL("https://api.zippopotam.us/us/33162");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();

		if (responseCode == HttpStatus.OK.value()){

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder data = new StringBuilder();
			String readLine = null;

			while ((readLine = in.readLine()) != null) {
				data.append(readLine);
			}

			in.close();

			JSONObject result = new JSONObject(data.toString());

			System.out.println(result);
		}
	}

}
