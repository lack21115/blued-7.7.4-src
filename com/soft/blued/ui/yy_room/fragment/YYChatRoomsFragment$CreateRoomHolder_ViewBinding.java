package com.soft.blued.ui.yy_room.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;

public class YYChatRoomsFragment$CreateRoomHolder_ViewBinding implements Unbinder {
  private YYChatRoomsFragment.CreateRoomHolder b;
  
  public YYChatRoomsFragment$CreateRoomHolder_ViewBinding(YYChatRoomsFragment.CreateRoomHolder paramCreateRoomHolder, View paramView) {
    this.b = paramCreateRoomHolder;
    paramCreateRoomHolder.listView = (RecyclerView)Utils.a(paramView, 2131300305, "field 'listView'", RecyclerView.class);
    paramCreateRoomHolder.tvCreate = (ShapeTextView)Utils.a(paramView, 2131300682, "field 'tvCreate'", ShapeTextView.class);
    paramCreateRoomHolder.tvCancel = (ImageView)Utils.a(paramView, 2131300611, "field 'tvCancel'", ImageView.class);
    paramCreateRoomHolder.etRoomName = (EditText)Utils.a(paramView, 2131297013, "field 'etRoomName'", EditText.class);
  }
  
  public void unbind() {
    YYChatRoomsFragment.CreateRoomHolder createRoomHolder = this.b;
    if (createRoomHolder != null) {
      this.b = null;
      createRoomHolder.listView = null;
      createRoomHolder.tvCreate = null;
      createRoomHolder.tvCancel = null;
      createRoomHolder.etRoomName = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\fragment\YYChatRoomsFragment$CreateRoomHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */