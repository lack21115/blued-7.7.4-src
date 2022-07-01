package androidx.appcompat.app;

import androidx.appcompat.view.ActionMode;

public interface AppCompatCallback {
  void onSupportActionModeFinished(ActionMode paramActionMode);
  
  void onSupportActionModeStarted(ActionMode paramActionMode);
  
  ActionMode onWindowStartingSupportActionMode(ActionMode.Callback paramCallback);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\app\AppCompatCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */