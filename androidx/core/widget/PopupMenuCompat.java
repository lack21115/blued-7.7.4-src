package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupMenu;

public final class PopupMenuCompat {
  public static View.OnTouchListener getDragToOpenListener(Object paramObject) {
    return (Build.VERSION.SDK_INT >= 19) ? ((PopupMenu)paramObject).getDragToOpenListener() : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\widget\PopupMenuCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */