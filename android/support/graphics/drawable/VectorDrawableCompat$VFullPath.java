package android.support.graphics.drawable;

import android.content.res.TypedArray;
import android.graphics.Paint;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

final class VectorDrawableCompat$VFullPath extends VectorDrawableCompat$VPath {
  float mFillAlpha = 1.0F;
  
  int mFillColor = 0;
  
  int mFillRule = 0;
  
  float mStrokeAlpha = 1.0F;
  
  int mStrokeColor = 0;
  
  Paint.Cap mStrokeLineCap = Paint.Cap.BUTT;
  
  Paint.Join mStrokeLineJoin = Paint.Join.MITER;
  
  float mStrokeMiterlimit = 4.0F;
  
  float mStrokeWidth = 0.0F;
  
  private int[] mThemeAttrs;
  
  float mTrimPathEnd = 1.0F;
  
  float mTrimPathOffset = 0.0F;
  
  float mTrimPathStart = 0.0F;
  
  public VectorDrawableCompat$VFullPath() {}
  
  public VectorDrawableCompat$VFullPath(VectorDrawableCompat$VFullPath paramVectorDrawableCompat$VFullPath) {
    super(paramVectorDrawableCompat$VFullPath);
    this.mThemeAttrs = paramVectorDrawableCompat$VFullPath.mThemeAttrs;
    this.mStrokeColor = paramVectorDrawableCompat$VFullPath.mStrokeColor;
    this.mStrokeWidth = paramVectorDrawableCompat$VFullPath.mStrokeWidth;
    this.mStrokeAlpha = paramVectorDrawableCompat$VFullPath.mStrokeAlpha;
    this.mFillColor = paramVectorDrawableCompat$VFullPath.mFillColor;
    this.mFillRule = paramVectorDrawableCompat$VFullPath.mFillRule;
    this.mFillAlpha = paramVectorDrawableCompat$VFullPath.mFillAlpha;
    this.mTrimPathStart = paramVectorDrawableCompat$VFullPath.mTrimPathStart;
    this.mTrimPathEnd = paramVectorDrawableCompat$VFullPath.mTrimPathEnd;
    this.mTrimPathOffset = paramVectorDrawableCompat$VFullPath.mTrimPathOffset;
    this.mStrokeLineCap = paramVectorDrawableCompat$VFullPath.mStrokeLineCap;
    this.mStrokeLineJoin = paramVectorDrawableCompat$VFullPath.mStrokeLineJoin;
    this.mStrokeMiterlimit = paramVectorDrawableCompat$VFullPath.mStrokeMiterlimit;
  }
  
  final float getFillAlpha() {
    return this.mFillAlpha;
  }
  
  final int getFillColor() {
    return this.mFillColor;
  }
  
  final float getStrokeAlpha() {
    return this.mStrokeAlpha;
  }
  
  final int getStrokeColor() {
    return this.mStrokeColor;
  }
  
  final float getStrokeWidth() {
    return this.mStrokeWidth;
  }
  
  final float getTrimPathEnd() {
    return this.mTrimPathEnd;
  }
  
  final float getTrimPathOffset() {
    return this.mTrimPathOffset;
  }
  
  final float getTrimPathStart() {
    return this.mTrimPathStart;
  }
  
  final void setFillAlpha(float paramFloat) {
    this.mFillAlpha = paramFloat;
  }
  
  final void setFillColor(int paramInt) {
    this.mFillColor = paramInt;
  }
  
  final void setStrokeAlpha(float paramFloat) {
    this.mStrokeAlpha = paramFloat;
  }
  
  final void setStrokeColor(int paramInt) {
    this.mStrokeColor = paramInt;
  }
  
  final void setStrokeWidth(float paramFloat) {
    this.mStrokeWidth = paramFloat;
  }
  
  final void setTrimPathEnd(float paramFloat) {
    this.mTrimPathEnd = paramFloat;
  }
  
  final void setTrimPathOffset(float paramFloat) {
    this.mTrimPathOffset = paramFloat;
  }
  
  final void setTrimPathStart(float paramFloat) {
    this.mTrimPathStart = paramFloat;
  }
  
  final void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser) {
    this.mThemeAttrs = null;
    if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData"))
      return; 
    String str = paramTypedArray.getString(0);
    if (str != null)
      this.mPathName = str; 
    str = paramTypedArray.getString(2);
    if (str != null)
      this.mNodes = PathParser.createNodesFromPathData(str); 
    this.mFillColor = TypedArrayUtils.getNamedColor(paramTypedArray, paramXmlPullParser, "fillColor", 1, this.mFillColor);
    this.mFillAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.mFillAlpha);
    int i = TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1);
    Paint.Cap cap = this.mStrokeLineCap;
    switch (i) {
      case 2:
        cap = Paint.Cap.SQUARE;
        break;
      case 1:
        cap = Paint.Cap.ROUND;
        break;
      case 0:
        cap = Paint.Cap.BUTT;
        break;
    } 
    this.mStrokeLineCap = cap;
    i = TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1);
    Paint.Join join = this.mStrokeLineJoin;
    switch (i) {
      case 2:
        join = Paint.Join.BEVEL;
        break;
      case 1:
        join = Paint.Join.ROUND;
        break;
      case 0:
        join = Paint.Join.MITER;
        break;
    } 
    this.mStrokeLineJoin = join;
    this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
    this.mStrokeColor = TypedArrayUtils.getNamedColor(paramTypedArray, paramXmlPullParser, "strokeColor", 3, this.mStrokeColor);
    this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.mStrokeAlpha);
    this.mStrokeWidth = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
    this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.mTrimPathEnd);
    this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.mTrimPathOffset);
    this.mTrimPathStart = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.mTrimPathStart);
    this.mFillRule = TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "fillType", 13, this.mFillRule);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\graphics\drawable\VectorDrawableCompat$VFullPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */