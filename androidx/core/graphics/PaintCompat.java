package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.os.Build;
import androidx.core.util.Pair;

public final class PaintCompat {
  private static final ThreadLocal<Pair<Rect, Rect>> a = new ThreadLocal<Pair<Rect, Rect>>();
  
  private static Pair<Rect, Rect> a() {
    Pair<Rect, Rect> pair = a.get();
    if (pair == null) {
      pair = new Pair(new Rect(), new Rect());
      a.set(pair);
      return pair;
    } 
    ((Rect)pair.first).setEmpty();
    ((Rect)pair.second).setEmpty();
    return pair;
  }
  
  public static boolean hasGlyph(Paint paramPaint, String paramString) {
    if (Build.VERSION.SDK_INT >= 23)
      return paramPaint.hasGlyph(paramString); 
    int i = paramString.length();
    if (i == 1 && Character.isWhitespace(paramString.charAt(0)))
      return true; 
    float f2 = paramPaint.measureText("󟿽");
    float f4 = paramPaint.measureText("m");
    float f3 = paramPaint.measureText(paramString);
    float f1 = 0.0F;
    if (f3 == 0.0F)
      return false; 
    if (paramString.codePointCount(0, paramString.length()) > 1) {
      if (f3 > f4 * 2.0F)
        return false; 
      int j;
      for (j = 0; j < i; j = k) {
        int k = Character.charCount(paramString.codePointAt(j)) + j;
        f1 += paramPaint.measureText(paramString, j, k);
      } 
      if (f3 >= f1)
        return false; 
    } 
    if (f3 != f2)
      return true; 
    Pair<Rect, Rect> pair = a();
    paramPaint.getTextBounds("󟿽", 0, 2, (Rect)pair.first);
    paramPaint.getTextBounds(paramString, 0, i, (Rect)pair.second);
    return ((Rect)pair.first).equals(pair.second) ^ true;
  }
  
  public static boolean setBlendMode(Paint paramPaint, BlendModeCompat paramBlendModeCompat) {
    int i = Build.VERSION.SDK_INT;
    BlendMode blendMode1 = null;
    BlendMode blendMode2 = null;
    if (i >= 29) {
      blendMode1 = blendMode2;
      if (paramBlendModeCompat != null)
        blendMode1 = BlendModeUtils.a(paramBlendModeCompat); 
      paramPaint.setBlendMode(blendMode1);
      return true;
    } 
    if (paramBlendModeCompat != null) {
      PorterDuffXfermode porterDuffXfermode;
      PorterDuff.Mode mode = BlendModeUtils.b(paramBlendModeCompat);
      BlendMode blendMode = blendMode1;
      if (mode != null)
        porterDuffXfermode = new PorterDuffXfermode(mode); 
      paramPaint.setXfermode((Xfermode)porterDuffXfermode);
      return (mode != null);
    } 
    paramPaint.setXfermode(null);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\PaintCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */