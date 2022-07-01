package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.io.IOException;
import java.util.ArrayList;

class ShapeGroupParser {
  static ShapeGroup a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    ArrayList<ContentModel> arrayList = new ArrayList();
    String str = null;
    boolean bool = false;
    while (paramJsonReader.hasNext()) {
      String str1 = paramJsonReader.nextName();
      byte b = -1;
      int i = str1.hashCode();
      if (i != 3324) {
        if (i != 3371) {
          if (i == 3519 && str1.equals("nm"))
            b = 0; 
        } else if (str1.equals("it")) {
          b = 2;
        } 
      } else if (str1.equals("hd")) {
        b = 1;
      } 
      if (b != 0) {
        if (b != 1) {
          if (b != 2) {
            paramJsonReader.skipValue();
            continue;
          } 
          paramJsonReader.beginArray();
          while (paramJsonReader.hasNext()) {
            ContentModel contentModel = ContentModelParser.a(paramJsonReader, paramLottieComposition);
            if (contentModel != null)
              arrayList.add(contentModel); 
          } 
          paramJsonReader.endArray();
          continue;
        } 
        bool = paramJsonReader.nextBoolean();
        continue;
      } 
      str = paramJsonReader.nextString();
    } 
    return new ShapeGroup(str, arrayList, bool);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\ShapeGroupParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */