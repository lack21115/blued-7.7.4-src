package com.soft.blued.ui.group.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.group.GroupMembersListFragment;
import com.soft.blued.ui.group.model.BluedGroupAllMembers;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public class GroupMemberListAdapter extends BaseAdapter {
  public boolean a;
  
  private LayoutInflater b;
  
  private Context c;
  
  private List<BluedGroupAllMembers> d;
  
  private LoadOptions e;
  
  private String f;
  
  private String g;
  
  private TextView h;
  
  private TextView i;
  
  private IRequestHost j;
  
  public GroupMemberListAdapter(Context paramContext, IRequestHost paramIRequestHost, List<BluedGroupAllMembers> paramList, TextView paramTextView1, TextView paramTextView2) {
    this.c = paramContext;
    this.j = paramIRequestHost;
    this.d = paramList;
    this.b = LayoutInflater.from(paramContext);
    this.e = new LoadOptions();
    this.h = paramTextView1;
    this.i = paramTextView2;
    LoadOptions loadOptions = this.e;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
  }
  
  public void a() {
    this.d.clear();
    notifyDataSetChanged();
  }
  
  public void a(List<BluedGroupAllMembers> paramList) {
    if (paramList != null && paramList.size() > 0) {
      this.d.addAll(paramList);
      notifyDataSetChanged();
    } 
  }
  
  public int getCount() {
    return this.d.size();
  }
  
  public Object getItem(int paramInt) {
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    BluedGroupAllMembers bluedGroupAllMembers = this.d.get(paramInt);
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.b.inflate(2131493543, null);
      viewHolder1.a = (LinearLayout)view.findViewById(2131298843);
      viewHolder1.b = (ImageView)view.findViewById(2131297952);
      viewHolder1.c = (ImageView)view.findViewById(2131299212);
      viewHolder1.d = (TextView)view.findViewById(2131301475);
      viewHolder1.e = (TextView)view.findViewById(2131300871);
      viewHolder1.f = (TextView)view.findViewById(2131301469);
      viewHolder1.g = (TextView)view.findViewById(2131300943);
      viewHolder1.h = (TextView)view.findViewById(2131300847);
      viewHolder1.i = (CheckBox)view.findViewById(2131296670);
      viewHolder1.j = (ImageView)view.findViewById(2131297581);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    UserRelationshipUtils.a(viewHolder1.j, (UserBasicModel)bluedGroupAllMembers);
    viewHolder1.a.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            param1View = ((Activity)GroupMemberListAdapter.a(this.a)).getCurrentFocus();
            if (param1View != null)
              param1View.clearFocus(); 
            return false;
          }
        });
    viewHolder1.a.setOnClickListener(new View.OnClickListener(this, bluedGroupAllMembers, viewHolder1) {
          public void onClick(View param1View) {
            UserInfoFragmentNew.a(GroupMemberListAdapter.a(this.c), (UserBasicModel)this.a, "", (View)this.b.b);
          }
        });
    if (GroupMembersListFragment.o.size() > 0)
      for (paramInt = 0; paramInt < GroupMembersListFragment.o.size(); paramInt++) {
        if (((String)GroupMembersListFragment.o.get(paramInt)).equals(bluedGroupAllMembers.uid)) {
          bluedGroupAllMembers.isCheckedFlag = true;
          bluedGroupAllMembers.isEnabledFlag = true;
        } 
      }  
    if (this.a == true) {
      viewHolder1.i.setVisibility(0);
    } else {
      viewHolder1.i.setVisibility(8);
    } 
    viewHolder1.h.setVisibility(8);
    ImageLoader.a(this.j, bluedGroupAllMembers.avatar).a(2131234356).c().a(viewHolder1.b);
    UserRelationshipUtils.a(viewHolder1.c, bluedGroupAllMembers.vbadge, 3);
    if (!StringUtils.e(bluedGroupAllMembers.note)) {
      viewHolder1.d.setText(bluedGroupAllMembers.note);
    } else if (!StringUtils.e(bluedGroupAllMembers.name)) {
      viewHolder1.d.setText(bluedGroupAllMembers.name);
    } else {
      viewHolder1.d.setVisibility(4);
    } 
    UserRelationshipUtils.a(this.c, viewHolder1.d, (UserBasicModel)bluedGroupAllMembers);
    if (!StringUtils.e(bluedGroupAllMembers.distance)) {
      viewHolder1.f.setText(DistanceUtils.a(bluedGroupAllMembers.distance, BlueAppLocal.c(), false));
    } else {
      viewHolder1.f.setVisibility(4);
    } 
    DistanceUtils.a(this.c, viewHolder1.f, (UserBasicModel)bluedGroupAllMembers, 1);
    if (!StringUtils.e(bluedGroupAllMembers.last_active_time)) {
      viewHolder1.g.setText(TimeAndDateUtils.g(this.c, TimeAndDateUtils.b(bluedGroupAllMembers.last_active_time)));
    } else {
      viewHolder1.g.setText("");
    } 
    TextView textView = viewHolder1.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bluedGroupAllMembers.age);
    stringBuilder.append(" / ");
    stringBuilder.append(bluedGroupAllMembers.height);
    stringBuilder.append(" / ");
    stringBuilder.append(bluedGroupAllMembers.weight);
    stringBuilder.append(" ");
    stringBuilder.append(this.c.getResources().getString(2131758698));
    stringBuilder.append(" ");
    stringBuilder.append(UserRelationshipUtils.c(this.c, bluedGroupAllMembers.role));
    textView.setText(stringBuilder.toString());
    if (!StringUtils.e(bluedGroupAllMembers.is_creator) && "1".equals(bluedGroupAllMembers.is_creator)) {
      if (this.a == true)
        viewHolder1.i.setVisibility(4); 
      viewHolder1.h.setVisibility(0);
      viewHolder1.h.setBackgroundResource(2131233798);
      viewHolder1.h.setText(this.c.getResources().getString(2131756710));
    } 
    if (!StringUtils.e(bluedGroupAllMembers.is_admin) && "1".equals(bluedGroupAllMembers.is_admin)) {
      if (this.a == true)
        if (GroupMembersListFragment.v.equals("1")) {
          viewHolder1.i.setVisibility(0);
        } else {
          viewHolder1.i.setVisibility(4);
        }  
      viewHolder1.h.setVisibility(0);
      viewHolder1.h.setBackgroundResource(2131233770);
      viewHolder1.h.setText(this.c.getResources().getString(2131756630));
    } 
    viewHolder1.i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this, viewHolder1, bluedGroupAllMembers) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            if (param1Boolean) {
              this.a.i.setOnClickListener(new View.OnClickListener(this) {
                    public void onClick(View param2View) {
                      this.a.b.isCheckedFlag = true;
                      GroupMemberListAdapter.a(this.a.c, this.a.b.uid);
                      if (!StringUtils.e(GroupMemberListAdapter.b(this.a.c))) {
                        GroupMembersListFragment.o.add(GroupMemberListAdapter.b(this.a.c));
                        if (GroupMembersListFragment.o.size() > 0) {
                          GroupMemberListAdapter.c(this.a.c).setText(GroupMemberListAdapter.a(this.a.c).getResources().getString(2131756100));
                        } else {
                          GroupMemberListAdapter.c(this.a.c).setText(GroupMemberListAdapter.a(this.a.c).getResources().getString(2131755726));
                        } 
                        TextView textView = GroupMemberListAdapter.d(this.a.c);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(" (");
                        stringBuilder.append(GroupMembersListFragment.o.size());
                        stringBuilder.append("/");
                        stringBuilder.append(GroupMembersListFragment.s);
                        stringBuilder.append(") ");
                        textView.setText(stringBuilder.toString());
                      } 
                    }
                  });
              return;
            } 
            this.a.i.setOnClickListener(new View.OnClickListener(this) {
                  public void onClick(View param2View) {
                    BluedGroupAllMembers bluedGroupAllMembers = this.a.b;
                    int i = 0;
                    bluedGroupAllMembers.isCheckedFlag = false;
                    GroupMemberListAdapter.b(this.a.c, this.a.b.uid);
                    if (GroupMembersListFragment.o != null)
                      while (i < GroupMembersListFragment.o.size()) {
                        if (((String)GroupMembersListFragment.o.get(i)).equals(GroupMemberListAdapter.e(this.a.c))) {
                          GroupMembersListFragment.o.remove(GroupMembersListFragment.o.get(i));
                          if (GroupMembersListFragment.o.size() > 0) {
                            GroupMemberListAdapter.c(this.a.c).setText(GroupMemberListAdapter.a(this.a.c).getResources().getString(2131756100));
                          } else {
                            GroupMemberListAdapter.c(this.a.c).setText(GroupMemberListAdapter.a(this.a.c).getResources().getString(2131755726));
                          } 
                          TextView textView = GroupMemberListAdapter.d(this.a.c);
                          StringBuilder stringBuilder = new StringBuilder();
                          stringBuilder.append(" (");
                          stringBuilder.append(GroupMembersListFragment.o.size());
                          stringBuilder.append("/");
                          stringBuilder.append(GroupMembersListFragment.s);
                          stringBuilder.append(") ");
                          textView.setText(stringBuilder.toString());
                        } 
                        i++;
                      }  
                  }
                });
          }
        });
    viewHolder1.i.setChecked(bluedGroupAllMembers.isCheckedFlag);
    return (View)viewHolder2;
  }
  
  class ViewHolder {
    LinearLayout a;
    
    ImageView b;
    
    ImageView c;
    
    TextView d;
    
    TextView e;
    
    TextView f;
    
    TextView g;
    
    TextView h;
    
    CheckBox i;
    
    ImageView j;
    
    private ViewHolder(GroupMemberListAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\adapter\GroupMemberListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */