package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class KeyframesParser {
  static <T> List<Keyframe<T>> a(JsonReader paramJsonReader, LottieComposition paramLottieComposition, float paramFloat, ValueParser<T> paramValueParser) throws IOException {
    ArrayList<Keyframe<T>> arrayList = new ArrayList();
    if (paramJsonReader.peek() == JsonToken.STRING) {
      paramLottieComposition.a("Lottie doesn't support expressions.");
      return arrayList;
    } 
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext()) {
      String str = paramJsonReader.nextName();
      byte b = -1;
      if (str.hashCode() == 107 && str.equals("k"))
        b = 0; 
      if (b != 0) {
        paramJsonReader.skipValue();
        continue;
      } 
      if (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY) {
        paramJsonReader.beginArray();
        if (paramJsonReader.peek() == JsonToken.NUMBER) {
          arrayList.add(KeyframeParser.a(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser, false));
        } else {
          while (paramJsonReader.hasNext())
            arrayList.add(KeyframeParser.a(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser, true)); 
        } 
        paramJsonReader.endArray();
        continue;
      } 
      arrayList.add(KeyframeParser.a(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser, false));
    } 
    paramJsonReader.endObject();
    a(arrayList);
    return arrayList;
  }
  
  public static <T> void a(List<? extends Keyframe<T>> paramList) {
    int j = paramList.size();
    int i = 0;
    while (true) {
      int k = j - 1;
      if (i < k) {
        Keyframe keyframe1 = paramList.get(i);
        k = i + 1;
        Keyframe keyframe2 = paramList.get(k);
        keyframe1.e = Float.valueOf(keyframe2.d);
        i = k;
        if (keyframe1.b == null) {
          i = k;
          if (keyframe2.a != null) {
            keyframe1.b = keyframe2.a;
            i = k;
            if (keyframe1 instanceof PathKeyframe) {
              ((PathKeyframe)keyframe1).a();
              i = k;
            } 
          } 
        } 
        continue;
      } 
      Keyframe keyframe = paramList.get(k);
      if ((keyframe.a == null || keyframe.b == null) && paramList.size() > 1)
        paramList.remove(keyframe); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\KeyframesParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */