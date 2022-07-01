package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

public class PathParser implements ValueParser<PointF> {
  public static final PathParser a = new PathParser();
  
  public PointF a(JsonReader paramJsonReader, float paramFloat) throws IOException {
    return JsonUtils.b(paramJsonReader, paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\PathParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */