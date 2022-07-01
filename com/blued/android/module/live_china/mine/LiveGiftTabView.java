package com.blued.android.module.live_china.mine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.blued.android.module.common.view.CommonGiftTabView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftPackageModel;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;

public class LiveGiftTabView extends CommonGiftTabView<LiveGiftPackageModel> {
  public LiveGiftTabView(Context paramContext) {
    super(paramContext);
  }
  
  public LiveGiftTabView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public int getItemViewLayoutId() {
    return R.layout.live_gift_tab_item_layout;
  }
  
  public void setToolBtnSelect(int paramInt) {
    for (int i = 0; i < this.d.size(); i++) {
      TextView textView = (TextView)((View)this.d.get(i)).findViewById(R.id.common_tab_view_item_name);
      if (i == paramInt) {
        textView.setTextColor(getContext().getResources().getColor(R.color.syc_FFB119));
      } else {
        textView.setTextColor(getContext().getResources().getColor(R.color.syc_dark_j));
      } 
    } 
    if (this.d.size() > 1) {
      View view = ((View)this.d.get(1)).findViewById(R.id.live_gift_tab_item_dot);
      if (paramInt == 1) {
        if (LiveRoomManager.a().i() != null && (LiveRoomManager.a().i()).level >= 16 && !LiveRoomPreferences.M() && !LiveFloatManager.a().B()) {
          LiveRoomPreferences.N();
          view.setVisibility(8);
          return;
        } 
      } else if (LiveRoomManager.a().i() != null && (LiveRoomManager.a().i()).level >= 16 && !LiveRoomPreferences.M() && !LiveFloatManager.a().B()) {
        view.setVisibility(0);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\mine\LiveGiftTabView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */