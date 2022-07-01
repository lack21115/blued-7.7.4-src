package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

public final class DragAndDropPermissionsCompat {
  private Object a;
  
  private DragAndDropPermissionsCompat(Object paramObject) {
    this.a = paramObject;
  }
  
  public static DragAndDropPermissionsCompat request(Activity paramActivity, DragEvent paramDragEvent) {
    if (Build.VERSION.SDK_INT >= 24) {
      DragAndDropPermissions dragAndDropPermissions = paramActivity.requestDragAndDropPermissions(paramDragEvent);
      if (dragAndDropPermissions != null)
        return new DragAndDropPermissionsCompat(dragAndDropPermissions); 
    } 
    return null;
  }
  
  public void release() {
    if (Build.VERSION.SDK_INT >= 24)
      ((DragAndDropPermissions)this.a).release(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\DragAndDropPermissionsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */