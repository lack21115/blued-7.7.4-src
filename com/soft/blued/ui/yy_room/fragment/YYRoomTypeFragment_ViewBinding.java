package com.soft.blued.ui.yy_room.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;

public class YYRoomTypeFragment_ViewBinding implements Unbinder {
  private YYRoomTypeFragment b;
  
  public YYRoomTypeFragment_ViewBinding(YYRoomTypeFragment paramYYRoomTypeFragment, View paramView) {
    this.b = paramYYRoomTypeFragment;
    paramYYRoomTypeFragment.rvRoomListVew = (RecyclerView)Utils.a(paramView, 2131299790, "field 'rvRoomListVew'", RecyclerView.class);
    paramYYRoomTypeFragment.tvCreateRoom = (ShapeTextView)Utils.a(paramView, 2131300683, "field 'tvCreateRoom'", ShapeTextView.class);
    paramYYRoomTypeFragment.tvRandomEnter = (ShapeTextView)Utils.a(paramView, 2131301213, "field 'tvRandomEnter'", ShapeTextView.class);
  }
  
  public void unbind() {
    YYRoomTypeFragment yYRoomTypeFragment = this.b;
    if (yYRoomTypeFragment != null) {
      this.b = null;
      yYRoomTypeFragment.rvRoomListVew = null;
      yYRoomTypeFragment.tvCreateRoom = null;
      yYRoomTypeFragment.tvRandomEnter = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\fragment\YYRoomTypeFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */