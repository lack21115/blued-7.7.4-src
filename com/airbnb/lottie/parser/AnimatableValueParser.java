package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.List;

public class AnimatableValueParser {
  public static AnimatableFloatValue a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    return a(paramJsonReader, paramLottieComposition, true);
  }
  
  public static AnimatableFloatValue a(JsonReader paramJsonReader, LottieComposition paramLottieComposition, boolean paramBoolean) throws IOException {
    float f;
    if (paramBoolean) {
      f = Utils.a();
    } else {
      f = 1.0F;
    } 
    return new AnimatableFloatValue(a(paramJsonReader, f, paramLottieComposition, FloatParser.a));
  }
  
  static AnimatableGradientColorValue a(JsonReader paramJsonReader, LottieComposition paramLottieComposition, int paramInt) throws IOException {
    return new AnimatableGradientColorValue(a(paramJsonReader, paramLottieComposition, new GradientColorParser(paramInt)));
  }
  
  private static <T> List<Keyframe<T>> a(JsonReader paramJsonReader, float paramFloat, LottieComposition paramLottieComposition, ValueParser<T> paramValueParser) throws IOException {
    return KeyframesParser.a(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser);
  }
  
  private static <T> List<Keyframe<T>> a(JsonReader paramJsonReader, LottieComposition paramLottieComposition, ValueParser<T> paramValueParser) throws IOException {
    return KeyframesParser.a(paramJsonReader, paramLottieComposition, 1.0F, paramValueParser);
  }
  
  static AnimatableIntegerValue b(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    return new AnimatableIntegerValue(a(paramJsonReader, paramLottieComposition, IntegerParser.a));
  }
  
  static AnimatablePointValue c(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    return new AnimatablePointValue(a(paramJsonReader, Utils.a(), paramLottieComposition, PointFParser.a));
  }
  
  static AnimatableScaleValue d(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    return new AnimatableScaleValue(a(paramJsonReader, paramLottieComposition, ScaleXYParser.a));
  }
  
  static AnimatableShapeValue e(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    return new AnimatableShapeValue(a(paramJsonReader, Utils.a(), paramLottieComposition, ShapeDataParser.a));
  }
  
  static AnimatableTextFrame f(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    return new AnimatableTextFrame(a(paramJsonReader, paramLottieComposition, DocumentDataParser.a));
  }
  
  static AnimatableColorValue g(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    return new AnimatableColorValue(a(paramJsonReader, paramLottieComposition, ColorParser.a));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\AnimatableValueParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */