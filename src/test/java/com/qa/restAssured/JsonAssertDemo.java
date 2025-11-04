package com.qa.restAssured;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;
 
public class JsonAssertDemo {
 
    @Test
    public void exactSameJson() throws JSONException {
 
        String jsonObject1 = "{ " +
                "\"first_name\" : \"Vibha\"," +
                "\"last_name\": \"Singh\"" +
                "}";
 
        String jsonObject2 = "{ " +
                "\"first_name\" : \"Vibha\"," +
                "\"last_name\": \"Singh\"" +
                "}";
 
        // Lenient mode - extensible and no strict ordering
        JSONAssert.assertEquals(jsonObject1, jsonObject2, JSONCompareMode.LENIENT);
        
        
    }
}