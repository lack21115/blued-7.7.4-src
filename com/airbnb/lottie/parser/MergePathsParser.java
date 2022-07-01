package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.model.content.MergePaths;
import java.io.IOException;

class MergePathsParser {
  static MergePaths a(JsonReader paramJsonReader) throws IOException {
    String str = null;
    MergePaths.MergePathsMode mergePathsMode = null;
    boolean bool = false;
    while (paramJsonReader.hasNext()) {
      String str1 = paramJsonReader.nextName();
      byte b = -1;
      int i = str1.hashCode();
      if (i != 3324) {
        if (i != 3488) {
          if (i == 3519 && str1.equals("nm"))
            b = 0; 
        } else if (str1.equals("mm")) {
          b = 1;
        } 
      } else if (str1.equals("hd")) {
        b = 2;
      } 
      if (b != 0) {
        if (b != 1) {
          if (b != 2) {
            paramJsonReader.skipValue();
            continue;
          } 
          bool = paramJsonReader.nextBoolean();
          continue;
        } 
        mergePathsMode = MergePaths.MergePathsMode.a(paramJsonReader.nextInt());
        continue;
      } 
      str = paramJsonReader.nextString();
    } 
    return new MergePaths(str, mergePathsMode, bool);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\MergePathsParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */