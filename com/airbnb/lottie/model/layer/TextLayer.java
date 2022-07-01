package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextLayer extends BaseLayer {
  private final StringBuilder e = new StringBuilder(2);
  
  private final RectF f = new RectF();
  
  private final Matrix g = new Matrix();
  
  private final Paint h = new Paint(this, 1) {
    
    };
  
  private final Paint i = new Paint(this, 1) {
    
    };
  
  private final Map<FontCharacter, List<ContentGroup>> j = new HashMap<FontCharacter, List<ContentGroup>>();
  
  private final LongSparseArray<String> k = new LongSparseArray();
  
  private final TextKeyframeAnimation l;
  
  private final LottieDrawable m;
  
  private final LottieComposition n;
  
  private BaseKeyframeAnimation<Integer, Integer> o;
  
  private BaseKeyframeAnimation<Integer, Integer> p;
  
  private BaseKeyframeAnimation<Float, Float> q;
  
  private BaseKeyframeAnimation<Float, Float> r;
  
  TextLayer(LottieDrawable paramLottieDrawable, Layer paramLayer) {
    super(paramLottieDrawable, paramLayer);
    this.m = paramLottieDrawable;
    this.n = paramLayer.a();
    this.l = paramLayer.s().d();
    this.l.a(this);
    a((BaseKeyframeAnimation<?, ?>)this.l);
    AnimatableTextProperties animatableTextProperties = paramLayer.t();
    if (animatableTextProperties != null && animatableTextProperties.a != null) {
      this.o = animatableTextProperties.a.a();
      this.o.a(this);
      a(this.o);
    } 
    if (animatableTextProperties != null && animatableTextProperties.b != null) {
      this.p = animatableTextProperties.b.a();
      this.p.a(this);
      a(this.p);
    } 
    if (animatableTextProperties != null && animatableTextProperties.c != null) {
      this.q = animatableTextProperties.c.a();
      this.q.a(this);
      a(this.q);
    } 
    if (animatableTextProperties != null && animatableTextProperties.d != null) {
      this.r = animatableTextProperties.d.a();
      this.r.a(this);
      a(this.r);
    } 
  }
  
  private float a(String paramString, Font paramFont, float paramFloat1, float paramFloat2) {
    float f = 0.0F;
    int i;
    for (i = 0; i < paramString.length(); i++) {
      int j = FontCharacter.a(paramString.charAt(i), paramFont.a(), paramFont.c());
      FontCharacter fontCharacter = (FontCharacter)this.n.j().get(j);
      if (fontCharacter != null)
        f = (float)(f + fontCharacter.b() * paramFloat1 * Utils.a() * paramFloat2); 
    } 
    return f;
  }
  
  private String a(String paramString, int paramInt) {
    int j = paramString.codePointAt(paramInt);
    int i = Character.charCount(j) + paramInt;
    while (i < paramString.length()) {
      int k = paramString.codePointAt(i);
      if (!a(k))
        break; 
      i += Character.charCount(k);
      j = j * 31 + k;
    } 
    LongSparseArray<String> longSparseArray = this.k;
    long l = j;
    if (longSparseArray.containsKey(l))
      return (String)this.k.get(l); 
    this.e.setLength(0);
    while (paramInt < i) {
      j = paramString.codePointAt(paramInt);
      this.e.appendCodePoint(j);
      paramInt += Character.charCount(j);
    } 
    paramString = this.e.toString();
    this.k.put(l, paramString);
    return paramString;
  }
  
  private List<ContentGroup> a(FontCharacter paramFontCharacter) {
    if (this.j.containsKey(paramFontCharacter))
      return this.j.get(paramFontCharacter); 
    List<ShapeGroup> list = paramFontCharacter.a();
    int j = list.size();
    ArrayList<ContentGroup> arrayList = new ArrayList(j);
    for (int i = 0; i < j; i++) {
      ShapeGroup shapeGroup = list.get(i);
      arrayList.add(new ContentGroup(this.m, this, shapeGroup));
    } 
    this.j.put(paramFontCharacter, arrayList);
    return arrayList;
  }
  
  private List<String> a(String paramString) {
    return Arrays.asList(paramString.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
  }
  
  private void a(Path paramPath, Paint paramPaint, Canvas paramCanvas) {
    if (paramPaint.getColor() == 0)
      return; 
    if (paramPaint.getStyle() == Paint.Style.STROKE && paramPaint.getStrokeWidth() == 0.0F)
      return; 
    paramCanvas.drawPath(paramPath, paramPaint);
  }
  
  private void a(DocumentData.Justification paramJustification, Canvas paramCanvas, float paramFloat) {
    int i = null.a[paramJustification.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return; 
        paramCanvas.translate(-paramFloat / 2.0F, 0.0F);
        return;
      } 
      paramCanvas.translate(-paramFloat, 0.0F);
    } 
  }
  
  private void a(DocumentData paramDocumentData, Matrix paramMatrix, Font paramFont, Canvas paramCanvas) {
    float f1 = (float)paramDocumentData.c / 100.0F;
    float f2 = Utils.a(paramMatrix);
    String str = paramDocumentData.a;
    float f3 = (float)paramDocumentData.f * Utils.a();
    List<String> list = a(str);
    int j = list.size();
    int i;
    for (i = 0; i < j; i++) {
      String str1 = list.get(i);
      float f = a(str1, paramFont, f1, f2);
      paramCanvas.save();
      a(paramDocumentData.d, paramCanvas, f);
      f = (j - 1) * f3 / 2.0F;
      paramCanvas.translate(0.0F, i * f3 - f);
      a(str1, paramDocumentData, paramMatrix, paramFont, paramCanvas, f2, f1);
      paramCanvas.restore();
    } 
  }
  
  private void a(DocumentData paramDocumentData, Font paramFont, Matrix paramMatrix, Canvas paramCanvas) {
    float f1 = Utils.a(paramMatrix);
    Typeface typeface = this.m.a(paramFont.a(), paramFont.c());
    if (typeface == null)
      return; 
    String str2 = paramDocumentData.a;
    TextDelegate textDelegate = this.m.o();
    String str1 = str2;
    if (textDelegate != null)
      str1 = textDelegate.a(str2); 
    this.h.setTypeface(typeface);
    this.h.setTextSize((float)(paramDocumentData.c * Utils.a()));
    this.i.setTypeface(this.h.getTypeface());
    this.i.setTextSize(this.h.getTextSize());
    float f2 = (float)paramDocumentData.f * Utils.a();
    List<String> list = a(str1);
    int j = list.size();
    int i;
    for (i = 0; i < j; i++) {
      str2 = list.get(i);
      float f = this.i.measureText(str2);
      a(paramDocumentData.d, paramCanvas, f);
      f = (j - 1) * f2 / 2.0F;
      paramCanvas.translate(0.0F, i * f2 - f);
      a(str2, paramDocumentData, paramCanvas, f1);
      paramCanvas.setMatrix(paramMatrix);
    } 
  }
  
  private void a(FontCharacter paramFontCharacter, Matrix paramMatrix, float paramFloat, DocumentData paramDocumentData, Canvas paramCanvas) {
    List<ContentGroup> list = a(paramFontCharacter);
    int i;
    for (i = 0; i < list.size(); i++) {
      Path path = ((ContentGroup)list.get(i)).e();
      path.computeBounds(this.f, false);
      this.g.set(paramMatrix);
      this.g.preTranslate(0.0F, (float)-paramDocumentData.g * Utils.a());
      this.g.preScale(paramFloat, paramFloat);
      path.transform(this.g);
      if (paramDocumentData.k) {
        a(path, this.h, paramCanvas);
        a(path, this.i, paramCanvas);
      } else {
        a(path, this.i, paramCanvas);
        a(path, this.h, paramCanvas);
      } 
    } 
  }
  
  private void a(String paramString, Paint paramPaint, Canvas paramCanvas) {
    if (paramPaint.getColor() == 0)
      return; 
    if (paramPaint.getStyle() == Paint.Style.STROKE && paramPaint.getStrokeWidth() == 0.0F)
      return; 
    paramCanvas.drawText(paramString, 0, paramString.length(), 0.0F, 0.0F, paramPaint);
  }
  
  private void a(String paramString, DocumentData paramDocumentData, Canvas paramCanvas) {
    if (paramDocumentData.k) {
      a(paramString, this.h, paramCanvas);
      a(paramString, this.i, paramCanvas);
      return;
    } 
    a(paramString, this.i, paramCanvas);
    a(paramString, this.h, paramCanvas);
  }
  
  private void a(String paramString, DocumentData paramDocumentData, Canvas paramCanvas, float paramFloat) {
    int i = 0;
    while (i < paramString.length()) {
      String str = a(paramString, i);
      i += str.length();
      a(str, paramDocumentData, paramCanvas);
      float f3 = this.h.measureText(str, 0, 1);
      float f2 = paramDocumentData.e / 10.0F;
      BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.r;
      float f1 = f2;
      if (baseKeyframeAnimation != null)
        f1 = f2 + ((Float)baseKeyframeAnimation.g()).floatValue(); 
      paramCanvas.translate(f3 + f1 * paramFloat, 0.0F);
    } 
  }
  
  private void a(String paramString, DocumentData paramDocumentData, Matrix paramMatrix, Font paramFont, Canvas paramCanvas, float paramFloat1, float paramFloat2) {
    int i;
    for (i = 0; i < paramString.length(); i++) {
      int j = FontCharacter.a(paramString.charAt(i), paramFont.a(), paramFont.c());
      FontCharacter fontCharacter = (FontCharacter)this.n.j().get(j);
      if (fontCharacter != null) {
        a(fontCharacter, paramMatrix, paramFloat2, paramDocumentData, paramCanvas);
        float f3 = (float)fontCharacter.b();
        float f4 = Utils.a();
        float f2 = paramDocumentData.e / 10.0F;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.r;
        float f1 = f2;
        if (baseKeyframeAnimation != null)
          f1 = f2 + ((Float)baseKeyframeAnimation.g()).floatValue(); 
        paramCanvas.translate(f3 * paramFloat2 * f4 * paramFloat1 + f1 * paramFloat1, 0.0F);
      } 
    } 
  }
  
  private boolean a(int paramInt) {
    return (Character.getType(paramInt) == 16 || Character.getType(paramInt) == 27 || Character.getType(paramInt) == 6 || Character.getType(paramInt) == 28 || Character.getType(paramInt) == 19);
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean) {
    super.a(paramRectF, paramMatrix, paramBoolean);
    paramRectF.set(0.0F, 0.0F, this.n.d().width(), this.n.d().height());
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    super.a(paramT, paramLottieValueCallback);
    if (paramT == LottieProperty.a) {
      BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.o;
      if (baseKeyframeAnimation != null) {
        baseKeyframeAnimation.a(paramLottieValueCallback);
        return;
      } 
    } 
    if (paramT == LottieProperty.b) {
      BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.p;
      if (baseKeyframeAnimation != null) {
        baseKeyframeAnimation.a(paramLottieValueCallback);
        return;
      } 
    } 
    if (paramT == LottieProperty.o) {
      BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.q;
      if (baseKeyframeAnimation != null) {
        baseKeyframeAnimation.a(paramLottieValueCallback);
        return;
      } 
    } 
    if (paramT == LottieProperty.p) {
      BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.r;
      if (baseKeyframeAnimation != null)
        baseKeyframeAnimation.a(paramLottieValueCallback); 
    } 
  }
  
  void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {
    paramCanvas.save();
    if (!this.m.p())
      paramCanvas.setMatrix(paramMatrix); 
    DocumentData documentData = (DocumentData)this.l.g();
    Font font = (Font)this.n.k().get(documentData.b);
    if (font == null) {
      paramCanvas.restore();
      return;
    } 
    BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation1 = this.o;
    if (baseKeyframeAnimation1 != null) {
      this.h.setColor(((Integer)baseKeyframeAnimation1.g()).intValue());
    } else {
      this.h.setColor(documentData.h);
    } 
    baseKeyframeAnimation1 = this.p;
    if (baseKeyframeAnimation1 != null) {
      this.i.setColor(((Integer)baseKeyframeAnimation1.g()).intValue());
    } else {
      this.i.setColor(documentData.i);
    } 
    if (this.d.a() == null) {
      paramInt = 100;
    } else {
      paramInt = ((Integer)this.d.a().g()).intValue();
    } 
    paramInt = paramInt * 255 / 100;
    this.h.setAlpha(paramInt);
    this.i.setAlpha(paramInt);
    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.q;
    if (baseKeyframeAnimation != null) {
      this.i.setStrokeWidth(((Float)baseKeyframeAnimation.g()).floatValue());
    } else {
      float f = Utils.a(paramMatrix);
      this.i.setStrokeWidth((float)(documentData.j * Utils.a() * f));
    } 
    if (this.m.p()) {
      a(documentData, paramMatrix, font, paramCanvas);
    } else {
      a(documentData, font, paramMatrix, paramCanvas);
    } 
    paramCanvas.restore();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\layer\TextLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */