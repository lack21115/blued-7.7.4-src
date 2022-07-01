package com.soft.blued.ui.live.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.ui.group.GroupInviteFromChatListFragment;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareWithContactAdapter extends BaseAdapter {
  public List<SessionModel> a = new ArrayList<SessionModel>();
  
  public List<SessionModel> b = new ArrayList<SessionModel>();
  
  public List<SessionModel> c = new ArrayList<SessionModel>();
  
  public List<SessionModel> d = new ArrayList<SessionModel>();
  
  private LayoutInflater e;
  
  private Context f;
  
  private IRequestHost g;
  
  private String h;
  
  private int i = 1;
  
  public ShareWithContactAdapter(IRequestHost paramIRequestHost, Context paramContext, List<SessionModel> paramList, int paramInt) {
    this.f = paramContext;
    this.g = paramIRequestHost;
    this.e = LayoutInflater.from(this.f);
    if (paramInt > 1)
      this.i = paramInt; 
    this.a = paramList;
    for (paramInt = 0; paramInt < this.a.size(); paramInt++) {
      this.b.add(this.a.get(paramInt));
      this.c.add(this.a.get(paramInt));
      if (((SessionModel)this.a.get(paramInt)).checked)
        this.d.add(this.a.get(paramInt)); 
    } 
  }
  
  private String a(SessionModel paramSessionModel, SessionSettingModel paramSessionSettingModel) {
    String str1;
    String str2 = paramSessionModel.nickName;
    if (paramSessionSettingModel != null) {
      str1 = paramSessionSettingModel.getSessinoNote();
    } else {
      str1 = "";
    } 
    if (!TextUtils.isEmpty(str1))
      return str1; 
    if (!TextUtils.isEmpty(str2))
      return str2; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramSessionModel.sessionId);
    stringBuilder.append("");
    return stringBuilder.toString();
  }
  
  private void a(SessionModel paramSessionModel, SessionSettingModel paramSessionSettingModel, ViewHolder paramViewHolder) {
    if (paramSessionModel == null)
      return; 
    if (paramSessionModel.sessionType == 3 && paramSessionModel.lastMsgFromId != Long.valueOf(UserInfo.a().i().getUid()).longValue() && MsgType.getClassify(paramSessionModel.lastMsgType) != 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramSessionModel.lastMsgFromNickname);
      stringBuilder.append(":");
      TextUtils.isEmpty(stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(paramSessionModel.lastMsgContent))
      if (MsgType.getClassify(paramSessionModel.lastMsgType) == 1 || paramSessionModel.lastMsgType == 8) {
        TextUtils.isEmpty(paramSessionModel.lastMsgContent);
      } else {
        short s = paramSessionModel.lastMsgType;
        if (s != 1) {
          if (s != 2)
            if (s != 3) {
              if (s != 4 && s != 6 && (s == 9 || s == 10) && paramSessionModel.sessionType != 2)
                s = paramSessionModel.sessionType; 
            } else if (IMV4Method.a(paramSessionModel.lastMsgFromId) == 1) {
              s = paramSessionModel.lastMsgStateCode;
            }  
        } else {
          TextUtils.isEmpty(paramSessionModel.lastMsgContent);
        } 
      }  
    if (TimeAndDateUtils.e(paramSessionModel.lastMsgTime)) {
      this.h = ((SimpleDateFormat)TimeAndDateUtils.c.get()).format(new Date(paramSessionModel.lastMsgTime));
    } else {
      this.h = ((SimpleDateFormat)TimeAndDateUtils.d.get()).format(new Date(paramSessionModel.lastMsgTime));
    } 
    if (paramSessionSettingModel == null || paramSessionSettingModel.getRemindAudio() == 0) {
      paramViewHolder.e.setVisibility(8);
      return;
    } 
    paramViewHolder.e.setVisibility(0);
  }
  
  public void a(String paramString) {
    List<SessionModel> list = this.b;
    if (list != null && list.size() > 0) {
      this.c.clear();
      for (int i = 0; i < this.b.size(); i++) {
        SessionModel sessionModel = this.b.get(i);
        if (a(sessionModel, (SessionSettingModel)sessionModel.sessionSettingModel).contains(paramString))
          this.c.add(this.b.get(i)); 
      } 
      this.a.clear();
      if (!TextUtils.isEmpty(paramString)) {
        this.a.addAll(this.c);
      } else {
        this.a.addAll(this.b);
      } 
    } 
    notifyDataSetChanged();
  }
  
  public int getCount() {
    return this.a.size();
  }
  
  public Object getItem(int paramInt) {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    if (paramView == null) {
      paramView = this.e.inflate(2131493650, paramViewGroup, false);
      viewHolder = new ViewHolder();
      viewHolder.g = (LinearLayout)paramView.findViewById(2131298961);
      viewHolder.c = (ImageView)paramView.findViewById(2131299261);
      viewHolder.d = (ImageView)paramView.findViewById(2131299262);
      viewHolder.f = (TextView)paramView.findViewById(2131300828);
      viewHolder.a = (TextView)paramView.findViewById(2131299265);
      viewHolder.b = (CheckBox)paramView.findViewById(2131296669);
      viewHolder.e = (ImageView)paramView.findViewById(2131299270);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    SessionModel sessionModel = this.a.get(paramInt);
    List<SessionModel> list = this.a;
    if (list != null && list.size() != 0) {
      if (paramInt >= this.a.size())
        return paramView; 
      if (sessionModel == null)
        return paramView; 
      SessionSettingModel sessionSettingModel = (SessionSettingModel)sessionModel.sessionSettingModel;
      viewHolder.b.setChecked(false);
      viewHolder.b.setEnabled(true);
      short s2 = sessionModel.sessionType;
      if (s2 != 1) {
        if (s2 != 2) {
          if (s2 == 3) {
            ImageLoader.a(this.g, sessionModel.avatar).a(2131232322).c().a(viewHolder.c);
            viewHolder.f.setVisibility(0);
            String str1 = a(sessionModel, sessionSettingModel);
            viewHolder.a.setText(str1);
            UserRelationshipUtils.a(viewHolder.d, sessionModel.vBadge, 3);
            if (GroupInviteFromChatListFragment.f != null && GroupInviteFromChatListFragment.f.equals(String.valueOf(sessionModel.sessionId))) {
              viewHolder.b.setChecked(true);
              viewHolder.b.setEnabled(false);
            } 
          } 
        } else {
          ImageLoader.a(this.g, AvatarUtils.a(0, sessionModel.avatar)).a(2131234356).c().a(viewHolder.c);
          viewHolder.f.setVisibility(8);
          String str1 = a(sessionModel, sessionSettingModel);
          viewHolder.a.setText(str1);
          UserRelationshipUtils.a(viewHolder.d, sessionModel.vBadge, 3);
        } 
      } else if (sessionModel.sessionId == 2L) {
        viewHolder.c.setImageResource(2131233440);
        viewHolder.f.setVisibility(8);
        viewHolder.a.setText(this.f.getResources().getString(2131755602));
        viewHolder.d.setVisibility(8);
      } 
      a(sessionModel, sessionSettingModel, viewHolder);
      long l = sessionModel.sessionId;
      String str = sessionModel.nickName;
      str = sessionModel.avatar;
      int i = sessionModel.vBadge;
      short s1 = sessionModel.sessionType;
      if (this.i == 1) {
        viewHolder.b.setVisibility(8);
        viewHolder.g.setOnClickListener(new View.OnClickListener(this, String.valueOf(l), s1) {
              public void onClick(View param1View) {
                String str1 = ShareWithContactAdapter.a(this.c).getResources().getString(2131756931);
                String str2 = ShareWithContactAdapter.a(this.c).getResources().getString(2131757188);
                CommonAlertDialog.a(ShareWithContactAdapter.a(this.c), null, str1, str2, null, null, new DialogInterface.OnClickListener(this) {
                      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                        Intent intent = new Intent();
                        String str = this.a.a;
                        param2Int = this.a.b;
                        intent.putExtra("CHOOSED_UID", new String[] { str });
                        intent.putExtra("CHOOSED_TYPE", new String[] { String.valueOf(param2Int) });
                        ((Activity)ShareWithContactAdapter.a(this.a.c)).setResult(-1, intent);
                        ((Activity)ShareWithContactAdapter.a(this.a.c)).finish();
                      }
                    }null, null, true);
              }
            });
        return paramView;
      } 
      if (sessionModel.chooseable) {
        viewHolder.b.setVisibility(0);
      } else {
        viewHolder.b.setVisibility(4);
      } 
      viewHolder.b.setChecked(sessionModel.checked);
      viewHolder.b.setClickable(false);
      paramView.setOnClickListener(new View.OnClickListener(this, sessionModel, paramInt) {
            public void onClick(View param1View) {
              if (this.a.chooseable) {
                boolean bool = this.a.checked;
                int i = 0;
                if (!bool) {
                  this.c.d.add(this.a);
                  ((SessionModel)this.c.a.get(this.b)).checked = true;
                } else {
                  this.c.d.remove(this.a);
                  ((SessionModel)this.c.a.get(this.b)).checked = false;
                } 
                if (this.c.d.size() >= ShareWithContactAdapter.b(this.c)) {
                  for (i = 0; i < this.c.a.size(); i++) {
                    SessionModel sessionModel = this.c.a.get(i);
                    if (this.c.d.contains(sessionModel)) {
                      sessionModel.chooseable = true;
                    } else {
                      sessionModel.chooseable = false;
                    } 
                  } 
                } else {
                  while (i < this.c.a.size()) {
                    ((SessionModel)this.c.a.get(i)).chooseable = true;
                    i++;
                  } 
                } 
                this.c.notifyDataSetChanged();
                return;
              } 
              AppMethods.a(ShareWithContactAdapter.a(this.c).getResources().getString(2131757187));
            }
          });
    } 
    return paramView;
  }
  
  class ViewHolder {
    TextView a;
    
    CheckBox b;
    
    ImageView c;
    
    ImageView d;
    
    ImageView e;
    
    TextView f;
    
    LinearLayout g;
    
    private ViewHolder(ShareWithContactAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\adapter\ShareWithContactAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */