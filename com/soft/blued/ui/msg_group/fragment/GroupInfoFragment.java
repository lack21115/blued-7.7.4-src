package com.soft.blued.ui.msg_group.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.custom.MvpKeyBoardFragment;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.log.trackUtils.EventTrackGroup;
import com.soft.blued.ui.msg_group.adapter.GroupManagerAdapter;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;
import com.soft.blued.ui.msg_group.presenter.GroupInfoPresenter;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.Logger;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.io.Serializable;
import java.util.List;

public class GroupInfoFragment extends MvpKeyBoardFragment<GroupInfoPresenter> {
  public static final String n = GroupInfoFragment.class.getSimpleName();
  
  @BindView(2131296459)
  View apply_reason;
  
  @BindView(2131297010)
  EditText et_reason;
  
  @BindView(2131297294)
  ImageView group_identity_change;
  
  @BindView(2131297301)
  ImageView group_setting_at_mute;
  
  @BindView(2131297302)
  ImageView group_setting_mute;
  
  @BindView(2131297303)
  ImageView group_setting_mute_notify;
  
  @BindView(2131297304)
  ImageView group_setting_top;
  
  @BindView(2131297305)
  ImageView group_setting_verify;
  
  @BindView(2131297689)
  ImageView iv_arrow_right;
  
  @BindView(2131297804)
  ImageView iv_icon;
  
  @BindView(2131297855)
  ImageView iv_manager_setting;
  
  @BindView(2131298140)
  RecyclerView list_manager;
  
  @BindView(2131298709)
  ShapeLinearLayout ll_apply;
  
  @BindView(2131298749)
  LinearLayout ll_clear_msg;
  
  @BindView(2131298791)
  LinearLayout ll_exit;
  
  @BindView(2131298905)
  KeyboardListenLinearLayout ll_keyboard;
  
  @BindView(2131299006)
  LinearLayout ll_owner_modify;
  
  @BindView(2131299054)
  LinearLayout ll_report;
  
  @BindView(2131299079)
  LinearLayout ll_setting;
  
  private GroupManagerAdapter o;
  
  @BindView(2131299693)
  RelativeLayout rl_change;
  
  @BindView(2131299698)
  RelativeLayout rl_description;
  
  @BindView(2131299702)
  RelativeLayout rl_et;
  
  @BindView(2131299727)
  RelativeLayout rl_setting_at_notify;
  
  @BindView(2131299737)
  RelativeLayout rl_verify;
  
  @BindView(2131299836)
  ScrollView scrollView;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  @BindView(2131300494)
  ShapeTextView tv_add_group;
  
  @BindView(2131300519)
  ShapeTextView tv_apply;
  
  @BindView(2131300522)
  TextView tv_apply_hint;
  
  @BindView(2131300639)
  TextView tv_clear_msg;
  
  @BindView(2131300704)
  TextView tv_desc;
  
  @BindView(2131300712)
  TextView tv_dismiss_hint;
  
  @BindView(2131300739)
  TextView tv_exit;
  
  @BindView(2131300806)
  TextView tv_go_chat;
  
  @BindView(2131300851)
  TextView tv_group_name;
  
  @BindView(2131301032)
  TextView tv_member_num;
  
  @BindView(2131301263)
  TextView tv_report;
  
