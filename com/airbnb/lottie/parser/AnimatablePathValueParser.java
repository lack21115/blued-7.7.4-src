package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimatablePathValueParser {
  public static AnimatablePathValue a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    ArrayList<PathKeyframe> arrayList = new ArrayList();
    if (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY) {
      paramJsonReader.beginArray();
      while (paramJsonReader.hasNext())
        arrayList.add(PathKeyframeParser.a(paramJsonReader, paramLottieComposition)); 
      paramJsonReader.endArray();
      KeyframesParser.a((List)arrayList);
    } else {
      arrayList.add(new Keyframe(JsonUtils.b(paramJsonReader, Utils.a())));
    } 
    return new AnimatablePathValue(arrayList);
  }
  
  static AnimatableValue<PointF, PointF> b(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    AnimatablePathValue animatablePathValue;
    paramJsonReader.beginObject();
    AnimatableFloatValue animatableFloatValue3 = null;
    AnimatableFloatValue animatableFloatValue1 = animatableFloatValue3;
    AnimatableFloatValue animatableFloatValue2 = animatableFloatValue1;
    boolean bool = false;
    while (paramJsonReader.peek() != JsonToken.END_OBJECT) {
      String str = paramJsonReader.nextName();
      byte b = -1;
      int i = str.hashCode();
      if (i != 107) {
        if (i != 120) {
          if (i == 121 && str.equals("y"))
            b = 2; 
        } else if (str.equals("x")) {
          b = 1;
        } 
      } else if (str.equals("k")) {
        b = 0;
      } 
      if (b != 0) {
        if (b != 1) {
          if (b != 2) {
            paramJsonReader.skipValue();
            continue;
          } 
          if (paramJsonReader.peek() == JsonToken.STRING) {
            paramJsonReader.skipValue();
          } else {
            animatableFloatValue2 = AnimatableValueParser.a(paramJsonReader, paramLottieComposition);
            continue;
          } 
        } else if (paramJsonReader.peek() == JsonToken.STRING) {
          paramJsonReader.skipValue();
        } else {
          animatableFloatValue1 = AnimatableValueParser.a(paramJsonReader, paramLottieComposition);
          continue;
        } 
        bool = true;
        continue;
      } 
      animatablePathValue = a(paramJsonReader, paramLottieComposition);
    } 
    paramJsonReader.endObject();
    if (bool)
      paramLottieComposition.a("Lottie doesn't support expressions."); 
    return (AnimatableValue<PointF, PointF>)((animatablePathValue != null) ? animatablePathValue : new AnimatableSplitDimensionPathValue(animatableFloatValue1, animatableFloatValue2));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\AnimatablePathValueParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */