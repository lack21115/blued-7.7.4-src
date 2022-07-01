package com.blued.android.module.yy_china.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.adapter.BaseGiftAdapter;
import com.blued.android.module.common.fragment.BaseGiftPageFragment;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYGiftAdapter;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class YYGiftPageFragment extends BaseGiftPageFragment {
  public int k() {
    return R.layout.fragment_yy_gift_page;
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    LiveEventBus.get("gift_free_time", Integer.class).observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            GridLayoutManager gridLayoutManager;
            try {
              gridLayoutManager = (GridLayoutManager)YYGiftPageFragment.a(this.a).getLayoutManager();
              if (gridLayoutManager == null)
                return; 
            } catch (Exception exception) {
              exception.printStackTrace();
              return;
            } 
            int i;
            for (i = 0; i < YYGiftPageFragment.b(this.a).getItemCount(); i++) {
              YYGiftModel yYGiftModel = YYGiftPageFragment.c(this.a).a().get(i);
              if (TextUtils.equals(yYGiftModel.is_free, "1")) {
                View view = gridLayoutManager.findViewByPosition(i);
                if (view != null) {
                  TextView textView = (TextView)view.findViewById(R.id.item_live_gift_price);
                  if (textView != null) {
                    if (exception.intValue() < 60) {
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append(exception);
                      stringBuilder.append("s");
                      yYGiftModel.setFreeTime(stringBuilder.toString());
                    } else {
                      yYGiftModel.setFreeTime("0豆");
                    } 
                    textView.setText(yYGiftModel.getFreeTime());
                    return;
                  } 
                } 
              } 
            } 
          }
        });
  }
  
  public void r() {
    this.h.addItemDecoration(new RecyclerView.ItemDecoration(this) {
          public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            if (param1RecyclerView.getChildAdapterPosition(param1View) % 4 == 0) {
              param1Rect.right = DensityUtils.a(this.a.getContext(), 5.0F);
            } else {
              param1Rect.right = DensityUtils.a(this.a.getContext(), 5.0F);
            } 
            param1Rect.bottom = DensityUtils.a(this.a.getContext(), 5.0F);
          }
        });
    this.i = (BaseGiftAdapter)new YYGiftAdapter((BaseFragment)this, this.n);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYGiftPageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */