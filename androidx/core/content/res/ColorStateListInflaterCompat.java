package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.core.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ColorStateListInflaterCompat {
  private static int a(int paramInt, float paramFloat) {
    return paramInt & 0xFFFFFF | Math.round(Color.alpha(paramInt) * paramFloat) << 24;
  }
  
  private static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    int j = paramXmlPullParser.getDepth() + 1;
    int[][] arrayOfInt3 = new int[20][];
    int[] arrayOfInt4 = new int[arrayOfInt3.length];
    int i = 0;
    while (true) {
      int k = paramXmlPullParser.next();
      if (k != 1) {
        int m = paramXmlPullParser.getDepth();
        if (m >= j || k != 3) {
          if (k != 2 || m > j || !paramXmlPullParser.getName().equals("item"))
            continue; 
          TypedArray typedArray = a(paramResources, paramTheme, paramAttributeSet, R.styleable.ColorStateListItem);
          int n = typedArray.getColor(R.styleable.ColorStateListItem_android_color, -65281);
          float f = 1.0F;
          if (typedArray.hasValue(R.styleable.ColorStateListItem_android_alpha)) {
            f = typedArray.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0F);
          } else if (typedArray.hasValue(R.styleable.ColorStateListItem_alpha)) {
            f = typedArray.getFloat(R.styleable.ColorStateListItem_alpha, 1.0F);
          } 
          typedArray.recycle();
          int i1 = paramAttributeSet.getAttributeCount();
          int[] arrayOfInt = new int[i1];
          k = 0;
          for (m = 0; k < i1; m = i2) {
            int i3 = paramAttributeSet.getAttributeNameResource(k);
            int i2 = m;
            if (i3 != 16843173) {
              i2 = m;
              if (i3 != 16843551) {
                i2 = m;
                if (i3 != R.attr.alpha) {
                  if (paramAttributeSet.getAttributeBooleanValue(k, false)) {
                    i2 = i3;
                  } else {
                    i2 = -i3;
                  } 
                  arrayOfInt[m] = i2;
                  i2 = m + 1;
                } 
              } 
            } 
            k++;
          } 
          arrayOfInt = StateSet.trimStateSet(arrayOfInt, m);
          arrayOfInt4 = GrowingArrayUtils.append(arrayOfInt4, i, a(n, f));
          arrayOfInt3 = GrowingArrayUtils.<int[]>append(arrayOfInt3, i, arrayOfInt);
          i++;
          continue;
        } 
      } 
      break;
    } 
    int[] arrayOfInt1 = new int[i];
    int[][] arrayOfInt2 = new int[i][];
    System.arraycopy(arrayOfInt4, 0, arrayOfInt1, 0, i);
    System.arraycopy(arrayOfInt3, 0, arrayOfInt2, 0, i);
    return new ColorStateList(arrayOfInt2, arrayOfInt1);
  }
  
  private static TypedArray a(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfint) {
    return (paramTheme == null) ? paramResources.obtainAttributes(paramAttributeSet, paramArrayOfint) : paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfint, 0, 0);
  }
  
  public static ColorStateList createFromXml(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    int i;
    AttributeSet attributeSet = Xml.asAttributeSet(paramXmlPullParser);
    while (true) {
      i = paramXmlPullParser.next();
      if (i != 2 && i != 1)
        continue; 
      break;
    } 
    if (i == 2)
      return createFromXmlInner(paramResources, paramXmlPullParser, attributeSet, paramTheme); 
    throw new XmlPullParserException("No start tag found");
  }
  
  public static ColorStateList createFromXmlInner(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    String str = paramXmlPullParser.getName();
    if (str.equals("selector"))
      return a(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramXmlPullParser.getPositionDescription());
    stringBuilder.append(": invalid color state list tag ");
    stringBuilder.append(str);
    throw new XmlPullParserException(stringBuilder.toString());
  }
  
  public static ColorStateList inflate(Resources paramResources, int paramInt, Resources.Theme paramTheme) {
    try {
      return createFromXml(paramResources, (XmlPullParser)paramResources.getXml(paramInt), paramTheme);
    } catch (Exception exception) {
      Log.e("CSLCompat", "Failed to inflate ColorStateList.", exception);
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\content\res\ColorStateListInflaterCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */