package com.airbnb.lottie.parser;

import android.util.JsonReader;
import java.io.IOException;

public class IntegerParser implements ValueParser<Integer> {
  public static final IntegerParser a = new IntegerParser();
  
  public Integer a(JsonReader paramJsonReader, float paramFloat) throws IOException {
    return Integer.valueOf(Math.round(JsonUtils.b(paramJsonReader) * paramFloat));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\IntegerParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */