package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

class MatrixUtils {
  static final Matrix a = new Matrix() {
      void a() {
        throw new IllegalStateException("Matrix can not be modified");
      }
      
      public boolean postConcat(Matrix param1Matrix) {
        a();
        return false;
      }
      
      public boolean postRotate(float param1Float) {
        a();
        return false;
      }
      
      public boolean postRotate(float param1Float1, float param1Float2, float param1Float3) {
        a();
        return false;
      }
      
      public boolean postScale(float param1Float1, float param1Float2) {
        a();
        return false;
      }
      
      public boolean postScale(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
        a();
        return false;
      }
      
      public boolean postSkew(float param1Float1, float param1Float2) {
        a();
        return false;
      }
      
      public boolean postSkew(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
        a();
        return false;
      }
      
      public boolean postTranslate(float param1Float1, float param1Float2) {
        a();
        return false;
      }
      
      public boolean preConcat(Matrix param1Matrix) {
        a();
        return false;
      }
      
      public boolean preRotate(float param1Float) {
        a();
        return false;
      }
      
      public boolean preRotate(float param1Float1, float param1Float2, float param1Float3) {
        a();
        return false;
      }
      
      public boolean preScale(float param1Float1, float param1Float2) {
        a();
        return false;
      }
      
      public boolean preScale(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
        a();
        return false;
      }
      
      public boolean preSkew(float param1Float1, float param1Float2) {
        a();
        return false;
      }
      
      public boolean preSkew(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
        a();
        return false;
      }
      
      public boolean preTranslate(float param1Float1, float param1Float2) {
        a();
        return false;
      }
      
      public void reset() {
        a();
      }
      
      public void set(Matrix param1Matrix) {
        a();
      }
      
      public boolean setConcat(Matrix param1Matrix1, Matrix param1Matrix2) {
        a();
        return false;
      }
      
      public boolean setPolyToPoly(float[] param1ArrayOffloat1, int param1Int1, float[] param1ArrayOffloat2, int param1Int2, int param1Int3) {
        a();
        return false;
      }
      
      public boolean setRectToRect(RectF param1RectF1, RectF param1RectF2, Matrix.ScaleToFit param1ScaleToFit) {
        a();
        return false;
      }
      
      public void setRotate(float param1Float) {
        a();
      }
      
      public void setRotate(float param1Float1, float param1Float2, float param1Float3) {
        a();
      }
      
      public void setScale(float param1Float1, float param1Float2) {
        a();
      }
      
      public void setScale(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
        a();
      }
      
      public void setSinCos(float param1Float1, float param1Float2) {
        a();
      }
      
      public void setSinCos(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
        a();
      }
      
      public void setSkew(float param1Float1, float param1Float2) {
        a();
      }
      
      public void setSkew(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
        a();
      }
      
      public void setTranslate(float param1Float1, float param1Float2) {
        a();
      }
      
      public void setValues(float[] param1ArrayOffloat) {
        a();
      }
    };
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\MatrixUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */