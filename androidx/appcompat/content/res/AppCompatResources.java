package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class AppCompatResources {
  private static final ThreadLocal<TypedValue> a = new ThreadLocal<TypedValue>();
  
  private static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> b = new WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>>(0);
  
  private static final Object c = new Object();
  
  private static ColorStateList a(Context paramContext, int paramInt) {
    if (c(paramContext, paramInt))
      return null; 
    Resources resources = paramContext.getResources();
    XmlResourceParser xmlResourceParser = resources.getXml(paramInt);
    try {
      return ColorStateListInflaterCompat.createFromXml(resources, (XmlPullParser)xmlResourceParser, paramContext.getTheme());
    } catch (Exception exception) {
      Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", exception);
      return null;
    } 
  }
  
  private static TypedValue a() {
    TypedValue typedValue2 = a.get();
    TypedValue typedValue1 = typedValue2;
    if (typedValue2 == null) {
      typedValue1 = new TypedValue();
      a.set(typedValue1);
    } 
    return typedValue1;
  }
  
  private static void a(Context paramContext, int paramInt, ColorStateList paramColorStateList) {
    synchronized (c) {
      SparseArray<ColorStateListCacheEntry> sparseArray2 = b.get(paramContext);
      SparseArray<ColorStateListCacheEntry> sparseArray1 = sparseArray2;
      if (sparseArray2 == null) {
        sparseArray1 = new SparseArray();
        b.put(paramContext, sparseArray1);
      } 
      sparseArray1.append(paramInt, new ColorStateListCacheEntry(paramColorStateList, paramContext.getResources().getConfiguration()));
      return;
    } 
  }
  
  private static ColorStateList b(Context paramContext, int paramInt) {
    synchronized (c) {
      SparseArray sparseArray = b.get(paramContext);
      if (sparseArray != null && sparseArray.size() > 0) {
        ColorStateListCacheEntry colorStateListCacheEntry = (ColorStateListCacheEntry)sparseArray.get(paramInt);
        if (colorStateListCacheEntry != null) {
          if (colorStateListCacheEntry.b.equals(paramContext.getResources().getConfiguration()))
            return colorStateListCacheEntry.a; 
          sparseArray.remove(paramInt);
        } 
      } 
      return null;
    } 
  }
  
  private static boolean c(Context paramContext, int paramInt) {
    Resources resources = paramContext.getResources();
    TypedValue typedValue = a();
    resources.getValue(paramInt, typedValue, true);
    return (typedValue.type >= 28 && typedValue.type <= 31);
  }
  
  public static ColorStateList getColorStateList(Context paramContext, int paramInt) {
    if (Build.VERSION.SDK_INT >= 23)
      return paramContext.getColorStateList(paramInt); 
    ColorStateList colorStateList = b(paramContext, paramInt);
    if (colorStateList != null)
      return colorStateList; 
    colorStateList = a(paramContext, paramInt);
    if (colorStateList != null) {
      a(paramContext, paramInt, colorStateList);
      return colorStateList;
    } 
    return ContextCompat.getColorStateList(paramContext, paramInt);
  }
  
  public static Drawable getDrawable(Context paramContext, int paramInt) {
    return ResourceManagerInternal.get().getDrawable(paramContext, paramInt);
  }
  
  static class ColorStateListCacheEntry {
    final ColorStateList a;
    
    final Configuration b;
    
    ColorStateListCacheEntry(ColorStateList param1ColorStateList, Configuration param1Configuration) {
      this.a = param1ColorStateList;
      this.b = param1Configuration;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\content\res\AppCompatResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */