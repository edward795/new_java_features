package org.example.java9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpAPIImprovements {
    public static void main(String[] args) throws IOException, InterruptedException {
        String endpoint="https://jsonplaceholder.typicode.com/posts";
        HttpURLConnection connection=null;
        try{
            URL url=new URL(endpoint);
            connection=(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status=connection.getResponseCode();
            System.out.println("Status : "+status);

            try(BufferedReader reader=new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            )){
                while((reader.readLine()!=null)){
                    System.out.println(reader.readLine());
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(connection!=null) connection.disconnect();
        }


        HttpClient client=HttpClient.newHttpClient();
        HttpRequest HttpRequest= java.net.http.HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();
        HttpResponse<String> response=client.send(HttpRequest,
                HttpResponse.BodyHandlers.ofString());
        System.out.println("Status : "+response.statusCode());
        System.out.println(response.body());

    }
}
