package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeDataParser implements ValueParser<ShapeData> {
  public static final ShapeDataParser a = new ShapeDataParser();
  
  public ShapeData a(JsonReader paramJsonReader, float paramFloat) throws IOException {
    if (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY)
      paramJsonReader.beginArray(); 
    paramJsonReader.beginObject();
    List<PointF> list3 = null;
    List<PointF> list1 = null;
    List<PointF> list2 = list1;
    boolean bool;
    for (bool = false; paramJsonReader.hasNext(); bool = paramJsonReader.nextBoolean()) {
      String str = paramJsonReader.nextName();
      byte b = -1;
      int i = str.hashCode();
      if (i != 99) {
        if (i != 105) {
          if (i != 111) {
            if (i == 118 && str.equals("v"))
              b = 1; 
          } else if (str.equals("o")) {
            b = 3;
          } 
        } else if (str.equals("i")) {
          b = 2;
        } 
      } else if (str.equals("c")) {
        b = 0;
      } 
      if (b != 0) {
        if (b != 1) {
          if (b != 2) {
            if (b != 3)
              continue; 
            list2 = JsonUtils.a(paramJsonReader, paramFloat);
            continue;
          } 
          list1 = JsonUtils.a(paramJsonReader, paramFloat);
          continue;
        } 
        list3 = JsonUtils.a(paramJsonReader, paramFloat);
        continue;
      } 
    } 
    paramJsonReader.endObject();
    if (paramJsonReader.peek() == JsonToken.END_ARRAY)
      paramJsonReader.endArray(); 
    if (list3 != null && list1 != null && list2 != null) {
      if (list3.isEmpty())
        return new ShapeData(new PointF(), false, Collections.emptyList()); 
      int j = list3.size();
      PointF pointF = list3.get(0);
      ArrayList<CubicCurveData> arrayList = new ArrayList(j);
      int i;
      for (i = 1; i < j; i++) {
        PointF pointF1 = list3.get(i);
        int k = i - 1;
        PointF pointF2 = list3.get(k);
        PointF pointF3 = list2.get(k);
        PointF pointF4 = list1.get(i);
        arrayList.add(new CubicCurveData(MiscUtils.a(pointF2, pointF3), MiscUtils.a(pointF1, pointF4), pointF1));
      } 
      if (bool) {
        PointF pointF4 = list3.get(0);
        i = j - 1;
        PointF pointF3 = list3.get(i);
        PointF pointF2 = list2.get(i);
        PointF pointF1 = list1.get(0);
        arrayList.add(new CubicCurveData(MiscUtils.a(pointF3, pointF2), MiscUtils.a(pointF4, pointF1), pointF4));
      } 
      return new ShapeData(pointF, bool, arrayList);
    } 
    throw new IllegalArgumentException("Shape data was missing information.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\ShapeDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */