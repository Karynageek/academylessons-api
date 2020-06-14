package org.academy.api.pojo.karyna.chelpan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@Slf4j
public class Main {
    public static void main(String[] args) {
        Client client1 = new Client(1, "Kary", "kary123","chelp@gmail.com");
        Client client2 = new Client(2, "Oksana", "oks123","stol@gmail.com");

        Seller seller = new Seller(1,"Pavel", "shop@gmail.com", Arrays.asList("technical", "domestic"));

        Shop shop =new Shop(1, "TechShop", "Kiev");

        Message message = new Message(1, "Opening Star shop!", "Come to the shops’s opening!");

        Product product1 = new Product(1,"computer", Map.of("one",1),
                Map.of("kg", 3),25119);
        Product product2 = new Product(2,"milk", Map.of("one",1),
                Map.of("liter", 1), 20);

        List<Client> clients = List.of(client1, client2);
        List<Seller> sellers = List.of(seller);
        List<Shop> shops = List.of(shop);
        List<Message> messages = List.of(message);
        List<Product> products = List.of(product1, product2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        /**
         * POJO to json String
         */
        String jsonClients = gson.toJson(clients);
        log.info(jsonClients);
        String jsonSeller = gson.toJson(sellers);
        log.info(jsonSeller);
        String jsonShops = gson.toJson(shops);
        log.info(jsonShops);
        String jsonMessages = gson.toJson(messages);
        log.info(jsonMessages);
        String jsonProducts = gson.toJson(products);
        log.info(jsonProducts);

        /**
         * POJO to json file
         */
        try (FileWriter writer = new FileWriter("src/main/java/org/academy/api/pojo/karyna/chelpan/output.json")) {
            gson.toJson(clients, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
