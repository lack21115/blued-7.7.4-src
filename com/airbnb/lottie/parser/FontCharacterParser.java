package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.io.IOException;
import java.util.ArrayList;

class FontCharacterParser {
  static FontCharacter a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    ArrayList<ShapeGroup> arrayList = new ArrayList();
    paramJsonReader.beginObject();
    String str2 = null;
    String str1 = str2;
    double d2 = 0.0D;
    double d1 = d2;
    char c;
    for (c = Character.MIN_VALUE; paramJsonReader.hasNext(); c = paramJsonReader.nextString().charAt(0)) {
      byte b;
      String str = paramJsonReader.nextName();
      switch (str.hashCode()) {
        default:
          b = -1;
          break;
        case 109780401:
          if (str.equals("style")) {
            b = 3;
            break;
          } 
        case 3530753:
          if (str.equals("size")) {
            b = 1;
            break;
          } 
        case 3076010:
          if (str.equals("data")) {
            b = 5;
            break;
          } 
        case 3173:
          if (str.equals("ch")) {
            b = 0;
            break;
          } 
        case 119:
          if (str.equals("w")) {
            b = 2;
            break;
          } 
        case -1866931350:
          if (str.equals("fFamily")) {
            b = 4;
            break;
          } 
      } 
      if (b != 0) {
        if (b != 1) {
          if (b != 2) {
            if (b != 3) {
              if (b != 4) {
                if (b != 5) {
                  paramJsonReader.skipValue();
                  continue;
                } 
                paramJsonReader.beginObject();
                while (paramJsonReader.hasNext()) {
                  if ("shapes".equals(paramJsonReader.nextName())) {
                    paramJsonReader.beginArray();
                    while (paramJsonReader.hasNext())
                      arrayList.add((ShapeGroup)ContentModelParser.a(paramJsonReader, paramLottieComposition)); 
                    paramJsonReader.endArray();
                    continue;
                  } 
                  paramJsonReader.skipValue();
                } 
                paramJsonReader.endObject();
                continue;
              } 
              str1 = paramJsonReader.nextString();
              continue;
            } 
            str2 = paramJsonReader.nextString();
            continue;
          } 
          d1 = paramJsonReader.nextDouble();
          continue;
        } 
        d2 = paramJsonReader.nextDouble();
        continue;
      } 
    } 
    paramJsonReader.endObject();
    return new FontCharacter(arrayList, c, d2, d1, str2, str1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\FontCharacterParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */