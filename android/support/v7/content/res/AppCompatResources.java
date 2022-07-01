package android.support.v7.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class AppCompatResources {
  private static final ThreadLocal TL_TYPED_VALUE = new ThreadLocal();
  
  private static final Object sColorStateCacheLock;
  
  private static final WeakHashMap sColorStateCaches = new WeakHashMap<Object, Object>(0);
  
  static {
    sColorStateCacheLock = new Object();
    throw new VerifyError("bad dex opcode");
  }
  
  private static ColorStateList getCachedColorStateList(Context paramContext, int paramInt) {
    synchronized (sColorStateCacheLock) {
      SparseArray sparseArray = (SparseArray)sColorStateCaches.get(paramContext);
      if (sparseArray != null && sparseArray.size() > 0) {
        AppCompatResources$ColorStateListCacheEntry appCompatResources$ColorStateListCacheEntry = (AppCompatResources$ColorStateListCacheEntry)sparseArray.get(paramInt);
        if (appCompatResources$ColorStateListCacheEntry != null) {
          if (appCompatResources$ColorStateListCacheEntry.configuration.equals(paramContext.getResources().getConfiguration()))
            return appCompatResources$ColorStateListCacheEntry.value; 
          sparseArray.remove(paramInt);
        } 
      } 
      return null;
    } 
  }
  
  public static ColorStateList getColorStateList(Context paramContext, int paramInt) {
    if (Build.VERSION.SDK_INT >= 23)
      return paramContext.getColorStateList(paramInt); 
    ColorStateList colorStateList1 = getCachedColorStateList(paramContext, paramInt);
    if (colorStateList1 != null)
      return colorStateList1; 
    ColorStateList colorStateList2 = inflateColorStateList(paramContext, paramInt);
    if (colorStateList2 != null)
      synchronized (sColorStateCacheLock) {
        SparseArray sparseArray2 = (SparseArray)sColorStateCaches.get(paramContext);
        SparseArray sparseArray1 = sparseArray2;
        if (sparseArray2 == null) {
          sparseArray1 = new SparseArray();
          sColorStateCaches.put(paramContext, sparseArray1);
        } 
        sparseArray1.append(paramInt, new AppCompatResources$ColorStateListCacheEntry(colorStateList2, paramContext.getResources().getConfiguration()));
        return colorStateList2;
      }  
    return ContextCompat.getColorStateList(paramContext, paramInt);
  }
  
  public static Drawable getDrawable(Context paramContext, int paramInt) {
    return AppCompatDrawableManager.get().getDrawable(paramContext, paramInt);
  }
  
  private static ColorStateList inflateColorStateList(Context paramContext, int paramInt) {
    Resources resources2 = paramContext.getResources();
    TypedValue typedValue2 = TL_TYPED_VALUE.get();
    TypedValue typedValue1 = typedValue2;
    if (typedValue2 == null) {
      typedValue1 = new TypedValue();
      TL_TYPED_VALUE.set(typedValue1);
    } 
    boolean bool = true;
    resources2.getValue(paramInt, typedValue1, true);
    if (typedValue1.type < 28 || typedValue1.type > 31)
      bool = false; 
    if (bool)
      return null; 
    Resources resources1 = paramContext.getResources();
    XmlResourceParser xmlResourceParser = resources1.getXml(paramInt);
    try {
      return AppCompatColorStateListInflater.createFromXml(resources1, (XmlPullParser)xmlResourceParser, paramContext.getTheme());
    } catch (Exception exception) {
      Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", exception);
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\content\res\AppCompatResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */