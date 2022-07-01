package com.soft.blued.ui.group.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.utils.AvatarUtils;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.group.GroupInviteFromChatListFragment;
import com.soft.blued.ui.group.GroupMemberInviteFragment;
import com.soft.blued.ui.msg.adapter.ChatFriendListAdapter;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BluedMyChatFriendListAdapter extends BaseAdapter {
  private LayoutInflater a;
  
  private Context b;
  
  private GroupInviteFromChatListFragment c;
  
  private String d;
  
  private void a(SessionModel paramSessionModel, SessionSettingModel paramSessionSettingModel, TextView paramTextView) {
    String str1;
    String str2 = paramSessionModel.nickName;
    if (paramSessionSettingModel != null) {
      str1 = paramSessionSettingModel.getSessinoNote();
    } else {
      str1 = "";
    } 
    if (!TextUtils.isEmpty(str1)) {
      paramTextView.setText(str1);
      return;
    } 
    if (!TextUtils.isEmpty(str2)) {
      paramTextView.setText(str2);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramSessionModel.sessionId);
    stringBuilder.append("");
    paramTextView.setText(stringBuilder.toString());
  }
  
  private void a(SessionModel paramSessionModel, SessionSettingModel paramSessionSettingModel, ViewHolder paramViewHolder) {
    if (paramSessionModel == null)
      return; 
    short s = paramSessionModel.sessionType;
    String str2 = "";
    String str1 = str2;
    if (s == 3) {
      str1 = str2;
      if (paramSessionModel.lastMsgFromId != Long.parseLong(UserInfo.a().i().getUid())) {
        str1 = str2;
        if (MsgType.getClassify(paramSessionModel.lastMsgType) != 1) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramSessionModel.lastMsgFromNickname);
          stringBuilder.append(":");
          str1 = stringBuilder.toString();
          if (StringUtils.e(str1))
            str1 = str2; 
        } 
      } 
    } 
    paramViewHolder.c.setTextColor(this.b.getResources().getColor(2131100235));
    ChatFriendListAdapter.a(this.b, paramViewHolder.b, paramViewHolder.c, paramSessionModel, str1);
    if (TimeAndDateUtils.e(paramSessionModel.lastMsgTime)) {
      this.d = ((SimpleDateFormat)TimeAndDateUtils.c.get()).format(new Date(paramSessionModel.lastMsgTime));
    } else {
      this.d = ((SimpleDateFormat)TimeAndDateUtils.d.get()).format(new Date(paramSessionModel.lastMsgTime));
    } 
    if (paramSessionSettingModel == null || paramSessionSettingModel.getRemindAudio() == 0) {
      paramViewHolder.h.setVisibility(8);
      return;
    } 
    paramViewHolder.h.setVisibility(0);
  }
  
  public int getCount() {
    return this.c.e.size();
  }
  
  public Object getItem(int paramInt) {
    return this.c.e.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    GroupInviteFromChatListFragment groupInviteFromChatListFragment = null;
    ActivityFragmentActive activityFragmentActive = null;
    if (paramView == null) {
      paramView = this.a.inflate(2131493551, paramViewGroup, false);
      viewHolder = new ViewHolder();
      viewHolder.f = (ImageView)paramView.findViewById(2131299261);
      viewHolder.g = (ImageView)paramView.findViewById(2131299262);
      viewHolder.i = (TextView)paramView.findViewById(2131300828);
      viewHolder.a = (TextView)paramView.findViewById(2131299265);
      viewHolder.e = (CheckBox)paramView.findViewById(2131296669);
      viewHolder.b = paramView.findViewById(2131298023);
      viewHolder.c = (TextView)paramView.findViewById(2131299263);
      viewHolder.d = (ImageView)paramView.findViewById(2131299266);
      viewHolder.h = paramView.findViewById(2131299270);
      viewHolder.j = (ImageView)paramView.findViewById(2131297581);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    if (this.c.e != null && this.c.e.size() != 0) {
      if (paramInt >= this.c.e.size())
        return paramView; 
      SessionModel sessionModel = this.c.e.get(paramInt);
      if (sessionModel == null)
        return paramView; 
      SessionSettingModel sessionSettingModel = (SessionSettingModel)sessionModel.sessionSettingModel;
      if (sessionModel.lastMsgStateCode == 7) {
        viewHolder.d.setImageResource(2131232601);
        viewHolder.d.setVisibility(0);
      } else if (sessionModel.lastMsgStateCode == 1) {
        viewHolder.d.setImageResource(2131232613);
        viewHolder.d.setVisibility(0);
      } else if (sessionModel.lastMsgStateCode == 6) {
        viewHolder.d.setImageResource(2131232602);
        viewHolder.d.setVisibility(0);
      } else {
        viewHolder.d.setVisibility(8);
      } 
      viewHolder.e.setChecked(false);
      viewHolder.e.setEnabled(true);
      viewHolder.j.setVisibility(8);
      paramInt = sessionModel.sessionType;
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt == 3) {
            groupInviteFromChatListFragment = this.c;
            if (groupInviteFromChatListFragment != null)
              activityFragmentActive = groupInviteFromChatListFragment.w_(); 
            ImageLoader.a((IRequestHost)activityFragmentActive, sessionModel.avatar).a(2131232322).c().a(viewHolder.f);
            viewHolder.i.setVisibility(0);
            a(sessionModel, sessionSettingModel, viewHolder.a);
            UserRelationshipUtils.a(viewHolder.g, sessionModel.vBadge, 3);
            if (GroupInviteFromChatListFragment.f != null && GroupInviteFromChatListFragment.f.equals(String.valueOf(sessionModel.sessionId))) {
              viewHolder.e.setChecked(true);
              viewHolder.e.setEnabled(false);
            } 
          } 
        } else {
          ActivityFragmentActive activityFragmentActive1;
          GroupInviteFromChatListFragment groupInviteFromChatListFragment1 = this.c;
          if (groupInviteFromChatListFragment1 == null) {
            groupInviteFromChatListFragment1 = groupInviteFromChatListFragment;
          } else {
            activityFragmentActive1 = groupInviteFromChatListFragment1.w_();
          } 
          ImageLoader.a((IRequestHost)activityFragmentActive1, AvatarUtils.a(0, sessionModel.avatar)).a(2131234356).c().a(viewHolder.f);
          viewHolder.i.setVisibility(8);
          a(sessionModel, sessionSettingModel, viewHolder.a);
          UserBasicModel userBasicModel = new UserBasicModel();
          userBasicModel.vip_grade = sessionModel.vipGrade;
          userBasicModel.is_vip_annual = sessionModel.vipAnnual;
          userBasicModel.is_hide_vip_look = sessionModel.hideVipLook;
          userBasicModel.vip_exp_lvl = sessionModel.vipExpLvl;
          UserRelationshipUtils.a(viewHolder.j, userBasicModel);
          UserRelationshipUtils.a(this.b, viewHolder.a, userBasicModel);
          UserRelationshipUtils.a(viewHolder.g, sessionModel.vBadge, 3);
        } 
      } else if (sessionModel.sessionId == 2L) {
        viewHolder.f.setImageResource(2131233440);
        viewHolder.i.setVisibility(8);
        viewHolder.a.setText(this.b.getResources().getString(2131755602));
        viewHolder.g.setVisibility(8);
      } 
      a(sessionModel, sessionSettingModel, viewHolder);
      String str1 = String.valueOf(sessionModel.sessionId);
      String str2 = sessionModel.nickName;
      String str3 = sessionModel.avatar;
      int i = sessionModel.vBadge;
      short s = sessionModel.sessionType;
      if (GroupMemberInviteFragment.d.size() > 0)
        for (paramInt = 0; paramInt < GroupMemberInviteFragment.d.size(); paramInt++) {
          if (((String)GroupMemberInviteFragment.d.get(paramInt)).equals(str1) && s == ((Short)GroupMemberInviteFragment.h.get(paramInt)).shortValue()) {
            viewHolder.e.setChecked(true);
            viewHolder.e.setEnabled(true);
          } 
        }  
      if (GroupMemberInviteFragment.j.size() > 0)
        for (paramInt = 0; paramInt < GroupMemberInviteFragment.j.size(); paramInt++) {
          if (!StringUtils.e(str1) && !StringUtils.e(GroupMemberInviteFragment.j.get(paramInt)) && str1.equals(GroupMemberInviteFragment.j.get(paramInt))) {
            viewHolder.e.setChecked(true);
            viewHolder.e.setEnabled(false);
          } 
        }  
      viewHolder.e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this, viewHolder, str1, s, str2, str3, i) {
            public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
              if (param1Boolean) {
                this.a.e.setOnClickListener(new View.OnClickListener(this) {
                      public void onClick(View param2View) {
                        if (GroupMemberInviteFragment.d.size() >= 8) {
                          this.a.a.e.setChecked(false);
                          AppMethods.d(2131758312);
                          return;
                        } 
                        if (!StringUtils.e(this.a.b)) {
                          GroupMemberInviteFragment.h.add(Short.valueOf(this.a.c));
                          GroupMemberInviteFragment.d.add(this.a.b);
                          GroupMemberInviteFragment.e.add(this.a.d);
                          GroupMemberInviteFragment.f.add(this.a.e);
                          GroupMemberInviteFragment.g.add(Integer.valueOf(this.a.f));
                        } 
                        this.a.a.e.setChecked(true);
                      }
                    });
                return;
              } 
              this.a.e.setOnClickListener(new View.OnClickListener(this) {
                    public void onClick(View param2View) {
                      if (GroupMemberInviteFragment.d != null)
                        for (int i = 0; i < GroupMemberInviteFragment.d.size(); i++) {
                          if (((String)GroupMemberInviteFragment.d.get(i)).equals(this.a.b)) {
                            GroupMemberInviteFragment.d.remove(GroupMemberInviteFragment.d.get(i));
                            GroupMemberInviteFragment.e.remove(GroupMemberInviteFragment.e.get(i));
                            GroupMemberInviteFragment.f.remove(GroupMemberInviteFragment.f.get(i));
                            GroupMemberInviteFragment.g.remove(GroupMemberInviteFragment.g.get(i));
                            GroupMemberInviteFragment.h.remove(GroupMemberInviteFragment.h.get(i));
                          } 
                        }  
                      this.a.a.e.setChecked(false);
                    }
                  });
            }
          });
    } 
    return paramView;
  }
  
  class ViewHolder {
    TextView a;
    
    View b;
    
    TextView c;
    
    ImageView d;
    
    CheckBox e;
    
    ImageView f;
    
    ImageView g;
    
    View h;
    
    TextView i;
    
    ImageView j;
    
    private ViewHolder(BluedMyChatFriendListAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\adapter\BluedMyChatFriendListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */