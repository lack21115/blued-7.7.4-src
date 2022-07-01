package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class Streams {
  private Streams() {
    throw new UnsupportedOperationException();
  }
  
  public static JsonElement parse(JsonReader paramJsonReader) throws JsonParseException {
    boolean bool;
    try {
      paramJsonReader.peek();
      bool = false;
      try {
        return (JsonElement)TypeAdapters.JSON_ELEMENT.read(paramJsonReader);
      } catch (EOFException eOFException) {}
    } catch (EOFException eOFException) {
      bool = true;
    } catch (MalformedJsonException malformedJsonException) {
      throw new JsonSyntaxException(malformedJsonException);
    } catch (IOException iOException) {
      throw new JsonIOException(iOException);
    } catch (NumberFormatException numberFormatException) {
      throw new JsonSyntaxException(numberFormatException);
    } 
    if (bool)
      return (JsonElement)JsonNull.INSTANCE; 
    throw new JsonSyntaxException(numberFormatException);
  }
  
  public static void write(JsonElement paramJsonElement, JsonWriter paramJsonWriter) throws IOException {
    TypeAdapters.JSON_ELEMENT.write(paramJsonWriter, paramJsonElement);
  }
  
  public static Writer writerForAppendable(Appendable paramAppendable) {
    return (paramAppendable instanceof Writer) ? (Writer)paramAppendable : new AppendableWriter(paramAppendable);
  }
  
  static final class AppendableWriter extends Writer {
    private final Appendable appendable;
    
    private final CurrentWrite currentWrite = new CurrentWrite();
    
    AppendableWriter(Appendable param1Appendable) {
      this.appendable = param1Appendable;
    }
    
    public void close() {}
    
    public void flush() {}
    
    public void write(int param1Int) throws IOException {
      this.appendable.append((char)param1Int);
    }
    
    public void write(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException {
      CurrentWrite currentWrite = this.currentWrite;
      currentWrite.chars = param1ArrayOfchar;
      this.appendable.append(currentWrite, param1Int1, param1Int2 + param1Int1);
    }
    
    static class CurrentWrite implements CharSequence {
      char[] chars;
      
      public char charAt(int param2Int) {
        return this.chars[param2Int];
      }
      
      public int length() {
        return this.chars.length;
      }
      
      public CharSequence subSequence(int param2Int1, int param2Int2) {
        return new String(this.chars, param2Int1, param2Int2 - param2Int1);
      }
    }
  }
  
  static class CurrentWrite implements CharSequence {
    char[] chars;
    
    public char charAt(int param1Int) {
      return this.chars[param1Int];
    }
    
    public int length() {
      return this.chars.length;
    }
    
    public CharSequence subSequence(int param1Int1, int param1Int2) {
      return new String(this.chars, param1Int1, param1Int2 - param1Int1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\internal\Streams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */