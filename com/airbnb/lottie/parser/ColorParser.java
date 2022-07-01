package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

public class ColorParser implements ValueParser<Integer> {
  public static final ColorParser a = new ColorParser();
  
  public Integer a(JsonReader paramJsonReader, float paramFloat) throws IOException {
    boolean bool;
    if (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      paramJsonReader.beginArray(); 
    double d8 = paramJsonReader.nextDouble();
    double d7 = paramJsonReader.nextDouble();
    double d6 = paramJsonReader.nextDouble();
    double d5 = paramJsonReader.nextDouble();
    if (bool)
      paramJsonReader.endArray(); 
    double d4 = d8;
    double d3 = d7;
    double d2 = d6;
    double d1 = d5;
    if (d8 <= 1.0D) {
      d4 = d8;
      d3 = d7;
      d2 = d6;
      d1 = d5;
      if (d7 <= 1.0D) {
        d4 = d8;
        d3 = d7;
        d2 = d6;
        d1 = d5;
        if (d6 <= 1.0D) {
          d4 = d8;
          d3 = d7;
          d2 = d6;
          d1 = d5;
          if (d5 <= 1.0D) {
            d4 = d8 * 255.0D;
            d3 = d7 * 255.0D;
            d2 = d6 * 255.0D;
            d1 = d5 * 255.0D;
          } 
        } 
      } 
    } 
    return Integer.valueOf(Color.argb((int)d1, (int)d4, (int)d3, (int)d2));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\ColorParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */