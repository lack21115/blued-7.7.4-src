package android.support.v7.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class AppCompatColorStateListInflater {
  public static ColorStateList createFromXml(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme) {
    int i;
    AttributeSet attributeSet = Xml.asAttributeSet(paramXmlPullParser);
    do {
      i = paramXmlPullParser.next();
    } while (i != 2 && i != 1);
    if (i == 2) {
      String str = paramXmlPullParser.getName();
      if (str.equals("selector"))
        return inflate(paramResources, paramXmlPullParser, attributeSet, paramTheme); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramXmlPullParser.getPositionDescription());
      stringBuilder.append(": invalid color state list tag ");
      stringBuilder.append(str);
      throw new XmlPullParserException(stringBuilder.toString());
    } 
    throw new XmlPullParserException("No start tag found");
  }
  
  private static ColorStateList inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    int j = paramXmlPullParser.getDepth() + 1;
    int[][] arrayOfInt3 = new int[20][];
    int[] arrayOfInt4 = new int[20];
    int i = 0;
    while (true) {
      int k = paramXmlPullParser.next();
      if (k != 1) {
        int m = paramXmlPullParser.getDepth();
        if (m >= j || k != 3) {
          if (k == 2 && m <= j && paramXmlPullParser.getName().equals("item")) {
            TypedArray typedArray;
            int[] arrayOfInt6 = R.styleable.ColorStateListItem;
            if (paramTheme == null) {
              typedArray = paramResources.obtainAttributes(paramAttributeSet, arrayOfInt6);
            } else {
              typedArray = paramTheme.obtainStyledAttributes(paramAttributeSet, (int[])typedArray, 0, 0);
            } 
            int n = typedArray.getColor(R.styleable.ColorStateListItem_android_color, -65281);
            boolean bool = typedArray.hasValue(R.styleable.ColorStateListItem_android_alpha);
            float f = 1.0F;
            if (bool) {
              f = typedArray.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0F);
            } else if (typedArray.hasValue(R.styleable.ColorStateListItem_alpha)) {
              f = typedArray.getFloat(R.styleable.ColorStateListItem_alpha, 1.0F);
            } 
            typedArray.recycle();
            int i1 = paramAttributeSet.getAttributeCount();
            int[] arrayOfInt5 = new int[i1];
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
                    arrayOfInt5[m] = i2;
                    i2 = m + 1;
                  } 
                } 
              } 
              k++;
            } 
            arrayOfInt5 = StateSet.trimStateSet(arrayOfInt5, m);
            arrayOfInt4 = GrowingArrayUtils.append(arrayOfInt4, i, ColorUtils.setAlphaComponent(n, Math.round(Color.alpha(n) * f)));
            arrayOfInt3 = (int[][])GrowingArrayUtils.append((Object[])arrayOfInt3, i, arrayOfInt5);
            i++;
          } 
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\content\res\AppCompatColorStateListInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */