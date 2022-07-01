package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.ContextThemeWrapper;

public interface ThemedSpinnerAdapter extends SpinnerAdapter {
  Resources.Theme getDropDownViewTheme();
  
  void setDropDownViewTheme(Resources.Theme paramTheme);
  
  public static final class Helper {
    private final Context a;
    
    private final LayoutInflater b;
    
    private LayoutInflater c;
    
    public Helper(Context param1Context) {
      this.a = param1Context;
      this.b = LayoutInflater.from(param1Context);
    }
    
    public LayoutInflater getDropDownViewInflater() {
      LayoutInflater layoutInflater = this.c;
      return (layoutInflater != null) ? layoutInflater : this.b;
    }
    
    public Resources.Theme getDropDownViewTheme() {
      LayoutInflater layoutInflater = this.c;
      return (layoutInflater == null) ? null : layoutInflater.getContext().getTheme();
    }
    
    public void setDropDownViewTheme(Resources.Theme param1Theme) {
      if (param1Theme == null) {
        this.c = null;
        return;
      } 
      if (param1Theme == this.a.getTheme()) {
        this.c = this.b;
        return;
      } 
      this.c = LayoutInflater.from((Context)new ContextThemeWrapper(this.a, param1Theme));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ThemedSpinnerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */