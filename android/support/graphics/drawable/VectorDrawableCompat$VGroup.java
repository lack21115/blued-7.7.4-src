package android.support.graphics.drawable;

import android.graphics.Matrix;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;

final class VectorDrawableCompat$VGroup {
  int mChangingConfigurations;
  
  final ArrayList mChildren = new ArrayList();
  
  String mGroupName = null;
  
  final Matrix mLocalMatrix = new Matrix();
  
  float mPivotX = 0.0F;
  
  float mPivotY = 0.0F;
  
  float mRotate = 0.0F;
  
  float mScaleX = 1.0F;
  
  float mScaleY = 1.0F;
  
  final Matrix mStackedMatrix = new Matrix();
  
  int[] mThemeAttrs;
  
  float mTranslateX = 0.0F;
  
  float mTranslateY = 0.0F;
  
  public VectorDrawableCompat$VGroup() {}
  
  public VectorDrawableCompat$VGroup(VectorDrawableCompat$VGroup paramVectorDrawableCompat$VGroup, ArrayMap paramArrayMap) {
    this.mRotate = paramVectorDrawableCompat$VGroup.mRotate;
    this.mPivotX = paramVectorDrawableCompat$VGroup.mPivotX;
    this.mPivotY = paramVectorDrawableCompat$VGroup.mPivotY;
    this.mScaleX = paramVectorDrawableCompat$VGroup.mScaleX;
    this.mScaleY = paramVectorDrawableCompat$VGroup.mScaleY;
    this.mTranslateX = paramVectorDrawableCompat$VGroup.mTranslateX;
    this.mTranslateY = paramVectorDrawableCompat$VGroup.mTranslateY;
    this.mThemeAttrs = paramVectorDrawableCompat$VGroup.mThemeAttrs;
    this.mGroupName = paramVectorDrawableCompat$VGroup.mGroupName;
    this.mChangingConfigurations = paramVectorDrawableCompat$VGroup.mChangingConfigurations;
    if (this.mGroupName != null)
      paramArrayMap.put(this.mGroupName, this); 
    this.mLocalMatrix.set(paramVectorDrawableCompat$VGroup.mLocalMatrix);
    ArrayList<VectorDrawableCompat$VGroup> arrayList = paramVectorDrawableCompat$VGroup.mChildren;
    for (int i = 0; i < arrayList.size(); i++) {
      paramVectorDrawableCompat$VGroup = arrayList.get(i);
      if (paramVectorDrawableCompat$VGroup instanceof VectorDrawableCompat$VGroup) {
        paramVectorDrawableCompat$VGroup = paramVectorDrawableCompat$VGroup;
        this.mChildren.add(new VectorDrawableCompat$VGroup(paramVectorDrawableCompat$VGroup, paramArrayMap));
      } else {
        VectorDrawableCompat$VFullPath vectorDrawableCompat$VFullPath;
        VectorDrawableCompat$VClipPath vectorDrawableCompat$VClipPath;
        if (paramVectorDrawableCompat$VGroup instanceof VectorDrawableCompat$VFullPath) {
          vectorDrawableCompat$VFullPath = new VectorDrawableCompat$VFullPath((VectorDrawableCompat$VFullPath)paramVectorDrawableCompat$VGroup);
        } else if (vectorDrawableCompat$VFullPath instanceof VectorDrawableCompat$VClipPath) {
          vectorDrawableCompat$VClipPath = new VectorDrawableCompat$VClipPath((VectorDrawableCompat$VClipPath)vectorDrawableCompat$VFullPath);
        } else {
          throw new IllegalStateException("Unknown object in the tree!");
        } 
        this.mChildren.add(vectorDrawableCompat$VClipPath);
        if (vectorDrawableCompat$VClipPath.mPathName != null)
          paramArrayMap.put(vectorDrawableCompat$VClipPath.mPathName, vectorDrawableCompat$VClipPath); 
      } 
    } 
  }
  
  public final String getGroupName() {
    return this.mGroupName;
  }
  
  public final Matrix getLocalMatrix() {
    return this.mLocalMatrix;
  }
  
  public final float getPivotX() {
    return this.mPivotX;
  }
  
  public final float getPivotY() {
    return this.mPivotY;
  }
  
  public final float getRotation() {
    return this.mRotate;
  }
  
  public final float getScaleX() {
    return this.mScaleX;
  }
  
  public final float getScaleY() {
    return this.mScaleY;
  }
  
  public final float getTranslateX() {
    return this.mTranslateX;
  }
  
  public final float getTranslateY() {
    return this.mTranslateY;
  }
  
  public final void setPivotX(float paramFloat) {
    if (paramFloat != this.mPivotX) {
      this.mPivotX = paramFloat;
      updateLocalMatrix();
    } 
  }
  
  public final void setPivotY(float paramFloat) {
    if (paramFloat != this.mPivotY) {
      this.mPivotY = paramFloat;
      updateLocalMatrix();
    } 
  }
  
  public final void setRotation(float paramFloat) {
    if (paramFloat != this.mRotate) {
      this.mRotate = paramFloat;
      updateLocalMatrix();
    } 
  }
  
  public final void setScaleX(float paramFloat) {
    if (paramFloat != this.mScaleX) {
      this.mScaleX = paramFloat;
      updateLocalMatrix();
    } 
  }
  
  public final void setScaleY(float paramFloat) {
    if (paramFloat != this.mScaleY) {
      this.mScaleY = paramFloat;
      updateLocalMatrix();
    } 
  }
  
  public final void setTranslateX(float paramFloat) {
    if (paramFloat != this.mTranslateX) {
      this.mTranslateX = paramFloat;
      updateLocalMatrix();
    } 
  }
  
  public final void setTranslateY(float paramFloat) {
    if (paramFloat != this.mTranslateY) {
      this.mTranslateY = paramFloat;
      updateLocalMatrix();
    } 
  }
  
  final void updateLocalMatrix() {
    this.mLocalMatrix.reset();
    this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
    this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
    this.mLocalMatrix.postRotate(this.mRotate, 0.0F, 0.0F);
    this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\graphics\drawable\VectorDrawableCompat$VGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */