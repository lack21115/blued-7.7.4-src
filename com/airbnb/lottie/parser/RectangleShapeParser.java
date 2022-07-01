package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import java.io.IOException;

class RectangleShapeParser {
  static RectangleShape a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    AnimatableValue<PointF, PointF> animatableValue;
    AnimatablePointValue animatablePointValue;
    String str;
    AnimatableFloatValue animatableFloatValue4 = null;
    AnimatableFloatValue animatableFloatValue1 = animatableFloatValue4;
    AnimatableFloatValue animatableFloatValue2 = animatableFloatValue1;
    AnimatableFloatValue animatableFloatValue3 = animatableFloatValue2;
    boolean bool = false;
    while (paramJsonReader.hasNext()) {
      String str1 = paramJsonReader.nextName();
      byte b = -1;
      int i = str1.hashCode();
      if (i != 112) {
        if (i != 3324) {
          if (i != 3519) {
            if (i != 114) {
              if (i == 115 && str1.equals("s"))
                b = 2; 
            } else if (str1.equals("r")) {
              b = 3;
            } 
          } else if (str1.equals("nm")) {
            b = 0;
          } 
        } else if (str1.equals("hd")) {
          b = 4;
        } 
      } else if (str1.equals("p")) {
        b = 1;
      } 
      if (b != 0) {
        if (b != 1) {
          if (b != 2) {
            if (b != 3) {
              if (b != 4) {
                paramJsonReader.skipValue();
                continue;
              } 
              bool = paramJsonReader.nextBoolean();
              continue;
            } 
            animatableFloatValue3 = AnimatableValueParser.a(paramJsonReader, paramLottieComposition);
            continue;
          } 
          animatablePointValue = AnimatableValueParser.c(paramJsonReader, paramLottieComposition);
          continue;
        } 
        animatableValue = AnimatablePathValueParser.b(paramJsonReader, paramLottieComposition);
        continue;
      } 
      str = paramJsonReader.nextString();
    } 
    return new RectangleShape(str, animatableValue, animatablePointValue, animatableFloatValue3, bool);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\RectangleShapeParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */