package com.soft.blued.ui.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.live.adapter.PKLiveRecyclerAdapter;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.List;

public class PKLiveHorizontalView extends LinearLayout {
  public Context a;
  
  public View b;
  
  private TextView c;
  
  private RecyclerView d;
  
  private PKLiveRecyclerAdapter e;
  
  private TextView f;
  
  private ImageView g;
  
  public PKLiveHorizontalView(Context paramContext) {
    this(paramContext, null);
  }
  
  public PKLiveHorizontalView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PKLiveHorizontalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public void a(Context paramContext) {
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a).inflate(2131493786, (ViewGroup)this);
    this.c = (TextView)this.b.findViewById(2131300995);
    this.f = (TextView)this.b.findViewById(2131300987);
    this.g = (ImageView)this.b.findViewById(2131297833);
    this.d = (RecyclerView)this.b.findViewById(2131299778);
    CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(this, this.a);
    customLinearLayoutManager.setStackFromEnd(true);
    customLinearLayoutManager.setOrientation(0);
    customLinearLayoutManager.scrollToPosition(0);
    this.d.setLayoutManager((RecyclerView.LayoutManager)customLinearLayoutManager);
    this.e = new PKLiveRecyclerAdapter(this.a);
    setVisibility(8);
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            WebViewShowInfoFragment.a(AppInfo.d(), H5Url.a(4), this.a.a.getString(2131757565), 0);
          }
        });
  }
  
  public void a(IRequestHost paramIRequestHost, List<BluedLiveListData> paramList, BluedLiveListData paramBluedLiveListData, boolean paramBoolean) {
    if (paramBluedLiveListData.hotpk_list != null) {
      setVisibility(0);
      this.e.a(paramIRequestHost, paramList);
      this.e.c(paramBluedLiveListData.hotpk_list);
      this.d.setAdapter((RecyclerView.Adapter)this.e);
      this.e.notifyDataSetChanged();
    } else {
      setVisibility(8);
    } 
    if (paramBoolean) {
      this.f.setVisibility(0);
      this.g.setVisibility(0);
      InstantLog.a("live_list_pk_more_show");
      return;
    } 
    this.f.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  public RecyclerView getListView() {
    return this.d;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public class CustomLinearLayoutManager extends LinearLayoutManager {
    public CustomLinearLayoutManager(PKLiveHorizontalView this$0, Context param1Context) {
      super(param1Context);
    }
    
    public boolean canScrollVertically() {
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\view\PKLiveHorizontalView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */