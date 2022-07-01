package android.support.graphics.drawable;

import android.graphics.Path;
import android.support.v4.graphics.PathParser;

class VectorDrawableCompat$VPath {
  int mChangingConfigurations;
  
  protected PathParser.PathDataNode[] mNodes = null;
  
  String mPathName;
  
  public VectorDrawableCompat$VPath() {}
  
  public VectorDrawableCompat$VPath(VectorDrawableCompat$VPath paramVectorDrawableCompat$VPath) {
    this.mPathName = paramVectorDrawableCompat$VPath.mPathName;
    this.mChangingConfigurations = paramVectorDrawableCompat$VPath.mChangingConfigurations;
    this.mNodes = PathParser.deepCopyNodes(paramVectorDrawableCompat$VPath.mNodes);
  }
  
  public PathParser.PathDataNode[] getPathData() {
    return this.mNodes;
  }
  
  public String getPathName() {
    return this.mPathName;
  }
  
  public boolean isClipPath() {
    return false;
  }
  
  public void setPathData(PathParser.PathDataNode[] paramArrayOfPathDataNode) {
    if (!PathParser.canMorph(this.mNodes, paramArrayOfPathDataNode)) {
      this.mNodes = PathParser.deepCopyNodes(paramArrayOfPathDataNode);
      return;
    } 
    PathParser.PathDataNode[] arrayOfPathDataNode = this.mNodes;
    for (int i = 0; i < paramArrayOfPathDataNode.length; i++) {
      (arrayOfPathDataNode[i]).mType = (paramArrayOfPathDataNode[i]).mType;
      for (int j = 0; j < (paramArrayOfPathDataNode[i]).mParams.length; j++)
        (arrayOfPathDataNode[i]).mParams[j] = (paramArrayOfPathDataNode[i]).mParams[j]; 
    } 
  }
  
  public final void toPath(Path paramPath) {
    paramPath.reset();
    if (this.mNodes != null)
      PathParser.PathDataNode.nodesToPath(this.mNodes, paramPath); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\graphics\drawable\VectorDrawableCompat$VPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */