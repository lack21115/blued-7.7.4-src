package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

final class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
  private static final Method sAddFontWeightStyle;
  
  private static final Method sCreateFromFamiliesWithDefault;
  
  private static final Class sFontFamily;
  
  private static final Constructor sFontFamilyCtor;
  
  static {
    try {
      Class.forName("android.graphics.FontFamily");
      throw new VerifyError("bad dex opcode");
    } catch (ClassNotFoundException|NoSuchMethodException classNotFoundException) {
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  private static boolean addFontWeightStyle(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean) {
    try {
      return ((Boolean)sAddFontWeightStyle.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) })).booleanValue();
    } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } 
  }
  
  private static Typeface createFromFamiliesWithDefault(Object paramObject) {
    try {
      Object object = Array.newInstance(sFontFamily, 1);
      Array.set(object, 0, paramObject);
      return (Typeface)sCreateFromFamiliesWithDefault.invoke(null, new Object[] { object });
    } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } 
  }
  
  public static boolean isUsable() {
    if (sAddFontWeightStyle == null)
      Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation."); 
    return (sAddFontWeightStyle != null);
  }
  
  private static Object newFamily() {
    try {
      return sFontFamilyCtor.newInstance(new Object[0]);
    } catch (IllegalAccessException|InstantiationException|java.lang.reflect.InvocationTargetException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } 
  }
  
  public final Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt) {
    Object object = newFamily();
    FontResourcesParserCompat.FontFileResourceEntry[] arrayOfFontFileResourceEntry = paramFontFamilyFilesResourceEntry.mEntries;
    int i = arrayOfFontFileResourceEntry.length;
    for (paramInt = 0; paramInt < i; paramInt++) {
      FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = arrayOfFontFileResourceEntry[paramInt];
      ByteBuffer byteBuffer = TypefaceCompatUtil.copyToDirectBuffer(paramContext, paramResources, fontFileResourceEntry.mResourceId);
      if (byteBuffer == null)
        return null; 
      if (!addFontWeightStyle(object, byteBuffer, 0, fontFileResourceEntry.mWeight, fontFileResourceEntry.mItalic))
        return null; 
    } 
    return createFromFamiliesWithDefault(object);
  }
  
  public final Typeface createFromFontInfo(Context paramContext, CancellationSignal paramCancellationSignal, FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt) {
    Object object = newFamily();
    SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
    int j = paramArrayOfFontInfo.length;
    int i;
    for (i = 0; i < j; i++) {
      FontsContractCompat.FontInfo fontInfo = paramArrayOfFontInfo[i];
      Uri uri = fontInfo.mUri;
      ByteBuffer byteBuffer2 = (ByteBuffer)simpleArrayMap.get(uri);
      ByteBuffer byteBuffer1 = byteBuffer2;
      if (byteBuffer2 == null) {
        byteBuffer1 = TypefaceCompatUtil.mmap(paramContext, paramCancellationSignal, uri);
        simpleArrayMap.put(uri, byteBuffer1);
      } 
      if (!addFontWeightStyle(object, byteBuffer1, fontInfo.mTtcIndex, fontInfo.mWeight, fontInfo.mItalic))
        return null; 
    } 
    return Typeface.create(createFromFamiliesWithDefault(object), paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\graphics\TypefaceCompatApi24Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */