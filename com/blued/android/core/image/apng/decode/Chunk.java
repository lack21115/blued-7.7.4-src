package com.blued.android.core.image.apng.decode;

import android.text.TextUtils;
import com.blued.android.core.image.apng.io.APNGReader;
import java.io.IOException;

class Chunk {
  int d;
  
  int e;
  
  int f;
  
  int g;
  
  static int a(String paramString) {
    if (TextUtils.isEmpty(paramString) || paramString.length() != 4)
      return -1159790593; 
    char c1 = paramString.charAt(0);
    char c2 = paramString.charAt(1);
    char c3 = paramString.charAt(2);
    return (paramString.charAt(3) & 0xFF) << 24 | c1 & 0xFF | (c2 & 0xFF) << 8 | (c3 & 0xFF) << 16;
  }
  
  void a(APNGReader paramAPNGReader) throws IOException {}
  
  void b(APNGReader paramAPNGReader) throws IOException {
    int i = paramAPNGReader.available();
    a(paramAPNGReader);
    i -= paramAPNGReader.available();
    int j = this.d;
    if (i <= j) {
      if (i < j)
        paramAPNGReader.skip((j - i)); 
      return;
    } 
    throw new IOException("Out of chunk area");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\decode\Chunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */