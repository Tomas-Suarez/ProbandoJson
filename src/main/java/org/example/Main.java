package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


import java.io.*;
import java.lang.reflect.Type;
import java.net.InetSocketAddress;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/persona", new PersonaHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Servidor iniciado en http://localhost:8000/persona");

    }

    static class PersonaHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange e) throws IOException {
            String json = "";
            OutputStream os = e.getResponseBody();
            try {
                BufferedReader br = new BufferedReader(new FileReader("Date.json"));

                String line;
                while ((line = br.readLine()) != null) {
                    json += line;
                }
                br.close();
            } catch (IOException i) {
                String errorMessage = "Error al leer el archivo: " + i.getMessage();
                e.sendResponseHeaders(500, errorMessage.length());
                os.write(errorMessage.getBytes());
                os.close();
                return;
            }

            //Falta encriptar la password

            Gson gson = new Gson();
            Type listType = new TypeToken<List<Persona>>() {
            }.getType();
            List<Persona> personas = gson.fromJson(json, listType);

            System.out.println(personas);

            e.sendResponseHeaders(200, json.length());
            os.write(json.getBytes());
            os.close();

        }
    }


}