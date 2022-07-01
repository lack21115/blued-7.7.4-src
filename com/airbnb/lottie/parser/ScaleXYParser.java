package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

public class ScaleXYParser implements ValueParser<ScaleXY> {
  public static final ScaleXYParser a = new ScaleXYParser();
  
  public ScaleXY a(JsonReader paramJsonReader, float paramFloat) throws IOException {
    boolean bool;
    if (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      paramJsonReader.beginArray(); 
    float f1 = (float)paramJsonReader.nextDouble();
    float f2 = (float)paramJsonReader.nextDouble();
    while (paramJsonReader.hasNext())
      paramJsonReader.skipValue(); 
    if (bool)
      paramJsonReader.endArray(); 
    return new ScaleXY(f1 / 100.0F * paramFloat, f2 / 100.0F * paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\ScaleXYParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */