package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import java.io.IOException;

class RepeaterParser {
  static Repeater a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    AnimatableFloatValue animatableFloatValue1;
    AnimatableFloatValue animatableFloatValue2;
    String str;
    AnimatableTransform animatableTransform4 = null;
    AnimatableTransform animatableTransform1 = animatableTransform4;
    AnimatableTransform animatableTransform2 = animatableTransform1;
    AnimatableTransform animatableTransform3 = animatableTransform2;
    boolean bool = false;
    while (paramJsonReader.hasNext()) {
      String str1 = paramJsonReader.nextName();
      byte b = -1;
      int i = str1.hashCode();
      if (i != 99) {
        if (i != 111) {
          if (i != 3324) {
            if (i != 3519) {
              if (i == 3710 && str1.equals("tr"))
                b = 3; 
            } else if (str1.equals("nm")) {
              b = 0;
            } 
          } else if (str1.equals("hd")) {
            b = 4;
          } 
        } else if (str1.equals("o")) {
          b = 2;
        } 
      } else if (str1.equals("c")) {
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
            animatableTransform3 = AnimatableTransformParser.a(paramJsonReader, paramLottieComposition);
            continue;
          } 
          animatableFloatValue2 = AnimatableValueParser.a(paramJsonReader, paramLottieComposition, false);
          continue;
        } 
        animatableFloatValue1 = AnimatableValueParser.a(paramJsonReader, paramLottieComposition, false);
        continue;
      } 
      str = paramJsonReader.nextString();
    } 
    return new Repeater(str, animatableFloatValue1, animatableFloatValue2, animatableTransform3, bool);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\RepeaterParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */