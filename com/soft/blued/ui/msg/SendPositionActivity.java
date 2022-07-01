package com.soft.blued.ui.msg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.DelayRepeatTaskUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.location.LocationService;
import com.blued.android.module.location.View.MapViews;
import com.blued.android.module.location.model.LocationPOIModel;
import com.blued.android.statistics.BluedStatistics;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.msg.model.PositionPOIModel;
import com.soft.blued.utils.StringUtils;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;

public class SendPositionActivity extends BaseFragmentActivity implements View.OnClickListener {
  List<PositionPOIModel> c;
  
  private RenrenPullToRefreshListView d;
  
  private ListView e;
  
  private SendPositionPOIAdapter f;
  
  private Context g;
  
  private View h;
  
  private MapViews i;
  
  private double j;
  
  private double k;
  
  private String l;
  
  private CommonTopTitleNoTrans m;
  
  private void h() {
    this.c = new ArrayList<PositionPOIModel>();
    this.c.clear();
    this.m = (CommonTopTitleNoTrans)findViewById(2131300300);
    this.m.setLeftClickListener(this);
    this.m.setCenterText(this.g.getResources().getString(2131758405));
    this.m.setRightText(this.g.getResources().getString(2131758680));
    this.m.setRightTextColor(2131100838);
    this.m.setRightClickListener(this);
    this.h = findViewById(2131301301);
    this.h.setOnClickListener(this);
    this.d = (RenrenPullToRefreshListView)findViewById(2131298144);
    this.d.setRefreshEnabled(false);
    this.d.p();
    this.e = (ListView)this.d.getRefreshableView();
    this.e.setClipToPadding(false);
    this.e.setScrollBarStyle(33554432);
    this.e.setHeaderDividersEnabled(false);
    this.e.setDividerHeight(1);
    this.e.setDivider(getResources().getDrawable(2131232935));
    this.f = new SendPositionPOIAdapter(this, (Context)this);
    this.e.setAdapter((ListAdapter)this.f);
  }
  
  public void a(double paramDouble1, double paramDouble2) {
    LocationService.a((LifecycleOwner)this, 0, String.valueOf(paramDouble2), String.valueOf(paramDouble1), new -$$Lambda$SendPositionActivity$9MU4bmQnMweoqae-EgDUmhEo44M(this));
  }
  
  public void a(List<LocationPOIModel> paramList) {
    ArrayList<PositionPOIModel> arrayList = new ArrayList();
    if (paramList != null && paramList.size() > 0)
      for (int i = 0; i < paramList.size(); i++) {
        PositionPOIModel positionPOIModel = PositionPOIModel.getFromLocationPOIModel(paramList.get(i));
        if (i == 0) {
          positionPOIModel.mark_visible = true;
          if (StringUtils.e(positionPOIModel.address))
            positionPOIModel.address = positionPOIModel.name; 
          positionPOIModel.name = getResources().getString(2131758408);
          this.l = positionPOIModel.address;
        } 
        arrayList.add(positionPOIModel);
      }  
    this.f.a(arrayList);
    this.e.setSelection(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramIntent != null && paramInt2 == -1) {
      double d1 = paramIntent.getDoubleExtra("lot", this.k);
      double d2 = paramIntent.getDoubleExtra("lat", this.j);
      this.i.a(String.valueOf(Double.valueOf(d2)), String.valueOf(Double.valueOf(d1)));
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867) {
        if (i != 2131301301)
          return; 
        PermissionHelper.c(new PermissionCallbacks(this) {
              public void a(String[] param1ArrayOfString) {}
              
              public void aa_() {
                TerminalActivity.a((Context)this.a, SendPositionSearchFragment.class, null, 0);
              }
            });
        return;
      } 
      if (this.f.getCount() == 0) {
        AppMethods.d(2131757794);
        return;
      } 
      Intent intent = new Intent();
      double d = this.k;
      if (d == Double.MIN_VALUE || this.j == Double.MIN_VALUE || d == 0.0D) {
        intent.putExtra("lot", "");
        intent.putExtra("lat", "");
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.k);
        stringBuilder.append("");
        intent.putExtra("lot", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.j);
        stringBuilder.append("");
        intent.putExtra("lat", stringBuilder.toString());
      } 
      if (!TextUtils.isEmpty(this.l))
        intent.putExtra("address", this.l.replace(",", ".")); 
      if (CommonTools.a((Activity)this)) {
        setResult(-1, intent);
        finish();
        return;
      } 
    } else {
      finish();
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492907);
    this.g = (Context)this;
    h();
    this.i = (MapViews)findViewById(2131299198);
    this.i.a(this.g, paramBundle, null);
    this.i.b();
    this.i.setPositionMovedListener(new -$$Lambda$SendPositionActivity$hlxIh9kQP45p6ajJeoxBJZuC-8A(this));
  }
  
  public void onDestroy() {
    super.onDestroy();
    MapViews mapViews = this.i;
    if (mapViews != null)
      mapViews.e(); 
  }
  
  public void onPause() {
    super.onPause();
    MobclickAgent.onPageEnd(SendPositionActivity.class.getSimpleName());
    MobclickAgent.onPause((Context)this);
    MapViews mapViews = this.i;
    if (mapViews != null)
      mapViews.d(); 
  }
  
  public void onResume() {
    super.onResume();
    MobclickAgent.onPageStart(SendPositionActivity.class.getSimpleName());
    MobclickAgent.onResume((Context)this);
    MapViews mapViews = this.i;
    if (mapViews != null)
      mapViews.c(); 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    MapViews mapViews = this.i;
    if (mapViews != null)
      mapViews.a(paramBundle); 
  }
  
  public class SendPositionPOIAdapter extends BaseAdapter {
    private Context b;
    
    private LayoutInflater c;
    
    private List<PositionPOIModel> d = new ArrayList<PositionPOIModel>();
    
    private int e;
    
    public SendPositionPOIAdapter(SendPositionActivity this$0, Context param1Context) {
      this.b = param1Context;
      this.c = LayoutInflater.from(param1Context);
      this.e = (param1Context.getResources().getDisplayMetrics()).widthPixels;
    }
    
    public void a(List<PositionPOIModel> param1List) {
      this.d.clear();
      if (param1List != null && param1List.size() > 0)
        this.d.addAll(param1List); 
      notifyDataSetChanged();
    }
    
    public int getCount() {
      return this.d.size();
    }
    
    public Object getItem(int param1Int) {
      return Integer.valueOf(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      ViewHolder viewHolder1;
      ViewHolder viewHolder2;
      if (param1View == null) {
        viewHolder1 = new ViewHolder();
        View view = this.c.inflate(2131493646, param1ViewGroup, false);
        viewHolder1.a = (LinearLayout)view.findViewById(2131298900);
        viewHolder1.b = (TextView)view.findViewById(2131301177);
        viewHolder1.c = (TextView)view.findViewById(2131301176);
        viewHolder1.d = (ImageView)view.findViewById(2131297455);
        view.setTag(viewHolder1);
      } else {
        ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
        viewHolder2 = viewHolder1;
        viewHolder1 = viewHolder;
      } 
      PositionPOIModel positionPOIModel = this.d.get(param1Int);
      viewHolder1.b.setText(positionPOIModel.name);
      viewHolder1.c.setText(positionPOIModel.address);
      if (positionPOIModel.mark_visible) {
        viewHolder1.d.setVisibility(0);
      } else {
        viewHolder1.d.setVisibility(4);
      } 
      viewHolder1.a.setOnClickListener(new -$$Lambda$SendPositionActivity$SendPositionPOIAdapter$YTeYCjnJNUIHT3Raa3xpiqShHEQ(this, positionPOIModel, param1Int));
      return (View)viewHolder2;
    }
    
    class ViewHolder {
      public LinearLayout a;
      
      public TextView b;
      
      public TextView c;
      
      public ImageView d;
      
      private ViewHolder(SendPositionActivity.SendPositionPOIAdapter this$0) {}
    }
  }
  
  class ViewHolder {
    public LinearLayout a;
    
    public TextView b;
    
    public TextView c;
    
    public ImageView d;
    
    private ViewHolder(SendPositionActivity this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\SendPositionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */