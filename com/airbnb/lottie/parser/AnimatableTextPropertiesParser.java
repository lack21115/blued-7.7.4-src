package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import java.io.IOException;

public class AnimatableTextPropertiesParser {
  public static AnimatableTextProperties a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    paramJsonReader.beginObject();
    AnimatableTextProperties animatableTextProperties;
    for (animatableTextProperties = null; paramJsonReader.hasNext(); animatableTextProperties = b(paramJsonReader, paramLottieComposition)) {
      String str = paramJsonReader.nextName();
      byte b = -1;
      if (str.hashCode() == 97 && str.equals("a"))
        b = 0; 
      if (b != 0) {
        paramJsonReader.skipValue();
        continue;
      } 
    } 
    paramJsonReader.endObject();
    return (animatableTextProperties == null) ? new AnimatableTextProperties(null, null, null, null) : animatableTextProperties;
  }
  
  private static AnimatableTextProperties b(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    AnimatableColorValue animatableColorValue1;
    paramJsonReader.beginObject();
    AnimatableColorValue animatableColorValue2 = null;
    AnimatableFloatValue animatableFloatValue3 = null;
    AnimatableFloatValue animatableFloatValue1 = animatableFloatValue3;
    AnimatableFloatValue animatableFloatValue2 = animatableFloatValue1;
    while (paramJsonReader.hasNext()) {
      String str = paramJsonReader.nextName();
      byte b = -1;
      int i = str.hashCode();
      if (i != 116) {
        if (i != 3261) {
          if (i != 3664) {
            if (i == 3684 && str.equals("sw"))
              b = 2; 
          } else if (str.equals("sc")) {
            b = 1;
          } 
        } else if (str.equals("fc")) {
          b = 0;
        } 
      } else if (str.equals("t")) {
        b = 3;
      } 
      if (b != 0) {
        if (b != 1) {
          if (b != 2) {
            if (b != 3) {
              paramJsonReader.skipValue();
              continue;
            } 
            animatableFloatValue2 = AnimatableValueParser.a(paramJsonReader, paramLottieComposition);
            continue;
          } 
          animatableFloatValue1 = AnimatableValueParser.a(paramJsonReader, paramLottieComposition);
          continue;
        } 
        animatableColorValue1 = AnimatableValueParser.g(paramJsonReader, paramLottieComposition);
        continue;
      } 
      animatableColorValue2 = AnimatableValueParser.g(paramJsonReader, paramLottieComposition);
    } 
    paramJsonReader.endObject();
    return new AnimatableTextProperties(animatableColorValue2, animatableColorValue1, animatableFloatValue1, animatableFloatValue2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\AnimatableTextPropertiesParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */