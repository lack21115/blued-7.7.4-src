package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class JsonStreamParser implements Iterator<JsonElement> {
  private final Object lock;
  
  private final JsonReader parser;
  
  public JsonStreamParser(Reader paramReader) {
    this.parser = new JsonReader(paramReader);
    this.parser.setLenient(true);
    this.lock = new Object();
  }
  
  public JsonStreamParser(String paramString) {
    this(new StringReader(paramString));
  }
  
  public boolean hasNext() {
    synchronized (this.lock) {
      boolean bool;
      JsonToken jsonToken1 = this.parser.peek();
      JsonToken jsonToken2 = JsonToken.END_DOCUMENT;
      if (jsonToken1 != jsonToken2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    } 
  }
  
  public JsonElement next() throws JsonParseException {
    if (hasNext())
      try {
        return Streams.parse(this.parser);
      } catch (StackOverflowError stackOverflowError) {
        throw new JsonParseException("Failed parsing JSON source to Json", stackOverflowError);
      } catch (OutOfMemoryError outOfMemoryError) {
        throw new JsonParseException("Failed parsing JSON source to Json", outOfMemoryError);
      } catch (JsonParseException jsonParseException2) {
        NoSuchElementException noSuchElementException;
        JsonParseException jsonParseException1 = jsonParseException2;
        if (jsonParseException2.getCause() instanceof java.io.EOFException)
          noSuchElementException = new NoSuchElementException(); 
        throw noSuchElementException;
      }  
    throw new NoSuchElementException();
  }
  
  public void remove() {
    throw new UnsupportedOperationException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\JsonStreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */