package com.tekgs.nextgen.luckyPet.data.product;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class ItemCalibratableTypeAdapter extends TypeAdapter<ProductCalibratable> {
    public static ItemCalibratableTypeAdapter getInstance() {
        return new ItemCalibratableTypeAdapter();
    }

    @Override
    public void write(JsonWriter jsonWriter, ProductCalibratable productCalibratable) {
        //  NO-OP:  We currently aren't writing out 'Item' in this system
    }
    
    @Override
    public ProductCalibratable read(JsonReader jsonReader) throws IOException {
        return null;
    }

//    @Override
//    public ItemCalibratable read(JsonReader reader) {
//        ItemCalibratable item = new Item();
//        String fieldName = null;
//        try {
//            reader.beginObject();
//            while (reader.hasNext()) {
//                JsonToken token = reader.peek();
//                if (token.equals(JsonToken.NAME)) {
//                    fieldName = reader.nextName();
//                    if ("id".equals(fieldName)) {
//                        reader.peek();
//                        item.id = reader.nextInt();
//                    }
//                    if ("cost".equals(fieldName)) {
//                        reader.peek();
//                        item.cost = reader.nextInt();
//                    }
//                    if("description".equals(fieldName)){
//                        reader.peek();
//                        item.description = reader.nextString();
//                    }
//                }
//            }
//            reader.endObject();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return item;
//    }
}
