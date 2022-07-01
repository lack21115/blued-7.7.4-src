package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;

class PathKeyframeParser {
  static PathKeyframe a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    boolean bool;
    if (paramJsonReader.peek() == JsonToken.BEGIN_OBJECT) {
      bool = true;
    } else {
      bool = false;
    } 
    return new PathKeyframe(paramLottieComposition, KeyframeParser.a(paramJsonReader, paramLottieComposition, Utils.a(), PathParser.a, bool));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\PathKeyframeParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */