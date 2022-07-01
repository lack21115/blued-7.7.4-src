package com.airbnb.lottie.parser;

import android.graphics.Path;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import java.io.IOException;

class GradientFillParser {
  static GradientFill a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    AnimatableIntegerValue animatableIntegerValue;
    AnimatablePointValue animatablePointValue1;
    AnimatablePointValue animatablePointValue2;
    GradientType gradientType;
    Path.FillType fillType = Path.FillType.WINDING;
    String str6 = null;
    String str1 = str6;
    String str2 = str1;
    String str3 = str2;
    String str4 = str3;
    String str5 = str4;
    boolean bool = false;
    String str7 = str1;
    while (paramJsonReader.hasNext()) {
      byte b;
      Path.FillType fillType1;
      GradientType gradientType1;
      str1 = paramJsonReader.nextName();
      int i = str1.hashCode();
      if (i != 101) {
        if (i != 103) {
          if (i != 111) {
            if (i != 3324) {
              if (i != 3519) {
                switch (i) {
                  default:
                    i = -1;
                    break;
                  case 116:
                    if (str1.equals("t")) {
                      i = 3;
                      break;
                    } 
                  case 115:
                    if (str1.equals("s")) {
                      i = 4;
                      break;
                    } 
                  case 114:
                    if (str1.equals("r")) {
                      i = 6;
                      break;
                    } 
                } 
              } else if (str1.equals("nm")) {
                i = 0;
              } else {
              
              } 
            } else if (str1.equals("hd")) {
              i = 7;
            } else {
            
            } 
          } else if (str1.equals("o")) {
            i = 2;
          } else {
          
          } 
        } else if (str1.equals("g")) {
          i = 1;
        } else {
        
        } 
      } else if (str1.equals("e")) {
        i = 5;
      } else {
      
      } 
      switch (i) {
        default:
          paramJsonReader.skipValue();
          continue;
        case 7:
          bool = paramJsonReader.nextBoolean();
          continue;
        case 6:
          if (paramJsonReader.nextInt() == 1) {
            fillType1 = Path.FillType.WINDING;
          } else {
            fillType1 = Path.FillType.EVEN_ODD;
          } 
          fillType = fillType1;
          continue;
        case 5:
          animatablePointValue2 = AnimatableValueParser.c(paramJsonReader, paramLottieComposition);
          continue;
        case 4:
          animatablePointValue1 = AnimatableValueParser.c(paramJsonReader, paramLottieComposition);
          continue;
        case 3:
          if (paramJsonReader.nextInt() == 1) {
            gradientType1 = GradientType.a;
          } else {
            gradientType1 = GradientType.b;
          } 
          gradientType = gradientType1;
          continue;
        case 2:
          animatableIntegerValue = AnimatableValueParser.b(paramJsonReader, paramLottieComposition);
          continue;
        case 1:
          paramJsonReader.beginObject();
          b = -1;
          while (true)
            paramJsonReader.skipValue(); 
          paramJsonReader.endObject();
          continue;
        case 0:
          break;
      } 
      continue;
      str6 = paramJsonReader.nextString();
    } 
    return new GradientFill(str6, gradientType, fillType, (AnimatableGradientColorValue)str2, animatableIntegerValue, animatablePointValue1, animatablePointValue2, null, null, bool);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\GradientFillParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */