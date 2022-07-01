package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

public class PointFParser implements ValueParser<PointF> {
  public static final PointFParser a = new PointFParser();
  
  public PointF a(JsonReader paramJsonReader, float paramFloat) throws IOException {
    PointF pointF;
    JsonToken jsonToken = paramJsonReader.peek();
    if (jsonToken == JsonToken.BEGIN_ARRAY)
      return JsonUtils.b(paramJsonReader, paramFloat); 
    if (jsonToken == JsonToken.BEGIN_OBJECT)
      return JsonUtils.b(paramJsonReader, paramFloat); 
    if (jsonToken == JsonToken.NUMBER) {
      pointF = new PointF((float)paramJsonReader.nextDouble() * paramFloat, (float)paramJsonReader.nextDouble() * paramFloat);
      while (paramJsonReader.hasNext())
        paramJsonReader.skipValue(); 
      return pointF;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot convert json to point. Next token is ");
    stringBuilder.append(pointF);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\PointFParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */