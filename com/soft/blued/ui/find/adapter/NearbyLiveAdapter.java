package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class NearbyLiveAdapter extends BaseAdapter {
  private static final int[] h = new int[] { 2131296892, 2131296894, 2131296893 };
  
  public List<List<BluedLiveListData>> a;
  
  public List<BluedLiveListData> b;
  
  public int c = -1;
  
  public Context d;
  
  public LayoutInflater e;
  
  private IRequestHost f;
  
  private HashSet<String> g = new HashSet<String>();
  
  public NearbyLiveAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    this.d = paramContext;
    this.f = paramIRequestHost;
    this.e = LayoutInflater.from(paramContext);
    this.a = new ArrayList<List<BluedLiveListData>>();
    this.b = new ArrayList<BluedLiveListData>();
  }
  
  private void a(BluedLiveListData paramBluedLiveListData) {
    if (!this.g.contains(paramBluedLiveListData.lid)) {
      paramBluedLiveListData.sort = DistanceUtils.a(paramBluedLiveListData.sort, BlueAppLocal.c(), false);
      int i = this.c;
      if (i != -1 && i < this.a.size()) {
        List<BluedLiveListData> list = this.a.get(this.c);
        if (list.size() <= 2) {
          list.add(paramBluedLiveListData);
          this.g.add(paramBluedLiveListData.lid);
          return;
        } 
        this.c = -1;
        a(paramBluedLiveListData);
        return;
      } 
      ArrayList<BluedLiveListData> arrayList = new ArrayList();
      arrayList.add(paramBluedLiveListData);
      this.g.add(paramBluedLiveListData.lid);
      this.a.add(arrayList);
      this.c = this.a.size() - 1;
    } 
  }
  
  public void a() {
    Iterator<BluedLiveListData> iterator = this.b.iterator();
    while (iterator.hasNext()) {
      a(iterator.next());
      iterator.remove();
    } 
    notifyDataSetChanged();
  }
  
  public void a(List<BluedLiveListData> paramList) {
    if (paramList != null && paramList.size() > 0 && this.a != null) {
      int i = this.b.size();
      boolean bool = false;
      if (i > 0)
        for (i = 0; i < this.b.size(); i++)
          a(this.b.get(i));  
      for (i = 0; i < paramList.size(); i++)
        a(paramList.get(i)); 
      if (this.c != -1) {
        for (i = bool; i < ((List)this.a.get(this.c)).size(); i++) {
          this.b.add(((List<BluedLiveListData>)this.a.get(this.c)).get(i));
          this.g.remove(((BluedLiveListData)((List)this.a.get(this.c)).get(i)).lid);
        } 
        this.a.remove(this.c);
        this.c = -1;
      } 
      notifyDataSetChanged();
    } 
  }
  
  public void b(List<BluedLiveListData> paramList) {
    if (this.a != null) {
      this.g.clear();
      this.a.clear();
      this.b.clear();
      this.c = -1;
      a(paramList);
    } 
  }
  
  public int getCount() {
    List<List<BluedLiveListData>> list = this.a;
    return (list != null) ? list.size() : 0;
  }
  
  public Object getItem(int paramInt) {
    return null;
  }
  
  public long getItemId(int paramInt) {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder(this);
      View view = this.e.inflate(2131493612, paramViewGroup, false);
      viewHolder1.a = new View[3];
      viewHolder1.b = view.findViewById(2131297648);
      int i;
      for (i = 0; i < 3; i++) {
        viewHolder1.a[i] = view.findViewById(h[i]);
        viewHolder1.a[i].findViewById(2131297581).setVisibility(8);
      } 
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    List<BluedLiveListData> list = this.a.get(paramInt);
    if (paramInt == 0) {
      viewHolder1.b.setPadding(viewHolder1.b.getPaddingLeft(), DensityUtils.a(this.d, 8.0F), viewHolder1.b.getPaddingRight(), viewHolder1.b.getPaddingBottom());
    } else {
      viewHolder1.b.setPadding(viewHolder1.b.getPaddingLeft(), 0, viewHolder1.b.getPaddingRight(), viewHolder1.b.getPaddingBottom());
    } 
    for (paramInt = 0; paramInt < 3; paramInt++) {
      View view = viewHolder1.a[paramInt];
      ImageView imageView1 = (ImageView)view.findViewById(2131296342);
      TextView textView1 = (TextView)view.findViewById(2131300537);
      TextView textView2 = (TextView)view.findViewById(2131301479);
      TextView textView3 = (TextView)view.findViewById(2131300715);
      ImageView imageView2 = (ImageView)view.findViewById(2131297468);
      ImageView imageView3 = (ImageView)view.findViewById(2131297283);
      ImageView imageView4 = (ImageView)view.findViewById(2131297581);
      if (paramInt >= list.size()) {
        viewHolder1.a[paramInt].setVisibility(4);
      } else {
        viewHolder1.a[paramInt].setVisibility(0);
        imageView2.setVisibility(0);
        BluedLiveListData bluedLiveListData = list.get(paramInt);
        ImageLoader.a(this.f, bluedLiveListData.anchor.avatar).a(2131232977).a(2.0F).a(imageView1);
        if (bluedLiveListData.hb > 0) {
          imageView3.setVisibility(0);
        } else {
          imageView3.setVisibility(8);
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bluedLiveListData.realtime_count);
        stringBuilder.append("");
        if (!TextUtils.isEmpty(stringBuilder.toString())) {
          textView1.setText(AreaUtils.a(this.d, bluedLiveListData.realtime_count));
        } else {
          textView1.setText("");
        } 
        if (bluedLiveListData.anchor != null && !StringUtils.e(bluedLiveListData.anchor.name)) {
          textView2.setText(bluedLiveListData.anchor.name);
        } else {
          textView2.setText("");
        } 
        UserRelationshipUtils.a(this.d, textView2, bluedLiveListData.anchor);
        if (bluedLiveListData.anchor.vip_grade == 0) {
          imageView4.setVisibility(8);
        } else {
          imageView4.setVisibility(0);
          int j = bluedLiveListData.anchor.vip_grade;
          if (j != 1) {
            if (j == 2)
              imageView4.setImageResource(2131232733); 
          } else {
            imageView4.setImageResource(2131232816);
          } 
        } 
        textView2.setOnClickListener(new View.OnClickListener(this, bluedLiveListData) {
              public void onClick(View param1View) {
                this.a.anchor.uid = this.a.uid;
                UserInfoFragmentNew.a(this.b.d, this.a.anchor, "module_detail0", false, null);
              }
            });
        textView3.setVisibility(0);
        if (!StringUtils.e(bluedLiveListData.sort)) {
          textView3.setText(bluedLiveListData.sort);
        } else {
          textView3.setText("");
        } 
        DistanceUtils.a(this.d, textView3, bluedLiveListData.anchor.is_hide_distance, 0);
        int i = bluedLiveListData.screen_pattern;
        String str1 = bluedLiveListData.anchor.avatar;
        String str2 = bluedLiveListData.pic_url;
        str2 = bluedLiveListData.lid;
        String str3 = bluedLiveListData.anchor.name;
        imageView1.setOnClickListener(new View.OnClickListener(this, str2, i, bluedLiveListData.uid, str3, str1, bluedLiveListData.anchor.vbadge) {
              public void onClick(View param1View) {
                ArrayList<BluedLiveListData> arrayList = new ArrayList();
                Iterator<List<BluedLiveListData>> iterator = this.g.a.iterator();
                while (iterator.hasNext()) {
                  Iterator<BluedLiveListData> iterator1 = ((List)iterator.next()).iterator();
                  while (iterator1.hasNext())
                    arrayList.add(iterator1.next()); 
                } 
                InstantLog.b("nearby_model_detail", 0);
                LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(this.a, 0L), this.b, "module_detail0", this.c, this.d, this.e, this.f);
                LiveRoomInfoChannel.a(this.g.d, liveRoomData, -1, LiveRoomInfoChannel.a(arrayList, "module_detail0"));
              }
            });
      } 
    } 
    return (View)viewHolder2;
  }
  
  public class ViewHolder {
    public View[] a;
    
    public View b;
    
    public ViewHolder(NearbyLiveAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\NearbyLiveAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */