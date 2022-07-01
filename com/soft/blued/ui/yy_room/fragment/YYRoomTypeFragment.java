package com.soft.blued.ui.yy_room.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.ui.yy_room.presenter.YYRoomTypePresenter;

public class YYRoomTypeFragment extends MvpFragment<YYRoomTypePresenter> implements View.OnClickListener {
  private String d;
  
  @BindView(2131299790)
  RecyclerView rvRoomListVew;
  
  @BindView(2131300683)
  ShapeTextView tvCreateRoom;
  
  @BindView(2131301213)
  ShapeTextView tvRandomEnter;
  
  private void k() {}
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.tvCreateRoom.setOnClickListener(this);
    this.tvRandomEnter.setOnClickListener(this);
    k();
  }
  
  public void o() {
    super.o();
    if (getArguments() == null)
      return; 
    this.d = getArguments().getString("yy_room_type_id");
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131300683)
      return; 
    if (getParentFragment() instanceof YYChatRoomsFragment)
      ((YYChatRoomsFragment)getParentFragment()).c(this.d); 
  }
  
  public int p() {
    return 2131493378;
  }
  
  public String q() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("YYRoomTypeFragment");
    stringBuilder.append(this.d);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\fragment\YYRoomTypeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */