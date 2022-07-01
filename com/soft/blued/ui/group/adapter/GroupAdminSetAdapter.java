package com.soft.blued.ui.group.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.group.GroupAdminSetFragment;
import com.soft.blued.ui.group.model.BluedGroupAdminLists;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.List;

public class GroupAdminSetAdapter extends BaseAdapter {
  public boolean a = false;
  
  private Context b;
  
  private List<BluedGroupAdminLists> c;
  
  private LayoutInflater d;
  
  private LoadOptions e;
  
  private Dialog f;
  
  private ListView g;
  
  private LinearLayout h;
  
  private ImageView i;
  
  private TextView j;
  
  private TextView k;
  
  private View l;
  
  private IRequestHost m;
  
  public GroupAdminSetAdapter(Context paramContext, List<BluedGroupAdminLists> paramList, ListView paramListView, TextView paramTextView1, LinearLayout paramLinearLayout, ImageView paramImageView, TextView paramTextView2, View paramView, IRequestHost paramIRequestHost) {
    this.b = paramContext;
    this.c = paramList;
    this.g = paramListView;
    this.h = paramLinearLayout;
    this.i = paramImageView;
    this.j = paramTextView2;
    this.k = paramTextView1;
    this.l = paramView;
    this.m = paramIRequestHost;
    this.d = LayoutInflater.from(paramContext);
    this.e = new LoadOptions();
    this.f = DialogUtils.a(paramContext);
    LoadOptions loadOptions = this.e;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
  }
  
  public int getCount() {
    return this.c.size();
  }
  
  public Object getItem(int paramInt) {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    BluedGroupAdminLists bluedGroupAdminLists = this.c.get(paramInt);
    if (paramView == null) {
      viewHolder1 = new ViewHolder(this);
      View view = this.d.inflate(2131493538, paramViewGroup, false);
      viewHolder1.a = (ImageView)view.findViewById(2131297952);
      viewHolder1.b = (TextView)view.findViewById(2131301475);
      viewHolder1.c = (TextView)view.findViewById(2131301469);
      viewHolder1.d = (TextView)view.findViewById(2131300943);
      viewHolder1.e = (TextView)view.findViewById(2131300871);
      viewHolder1.f = (ImageView)view.findViewById(2131297784);
      viewHolder1.g = (ImageView)view.findViewById(2131299212);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    if (this.a) {
      viewHolder1.f.setVisibility(0);
    } else {
      viewHolder1.f.setVisibility(8);
    } 
    ImageLoader.a(this.m, bluedGroupAdminLists.users_avatar).a(2131234356).c().a(viewHolder1.a);
    UserRelationshipUtils.a(viewHolder1.g, bluedGroupAdminLists.users_vbadge, 3);
    if (!StringUtils.e(bluedGroupAdminLists.users_note)) {
      viewHolder1.b.setText(bluedGroupAdminLists.users_note);
    } else if (!StringUtils.e(bluedGroupAdminLists.users_name)) {
      viewHolder1.b.setText(bluedGroupAdminLists.users_name);
    } else {
      viewHolder1.b.setVisibility(4);
    } 
    if (!StringUtils.e(bluedGroupAdminLists.users_distance)) {
      viewHolder1.c.setText(DistanceUtils.a(bluedGroupAdminLists.users_distance, BlueAppLocal.c(), false));
    } else {
      viewHolder1.c.setVisibility(4);
    } 
    if (!StringUtils.e(bluedGroupAdminLists.last_active_time)) {
      viewHolder1.d.setText(TimeAndDateUtils.f(this.b, TimeAndDateUtils.b(bluedGroupAdminLists.last_active_time)));
    } else {
      viewHolder1.d.setText("");
    } 
    TextView textView = viewHolder1.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bluedGroupAdminLists.users_age);
    stringBuilder.append(" / ");
    stringBuilder.append(bluedGroupAdminLists.users_height);
    stringBuilder.append(" / ");
    stringBuilder.append(bluedGroupAdminLists.users_weight);
    stringBuilder.append(" - ");
    stringBuilder.append(UserRelationshipUtils.c(this.b, bluedGroupAdminLists.users_role));
    textView.setText(stringBuilder.toString());
    viewHolder1.f.setOnClickListener(new View.OnClickListener(this, paramInt, bluedGroupAdminLists) {
          public void onClick(View param1View) {
            CommonAlertDialog.a(GroupAdminSetAdapter.a(this.c), null, GroupAdminSetAdapter.a(this.c).getResources().getString(2131756627), GroupAdminSetAdapter.a(this.c).getResources().getString(2131756626), GroupAdminSetAdapter.a(this.c).getResources().getString(2131755726), GroupAdminSetAdapter.a(this.c).getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    GroupHttpUtils.h(GroupAdminSetAdapter.a(this.a.c), new BluedUIHttpResponse<BluedEntityA<BluedGroupAdminLists>>(this) {
                          protected void a(BluedEntityA<BluedGroupAdminLists> param3BluedEntityA) {
                            if (param3BluedEntityA != null)
                              try {
                                AppMethods.d(2131756624);
                                GroupAdminSetAdapter.c(this.a.a.c).remove(this.a.a.a);
                                TextView textView = GroupAdminSetAdapter.d(this.a.a.c);
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("(");
                                stringBuilder.append(GroupAdminSetAdapter.c(this.a.a.c).size());
                                stringBuilder.append("/");
                                stringBuilder.append(GroupAdminSetFragment.f);
                                stringBuilder.append(")");
                                textView.setText(stringBuilder.toString());
                                GroupAdminSetFragment.g = StringUtils.a(GroupAdminSetAdapter.c(this.a.a.c).size(), "0");
                                if (GroupAdminSetFragment.g.equals("0")) {
                                  this.a.a.c.a = false;
                                  GroupAdminSetAdapter.e(this.a.a.c).setVisibility(4);
                                } else {
                                  GroupAdminSetAdapter.e(this.a.a.c).setVisibility(0);
                                } 
                                if (GroupAdminSetFragment.g.equals(GroupAdminSetFragment.f)) {
                                  GroupAdminSetAdapter.f(this.a.a.c).setClickable(false);
                                  GroupAdminSetAdapter.g(this.a.a.c).setImageResource(2131232521);
                                  GroupAdminSetAdapter.h(this.a.a.c).setTextColor(GroupAdminSetAdapter.a(this.a.a.c).getResources().getColor(2131100325));
                                } else {
                                  GroupAdminSetAdapter.f(this.a.a.c).setClickable(true);
                                  GroupAdminSetAdapter.g(this.a.a.c).setImageResource(2131232520);
                                  GroupAdminSetAdapter.h(this.a.a.c).setTextColor(GroupAdminSetAdapter.a(this.a.a.c).getResources().getColor(2131100136));
                                } 
                                this.a.a.c.notifyDataSetChanged();
                                return;
                              } catch (Exception exception) {
                                exception.printStackTrace();
                              }  
                          }
                          
                          public void onUIFinish() {
                            super.onUIFinish();
                            DialogUtils.b(GroupAdminSetAdapter.b(this.a.a.c));
                          }
                          
                          public void onUIStart() {
                            super.onUIStart();
                            DialogUtils.a(GroupAdminSetAdapter.b(this.a.a.c));
                          }
                        }GroupAdminSetFragment.e, this.a.b.users_uid, GroupAdminSetAdapter.i(this.a.c));
                  }
                }new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {}
                },  null, true);
          }
        });
    viewHolder2.setOnClickListener(new View.OnClickListener(this, bluedGroupAdminLists, viewHolder1) {
          public void onClick(View param1View) {
            UserBasicModel userBasicModel = new UserBasicModel();
            userBasicModel.uid = this.a.users_uid;
            userBasicModel.name = this.a.users_name;
            userBasicModel.avatar = this.a.users_avatar;
            UserInfoFragmentNew.a(GroupAdminSetAdapter.a(this.c), userBasicModel, null, (View)this.b.a);
          }
        });
    return (View)viewHolder2;
  }
  
  public class ViewHolder {
    public ImageView a;
    
    public TextView b;
    
    public TextView c;
    
    public TextView d;
    
    public TextView e;
    
    public ImageView f;
    
    public ImageView g;
    
    public ViewHolder(GroupAdminSetAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\adapter\GroupAdminSetAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */