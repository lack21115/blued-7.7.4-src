package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class ImageMatrixProperty extends Property<ImageView, Matrix> {
  private final Matrix a = new Matrix();
  
  public ImageMatrixProperty() {
    super(Matrix.class, "imageMatrixProperty");
  }
  
  public Matrix a(ImageView paramImageView) {
    this.a.set(paramImageView.getImageMatrix());
    return this.a;
  }
  
  public void a(ImageView paramImageView, Matrix paramMatrix) {
    paramImageView.setImageMatrix(paramMatrix);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\animation\ImageMatrixProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */