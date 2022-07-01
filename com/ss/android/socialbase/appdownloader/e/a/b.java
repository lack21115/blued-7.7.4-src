package com.ss.android.socialbase.appdownloader.e.a;

import java.io.IOException;

public class b {
  public static final void a(d paramd, int paramInt) throws IOException {
    int i = paramd.b();
    if (i == paramInt)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected chunk of type 0x");
    stringBuilder.append(Integer.toHexString(paramInt));
    stringBuilder.append(", read 0x");
    stringBuilder.append(Integer.toHexString(i));
    stringBuilder.append(".");
    throw new IOException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\e\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */