package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class JsonUtils {
  static int a(JsonReader paramJsonReader) throws IOException {
    paramJsonReader.beginArray();
    int i = (int)(paramJsonReader.nextDouble() * 255.0D);
    int j = (int)(paramJsonReader.nextDouble() * 255.0D);
    int k = (int)(paramJsonReader.nextDouble() * 255.0D);
    while (paramJsonReader.hasNext())
      paramJsonReader.skipValue(); 
    paramJsonReader.endArray();
    return Color.argb(255, i, j, k);
  }
  
  static List<PointF> a(JsonReader paramJsonReader, float paramFloat) throws IOException {
    ArrayList<PointF> arrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY) {
      paramJsonReader.beginArray();
      arrayList.add(b(paramJsonReader, paramFloat));
      paramJsonReader.endArray();
    } 
    paramJsonReader.endArray();
    return arrayList;
  }
  
  static float b(JsonReader paramJsonReader) throws IOException {
    StringBuilder stringBuilder;
    JsonToken jsonToken = paramJsonReader.peek();
    int i = null.a[jsonToken.ordinal()];
    if (i != 1) {
      if (i == 2) {
        paramJsonReader.beginArray();
        float f = (float)paramJsonReader.nextDouble();
        while (paramJsonReader.hasNext())
          paramJsonReader.skipValue(); 
        paramJsonReader.endArray();
        return f;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Unknown value for token of type ");
      stringBuilder.append(jsonToken);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    return (float)stringBuilder.nextDouble();
  }
  
  static PointF b(JsonReader paramJsonReader, float paramFloat) throws IOException {
    int i = null.a[paramJsonReader.peek().ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i == 3)
          return e(paramJsonReader, paramFloat); 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown point starts with ");
        stringBuilder.append(paramJsonReader.peek());
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      return d(paramJsonReader, paramFloat);
    } 
    return c(paramJsonReader, paramFloat);
  }
  
  private static PointF c(JsonReader paramJsonReader, float paramFloat) throws IOException {
    float f1 = (float)paramJsonReader.nextDouble();
    float f2 = (float)paramJsonReader.nextDouble();
    while (paramJsonReader.hasNext())
      paramJsonReader.skipValue(); 
    return new PointF(f1 * paramFloat, f2 * paramFloat);
  }
  
  private static PointF d(JsonReader paramJsonReader, float paramFloat) throws IOException {
    paramJsonReader.beginArray();
    float f1 = (float)paramJsonReader.nextDouble();
    float f2 = (float)paramJsonReader.nextDouble();
    while (paramJsonReader.peek() != JsonToken.END_ARRAY)
      paramJsonReader.skipValue(); 
    paramJsonReader.endArray();
    return new PointF(f1 * paramFloat, f2 * paramFloat);
  }
  
  private static PointF e(JsonReader paramJsonReader, float paramFloat) throws IOException {
    paramJsonReader.beginObject();
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (paramJsonReader.hasNext()) {
      String str = paramJsonReader.nextName();
      byte b = -1;
      int i = str.hashCode();
      if (i != 120) {
        if (i == 121 && str.equals("y"))
          b = 1; 
      } else if (str.equals("x")) {
        b = 0;
      } 
      if (b != 0) {
        if (b != 1) {
          paramJsonReader.skipValue();
          continue;
        } 
        f1 = b(paramJsonReader);
        continue;
      } 
      f2 = b(paramJsonReader);
    } 
    paramJsonReader.endObject();
    return new PointF(f2 * paramFloat, f1 * paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\JsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */