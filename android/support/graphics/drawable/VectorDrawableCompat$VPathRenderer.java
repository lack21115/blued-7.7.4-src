package android.support.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.util.ArrayMap;

final class VectorDrawableCompat$VPathRenderer {
  private static final Matrix IDENTITY_MATRIX = new Matrix();
  
  float mBaseHeight = 0.0F;
  
  float mBaseWidth = 0.0F;
  
  private int mChangingConfigurations;
  
  private Paint mFillPaint;
  
  private final Matrix mFinalPathMatrix = new Matrix();
  
  private final Path mPath = new Path();
  
  private PathMeasure mPathMeasure;
  
  private final Path mRenderPath = new Path();
  
  private int mRootAlpha = 255;
  
  final VectorDrawableCompat$VGroup mRootGroup = new VectorDrawableCompat$VGroup();
  
  String mRootName = null;
  
  private Paint mStrokePaint;
  
  final ArrayMap mVGTargetsMap = new ArrayMap();
  
  float mViewportHeight = 0.0F;
  
  float mViewportWidth = 0.0F;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public VectorDrawableCompat$VPathRenderer() {}
  
  public VectorDrawableCompat$VPathRenderer(VectorDrawableCompat$VPathRenderer paramVectorDrawableCompat$VPathRenderer) {
    this.mBaseWidth = paramVectorDrawableCompat$VPathRenderer.mBaseWidth;
    this.mBaseHeight = paramVectorDrawableCompat$VPathRenderer.mBaseHeight;
    this.mViewportWidth = paramVectorDrawableCompat$VPathRenderer.mViewportWidth;
    this.mViewportHeight = paramVectorDrawableCompat$VPathRenderer.mViewportHeight;
    this.mChangingConfigurations = paramVectorDrawableCompat$VPathRenderer.mChangingConfigurations;
    this.mRootAlpha = paramVectorDrawableCompat$VPathRenderer.mRootAlpha;
    this.mRootName = paramVectorDrawableCompat$VPathRenderer.mRootName;
    if (paramVectorDrawableCompat$VPathRenderer.mRootName != null)
      this.mVGTargetsMap.put(paramVectorDrawableCompat$VPathRenderer.mRootName, this); 
  }
  
  private void drawGroupTree(VectorDrawableCompat$VGroup paramVectorDrawableCompat$VGroup, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter) {
    VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer2 = this;
    paramVectorDrawableCompat$VGroup.mStackedMatrix.set(paramMatrix);
    paramVectorDrawableCompat$VGroup.mStackedMatrix.preConcat(paramVectorDrawableCompat$VGroup.mLocalMatrix);
    paramCanvas.save();
    int i = 0;
    VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer1 = vectorDrawableCompat$VPathRenderer2;
    while (i < paramVectorDrawableCompat$VGroup.mChildren.size()) {
      vectorDrawableCompat$VPathRenderer2 = paramVectorDrawableCompat$VGroup.mChildren.get(i);
      if (vectorDrawableCompat$VPathRenderer2 instanceof VectorDrawableCompat$VGroup) {
        drawGroupTree((VectorDrawableCompat$VGroup)vectorDrawableCompat$VPathRenderer2, paramVectorDrawableCompat$VGroup.mStackedMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
      } else if (vectorDrawableCompat$VPathRenderer2 instanceof VectorDrawableCompat$VPath) {
        VectorDrawableCompat$VPath vectorDrawableCompat$VPath = (VectorDrawableCompat$VPath)vectorDrawableCompat$VPathRenderer2;
        float f1 = paramInt1 / vectorDrawableCompat$VPathRenderer1.mViewportWidth;
        float f3 = paramInt2 / vectorDrawableCompat$VPathRenderer1.mViewportHeight;
        float f2 = Math.min(f1, f3);
        Matrix matrix = paramVectorDrawableCompat$VGroup.mStackedMatrix;
        vectorDrawableCompat$VPathRenderer1.mFinalPathMatrix.set(matrix);
        vectorDrawableCompat$VPathRenderer1.mFinalPathMatrix.postScale(f1, f3);
        float[] arrayOfFloat = new float[4];
        arrayOfFloat[0] = 0.0F;
        arrayOfFloat[1] = 1.0F;
        arrayOfFloat[2] = 1.0F;
        arrayOfFloat[3] = 0.0F;
        matrix.mapVectors(arrayOfFloat);
        float f6 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
        float f7 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
        f1 = arrayOfFloat[0];
        f3 = arrayOfFloat[1];
        float f4 = arrayOfFloat[2];
        float f5 = arrayOfFloat[3];
        f6 = Math.max(f6, f7);
        if (f6 > 0.0F) {
          f1 = Math.abs(f1 * f5 - f3 * f4) / f6;
        } else {
          f1 = 0.0F;
        } 
        if (f1 != 0.0F) {
          VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer3;
          VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer4 = this;
          vectorDrawableCompat$VPath.toPath(vectorDrawableCompat$VPathRenderer4.mPath);
          Path path = vectorDrawableCompat$VPathRenderer4.mPath;
          vectorDrawableCompat$VPathRenderer4.mRenderPath.reset();
          if (vectorDrawableCompat$VPath.isClipPath()) {
            vectorDrawableCompat$VPathRenderer4.mRenderPath.addPath(path, vectorDrawableCompat$VPathRenderer4.mFinalPathMatrix);
            paramCanvas.clipPath(vectorDrawableCompat$VPathRenderer4.mRenderPath);
            vectorDrawableCompat$VPathRenderer3 = vectorDrawableCompat$VPathRenderer4;
          } else {
            vectorDrawableCompat$VPath = vectorDrawableCompat$VPath;
            if (((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mTrimPathStart != 0.0F || ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mTrimPathEnd != 1.0F) {
              f6 = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mTrimPathStart;
              f7 = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mTrimPathOffset;
              f4 = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mTrimPathEnd;
              f5 = ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mTrimPathOffset;
              if (vectorDrawableCompat$VPathRenderer4.mPathMeasure == null)
                vectorDrawableCompat$VPathRenderer4.mPathMeasure = new PathMeasure(); 
              vectorDrawableCompat$VPathRenderer4.mPathMeasure.setPath(vectorDrawableCompat$VPathRenderer4.mPath, false);
              f3 = vectorDrawableCompat$VPathRenderer4.mPathMeasure.getLength();
              f6 = (f6 + f7) % 1.0F * f3;
              f4 = (f4 + f5) % 1.0F * f3;
              vectorDrawableCompat$VPathRenderer3.reset();
              if (f6 > f4) {
                vectorDrawableCompat$VPathRenderer4.mPathMeasure.getSegment(f6, f3, (Path)vectorDrawableCompat$VPathRenderer3, true);
                vectorDrawableCompat$VPathRenderer4.mPathMeasure.getSegment(0.0F, f4, (Path)vectorDrawableCompat$VPathRenderer3, true);
              } else {
                vectorDrawableCompat$VPathRenderer4.mPathMeasure.getSegment(f6, f4, (Path)vectorDrawableCompat$VPathRenderer3, true);
              } 
              vectorDrawableCompat$VPathRenderer3.rLineTo(0.0F, 0.0F);
            } 
            vectorDrawableCompat$VPathRenderer4.mRenderPath.addPath((Path)vectorDrawableCompat$VPathRenderer3, vectorDrawableCompat$VPathRenderer4.mFinalPathMatrix);
            if (((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mFillColor != 0) {
              Path.FillType fillType;
              if (vectorDrawableCompat$VPathRenderer4.mFillPaint == null) {
                vectorDrawableCompat$VPathRenderer4.mFillPaint = new Paint();
                vectorDrawableCompat$VPathRenderer4.mFillPaint.setStyle(Paint.Style.FILL);
                vectorDrawableCompat$VPathRenderer4.mFillPaint.setAntiAlias(true);
              } 
              Paint paint = vectorDrawableCompat$VPathRenderer4.mFillPaint;
              paint.setColor(VectorDrawableCompat.applyAlpha(((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mFillColor, ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mFillAlpha));
              paint.setColorFilter(paramColorFilter);
              Path path1 = vectorDrawableCompat$VPathRenderer4.mRenderPath;
              if (((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mFillRule == 0) {
                fillType = Path.FillType.WINDING;
              } else {
                fillType = Path.FillType.EVEN_ODD;
              } 
              path1.setFillType(fillType);
              paramCanvas.drawPath(vectorDrawableCompat$VPathRenderer4.mRenderPath, paint);
            } 
            vectorDrawableCompat$VPathRenderer3 = vectorDrawableCompat$VPathRenderer4;
            if (((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeColor != 0) {
              if (vectorDrawableCompat$VPathRenderer4.mStrokePaint == null) {
                vectorDrawableCompat$VPathRenderer4.mStrokePaint = new Paint();
                vectorDrawableCompat$VPathRenderer4.mStrokePaint.setStyle(Paint.Style.STROKE);
                vectorDrawableCompat$VPathRenderer4.mStrokePaint.setAntiAlias(true);
              } 
              Paint paint = vectorDrawableCompat$VPathRenderer4.mStrokePaint;
              if (((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeLineJoin != null)
                paint.setStrokeJoin(((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeLineJoin); 
              if (((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeLineCap != null)
                paint.setStrokeCap(((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeLineCap); 
              paint.setStrokeMiter(((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeMiterlimit);
              paint.setColor(VectorDrawableCompat.applyAlpha(((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeColor, ((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeAlpha));
              paint.setColorFilter(paramColorFilter);
              paint.setStrokeWidth(((VectorDrawableCompat$VFullPath)vectorDrawableCompat$VPath).mStrokeWidth * f1 * f2);
              paramCanvas.drawPath(vectorDrawableCompat$VPathRenderer4.mRenderPath, paint);
              VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer = vectorDrawableCompat$VPathRenderer4;
            } 
          } 
        } else {
          VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer = this;
        } 
      } 
      i++;
    } 
    paramCanvas.restore();
  }
  
  public final void draw(Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter) {
    drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, paramCanvas, paramInt1, paramInt2, paramColorFilter);
  }
  
  public final float getAlpha() {
    return getRootAlpha() / 255.0F;
  }
  
  public final int getRootAlpha() {
    return this.mRootAlpha;
  }
  
  public final void setAlpha(float paramFloat) {
    setRootAlpha((int)(paramFloat * 255.0F));
  }
  
  public final void setRootAlpha(int paramInt) {
    this.mRootAlpha = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\graphics\drawable\VectorDrawableCompat$VPathRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */