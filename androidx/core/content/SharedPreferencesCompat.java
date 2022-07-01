package androidx.core.content;

import android.content.SharedPreferences;

@Deprecated
public final class SharedPreferencesCompat {
  @Deprecated
  public static final class EditorCompat {
    private static EditorCompat a;
    
    private final Helper b = new Helper();
    
    @Deprecated
    public static EditorCompat getInstance() {
      if (a == null)
        a = new EditorCompat(); 
      return a;
    }
    
    @Deprecated
    public void apply(SharedPreferences.Editor param1Editor) {
      this.b.apply(param1Editor);
    }
    
    static class Helper {
      public void apply(SharedPreferences.Editor param2Editor) {
        try {
          param2Editor.apply();
          return;
        } catch (AbstractMethodError abstractMethodError) {
          param2Editor.commit();
          return;
        } 
      }
    }
  }
  
  static class Helper {
    public void apply(SharedPreferences.Editor param1Editor) {
      try {
        param1Editor.apply();
        return;
      } catch (AbstractMethodError abstractMethodError) {
        param1Editor.commit();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\content\SharedPreferencesCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */