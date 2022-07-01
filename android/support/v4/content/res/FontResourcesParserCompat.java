package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.compat.R;
import android.support.v4.provider.FontRequest;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class FontResourcesParserCompat {
  public static FontResourcesParserCompat$FamilyResourceEntry parse(XmlPullParser paramXmlPullParser, Resources paramResources) {
    int i;
    do {
      i = paramXmlPullParser.next();
    } while (i != 2 && i != 1);
    if (i == 2) {
      paramXmlPullParser.require(2, null, "font-family");
      if (paramXmlPullParser.getName().equals("font-family"))
        return readFamily(paramXmlPullParser, paramResources); 
      skip(paramXmlPullParser);
      return null;
    } 
    throw new XmlPullParserException("No start tag found");
  }
  
  public static List readCerts(Resources paramResources, int paramInt) {
    ArrayList<List> arrayList1 = null;
    ArrayList<List> arrayList2 = null;
    if (paramInt != 0) {
      TypedArray typedArray = paramResources.obtainTypedArray(paramInt);
      arrayList1 = arrayList2;
      if (typedArray.length() > 0) {
        boolean bool;
        arrayList2 = new ArrayList();
        if (typedArray.getResourceId(0, 0) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        if (bool) {
          paramInt = 0;
          while (true) {
            arrayList1 = arrayList2;
            if (paramInt < typedArray.length()) {
              arrayList2.add(toByteArrayList(paramResources.getStringArray(typedArray.getResourceId(paramInt, 0))));
              paramInt++;
              continue;
            } 
            break;
          } 
        } else {
          arrayList2.add(toByteArrayList(paramResources.getStringArray(paramInt)));
          arrayList1 = arrayList2;
        } 
      } 
      typedArray.recycle();
    } 
    return (arrayList1 != null) ? arrayList1 : Collections.emptyList();
  }
  
  private static FontResourcesParserCompat$FamilyResourceEntry readFamily(XmlPullParser paramXmlPullParser, Resources paramResources) {
    TypedArray typedArray = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamily);
    String str1 = typedArray.getString(R.styleable.FontFamily_fontProviderAuthority);
    String str2 = typedArray.getString(R.styleable.FontFamily_fontProviderPackage);
    String str3 = typedArray.getString(R.styleable.FontFamily_fontProviderQuery);
    int i = typedArray.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
    int j = typedArray.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
    int k = typedArray.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
    typedArray.recycle();
    if (str1 != null && str2 != null && str3 != null) {
      while (paramXmlPullParser.next() != 3)
        skip(paramXmlPullParser); 
      return new FontResourcesParserCompat$ProviderResourceEntry(new FontRequest(str1, str2, str3, readCerts(paramResources, i)), j, k);
    } 
    ArrayList<FontResourcesParserCompat$FontFileResourceEntry> arrayList = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("font")) {
          arrayList.add(readFont(paramXmlPullParser, paramResources));
          continue;
        } 
        skip(paramXmlPullParser);
      } 
    } 
    return arrayList.isEmpty() ? null : new FontResourcesParserCompat$FontFamilyFilesResourceEntry(arrayList.<FontResourcesParserCompat$FontFileResourceEntry>toArray(new FontResourcesParserCompat$FontFileResourceEntry[arrayList.size()]));
  }
  
  private static FontResourcesParserCompat$FontFileResourceEntry readFont(XmlPullParser paramXmlPullParser, Resources paramResources) {
    TypedArray typedArray = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamilyFont);
    if (typedArray.hasValue(R.styleable.FontFamilyFont_fontWeight)) {
      i = R.styleable.FontFamilyFont_fontWeight;
    } else {
      i = R.styleable.FontFamilyFont_android_fontWeight;
    } 
    int j = typedArray.getInt(i, 400);
    if (typedArray.hasValue(R.styleable.FontFamilyFont_fontStyle)) {
      i = R.styleable.FontFamilyFont_fontStyle;
    } else {
      i = R.styleable.FontFamilyFont_android_fontStyle;
    } 
    int i = typedArray.getInt(i, 0);
    boolean bool = true;
    if (1 != i)
      bool = false; 
    if (typedArray.hasValue(R.styleable.FontFamilyFont_font)) {
      i = R.styleable.FontFamilyFont_font;
    } else {
      i = R.styleable.FontFamilyFont_android_font;
    } 
    int k = typedArray.getResourceId(i, 0);
    String str = typedArray.getString(i);
    typedArray.recycle();
    while (paramXmlPullParser.next() != 3)
      skip(paramXmlPullParser); 
    return new FontResourcesParserCompat$FontFileResourceEntry(str, j, bool, k);
  }
  
  private static void skip(XmlPullParser paramXmlPullParser) {
    for (int i = 1; i; i++) {
      switch (paramXmlPullParser.next()) {
        default:
          continue;
        case 3:
          i--;
          continue;
        case 2:
          break;
      } 
    } 
  }
  
  private static List toByteArrayList(String[] paramArrayOfString) {
    ArrayList<byte[]> arrayList = new ArrayList();
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++)
      arrayList.add(Base64.decode(paramArrayOfString[i], 0)); 
    return arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\content\res\FontResourcesParserCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */