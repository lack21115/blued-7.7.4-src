package com.blued.android.framework.qrcode.decoding;

import com.google.zxing.BarcodeFormat;
import java.util.Vector;
import java.util.regex.Pattern;

final class DecodeFormatManager {
  static final Vector<BarcodeFormat> a;
  
  static final Vector<BarcodeFormat> b;
  
  static final Vector<BarcodeFormat> c;
  
  static final Vector<BarcodeFormat> d;
  
  private static final Pattern e = Pattern.compile(",");
  
  static {
    a = new Vector<BarcodeFormat>(5);
    a.add(BarcodeFormat.o);
    a.add(BarcodeFormat.p);
    a.add(BarcodeFormat.h);
    a.add(BarcodeFormat.g);
    b = new Vector<BarcodeFormat>(a.size() + 4);
    b.addAll(a);
    b.add(BarcodeFormat.c);
    b.add(BarcodeFormat.d);
    b.add(BarcodeFormat.e);
    b.add(BarcodeFormat.i);
    c = new Vector<BarcodeFormat>(1);
    c.add(BarcodeFormat.l);
    d = new Vector<BarcodeFormat>(1);
    d.add(BarcodeFormat.f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\qrcode\decoding\DecodeFormatManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */