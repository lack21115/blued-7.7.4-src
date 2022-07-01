package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ComplexColorCompat {
  private final Shader a;
  
  private final ColorStateList b;
  
  private int c;
  
  private ComplexColorCompat(Shader paramShader, ColorStateList paramColorStateList, int paramInt) {
    this.a = paramShader;
    this.b = paramColorStateList;
    this.c = paramInt;
  }
  
  static ComplexColorCompat a(int paramInt) {
    return new ComplexColorCompat(null, null, paramInt);
  }
  
  static ComplexColorCompat a(ColorStateList paramColorStateList) {
    return new ComplexColorCompat(null, paramColorStateList, paramColorStateList.getDefaultColor());
  }
  
  private static ComplexColorCompat a(Resources paramResources, int paramInt, Resources.Theme paramTheme) throws IOException, XmlPullParserException {
    XmlResourceParser xmlResourceParser = paramResources.getXml(paramInt);
    AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
    while (true) {
      paramInt = xmlResourceParser.next();
      if (paramInt != 2 && paramInt != 1)
        continue; 
      break;
    } 
    if (paramInt == 2) {
      StringBuilder stringBuilder;
      String str = xmlResourceParser.getName();
      paramInt = -1;
      int i = str.hashCode();
      if (i != 89650992) {
        if (i == 1191572447 && str.equals("selector"))
          paramInt = 0; 
      } else if (str.equals("gradient")) {
        paramInt = 1;
      } 
      if (paramInt != 0) {
        if (paramInt == 1)
          return a(GradientColorInflaterCompat.a(paramResources, (XmlPullParser)xmlResourceParser, attributeSet, paramTheme)); 
        stringBuilder = new StringBuilder();
        stringBuilder.append(xmlResourceParser.getPositionDescription());
        stringBuilder.append(": unsupported complex color tag ");
        stringBuilder.append(str);
        throw new XmlPullParserException(stringBuilder.toString());
      } 
      return a(ColorStateListInflaterCompat.createFromXmlInner((Resources)stringBuilder, (XmlPullParser)xmlResourceParser, attributeSet, paramTheme));
    } 
    throw new XmlPullParserException("No start tag found");
  }
  
  static ComplexColorCompat a(Shader paramShader) {
    return new ComplexColorCompat(paramShader, null, 0);
  }
  
  public static ComplexColorCompat inflate(Resources paramResources, int paramInt, Resources.Theme paramTheme) {
    try {
      return a(paramResources, paramInt, paramTheme);
    } catch (Exception exception) {
      Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", exception);
      return null;
    } 
  }
  
  public int getColor() {
    return this.c;
  }
  
  public Shader getShader() {
    return this.a;
  }
  
  public boolean isGradient() {
    return (this.a != null);
  }
  
  public boolean isStateful() {
    if (this.a == null) {
      ColorStateList colorStateList = this.b;
      if (colorStateList != null && colorStateList.isStateful())
        return true; 
    } 
    return false;
  }
  
  public boolean onStateChanged(int[] paramArrayOfint) {
    if (isStateful()) {
      ColorStateList colorStateList = this.b;
      int i = colorStateList.getColorForState(paramArrayOfint, colorStateList.getDefaultColor());
      if (i != this.c) {
        this.c = i;
        return true;
      } 
    } 
    return false;
  }
  
  public void setColor(int paramInt) {
    this.c = paramInt;
  }
  
  public boolean willDraw() {
    return (isGradient() || this.c != 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\content\res\ComplexColorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */