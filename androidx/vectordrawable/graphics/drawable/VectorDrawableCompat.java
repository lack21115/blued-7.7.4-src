package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends VectorDrawableCommon {
  static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
  
  private VectorDrawableCompatState b = new VectorDrawableCompatState();
  
  private PorterDuffColorFilter c;
  
  private ColorFilter e;
  
  private boolean f;
  
  private boolean g = true;
  
  private Drawable.ConstantState h;
  
  private final float[] i = new float[9];
  
  private final Matrix j = new Matrix();
  
  private final Rect k = new Rect();
  
  VectorDrawableCompat() {}
  
  VectorDrawableCompat(VectorDrawableCompatState paramVectorDrawableCompatState) {
    this.c = a(this.c, paramVectorDrawableCompatState.c, paramVectorDrawableCompatState.d);
  }
  
  static int a(int paramInt, float paramFloat) {
    return paramInt & 0xFFFFFF | (int)(Color.alpha(paramInt) * paramFloat) << 24;
  }
  
  private static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode) {
    if (paramInt != 3) {
      if (paramInt != 5) {
        if (paramInt != 9) {
          switch (paramInt) {
            default:
              return paramMode;
            case 16:
              return PorterDuff.Mode.ADD;
            case 15:
              return PorterDuff.Mode.SCREEN;
            case 14:
              break;
          } 
          return PorterDuff.Mode.MULTIPLY;
        } 
        return PorterDuff.Mode.SRC_ATOP;
      } 
      return PorterDuff.Mode.SRC_IN;
    } 
    return PorterDuff.Mode.SRC_OVER;
  }
  
  private void a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    VectorDrawableCompatState vectorDrawableCompatState = this.b;
    VPathRenderer vPathRenderer = vectorDrawableCompatState.b;
    ArrayDeque<VGroup> arrayDeque = new ArrayDeque();
    arrayDeque.push(vPathRenderer.c);
    int j = paramXmlPullParser.getEventType();
    int k = paramXmlPullParser.getDepth();
    int i;
    for (i = 1; j != 1 && (paramXmlPullParser.getDepth() >= k + 1 || j != 3); i = m) {
      int m;
      if (j == 2) {
        VFullPath vFullPath;
        String str = paramXmlPullParser.getName();
        VGroup vGroup = arrayDeque.peek();
        if ("path".equals(str)) {
          vFullPath = new VFullPath();
          vFullPath.inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          vGroup.b.add(vFullPath);
          if (vFullPath.getPathName() != null)
            vPathRenderer.k.put(vFullPath.getPathName(), vFullPath); 
          m = 0;
          i = vectorDrawableCompatState.a;
          vectorDrawableCompatState.a = vFullPath.o | i;
        } else {
          VClipPath vClipPath;
          if ("clip-path".equals(vFullPath)) {
            vClipPath = new VClipPath();
            vClipPath.inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
            vGroup.b.add(vClipPath);
            if (vClipPath.getPathName() != null)
              vPathRenderer.k.put(vClipPath.getPathName(), vClipPath); 
            m = vectorDrawableCompatState.a;
            vectorDrawableCompatState.a = vClipPath.o | m;
            m = i;
          } else {
            m = i;
            if ("group".equals(vClipPath)) {
              VGroup vGroup1 = new VGroup();
              vGroup1.inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
              vGroup.b.add(vGroup1);
              arrayDeque.push(vGroup1);
              if (vGroup1.getGroupName() != null)
                vPathRenderer.k.put(vGroup1.getGroupName(), vGroup1); 
              m = vectorDrawableCompatState.a;
              vectorDrawableCompatState.a = vGroup1.e | m;
              m = i;
            } 
          } 
        } 
      } else {
        m = i;
        if (j == 3) {
          m = i;
          if ("group".equals(paramXmlPullParser.getName())) {
            arrayDeque.pop();
            m = i;
          } 
        } 
      } 
      j = paramXmlPullParser.next();
    } 
    if (i == 0)
      return; 
    throw new XmlPullParserException("no path defined");
  }
  
  private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme) throws XmlPullParserException {
    String str;
    VectorDrawableCompatState vectorDrawableCompatState = this.b;
    VPathRenderer vPathRenderer = vectorDrawableCompatState.b;
    vectorDrawableCompatState.d = a(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
    ColorStateList colorStateList = TypedArrayUtils.getNamedColorStateList(paramTypedArray, paramXmlPullParser, paramTheme, "tint", 1);
    if (colorStateList != null)
      vectorDrawableCompatState.c = colorStateList; 
    vectorDrawableCompatState.e = TypedArrayUtils.getNamedBoolean(paramTypedArray, paramXmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.e);
    vPathRenderer.f = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportWidth", 7, vPathRenderer.f);
    vPathRenderer.g = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportHeight", 8, vPathRenderer.g);
    if (vPathRenderer.f > 0.0F) {
      if (vPathRenderer.g > 0.0F) {
        vPathRenderer.d = paramTypedArray.getDimension(3, vPathRenderer.d);
        vPathRenderer.e = paramTypedArray.getDimension(2, vPathRenderer.e);
        if (vPathRenderer.d > 0.0F) {
          if (vPathRenderer.e > 0.0F) {
            vPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
            str = paramTypedArray.getString(0);
            if (str != null) {
              vPathRenderer.i = str;
              vPathRenderer.k.put(str, vPathRenderer);
            } 
            return;
          } 
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append(str.getPositionDescription());
          stringBuilder3.append("<vector> tag requires height > 0");
          throw new XmlPullParserException(stringBuilder3.toString());
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str.getPositionDescription());
        stringBuilder2.append("<vector> tag requires width > 0");
        throw new XmlPullParserException(stringBuilder2.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str.getPositionDescription());
      stringBuilder1.append("<vector> tag requires viewportHeight > 0");
      throw new XmlPullParserException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str.getPositionDescription());
    stringBuilder.append("<vector> tag requires viewportWidth > 0");
    throw new XmlPullParserException(stringBuilder.toString());
  }
  
  private boolean a() {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= 17) {
      bool1 = bool2;
      if (isAutoMirrored()) {
        bool1 = bool2;
        if (DrawableCompat.getLayoutDirection(this) == 1)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public static VectorDrawableCompat create(Resources paramResources, int paramInt, Resources.Theme paramTheme) {
    if (Build.VERSION.SDK_INT >= 24) {
      VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
      vectorDrawableCompat.d = ResourcesCompat.getDrawable(paramResources, paramInt, paramTheme);
      vectorDrawableCompat.h = new VectorDrawableDelegateState(vectorDrawableCompat.d.getConstantState());
      return vectorDrawableCompat;
    } 
    try {
      XmlResourceParser xmlResourceParser = paramResources.getXml(paramInt);
      AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
      while (true) {
        paramInt = xmlResourceParser.next();
        if (paramInt != 2 && paramInt != 1)
          continue; 
        break;
      } 
      if (paramInt == 2)
        return createFromXmlInner(paramResources, (XmlPullParser)xmlResourceParser, attributeSet, paramTheme); 
      throw new XmlPullParserException("No start tag found");
    } catch (XmlPullParserException xmlPullParserException) {
      Log.e("VectorDrawableCompat", "parser error", (Throwable)xmlPullParserException);
    } catch (IOException iOException) {
      Log.e("VectorDrawableCompat", "parser error", iOException);
    } 
    return null;
  }
  
  public static VectorDrawableCompat createFromXmlInner(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
    vectorDrawableCompat.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return vectorDrawableCompat;
  }
  
  PorterDuffColorFilter a(PorterDuffColorFilter paramPorterDuffColorFilter, ColorStateList paramColorStateList, PorterDuff.Mode paramMode) {
    return (paramColorStateList == null || paramMode == null) ? null : new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  Object a(String paramString) {
    return this.b.b.k.get(paramString);
  }
  
  void a(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public boolean canApplyTheme() {
    if (this.d != null)
      DrawableCompat.canApplyTheme(this.d); 
    return false;
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.d != null) {
      this.d.draw(paramCanvas);
      return;
    } 
    copyBounds(this.k);
    if (this.k.width() > 0) {
      PorterDuffColorFilter porterDuffColorFilter;
      if (this.k.height() <= 0)
        return; 
      ColorFilter colorFilter2 = this.e;
      ColorFilter colorFilter1 = colorFilter2;
      if (colorFilter2 == null)
        porterDuffColorFilter = this.c; 
      paramCanvas.getMatrix(this.j);
      this.j.getValues(this.i);
      float f1 = Math.abs(this.i[0]);
      float f2 = Math.abs(this.i[4]);
      float f4 = Math.abs(this.i[1]);
      float f3 = Math.abs(this.i[3]);
      if (f4 != 0.0F || f3 != 0.0F) {
        f1 = 1.0F;
        f2 = 1.0F;
      } 
      int i = (int)(this.k.width() * f1);
      int j = (int)(this.k.height() * f2);
      i = Math.min(2048, i);
      j = Math.min(2048, j);
      if (i > 0) {
        if (j <= 0)
          return; 
        int k = paramCanvas.save();
        paramCanvas.translate(this.k.left, this.k.top);
        if (a()) {
          paramCanvas.translate(this.k.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        } 
        this.k.offsetTo(0, 0);
        this.b.createCachedBitmapIfNeeded(i, j);
        if (!this.g) {
          this.b.updateCachedBitmap(i, j);
        } else if (!this.b.canReuseCache()) {
          this.b.updateCachedBitmap(i, j);
          this.b.updateCacheStates();
        } 
        this.b.drawCachedBitmapWithRootAlpha(paramCanvas, (ColorFilter)porterDuffColorFilter, this.k);
        paramCanvas.restoreToCount(k);
      } 
    } 
  }
  
  public int getAlpha() {
    return (this.d != null) ? DrawableCompat.getAlpha(this.d) : this.b.b.getRootAlpha();
  }
  
  public int getChangingConfigurations() {
    return (this.d != null) ? this.d.getChangingConfigurations() : (super.getChangingConfigurations() | this.b.getChangingConfigurations());
  }
  
  public ColorFilter getColorFilter() {
    return (this.d != null) ? DrawableCompat.getColorFilter(this.d) : this.e;
  }
  
  public Drawable.ConstantState getConstantState() {
    if (this.d != null && Build.VERSION.SDK_INT >= 24)
      return new VectorDrawableDelegateState(this.d.getConstantState()); 
    this.b.a = getChangingConfigurations();
    return this.b;
  }
  
  public int getIntrinsicHeight() {
    return (this.d != null) ? this.d.getIntrinsicHeight() : (int)this.b.b.e;
  }
  
  public int getIntrinsicWidth() {
    return (this.d != null) ? this.d.getIntrinsicWidth() : (int)this.b.b.d;
  }
  
  public int getOpacity() {
    return (this.d != null) ? this.d.getOpacity() : -3;
  }
  
  public float getPixelSize() {
    VectorDrawableCompatState vectorDrawableCompatState = this.b;
    if (vectorDrawableCompatState == null || vectorDrawableCompatState.b == null || this.b.b.d == 0.0F || this.b.b.e == 0.0F || this.b.b.g == 0.0F || this.b.b.f == 0.0F)
      return 1.0F; 
    float f1 = this.b.b.d;
    float f2 = this.b.b.e;
    float f3 = this.b.b.f;
    float f4 = this.b.b.g;
    return Math.min(f3 / f1, f4 / f2);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet) throws XmlPullParserException, IOException {
    if (this.d != null) {
      this.d.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    } 
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, (Resources.Theme)null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) throws XmlPullParserException, IOException {
    if (this.d != null) {
      DrawableCompat.inflate(this.d, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    } 
    VectorDrawableCompatState vectorDrawableCompatState = this.b;
    vectorDrawableCompatState.b = new VPathRenderer();
    TypedArray typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.a);
    a(typedArray, paramXmlPullParser, paramTheme);
    typedArray.recycle();
    vectorDrawableCompatState.a = getChangingConfigurations();
    vectorDrawableCompatState.k = true;
    a(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.c = a(this.c, vectorDrawableCompatState.c, vectorDrawableCompatState.d);
  }
  
  public void invalidateSelf() {
    if (this.d != null) {
      this.d.invalidateSelf();
      return;
    } 
    super.invalidateSelf();
  }
  
  public boolean isAutoMirrored() {
    return (this.d != null) ? DrawableCompat.isAutoMirrored(this.d) : this.b.e;
  }
  
  public boolean isStateful() {
    if (this.d != null)
      return this.d.isStateful(); 
    if (!super.isStateful()) {
      VectorDrawableCompatState vectorDrawableCompatState = this.b;
      if (vectorDrawableCompatState == null || (!vectorDrawableCompatState.isStateful() && (this.b.c == null || !this.b.c.isStateful())))
        return false; 
    } 
    return true;
  }
  
  public Drawable mutate() {
    if (this.d != null) {
      this.d.mutate();
      return this;
    } 
    if (!this.f && super.mutate() == this) {
      this.b = new VectorDrawableCompatState(this.b);
      this.f = true;
    } 
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    if (this.d != null)
      this.d.setBounds(paramRect); 
  }
  
  protected boolean onStateChange(int[] paramArrayOfint) {
    if (this.d != null)
      return this.d.setState(paramArrayOfint); 
    boolean bool2 = false;
    VectorDrawableCompatState vectorDrawableCompatState = this.b;
    boolean bool1 = bool2;
    if (vectorDrawableCompatState.c != null) {
      bool1 = bool2;
      if (vectorDrawableCompatState.d != null) {
        this.c = a(this.c, vectorDrawableCompatState.c, vectorDrawableCompatState.d);
        invalidateSelf();
        bool1 = true;
      } 
    } 
    bool2 = bool1;
    if (vectorDrawableCompatState.isStateful()) {
      bool2 = bool1;
      if (vectorDrawableCompatState.onStateChanged(paramArrayOfint)) {
        invalidateSelf();
        bool2 = true;
      } 
    } 
    return bool2;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong) {
    if (this.d != null) {
      this.d.scheduleSelf(paramRunnable, paramLong);
      return;
    } 
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt) {
    if (this.d != null) {
      this.d.setAlpha(paramInt);
      return;
    } 
    if (this.b.b.getRootAlpha() != paramInt) {
      this.b.b.setRootAlpha(paramInt);
      invalidateSelf();
    } 
  }
  
  public void setAutoMirrored(boolean paramBoolean) {
    if (this.d != null) {
      DrawableCompat.setAutoMirrored(this.d, paramBoolean);
      return;
    } 
    this.b.e = paramBoolean;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    if (this.d != null) {
      this.d.setColorFilter(paramColorFilter);
      return;
    } 
    this.e = paramColorFilter;
    invalidateSelf();
  }
  
  public void setTint(int paramInt) {
    if (this.d != null) {
      DrawableCompat.setTint(this.d, paramInt);
      return;
    } 
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    if (this.d != null) {
      DrawableCompat.setTintList(this.d, paramColorStateList);
      return;
    } 
    VectorDrawableCompatState vectorDrawableCompatState = this.b;
    if (vectorDrawableCompatState.c != paramColorStateList) {
      vectorDrawableCompatState.c = paramColorStateList;
      this.c = a(this.c, paramColorStateList, vectorDrawableCompatState.d);
      invalidateSelf();
    } 
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    if (this.d != null) {
      DrawableCompat.setTintMode(this.d, paramMode);
      return;
    } 
    VectorDrawableCompatState vectorDrawableCompatState = this.b;
    if (vectorDrawableCompatState.d != paramMode) {
      vectorDrawableCompatState.d = paramMode;
      this.c = a(this.c, vectorDrawableCompatState.c, paramMode);
      invalidateSelf();
    } 
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    return (this.d != null) ? this.d.setVisible(paramBoolean1, paramBoolean2) : super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(Runnable paramRunnable) {
    if (this.d != null) {
      this.d.unscheduleSelf(paramRunnable);
      return;
    } 
    super.unscheduleSelf(paramRunnable);
  }
  
  static class VClipPath extends VPath {
    VClipPath() {}
    
    VClipPath(VClipPath param1VClipPath) {
      super(param1VClipPath);
    }
    
    private void a(TypedArray param1TypedArray, XmlPullParser param1XmlPullParser) {
      String str = param1TypedArray.getString(0);
      if (str != null)
        this.m = str; 
      str = param1TypedArray.getString(1);
      if (str != null)
        this.l = PathParser.createNodesFromPathData(str); 
      this.n = TypedArrayUtils.getNamedInt(param1TypedArray, param1XmlPullParser, "fillType", 2, 0);
    }
    
    public void inflate(Resources param1Resources, AttributeSet param1AttributeSet, Resources.Theme param1Theme, XmlPullParser param1XmlPullParser) {
      if (!TypedArrayUtils.hasAttribute(param1XmlPullParser, "pathData"))
        return; 
      TypedArray typedArray = TypedArrayUtils.obtainAttributes(param1Resources, param1Theme, param1AttributeSet, AndroidResources.d);
      a(typedArray, param1XmlPullParser);
      typedArray.recycle();
    }
    
    public boolean isClipPath() {
      return true;
    }
  }
  
  static class VFullPath extends VPath {
    ComplexColorCompat a;
    
    float b = 0.0F;
    
    ComplexColorCompat c;
    
    float d = 1.0F;
    
    float e = 1.0F;
    
    float f = 0.0F;
    
    float g = 1.0F;
    
    float h = 0.0F;
    
    Paint.Cap i = Paint.Cap.BUTT;
    
    Paint.Join j = Paint.Join.MITER;
    
    float k = 4.0F;
    
    private int[] p;
    
    VFullPath() {}
    
    VFullPath(VFullPath param1VFullPath) {
      super(param1VFullPath);
      this.p = param1VFullPath.p;
      this.a = param1VFullPath.a;
      this.b = param1VFullPath.b;
      this.d = param1VFullPath.d;
      this.c = param1VFullPath.c;
      this.n = param1VFullPath.n;
      this.e = param1VFullPath.e;
      this.f = param1VFullPath.f;
      this.g = param1VFullPath.g;
      this.h = param1VFullPath.h;
      this.i = param1VFullPath.i;
      this.j = param1VFullPath.j;
      this.k = param1VFullPath.k;
    }
    
    private Paint.Cap a(int param1Int, Paint.Cap param1Cap) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? param1Cap : Paint.Cap.SQUARE) : Paint.Cap.ROUND) : Paint.Cap.BUTT;
    }
    
    private Paint.Join a(int param1Int, Paint.Join param1Join) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? param1Join : Paint.Join.BEVEL) : Paint.Join.ROUND) : Paint.Join.MITER;
    }
    
    private void a(TypedArray param1TypedArray, XmlPullParser param1XmlPullParser, Resources.Theme param1Theme) {
      this.p = null;
      if (!TypedArrayUtils.hasAttribute(param1XmlPullParser, "pathData"))
        return; 
      String str = param1TypedArray.getString(0);
      if (str != null)
        this.m = str; 
      str = param1TypedArray.getString(2);
      if (str != null)
        this.l = PathParser.createNodesFromPathData(str); 
      this.c = TypedArrayUtils.getNamedComplexColor(param1TypedArray, param1XmlPullParser, param1Theme, "fillColor", 1, 0);
      this.e = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "fillAlpha", 12, this.e);
      this.i = a(TypedArrayUtils.getNamedInt(param1TypedArray, param1XmlPullParser, "strokeLineCap", 8, -1), this.i);
      this.j = a(TypedArrayUtils.getNamedInt(param1TypedArray, param1XmlPullParser, "strokeLineJoin", 9, -1), this.j);
      this.k = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "strokeMiterLimit", 10, this.k);
      this.a = TypedArrayUtils.getNamedComplexColor(param1TypedArray, param1XmlPullParser, param1Theme, "strokeColor", 3, 0);
      this.d = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "strokeAlpha", 11, this.d);
      this.b = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "strokeWidth", 4, this.b);
      this.g = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "trimPathEnd", 6, this.g);
      this.h = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "trimPathOffset", 7, this.h);
      this.f = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "trimPathStart", 5, this.f);
      this.n = TypedArrayUtils.getNamedInt(param1TypedArray, param1XmlPullParser, "fillType", 13, this.n);
    }
    
    public void applyTheme(Resources.Theme param1Theme) {
      if (this.p == null);
    }
    
    public boolean canApplyTheme() {
      return (this.p != null);
    }
    
    float getFillAlpha() {
      return this.e;
    }
    
    int getFillColor() {
      return this.c.getColor();
    }
    
    float getStrokeAlpha() {
      return this.d;
    }
    
    int getStrokeColor() {
      return this.a.getColor();
    }
    
    float getStrokeWidth() {
      return this.b;
    }
    
    float getTrimPathEnd() {
      return this.g;
    }
    
    float getTrimPathOffset() {
      return this.h;
    }
    
    float getTrimPathStart() {
      return this.f;
    }
    
    public void inflate(Resources param1Resources, AttributeSet param1AttributeSet, Resources.Theme param1Theme, XmlPullParser param1XmlPullParser) {
      TypedArray typedArray = TypedArrayUtils.obtainAttributes(param1Resources, param1Theme, param1AttributeSet, AndroidResources.c);
      a(typedArray, param1XmlPullParser, param1Theme);
      typedArray.recycle();
    }
    
    public boolean isStateful() {
      return (this.c.isStateful() || this.a.isStateful());
    }
    
    public boolean onStateChanged(int[] param1ArrayOfint) {
      boolean bool = this.c.onStateChanged(param1ArrayOfint);
      return this.a.onStateChanged(param1ArrayOfint) | bool;
    }
    
    void setFillAlpha(float param1Float) {
      this.e = param1Float;
    }
    
    void setFillColor(int param1Int) {
      this.c.setColor(param1Int);
    }
    
    void setStrokeAlpha(float param1Float) {
      this.d = param1Float;
    }
    
    void setStrokeColor(int param1Int) {
      this.a.setColor(param1Int);
    }
    
    void setStrokeWidth(float param1Float) {
      this.b = param1Float;
    }
    
    void setTrimPathEnd(float param1Float) {
      this.g = param1Float;
    }
    
    void setTrimPathOffset(float param1Float) {
      this.h = param1Float;
    }
    
    void setTrimPathStart(float param1Float) {
      this.f = param1Float;
    }
  }
  
  static class VGroup extends VObject {
    final Matrix a = new Matrix();
    
    final ArrayList<VectorDrawableCompat.VObject> b = new ArrayList<VectorDrawableCompat.VObject>();
    
    float c = 0.0F;
    
    final Matrix d = new Matrix();
    
    int e;
    
    private float f = 0.0F;
    
    private float g = 0.0F;
    
    private float h = 1.0F;
    
    private float i = 1.0F;
    
    private float j = 0.0F;
    
    private float k = 0.0F;
    
    private int[] l;
    
    private String m = null;
    
    public VGroup() {}
    
    public VGroup(VGroup param1VGroup, ArrayMap<String, Object> param1ArrayMap) {
      this.c = param1VGroup.c;
      this.f = param1VGroup.f;
      this.g = param1VGroup.g;
      this.h = param1VGroup.h;
      this.i = param1VGroup.i;
      this.j = param1VGroup.j;
      this.k = param1VGroup.k;
      this.l = param1VGroup.l;
      this.m = param1VGroup.m;
      this.e = param1VGroup.e;
      String str = this.m;
      if (str != null)
        param1ArrayMap.put(str, this); 
      this.d.set(param1VGroup.d);
      ArrayList<VectorDrawableCompat.VObject> arrayList = param1VGroup.b;
      for (int i = 0; i < arrayList.size(); i++) {
        param1VGroup = (VGroup)arrayList.get(i);
        if (param1VGroup instanceof VGroup) {
          param1VGroup = param1VGroup;
          this.b.add(new VGroup(param1VGroup, param1ArrayMap));
        } else {
          VectorDrawableCompat.VFullPath vFullPath;
          VectorDrawableCompat.VClipPath vClipPath;
          if (param1VGroup instanceof VectorDrawableCompat.VFullPath) {
            vFullPath = new VectorDrawableCompat.VFullPath((VectorDrawableCompat.VFullPath)param1VGroup);
          } else if (vFullPath instanceof VectorDrawableCompat.VClipPath) {
            vClipPath = new VectorDrawableCompat.VClipPath((VectorDrawableCompat.VClipPath)vFullPath);
          } else {
            throw new IllegalStateException("Unknown object in the tree!");
          } 
          this.b.add(vClipPath);
          if (vClipPath.m != null)
            param1ArrayMap.put(vClipPath.m, vClipPath); 
        } 
      } 
    }
    
    private void a() {
      this.d.reset();
      this.d.postTranslate(-this.f, -this.g);
      this.d.postScale(this.h, this.i);
      this.d.postRotate(this.c, 0.0F, 0.0F);
      this.d.postTranslate(this.j + this.f, this.k + this.g);
    }
    
    private void a(TypedArray param1TypedArray, XmlPullParser param1XmlPullParser) {
      this.l = null;
      this.c = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "rotation", 5, this.c);
      this.f = param1TypedArray.getFloat(1, this.f);
      this.g = param1TypedArray.getFloat(2, this.g);
      this.h = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "scaleX", 3, this.h);
      this.i = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "scaleY", 4, this.i);
      this.j = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "translateX", 6, this.j);
      this.k = TypedArrayUtils.getNamedFloat(param1TypedArray, param1XmlPullParser, "translateY", 7, this.k);
      String str = param1TypedArray.getString(0);
      if (str != null)
        this.m = str; 
      a();
    }
    
    public String getGroupName() {
      return this.m;
    }
    
    public Matrix getLocalMatrix() {
      return this.d;
    }
    
    public float getPivotX() {
      return this.f;
    }
    
    public float getPivotY() {
      return this.g;
    }
    
    public float getRotation() {
      return this.c;
    }
    
    public float getScaleX() {
      return this.h;
    }
    
    public float getScaleY() {
      return this.i;
    }
    
    public float getTranslateX() {
      return this.j;
    }
    
    public float getTranslateY() {
      return this.k;
    }
    
    public void inflate(Resources param1Resources, AttributeSet param1AttributeSet, Resources.Theme param1Theme, XmlPullParser param1XmlPullParser) {
      TypedArray typedArray = TypedArrayUtils.obtainAttributes(param1Resources, param1Theme, param1AttributeSet, AndroidResources.b);
      a(typedArray, param1XmlPullParser);
      typedArray.recycle();
    }
    
    public boolean isStateful() {
      for (int i = 0; i < this.b.size(); i++) {
        if (((VectorDrawableCompat.VObject)this.b.get(i)).isStateful())
          return true; 
      } 
      return false;
    }
    
    public boolean onStateChanged(int[] param1ArrayOfint) {
      int i = 0;
      boolean bool = false;
      while (i < this.b.size()) {
        bool |= ((VectorDrawableCompat.VObject)this.b.get(i)).onStateChanged(param1ArrayOfint);
        i++;
      } 
      return bool;
    }
    
    public void setPivotX(float param1Float) {
      if (param1Float != this.f) {
        this.f = param1Float;
        a();
      } 
    }
    
    public void setPivotY(float param1Float) {
      if (param1Float != this.g) {
        this.g = param1Float;
        a();
      } 
    }
    
    public void setRotation(float param1Float) {
      if (param1Float != this.c) {
        this.c = param1Float;
        a();
      } 
    }
    
    public void setScaleX(float param1Float) {
      if (param1Float != this.h) {
        this.h = param1Float;
        a();
      } 
    }
    
    public void setScaleY(float param1Float) {
      if (param1Float != this.i) {
        this.i = param1Float;
        a();
      } 
    }
    
    public void setTranslateX(float param1Float) {
      if (param1Float != this.j) {
        this.j = param1Float;
        a();
      } 
    }
    
    public void setTranslateY(float param1Float) {
      if (param1Float != this.k) {
        this.k = param1Float;
        a();
      } 
    }
  }
  
  static abstract class VObject {
    private VObject() {}
    
    public boolean isStateful() {
      return false;
    }
    
    public boolean onStateChanged(int[] param1ArrayOfint) {
      return false;
    }
  }
  
  static abstract class VPath extends VObject {
    protected PathParser.PathDataNode[] l = null;
    
    String m;
    
    int n = 0;
    
    int o;
    
    public VPath() {}
    
    public VPath(VPath param1VPath) {
      this.m = param1VPath.m;
      this.o = param1VPath.o;
      this.l = PathParser.deepCopyNodes(param1VPath.l);
    }
    
    public void applyTheme(Resources.Theme param1Theme) {}
    
    public boolean canApplyTheme() {
      return false;
    }
    
    public PathParser.PathDataNode[] getPathData() {
      return this.l;
    }
    
    public String getPathName() {
      return this.m;
    }
    
    public boolean isClipPath() {
      return false;
    }
    
    public String nodesToString(PathParser.PathDataNode[] param1ArrayOfPathDataNode) {
      String str = " ";
      for (int i = 0; i < param1ArrayOfPathDataNode.length; i++) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append((param1ArrayOfPathDataNode[i]).mType);
        stringBuilder.append(":");
        str = stringBuilder.toString();
        float[] arrayOfFloat = (param1ArrayOfPathDataNode[i]).mParams;
        for (int j = 0; j < arrayOfFloat.length; j++) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str);
          stringBuilder1.append(arrayOfFloat[j]);
          stringBuilder1.append(",");
          str = stringBuilder1.toString();
        } 
      } 
      return str;
    }
    
    public void printVPath(int param1Int) {
      String str = "";
      for (int i = 0; i < param1Int; i++) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append("    ");
        str = stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("current path is :");
      stringBuilder.append(this.m);
      stringBuilder.append(" pathData is ");
      stringBuilder.append(nodesToString(this.l));
      Log.v("VectorDrawableCompat", stringBuilder.toString());
    }
    
    public void setPathData(PathParser.PathDataNode[] param1ArrayOfPathDataNode) {
      if (!PathParser.canMorph(this.l, param1ArrayOfPathDataNode)) {
        this.l = PathParser.deepCopyNodes(param1ArrayOfPathDataNode);
        return;
      } 
      PathParser.updateNodes(this.l, param1ArrayOfPathDataNode);
    }
    
    public void toPath(Path param1Path) {
      param1Path.reset();
      PathParser.PathDataNode[] arrayOfPathDataNode = this.l;
      if (arrayOfPathDataNode != null)
        PathParser.PathDataNode.nodesToPath(arrayOfPathDataNode, param1Path); 
    }
  }
  
  static class VPathRenderer {
    private static final Matrix n = new Matrix();
    
    Paint a;
    
    Paint b;
    
    final VectorDrawableCompat.VGroup c = new VectorDrawableCompat.VGroup();
    
    float d = 0.0F;
    
    float e = 0.0F;
    
    float f = 0.0F;
    
    float g = 0.0F;
    
    int h = 255;
    
    String i = null;
    
    Boolean j = null;
    
    final ArrayMap<String, Object> k = new ArrayMap();
    
    private final Path l = new Path();
    
    private final Path m = new Path();
    
    private final Matrix o = new Matrix();
    
    private PathMeasure p;
    
    private int q;
    
    public VPathRenderer() {}
    
    public VPathRenderer(VPathRenderer param1VPathRenderer) {
      this.d = param1VPathRenderer.d;
      this.e = param1VPathRenderer.e;
      this.f = param1VPathRenderer.f;
      this.g = param1VPathRenderer.g;
      this.q = param1VPathRenderer.q;
      this.h = param1VPathRenderer.h;
      this.i = param1VPathRenderer.i;
      String str = param1VPathRenderer.i;
      if (str != null)
        this.k.put(str, this); 
      this.j = param1VPathRenderer.j;
    }
    
    private static float a(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
      return param1Float1 * param1Float4 - param1Float2 * param1Float3;
    }
    
    private float a(Matrix param1Matrix) {
      float[] arrayOfFloat = new float[4];
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 1.0F;
      arrayOfFloat[2] = 1.0F;
      arrayOfFloat[3] = 0.0F;
      param1Matrix.mapVectors(arrayOfFloat);
      float f1 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
      float f3 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
      float f2 = a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
      f3 = Math.max(f1, f3);
      f1 = 0.0F;
      if (f3 > 0.0F)
        f1 = Math.abs(f2) / f3; 
      return f1;
    }
    
    private void a(VectorDrawableCompat.VGroup param1VGroup, Matrix param1Matrix, Canvas param1Canvas, int param1Int1, int param1Int2, ColorFilter param1ColorFilter) {
      param1VGroup.a.set(param1Matrix);
      param1VGroup.a.preConcat(param1VGroup.d);
      param1Canvas.save();
      int i;
      for (i = 0; i < param1VGroup.b.size(); i++) {
        VectorDrawableCompat.VObject vObject = param1VGroup.b.get(i);
        if (vObject instanceof VectorDrawableCompat.VGroup) {
          a((VectorDrawableCompat.VGroup)vObject, param1VGroup.a, param1Canvas, param1Int1, param1Int2, param1ColorFilter);
        } else if (vObject instanceof VectorDrawableCompat.VPath) {
          a(param1VGroup, (VectorDrawableCompat.VPath)vObject, param1Canvas, param1Int1, param1Int2, param1ColorFilter);
        } 
      } 
      param1Canvas.restore();
    }
    
    private void a(VectorDrawableCompat.VGroup param1VGroup, VectorDrawableCompat.VPath param1VPath, Canvas param1Canvas, int param1Int1, int param1Int2, ColorFilter param1ColorFilter) {
      Path path1;
      float f2 = param1Int1 / this.f;
      float f3 = param1Int2 / this.g;
      float f1 = Math.min(f2, f3);
      Matrix matrix = param1VGroup.a;
      this.o.set(matrix);
      this.o.postScale(f2, f3);
      f2 = a(matrix);
      if (f2 == 0.0F)
        return; 
      param1VPath.toPath(this.l);
      Path path2 = this.l;
      this.m.reset();
      if (param1VPath.isClipPath()) {
        Path.FillType fillType;
        path1 = this.m;
        if (param1VPath.n == 0) {
          fillType = Path.FillType.WINDING;
        } else {
          fillType = Path.FillType.EVEN_ODD;
        } 
        path1.setFillType(fillType);
        this.m.addPath(path2, this.o);
        param1Canvas.clipPath(this.m);
        return;
      } 
      param1VPath = param1VPath;
      if (((VectorDrawableCompat.VFullPath)param1VPath).f != 0.0F || ((VectorDrawableCompat.VFullPath)param1VPath).g != 1.0F) {
        float f6 = ((VectorDrawableCompat.VFullPath)param1VPath).f;
        float f7 = ((VectorDrawableCompat.VFullPath)param1VPath).h;
        float f4 = ((VectorDrawableCompat.VFullPath)param1VPath).g;
        float f5 = ((VectorDrawableCompat.VFullPath)param1VPath).h;
        if (this.p == null)
          this.p = new PathMeasure(); 
        this.p.setPath(this.l, false);
        f3 = this.p.getLength();
        f6 = (f6 + f7) % 1.0F * f3;
        f4 = (f4 + f5) % 1.0F * f3;
        path2.reset();
        if (f6 > f4) {
          this.p.getSegment(f6, f3, path2, true);
          this.p.getSegment(0.0F, f4, path2, true);
        } else {
          this.p.getSegment(f6, f4, path2, true);
        } 
        path2.rLineTo(0.0F, 0.0F);
      } 
      this.m.addPath(path2, this.o);
      if (((VectorDrawableCompat.VFullPath)param1VPath).c.willDraw()) {
        Shader shader;
        Path.FillType fillType;
        ComplexColorCompat complexColorCompat = ((VectorDrawableCompat.VFullPath)param1VPath).c;
        if (this.b == null) {
          this.b = new Paint(1);
          this.b.setStyle(Paint.Style.FILL);
        } 
        Paint paint = this.b;
        if (complexColorCompat.isGradient()) {
          shader = complexColorCompat.getShader();
          shader.setLocalMatrix(this.o);
          paint.setShader(shader);
          paint.setAlpha(Math.round(((VectorDrawableCompat.VFullPath)param1VPath).e * 255.0F));
        } else {
          paint.setShader(null);
          paint.setAlpha(255);
          paint.setColor(VectorDrawableCompat.a(shader.getColor(), ((VectorDrawableCompat.VFullPath)param1VPath).e));
        } 
        paint.setColorFilter((ColorFilter)path1);
        Path path = this.m;
        if (((VectorDrawableCompat.VFullPath)param1VPath).n == 0) {
          fillType = Path.FillType.WINDING;
        } else {
          fillType = Path.FillType.EVEN_ODD;
        } 
        path.setFillType(fillType);
        param1Canvas.drawPath(this.m, paint);
      } 
      if (((VectorDrawableCompat.VFullPath)param1VPath).a.willDraw()) {
        Shader shader;
        ComplexColorCompat complexColorCompat = ((VectorDrawableCompat.VFullPath)param1VPath).a;
        if (this.a == null) {
          this.a = new Paint(1);
          this.a.setStyle(Paint.Style.STROKE);
        } 
        Paint paint = this.a;
        if (((VectorDrawableCompat.VFullPath)param1VPath).j != null)
          paint.setStrokeJoin(((VectorDrawableCompat.VFullPath)param1VPath).j); 
        if (((VectorDrawableCompat.VFullPath)param1VPath).i != null)
          paint.setStrokeCap(((VectorDrawableCompat.VFullPath)param1VPath).i); 
        paint.setStrokeMiter(((VectorDrawableCompat.VFullPath)param1VPath).k);
        if (complexColorCompat.isGradient()) {
          shader = complexColorCompat.getShader();
          shader.setLocalMatrix(this.o);
          paint.setShader(shader);
          paint.setAlpha(Math.round(((VectorDrawableCompat.VFullPath)param1VPath).d * 255.0F));
        } else {
          paint.setShader(null);
          paint.setAlpha(255);
          paint.setColor(VectorDrawableCompat.a(shader.getColor(), ((VectorDrawableCompat.VFullPath)param1VPath).d));
        } 
        paint.setColorFilter((ColorFilter)path1);
        paint.setStrokeWidth(((VectorDrawableCompat.VFullPath)param1VPath).b * f1 * f2);
        param1Canvas.drawPath(this.m, paint);
      } 
    }
    
    public void draw(Canvas param1Canvas, int param1Int1, int param1Int2, ColorFilter param1ColorFilter) {
      a(this.c, n, param1Canvas, param1Int1, param1Int2, param1ColorFilter);
    }
    
    public float getAlpha() {
      return getRootAlpha() / 255.0F;
    }
    
    public int getRootAlpha() {
      return this.h;
    }
    
    public boolean isStateful() {
      if (this.j == null)
        this.j = Boolean.valueOf(this.c.isStateful()); 
      return this.j.booleanValue();
    }
    
    public boolean onStateChanged(int[] param1ArrayOfint) {
      return this.c.onStateChanged(param1ArrayOfint);
    }
    
    public void setAlpha(float param1Float) {
      setRootAlpha((int)(param1Float * 255.0F));
    }
    
    public void setRootAlpha(int param1Int) {
      this.h = param1Int;
    }
  }
  
  static class VectorDrawableCompatState extends Drawable.ConstantState {
    int a;
    
    VectorDrawableCompat.VPathRenderer b;
    
    ColorStateList c = null;
    
    PorterDuff.Mode d = VectorDrawableCompat.a;
    
    boolean e;
    
    Bitmap f;
    
    ColorStateList g;
    
    PorterDuff.Mode h;
    
    int i;
    
    boolean j;
    
    boolean k;
    
    Paint l;
    
    public VectorDrawableCompatState() {
      this.b = new VectorDrawableCompat.VPathRenderer();
    }
    
    public VectorDrawableCompatState(VectorDrawableCompatState param1VectorDrawableCompatState) {
      if (param1VectorDrawableCompatState != null) {
        this.a = param1VectorDrawableCompatState.a;
        this.b = new VectorDrawableCompat.VPathRenderer(param1VectorDrawableCompatState.b);
        if (param1VectorDrawableCompatState.b.b != null)
          this.b.b = new Paint(param1VectorDrawableCompatState.b.b); 
        if (param1VectorDrawableCompatState.b.a != null)
          this.b.a = new Paint(param1VectorDrawableCompatState.b.a); 
        this.c = param1VectorDrawableCompatState.c;
        this.d = param1VectorDrawableCompatState.d;
        this.e = param1VectorDrawableCompatState.e;
      } 
    }
    
    public boolean canReuseBitmap(int param1Int1, int param1Int2) {
      return (param1Int1 == this.f.getWidth() && param1Int2 == this.f.getHeight());
    }
    
    public boolean canReuseCache() {
      return (!this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha());
    }
    
    public void createCachedBitmapIfNeeded(int param1Int1, int param1Int2) {
      if (this.f == null || !canReuseBitmap(param1Int1, param1Int2)) {
        this.f = Bitmap.createBitmap(param1Int1, param1Int2, Bitmap.Config.ARGB_8888);
        this.k = true;
      } 
    }
    
    public void drawCachedBitmapWithRootAlpha(Canvas param1Canvas, ColorFilter param1ColorFilter, Rect param1Rect) {
      Paint paint = getPaint(param1ColorFilter);
      param1Canvas.drawBitmap(this.f, null, param1Rect, paint);
    }
    
    public int getChangingConfigurations() {
      return this.a;
    }
    
    public Paint getPaint(ColorFilter param1ColorFilter) {
      if (!hasTranslucentRoot() && param1ColorFilter == null)
        return null; 
      if (this.l == null) {
        this.l = new Paint();
        this.l.setFilterBitmap(true);
      } 
      this.l.setAlpha(this.b.getRootAlpha());
      this.l.setColorFilter(param1ColorFilter);
      return this.l;
    }
    
    public boolean hasTranslucentRoot() {
      return (this.b.getRootAlpha() < 255);
    }
    
    public boolean isStateful() {
      return this.b.isStateful();
    }
    
    public Drawable newDrawable() {
      return new VectorDrawableCompat(this);
    }
    
    public Drawable newDrawable(Resources param1Resources) {
      return new VectorDrawableCompat(this);
    }
    
    public boolean onStateChanged(int[] param1ArrayOfint) {
      boolean bool = this.b.onStateChanged(param1ArrayOfint);
      this.k |= bool;
      return bool;
    }
    
    public void updateCacheStates() {
      this.g = this.c;
      this.h = this.d;
      this.i = this.b.getRootAlpha();
      this.j = this.e;
      this.k = false;
    }
    
    public void updateCachedBitmap(int param1Int1, int param1Int2) {
      this.f.eraseColor(0);
      Canvas canvas = new Canvas(this.f);
      this.b.draw(canvas, param1Int1, param1Int2, null);
    }
  }
  
  static class VectorDrawableDelegateState extends Drawable.ConstantState {
    private final Drawable.ConstantState a;
    
    public VectorDrawableDelegateState(Drawable.ConstantState param1ConstantState) {
      this.a = param1ConstantState;
    }
    
    public boolean canApplyTheme() {
      return this.a.canApplyTheme();
    }
    
    public int getChangingConfigurations() {
      return this.a.getChangingConfigurations();
    }
    
    public Drawable newDrawable() {
      VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
      vectorDrawableCompat.d = this.a.newDrawable();
      return vectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources param1Resources) {
      VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
      vectorDrawableCompat.d = this.a.newDrawable(param1Resources);
      return vectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources param1Resources, Resources.Theme param1Theme) {
      VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
      vectorDrawableCompat.d = this.a.newDrawable(param1Resources, param1Theme);
      return vectorDrawableCompat;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\vectordrawable\graphics\drawable\VectorDrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */