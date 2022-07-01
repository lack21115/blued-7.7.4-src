package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import java.io.IOException;

class CircleShapeParser {
  static CircleShape a(JsonReader paramJsonReader, LottieComposition paramLottieComposition, int paramInt) throws IOException {
    boolean bool;
    AnimatableValue<PointF, PointF> animatableValue;
    String str;
    if (paramInt == 3) {
      bool = true;
    } else {
      bool = false;
    } 
    AnimatablePointValue animatablePointValue3 = null;
    AnimatablePointValue animatablePointValue1 = animatablePointValue3;
    AnimatablePointValue animatablePointValue2 = animatablePointValue1;
    boolean bool1 = false;
    while (paramJsonReader.hasNext()) {
      String str1 = paramJsonReader.nextName();
      paramInt = -1;
      int i = str1.hashCode();
      if (i != 100) {
        if (i != 112) {
          if (i != 115) {
            if (i != 3324) {
              if (i == 3519 && str1.equals("nm"))
                paramInt = 0; 
            } else if (str1.equals("hd")) {
              paramInt = 3;
            } 
          } else if (str1.equals("s")) {
            paramInt = 2;
          } 
        } else if (str1.equals("p")) {
          paramInt = 1;
        } 
      } else if (str1.equals("d")) {
        paramInt = 4;
      } 
      if (paramInt != 0) {
        if (paramInt != 1) {
          if (paramInt != 2) {
            if (paramInt != 3) {
              if (paramInt != 4) {
                paramJsonReader.skipValue();
                continue;
              } 
              if (paramJsonReader.nextInt() == 3) {
                boolean bool2 = true;
                continue;
              } 
              bool = false;
              continue;
            } 
            bool1 = paramJsonReader.nextBoolean();
            continue;
          } 
          animatablePointValue2 = AnimatableValueParser.c(paramJsonReader, paramLottieComposition);
          continue;
        } 
        animatableValue = AnimatablePathValueParser.b(paramJsonReader, paramLottieComposition);
        continue;
      } 
      str = paramJsonReader.nextString();
    } 
    return new CircleShape(str, animatableValue, animatablePointValue2, bool, bool1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\CircleShapeParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */