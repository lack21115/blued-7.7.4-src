package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
  public static JsonElement parseReader(JsonReader paramJsonReader) throws JsonIOException, JsonSyntaxException {
    Exception exception;
    boolean bool = paramJsonReader.isLenient();
    paramJsonReader.setLenient(true);
    try {
      JsonElement jsonElement = Streams.parse(paramJsonReader);
      paramJsonReader.setLenient(bool);
      return jsonElement;
    } catch (StackOverflowError stackOverflowError) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed parsing JSON source: ");
      stringBuilder.append(paramJsonReader);
      stringBuilder.append(" to Json");
      throw new JsonParseException(stringBuilder.toString(), stackOverflowError);
    } catch (OutOfMemoryError outOfMemoryError) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed parsing JSON source: ");
      stringBuilder.append(paramJsonReader);
      stringBuilder.append(" to Json");
      throw new JsonParseException(stringBuilder.toString(), outOfMemoryError);
    } finally {}
    paramJsonReader.setLenient(bool);
    throw exception;
  }
  
  public static JsonElement parseReader(Reader paramReader) throws JsonIOException, JsonSyntaxException {
    try {
      JsonReader jsonReader = new JsonReader(paramReader);
      JsonElement jsonElement = parseReader(jsonReader);
      if (!jsonElement.isJsonNull()) {
        if (jsonReader.peek() == JsonToken.END_DOCUMENT)
          return jsonElement; 
        throw new JsonSyntaxException("Did not consume the entire document.");
      } 
      return jsonElement;
    } catch (MalformedJsonException malformedJsonException) {
      throw new JsonSyntaxException(malformedJsonException);
    } catch (IOException iOException) {
      throw new JsonIOException(iOException);
    } catch (NumberFormatException numberFormatException) {
      throw new JsonSyntaxException(numberFormatException);
    } 
  }
  
  public static JsonElement parseString(String paramString) throws JsonSyntaxException {
    return parseReader(new StringReader(paramString));
  }
  
  @Deprecated
  public JsonElement parse(JsonReader paramJsonReader) throws JsonIOException, JsonSyntaxException {
    return parseReader(paramJsonReader);
  }
  
  @Deprecated
  public JsonElement parse(Reader paramReader) throws JsonIOException, JsonSyntaxException {
    return parseReader(paramReader);
  }
  
  @Deprecated
  public JsonElement parse(String paramString) throws JsonSyntaxException {
    return parseString(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\JsonParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */