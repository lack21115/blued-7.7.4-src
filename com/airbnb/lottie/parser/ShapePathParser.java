package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import java.io.IOException;

class ShapePathParser {
  static ShapePath a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    String str = null;
    AnimatableShapeValue animatableShapeValue = null;
    int i = 0;
    boolean bool = false;
    while (paramJsonReader.hasNext()) {
      String str1 = paramJsonReader.nextName();
      byte b = -1;
      int j = str1.hashCode();
      if (j != 3324) {
        if (j != 3432) {
          if (j != 3519) {
            if (j == 104415 && str1.equals("ind"))
              b = 1; 
          } else if (str1.equals("nm")) {
            b = 0;
          } 
        } else if (str1.equals("ks")) {
          b = 2;
        } 
      } else if (str1.equals("hd")) {
        b = 3;
      } 
      if (b != 0) {
        if (b != 1) {
          if (b != 2) {
            if (b != 3) {
              paramJsonReader.skipValue();
              continue;
            } 
            bool = paramJsonReader.nextBoolean();
            continue;
          } 
          animatableShapeValue = AnimatableValueParser.e(paramJsonReader, paramLottieComposition);
          continue;
        } 
        i = paramJsonReader.nextInt();
        continue;
      } 
      str = paramJsonReader.nextString();
    } 
    return new ShapePath(str, i, animatableShapeValue, bool);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\ShapePathParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */