package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class FontResourcesParserCompat {
  public static final int FETCH_STRATEGY_ASYNC = 1;
  
  public static final int FETCH_STRATEGY_BLOCKING = 0;
  
  public static final int INFINITE_TIMEOUT_VALUE = -1;
  
  private static int a(TypedArray paramTypedArray, int paramInt) {
    if (Build.VERSION.SDK_INT >= 21)
      return paramTypedArray.getType(paramInt); 
    TypedValue typedValue = new TypedValue();
    paramTypedArray.getValue(paramInt, typedValue);
    return typedValue.type;
  }
  
  private static FamilyResourceEntry a(XmlPullParser paramXmlPullParser, Resources paramResources) throws XmlPullParserException, IOException {
    paramXmlPullParser.require(2, null, "font-family");
    if (paramXmlPullParser.getName().equals("font-family"))
      return b(paramXmlPullParser, paramResources); 
    a(paramXmlPullParser);
    return null;
  }
  
  private static List<byte[]> a(String[] paramArrayOfString) {
    ArrayList<byte[]> arrayList = new ArrayList();
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++)
      arrayList.add(Base64.decode(paramArrayOfString[i], 0)); 
    return (List<byte[]>)arrayList;
  }
  
  private static void a(XmlPullParser paramXmlPullParser) throws XmlPullParserException, IOException {
    for (int i = 1; i; i++) {
      int j = paramXmlPullParser.next();
      if (j != 2) {
        if (j != 3)
          continue; 
        i--;
        continue;
      } 
    } 
  }
  
  private static FamilyResourceEntry b(XmlPullParser paramXmlPullParser, Resources paramResources) throws XmlPullParserException, IOException {
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
        a(paramXmlPullParser); 
      return new ProviderResourceEntry(new FontRequest(str1, str2, str3, readCerts(paramResources, i)), j, k);
    } 
    ArrayList<FontFileResourceEntry> arrayList = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() != 2)
        continue; 
      if (paramXmlPullParser.getName().equals("font")) {
        arrayList.add(c(paramXmlPullParser, paramResources));
        continue;
      } 
      a(paramXmlPullParser);
    } 
    return arrayList.isEmpty() ? null : new FontFamilyFilesResourceEntry(arrayList.<FontFileResourceEntry>toArray(new FontFileResourceEntry[arrayList.size()]));
  }
  
  private static FontFileResourceEntry c(XmlPullParser paramXmlPullParser, Resources paramResources) throws XmlPullParserException, IOException {
    int i;
    boolean bool;
    TypedArray typedArray = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamilyFont);
    if (typedArray.hasValue(R.styleable.FontFamilyFont_fontWeight)) {
      i = R.styleable.FontFamilyFont_fontWeight;
    } else {
      i = R.styleable.FontFamilyFont_android_fontWeight;
    } 
    int k = typedArray.getInt(i, 400);
    if (typedArray.hasValue(R.styleable.FontFamilyFont_fontStyle)) {
      i = R.styleable.FontFamilyFont_fontStyle;
    } else {
      i = R.styleable.FontFamilyFont_android_fontStyle;
    } 
    if (1 == typedArray.getInt(i, 0)) {
      bool = true;
    } else {
      bool = false;
    } 
    if (typedArray.hasValue(R.styleable.FontFamilyFont_ttcIndex)) {
      i = R.styleable.FontFamilyFont_ttcIndex;
    } else {
      i = R.styleable.FontFamilyFont_android_ttcIndex;
    } 
    if (typedArray.hasValue(R.styleable.FontFamilyFont_fontVariationSettings)) {
      j = R.styleable.FontFamilyFont_fontVariationSettings;
    } else {
      j = R.styleable.FontFamilyFont_android_fontVariationSettings;
    } 
    String str1 = typedArray.getString(j);
    int j = typedArray.getInt(i, 0);
    if (typedArray.hasValue(R.styleable.FontFamilyFont_font)) {
      i = R.styleable.FontFamilyFont_font;
    } else {
      i = R.styleable.FontFamilyFont_android_font;
    } 
    int m = typedArray.getResourceId(i, 0);
    String str2 = typedArray.getString(i);
    typedArray.recycle();
    while (paramXmlPullParser.next() != 3)
      a(paramXmlPullParser); 
    return new FontFileResourceEntry(str2, k, bool, str1, j, m);
  }
  
  public static FamilyResourceEntry parse(XmlPullParser paramXmlPullParser, Resources paramResources) throws XmlPullParserException, IOException {
    int i;
    while (true) {
      i = paramXmlPullParser.next();
      if (i != 2 && i != 1)
        continue; 
      break;
    } 
    if (i == 2)
      return a(paramXmlPullParser, paramResources); 
    throw new XmlPullParserException("No start tag found");
  }
  
  public static List<List<byte[]>> readCerts(Resources paramResources, int paramInt) {
    if (paramInt == 0)
      return Collections.emptyList(); 
    TypedArray typedArray = paramResources.obtainTypedArray(paramInt);
    try {
      List<?> list;
      if (typedArray.length() == 0) {
        list = Collections.emptyList();
        return (List)list;
      } 
      ArrayList<List<byte[]>> arrayList = new ArrayList();
      if (a(typedArray, 0) == 1)
        for (paramInt = 0;; paramInt++) {
          if (paramInt < typedArray.length()) {
            int i = typedArray.getResourceId(paramInt, 0);
            if (i != 0)
              arrayList.add(a(list.getStringArray(i))); 
          } else {
            return arrayList;
          } 
        }  
      arrayList.add(a(list.getStringArray(paramInt)));
      return arrayList;
    } finally {
      typedArray.recycle();
    } 
  }
  
  public static interface FamilyResourceEntry {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FetchStrategy {}
  
  public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
    private final FontResourcesParserCompat.FontFileResourceEntry[] a;
    
    public FontFamilyFilesResourceEntry(FontResourcesParserCompat.FontFileResourceEntry[] param1ArrayOfFontFileResourceEntry) {
      this.a = param1ArrayOfFontFileResourceEntry;
    }
    
    public FontResourcesParserCompat.FontFileResourceEntry[] getEntries() {
      return this.a;
    }
  }
  
  public static final class FontFileResourceEntry {
    private final String a;
    
    private int b;
    
    private boolean c;
    
    private String d;
    
    private int e;
    
    private int f;
    
    public FontFileResourceEntry(String param1String1, int param1Int1, boolean param1Boolean, String param1String2, int param1Int2, int param1Int3) {
      this.a = param1String1;
      this.b = param1Int1;
      this.c = param1Boolean;
      this.d = param1String2;
      this.e = param1Int2;
      this.f = param1Int3;
    }
    
    public String getFileName() {
      return this.a;
    }
    
    public int getResourceId() {
      return this.f;
    }
    
    public int getTtcIndex() {
      return this.e;
    }
    
    public String getVariationSettings() {
      return this.d;
    }
    
    public int getWeight() {
      return this.b;
    }
    
    public boolean isItalic() {
      return this.c;
    }
  }
  
  public static final class ProviderResourceEntry implements FamilyResourceEntry {
    private final FontRequest a;
    
    private final int b;
    
    private final int c;
    
    public ProviderResourceEntry(FontRequest param1FontRequest, int param1Int1, int param1Int2) {
      this.a = param1FontRequest;
      this.c = param1Int1;
      this.b = param1Int2;
    }
    
    public int getFetchStrategy() {
      return this.c;
    }
    
    public FontRequest getRequest() {
      return this.a;
    }
    
    public int getTimeout() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\content\res\FontResourcesParserCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */