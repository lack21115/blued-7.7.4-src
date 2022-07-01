package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.model.Font;
import java.io.IOException;

class FontParser {
  static Font a(JsonReader paramJsonReader) throws IOException {
    paramJsonReader.beginObject();
    String str3 = null;
    String str2 = null;
    String str1 = str2;
    float f = 0.0F;
    while (paramJsonReader.hasNext()) {
      String str = paramJsonReader.nextName();
      byte b = -1;
      switch (str.hashCode()) {
        case 96619537:
          if (str.equals("fName"))
            b = 1; 
          break;
        case -1294566165:
          if (str.equals("fStyle"))
            b = 2; 
          break;
        case -1408684838:
          if (str.equals("ascent"))
            b = 3; 
          break;
        case -1866931350:
          if (str.equals("fFamily"))
            b = 0; 
          break;
      } 
      if (b != 0) {
        if (b != 1) {
          if (b != 2) {
            if (b != 3) {
              paramJsonReader.skipValue();
              continue;
            } 
            f = (float)paramJsonReader.nextDouble();
            continue;
          } 
          str1 = paramJsonReader.nextString();
          continue;
        } 
        str2 = paramJsonReader.nextString();
        continue;
      } 
      str3 = paramJsonReader.nextString();
    } 
    paramJsonReader.endObject();
    return new Font(str3, str2, str1, f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\FontParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */