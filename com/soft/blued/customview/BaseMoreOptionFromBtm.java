package com.soft.blued.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.module_share_china.R;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.BaseShareEntity;
import com.soft.blued.ui.share_custom.Model.ShareOption;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseMoreOptionFromBtm {
  public Context a;
  
  protected BaseShareEntity b;
  
  protected String c = "";
  
  public boolean d = false;
  
  public boolean e = false;
  
  private ShareOptionRecyclerAdapter f;
  
  private ShareOptionRecyclerAdapter g;
  
  private List<ShareOption> h;
  
  private List<ShareOption> i;
  
  private View j;
  
  private PopMenuFromBottom k;
  
  private TextView l;
  
  public BaseMoreOptionFromBtm(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener) {
    this.a = paramContext;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.h = new ArrayList<ShareOption>();
    this.h.add(new ShareOption(R.drawable.icon_share_to_people, R.string.share_to_friends));
    this.h.add(new ShareOption(R.drawable.icon_share_to_feed, R.string.common_main_feed));
    this.h.add(new ShareOption(R.drawable.icon_share_to_wechat, R.string.ssdk_wechat));
    this.h.add(new ShareOption(R.drawable.icon_share_to_wechat_moment, R.string.ssdk_wechatmoments));
    this.h.add(new ShareOption(R.drawable.icon_share_to_qq, R.string.ssdk_qq));
    this.h.add(new ShareOption(R.drawable.icon_share_to_sina_weibo, R.string.ssdk_sinaweibo));
    this.i = new ArrayList<ShareOption>();
    List<ShareOption> list = a();
    if (list != null && list.size() > 0)
      this.i.addAll(list); 
    this.f = new ShareOptionRecyclerAdapter(paramContext, this.h, false);
    this.g = new ShareOptionRecyclerAdapter(paramContext, this.i, false);
    this.j = LayoutInflater.from(paramContext).inflate(R.layout.more_options_common_layout, null);
    this.l = (TextView)this.j.findViewById(R.id.tv_cancel);
    RecyclerView recyclerView2 = (RecyclerView)this.j.findViewById(R.id.lv_share_options);
    RecyclerView recyclerView1 = (RecyclerView)this.j.findViewById(R.id.lv_other_options);
    LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(paramContext);
    linearLayoutManager2.setStackFromEnd(true);
    linearLayoutManager2.setOrientation(0);
    linearLayoutManager2.scrollToPosition(0);
    recyclerView2.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager2);
    recyclerView2.setHasFixedSize(true);
    recyclerView2.setAdapter((RecyclerView.Adapter)this.f);
    this.f.notifyDataSetChanged();
    LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(paramContext);
    linearLayoutManager1.setStackFromEnd(true);
    linearLayoutManager1.setOrientation(0);
    linearLayoutManager1.scrollToPosition(0);
    recyclerView1.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager1);
    recyclerView1.setHasFixedSize(true);
    recyclerView1.setAdapter((RecyclerView.Adapter)this.g);
    this.g.notifyDataSetChanged();
    ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener = new ShareOptionRecyclerAdapter.ShareOptionsItemClickListener(this) {
        public void onItemClick(int param1Int) {
          this.a.a(param1Int);
        }
      };
    this.f.a(shareOptionsItemClickListener);
    this.g.a(shareOptionsItemClickListener);
    this.k = new PopMenuFromBottom(paramContext, this.j);
    this.l.setOnClickListener(new View.OnClickListener(this, paramOnClickListener) {
          public void onClick(View param1View) {
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null)
              onClickListener.onClick(param1View); 
            BaseMoreOptionFromBtm.a(this.b).d();
          }
        });
  }
  
  public abstract List<ShareOption> a();
  
  protected void a(int paramInt) {
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            BaseMoreOptionFromBtm.a(this.a).d();
          }
        },  300L);
  }
  
  protected void a(BaseShareEntity paramBaseShareEntity) {
    this.b = paramBaseShareEntity;
    a(this.h, this.i);
    this.f.notifyDataSetChanged();
    this.g.notifyDataSetChanged();
    this.k.e();
  }
  
  public abstract void a(List<ShareOption> paramList1, List<ShareOption> paramList2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\BaseMoreOptionFromBtm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */