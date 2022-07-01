package com.airbnb.lottie.parser;

import android.graphics.Path;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import java.io.IOException;

class ShapeFillParser {
  static ShapeFill a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    Path.FillType fillType;
    AnimatableColorValue animatableColorValue;
    String str;
    AnimatableIntegerValue animatableIntegerValue3 = null;
    AnimatableIntegerValue animatableIntegerValue1 = animatableIntegerValue3;
    AnimatableIntegerValue animatableIntegerValue2 = animatableIntegerValue1;
    int i = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    while (paramJsonReader.hasNext()) {
      String str1 = paramJsonReader.nextName();
      byte b = -1;
      int j = str1.hashCode();
      if (j != -396065730) {
        if (j != 99) {
          if (j != 111) {
            if (j != 114) {
              if (j != 3324) {
                if (j == 3519 && str1.equals("nm"))
                  b = 0; 
              } else if (str1.equals("hd")) {
                b = 5;
              } 
            } else if (str1.equals("r")) {
              b = 4;
            } 
          } else if (str1.equals("o")) {
            b = 2;
          } 
        } else if (str1.equals("c")) {
          b = 1;
        } 
      } else if (str1.equals("fillEnabled")) {
        b = 3;
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
                bool1 = paramJsonReader.nextBoolean();
                continue;
              } 
              i = paramJsonReader.nextInt();
              continue;
            } 
            bool2 = paramJsonReader.nextBoolean();
            continue;
          } 
          animatableIntegerValue2 = AnimatableValueParser.b(paramJsonReader, paramLottieComposition);
          continue;
        } 
        animatableColorValue = AnimatableValueParser.g(paramJsonReader, paramLottieComposition);
        continue;
      } 
      str = paramJsonReader.nextString();
    } 
    if (i == 1) {
      fillType = Path.FillType.WINDING;
    } else {
      fillType = Path.FillType.EVEN_ODD;
    } 
    return new ShapeFill(str, bool2, fillType, animatableColorValue, animatableIntegerValue2, bool1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\ShapeFillParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */