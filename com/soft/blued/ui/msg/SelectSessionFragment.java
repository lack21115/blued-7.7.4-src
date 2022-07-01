package com.soft.blued.ui.msg;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.msg.adapter.SelectSessionAdapter;
import com.soft.blued.ui.msg.presenter.SelectSessionPresenter;
import com.soft.blued.ui.setting.event.SelectSessionEvent;
import com.soft.blued.utils.RecyclerViewAnimUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectSessionFragment extends MvpFragment<SelectSessionPresenter> {
  SelectSessionAdapter d;
  
  @BindView(2131299601)
  RecyclerView recyclerView;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans top_title;
  
  @BindView(2131300509)
  TextView tv_all;
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.top_title.setCenterText("选择会话");
    this.top_title.setRightText("完成");
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    RecyclerViewAnimUtil.a(this.recyclerView);
    this.d = new SelectSessionAdapter((IRequestHost)w_());
    this.d.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            SessionModel sessionModel = param1BaseQuickAdapter.n().get(param1Int);
            sessionModel.checked ^= 0x1;
            param1BaseQuickAdapter.notifyItemChanged(param1Int);
          }
        });
    this.recyclerView.setAdapter((RecyclerView.Adapter)this.d);
    this.top_title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    this.top_title.setRightClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ArrayList<Long> arrayList = new ArrayList();
            for (SessionModel sessionModel : this.a.d.n()) {
              if (sessionModel.checked)
                arrayList.add(Long.valueOf(sessionModel.sessionId)); 
            } 
            SelectSessionEvent selectSessionEvent = new SelectSessionEvent();
            selectSessionEvent.a = arrayList;
            LiveEventBus.get("select_session").post(selectSessionEvent);
            this.a.C();
          }
        });
    this.tv_all.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            Iterator iterator = this.a.d.n().iterator();
            while (iterator.hasNext())
              ((SessionModel)iterator.next()).checked = true; 
            this.a.d.notifyDataSetChanged();
          }
        });
  }
  
  public void a(List<SessionModel> paramList) {
    Iterator<SessionModel> iterator = paramList.iterator();
    while (iterator.hasNext())
      ((SessionModel)iterator.next()).checked = false; 
    this.d.c(paramList);
  }
  
  public int p() {
    return 2131493064;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\SelectSessionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */