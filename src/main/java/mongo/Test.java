package mongo;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mongodb.*;
import com.mongodb.util.JSON;
import mongo.model.CurrRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB database = mongoClient.getDB("currrates");
        DBCollection collection = database.getCollection("currrates");
        //System.out.println(collection.findOne());
        int[] arr = {840,978};
        BasicDBObject inQuery = new BasicDBObject();
        inQuery.put("r030", new BasicDBObject("$in", arr));

        BasicDBObject andQuery = new BasicDBObject();
        List<BasicDBObject> obj = new ArrayList<>();
        obj.add(new BasicDBObject(new BasicDBObject("r030", true)
                .append("txt", true)
                .append("rate", true)
                .append("cc", true)
                .append("exchangedate", true)));
        obj.add(new BasicDBObject("r030", new BasicDBObject("$in", arr)));
        andQuery.put("$and", obj);

        Gson gson = new Gson();
        List<CurrRate> currRates = new ArrayList<>();

        DBCursor cursor = collection.find(andQuery);
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
            CurrRate currRate = gson.fromJson(cursor.next().toString(), CurrRate.class);
            currRates.add(currRate);
        }
        System.out.println("=======================================================");
        System.out.println(currRates);

//        DBCursor cursor = collection.find(new BasicDBObject("r030", true)
//                                              .append("txt", true)
//                                              .append("rate", true)
//                                              .append("cc", true)
//                                              .append("exchangedate", true));





        //BasicDBObject whereQuery = new BasicDBObject();
        //whereQuery.put("r030", new BasicDBObject("$in", arr));
        //whereQuery.put("rate", new BasicDBObject("$gt", 27));
        //DBCursor cursor = collection.find(whereQuery);
//        while(cursor.hasNext()) {
//            System.out.println(cursor.next());
//            CurrRate currRate = gson.fromJson(cursor.next().toString(), CurrRate.class);
//            currRates.add(currRate);
//        }
//        System.out.println("=======================================================");
//        System.out.println(currRates);

        //collection.remove(new BasicDBObject());
//        for (DBObject db: collection.find()) {
//            System.out.println(db);
//        }
        
        //collection("customers").find("{'r030':986}").toArray(function(err, result)

//        BasicDBObject document = new BasicDBObject();
//        document.put("name", "Shubham");
//        document.put("company", "Baeldung");

//        Gson gson = new Gson();
//        BufferedReader bufferedReader = new BufferedReader(
//                                        new InputStreamReader(
//                                        new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date=20200416&json").openStream()));
//
//        List<CurrRate> currRates = Arrays.asList(gson.fromJson(bufferedReader, CurrRate[].class));
//
//        DBObject dbObject;
//
//        for (CurrRate currRate : currRates) {
//            dbObject = (DBObject) JSON.parse(currRate.toString());
//                        collection.insert(dbObject);
//        }
//
//        currRates.forEach(System.out::println);
        
    }
}
