package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.VerticalRecyclerView;
import com.soft.blued.ui.msg.adapter.BottomMenuAdapter;
import java.util.List;

public class BottomMenuPop extends BottomPopupView {
  public List<MenuItemInfo> b;
  
  public View.OnClickListener c;
  
  public BottomMenuPop(Context paramContext) {
    super(paramContext);
  }
  
  public void b() {
    super.b();
    VerticalRecyclerView verticalRecyclerView = (VerticalRecyclerView)findViewById(2131299605);
    List<MenuItemInfo> list = this.b;
    if (list != null) {
      verticalRecyclerView.setAdapter((RecyclerView.Adapter)new BottomMenuAdapter(list));
      verticalRecyclerView.v();
    } 
    ShapeTextView shapeTextView = (ShapeTextView)findViewById(2131300611);
    ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView, 2131100728);
    ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, 2131100838);
    shapeTextView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.p();
            if (this.a.c != null)
              this.a.c.onClick(param1View); 
          }
        });
  }
  
  public int getImplLayoutId() {
    return 2131494029;
  }
  
  public static class MenuItemInfo {
    public String a;
    
    public int b = 2131100838;
    
    public View.OnClickListener c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\pop\BottomMenuPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */