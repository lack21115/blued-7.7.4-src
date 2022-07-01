package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.view.pulltorefresh.RecyclerViewSpacing;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.liveForMsg.data.LiveMsgPeopleAdapter;
import com.blued.android.module.live_china.manager.LiveRoomManager;

public class LiveViewerListView extends FrameLayout {
  private Context a;
  
  private LayoutInflater b;
  
  private View c;
  
  private RecyclerView d;
  
  private LiveMsgPeopleAdapter e;
  
  public LiveViewerListView(Context paramContext) {
    this(paramContext, null);
  }
  
  public LiveViewerListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    d();
  }
  
  private void d() {
    this.b = LayoutInflater.from(this.a);
    this.c = this.b.inflate(R.layout.live_viewer_list_view, (ViewGroup)this, true);
    this.d = (RecyclerView)this.c.findViewById(R.id.live_viewer_listview);
    this.d.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this.a, 0, false));
    this.d.addItemDecoration((RecyclerView.ItemDecoration)new RecyclerViewSpacing(this.a, 0, 1));
    this.e = new LiveMsgPeopleAdapter(this.a);
    this.d.setAdapter((RecyclerView.Adapter)this.e);
  }
  
  public void a() {
    if (LiveRoomManager.a().h() == null)
      return; 
    this.e.a();
  }
  
  public void b() {
    this.d.setVisibility(8);
  }
  
  public void c() {
    this.d.setVisibility(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveViewerListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */