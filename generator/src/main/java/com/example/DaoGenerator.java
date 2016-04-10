package com.example;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DaoGenerator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.example.alex.berich.model.db");

        addUsers(schema);
        addOrders(schema);
        addProducts(schema);

        new de.greenrobot.daogenerator.DaoGenerator().generateAll(schema, "./app/src/main/java");
    }

    private static void addUsers(Schema schema) {
        Entity contact = schema.addEntity("User");
        contact.addIdProperty();
        contact.setTableName("USERS");
        contact.addStringProperty("name").notNull();
    }

    private static void addOrders(Schema schema) {
        Entity order = schema.addEntity("Purchase");
        order.setTableName("PURCHASE");
        order.addIdProperty();
        order.addLongProperty("productId").notNull();
        order.addLongProperty("userId").notNull();
        order.addDateProperty("date").notNull();
    }

    private static void addProducts(Schema schema) {
        Entity product = schema.addEntity("Product");
        product.setTableName("Products");
        product.addIdProperty();
        product.addStringProperty("name").notNull();
        product.addStringProperty("category").notNull();
        product.addStringProperty("price").notNull();
        product.addFloatProperty("quantity");

    }

}