  private void F() {
    LiveEventBus.get("refresh_manager_list", GroupInfoModel.class).observe((LifecycleOwner)this, new Observer<GroupInfoModel>(this) {
          public void a(GroupInfoModel param1GroupInfoModel) {
            if (((GroupInfoPresenter)this.a.s()).m() != null && param1GroupInfoModel != null && param1GroupInfoModel.admin != null) {
              (((GroupInfoPresenter)this.a.s()).m()).admin = param1GroupInfoModel.admin;
              GroupInfoFragment.a(this.a, param1GroupInfoModel.admin);
            } 
          }
        });
    LiveEventBus.get("modify_group_info", Void.class).observe((LifecycleOwner)this, new Observer<Void>(this) {
          public void a(Void param1Void) {
            ((GroupInfoPresenter)this.a.s()).a(true);
            this.a.u();
          }
        });
    LiveEventBus.get("add_group", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            ((GroupInfoPresenter)this.a.s()).d(param1String);
          }
        });
  }
  
  private void G() {
    this.rl_verify.setVisibility(8);
    this.rl_change.setVisibility(8);
    this.ll_owner_modify.setVisibility(8);
    this.tv_go_chat.setVisibility(8);
    this.ll_setting.setVisibility(8);
    this.ll_report.setVisibility(8);
    this.ll_clear_msg.setVisibility(8);
    this.ll_exit.setVisibility(8);
    this.tv_dismiss_hint.setVisibility(4);
    this.iv_manager_setting.setVisibility(8);
    this.iv_arrow_right.setVisibility(8);
    this.title.getRightImg().setVisibility(8);
    H();
  }
  
  private void H() {
    this.apply_reason.setVisibility(8);
    ShapeHelper.b((ShapeHelper.ShapeView)this.tv_apply, 2131100716);
    ShapeHelper.a((ShapeHelper.ShapeView)this.tv_apply, 2131100792);
    this.tv_apply.setClickable(true);
    this.tv_apply_hint.setVisibility(0);
    this.rl_et.setVisibility(0);
    ShapeHelper.b((ShapeHelper.ShapeView)this.ll_apply, 2131100728);
    this.tv_apply.setText(getString(2131755676));
    this.tv_add_group.setVisibility(8);
    ShapeHelper.b((ShapeHelper.ShapeView)this.tv_add_group, 2131100716);
    ShapeHelper.a((ShapeHelper.ShapeView)this.tv_add_group, 2131100792);
    this.tv_add_group.setClickable(true);
    this.tv_add_group.setText(getString(2131756682));
  }
  
  private void I() {
    CommonAlertDialog.a(getContext(), getContext().getResources().getString(2131756641), getContext().getResources().getString(2131756618), getContext().getResources().getString(2131756799), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            ((GroupInfoPresenter)this.a.s()).d(this.a.et_reason.getText().toString());
            KeyboardUtils.a((Activity)this.a.getActivity());
          }
        },  getContext().getResources().getString(2131756757), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            KeyboardUtils.a((Activity)this.a.getActivity());
          }
        },  null);
  }
  
  public static void a(Context paramContext, String paramString, GroupInfoModel paramGroupInfoModel, SocialNetWorkProtos.SourceType paramSourceType) {
    Bundle bundle = new Bundle();
    if (!TextUtils.isEmpty(paramString))
      bundle.putString("group_id", paramString); 
    if (paramGroupInfoModel != null)
      bundle.putSerializable("group_info", (Serializable)paramGroupInfoModel); 
    bundle.putSerializable("page_from", (Serializable)paramSourceType);
    TerminalActivity.d(paramContext, GroupInfoFragment.class, bundle);
  }
  
  private void a(List<GroupMemberModel> paramList) {
    GroupManagerAdapter groupManagerAdapter = this.o;
    if (groupManagerAdapter != null) {
      groupManagerAdapter.c(paramList);
      return;
    } 
    this.o = new GroupManagerAdapter(paramList, (IRequestHost)w_());
    this.list_manager.setAdapter((RecyclerView.Adapter)this.o);
    this.o.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            GroupMemberModel groupMemberModel = param1BaseQuickAdapter.n().get(param1Int);
            UserInfoFragmentNew.a(this.a.getContext(), groupMemberModel.uid, "group_chatting");
          }
        });
  }
  
  public void E() {
    String str;
    if (((GroupInfoPresenter)s()).m() == null)
      return; 
    if ((((GroupInfoPresenter)s()).m()).allow_join != 1) {
      this.apply_reason.setVisibility(0);
      ShapeHelper.b((ShapeHelper.ShapeView)this.tv_apply, 2131100845);
      ShapeHelper.a((ShapeHelper.ShapeView)this.tv_apply, 2131100844);
      this.tv_apply.setClickable(false);
      this.tv_apply_hint.setVisibility(4);
      this.rl_et.setVisibility(4);
      ShapeHelper.b((ShapeHelper.ShapeView)this.ll_apply, 2131100881);
      ShapeTextView shapeTextView1 = this.tv_apply;
      if ((((GroupInfoPresenter)s()).m()).apply_status == 1) {
        str = getString(2131756637);
      } else {
        str = getString(2131756685);
      } 
      shapeTextView1.setText(str);
      return;
    } 
    this.tv_add_group.setVisibility(0);
    ShapeHelper.b((ShapeHelper.ShapeView)this.tv_add_group, 2131100845);
    ShapeHelper.a((ShapeHelper.ShapeView)this.tv_add_group, 2131100844);
    ShapeTextView shapeTextView = this.tv_add_group;
    if ((((GroupInfoPresenter)s()).m()).apply_status == 1) {
      str = getString(2131756637);
    } else {
      str = getString(2131756685);
    } 
    shapeTextView.setText(str);
    this.tv_add_group.setClickable(false);
  }
  
  public void a(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      this.apply_reason.setClickable(false);
      return;
    } 
    this.apply_reason.setClickable(true);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.scrollView.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131100881));
    this.title.getLeftImg().setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    this.title.getRightImg().setVisibility(4);
    this.list_manager.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext(), 0, false));
    a(this.ll_keyboard);
    F();
  }
  
  public void a(GroupInfoModel paramGroupInfoModel) {
    if (paramGroupInfoModel != null) {
      G();
      int i = paramGroupInfoModel.group_role;
      if (i != 0) {
        if (i != 1) {
          if (i == 2 || i == 3) {
            this.tv_go_chat.setVisibility(0);
            this.ll_setting.setVisibility(0);
            this.ll_clear_msg.setVisibility(0);
            this.ll_exit.setVisibility(0);
            this.ll_report.setVisibility(0);
            this.iv_arrow_right.setVisibility(0);
            this.tv_exit.setText(getString(2131755677));
          } 
        } else {
          this.rl_verify.setVisibility(0);
          this.rl_change.setVisibility(0);
          this.ll_owner_modify.setVisibility(0);
          this.tv_go_chat.setVisibility(0);
          this.ll_setting.setVisibility(0);
          this.ll_clear_msg.setVisibility(0);
          this.ll_exit.setVisibility(0);
          this.tv_exit.setText(getString(2131755673));
          this.iv_manager_setting.setVisibility(0);
          this.iv_arrow_right.setVisibility(0);
          this.title.getRightImg().setVisibility(0);
          this.title.getRightImg().setImageDrawable(BluedSkinUtils.b(getContext(), 2131232524));
          this.title.setRightClickListener(new View.OnClickListener(this) {
                public void onClick(View param1View) {
                  Bundle bundle = new Bundle();
                  bundle.putSerializable("group_info", (Serializable)((GroupInfoPresenter)this.a.s()).m());
                  TerminalActivity.d(this.a.getContext(), GroupInfoEditFragment.class, bundle);
                }
              });
        } 
      } else {
        this.ll_report.setVisibility(0);
        String str = n;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("allow_join : ");
        stringBuilder1.append(paramGroupInfoModel.allow_join);
        Logger.c(str, new Object[] { stringBuilder1.toString() });
        str = n;
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("apply_status : ");
        stringBuilder1.append(paramGroupInfoModel.apply_status);
        Logger.c(str, new Object[] { stringBuilder1.toString() });
        if (paramGroupInfoModel.apply_status != 0) {
          E();
        } else if (paramGroupInfoModel.allow_join != 1) {
          this.apply_reason.setVisibility(0);
        } else {
          this.tv_add_group.setVisibility(0);
        } 
      } 
      ImageLoader.a((IRequestHost)w_(), paramGroupInfoModel.group_cover).c().a(this.iv_icon);
      if (!TextUtils.isEmpty(paramGroupInfoModel.group_desc))
        this.tv_desc.setText(paramGroupInfoModel.group_desc); 
      this.tv_desc.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (this.a.tv_desc.getMaxLines() == 4) {
                this.a.tv_desc.setMaxLines(100);
                return;
              } 
              this.a.tv_desc.setMaxLines(4);
            }
          });
      this.tv_group_name.setText(paramGroupInfoModel.group_title);
      TextView textView = this.tv_member_num;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramGroupInfoModel.group_now_population);
      stringBuilder.append("/");
      stringBuilder.append(paramGroupInfoModel.group_max_population);
      textView.setText(stringBuilder.toString());
      a(paramGroupInfoModel.admin);
      b(paramGroupInfoModel);
    } 
  }
  
  public void a(Integer paramInteger) {
    ImageView imageView = this.group_setting_top;
    int i = paramInteger.intValue();
    boolean bool = true;
    if (i != 1)
      bool = false; 
    imageView.setSelected(bool);
  }
  
  public void b(GroupInfoModel paramGroupInfoModel) {
    int i = paramGroupInfoModel.group_role;
    boolean bool = false;
    if (i != 0) {
      boolean bool1;
      ImageView imageView2 = this.group_setting_mute;
      if (paramGroupInfoModel.message_is_mute == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      imageView2.setSelected(bool1);
      if (this.group_setting_mute.isSelected()) {
        imageView2 = this.group_setting_at_mute;
        if (paramGroupInfoModel.at_message_is_mute == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        imageView2.setSelected(bool1);
      } 
      RelativeLayout relativeLayout = this.rl_setting_at_notify;
      if (paramGroupInfoModel.message_is_mute == 1) {
        i = 0;
      } else {
        i = 8;
      } 
      relativeLayout.setVisibility(i);
      ImageView imageView1 = this.group_setting_mute_notify;
      if (paramGroupInfoModel.notice_is_mute == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      imageView1.setSelected(bool1);
    } 
    if (paramGroupInfoModel.group_role == 1) {
      ImageView imageView = this.group_setting_verify;
      boolean bool1 = bool;
      if (paramGroupInfoModel.allow_join == 2)
        bool1 = true; 
      imageView.setSelected(bool1);
    } 
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(19);
    this.apply_reason.setClickable(false);
  }
  
  @OnClick({2131297302, 2131297301, 2131297303, 2131297305, 2131297304, 2131300639, 2131300739, 2131300494, 2131297855, 2131299720, 2131301263, 2131300806, 2131299693, 2131300519, 2131296459})
  public void onClick(View paramView) {
    GroupInfoPresenter groupInfoPresenter;
    FragmentActivity fragmentActivity;
    SocialNetWorkProtos.Event event;
    Bundle bundle2;
    Context context;
    Bundle bundle1;
    byte b;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    StringBuilder stringBuilder;
    if (((GroupInfoPresenter)s()).m() == null)
      return; 
    int i = paramView.getId();
    switch (i) {
      default:
        bool1 = true;
        bool2 = true;
        bool3 = true;
        b = 1;
        switch (i) {
          default:
            return;
          case 2131297305:
            groupInfoPresenter = (GroupInfoPresenter)s();
            if (!this.group_setting_verify.isSelected())
              b = 2; 
            groupInfoPresenter.a("allow_join", b);
            return;
          case 2131297304:
            ((GroupInfoPresenter)s()).a(this.group_setting_top);
            return;
          case 2131297303:
            groupInfoPresenter = (GroupInfoPresenter)s();
            b = bool1;
            if (this.group_setting_mute_notify.isSelected())
              b = 2; 
            groupInfoPresenter.a("notice_is_mute", b);
            return;
          case 2131297302:
            groupInfoPresenter = (GroupInfoPresenter)s();
            b = bool2;
            if (this.group_setting_mute.isSelected())
              b = 2; 
            groupInfoPresenter.a("message_is_mute", b);
            return;
          case 2131297301:
            break;
        } 
        groupInfoPresenter = (GroupInfoPresenter)s();
        b = bool3;
        if (this.group_setting_at_mute.isSelected())
          b = 2; 
        groupInfoPresenter.a("at_message_is_mute", b);
        return;
      case 2131301263:
        fragmentActivity = getActivity();
        stringBuilder = new StringBuilder();
        stringBuilder.append((((GroupInfoPresenter)s()).m()).group_id);
        stringBuilder.append("");
        ReportFragmentNew.a((Context)fragmentActivity, 4, stringBuilder.toString(), (((GroupInfoPresenter)s()).m()).group_title);
        return;
      case 2131300806:
        ((GroupInfoPresenter)s()).r();
        return;
      case 2131300739:
        ((GroupInfoPresenter)s()).p();
        return;
      case 2131300639:
        if (((GroupInfoPresenter)s()).n() != null) {
          CommonAlertDialog.a(getContext(), getContext().getResources().getString(2131755498), getContext().getResources().getString(2131755805), getContext().getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                  ChatManager.getInstance().deleteSessionAndChatting(Short.valueOf((short)3), Long.valueOf((((GroupInfoPresenter)this.a.s()).n()).sessionId).longValue());
                }
              }getContext().getResources().getString(2131756057), new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
              },  null);
          return;
        } 
        return;
      case 2131300494:
      case 2131300519:
        event = SocialNetWorkProtos.Event.GROUP_JOIN_CLICK;
        stringBuilder = new StringBuilder();
        stringBuilder.append((((GroupInfoPresenter)s()).m()).group_id);
        stringBuilder.append("");
        EventTrackGroup.a(event, stringBuilder.toString(), ((GroupInfoPresenter)s()).o());
        I();
        return;
      case 2131299720:
        if ((((GroupInfoPresenter)s()).m()).group_role == 0)
          return; 
        bundle2 = new Bundle();
        bundle2.putInt("group_role", (((GroupInfoPresenter)s()).m()).group_role);
        stringBuilder = new StringBuilder();
        stringBuilder.append((((GroupInfoPresenter)s()).m()).group_id);
        stringBuilder.append("");
        bundle2.putString("group_id", stringBuilder.toString());
        TerminalActivity.d(getContext(), GroupMemberFragment.class, bundle2);
        return;
      case 2131299693:
        context = getContext();
        stringBuilder = new StringBuilder();
        stringBuilder.append((((GroupInfoPresenter)s()).m()).group_id);
        stringBuilder.append("");
        SearchMemberFragment.a(context, 2, stringBuilder.toString(), (((GroupInfoPresenter)s()).m()).group_role);
        return;
      case 2131297855:
        bundle1 = new Bundle();
        bundle1.putSerializable("group_info", (Serializable)((GroupInfoPresenter)s()).m());
        TerminalActivity.d(getContext(), GroupManagerFragment.class, bundle1);
        return;
      case 2131296459:
        break;
    } 
    KeyboardUtils.a((Activity)getActivity());
  }
  
  public int p() {
    return 2131493060;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\GroupInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */