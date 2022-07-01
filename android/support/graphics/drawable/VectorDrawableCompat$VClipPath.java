package android.support.graphics.drawable;

import android.content.res.TypedArray;
import android.support.v4.graphics.PathParser;

final class VectorDrawableCompat$VClipPath extends VectorDrawableCompat$VPath {
  public VectorDrawableCompat$VClipPath() {}
  
  public VectorDrawableCompat$VClipPath(VectorDrawableCompat$VClipPath paramVectorDrawableCompat$VClipPath) {
    super(paramVectorDrawableCompat$VClipPath);
  }
  
  public final boolean isClipPath() {
    return true;
  }
  
  final void updateStateFromTypedArray(TypedArray paramTypedArray) {
    String str2 = paramTypedArray.getString(0);
    if (str2 != null)
      this.mPathName = str2; 
    String str1 = paramTypedArray.getString(1);
    if (str1 != null)
      this.mNodes = PathParser.createNodesFromPathData(str1); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\graphics\drawable\VectorDrawableCompat$VClipPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */