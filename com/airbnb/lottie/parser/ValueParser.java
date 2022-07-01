package com.airbnb.lottie.parser;

import android.util.JsonReader;
import java.io.IOException;

interface ValueParser<V> {
  V b(JsonReader paramJsonReader, float paramFloat) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\ValueParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */