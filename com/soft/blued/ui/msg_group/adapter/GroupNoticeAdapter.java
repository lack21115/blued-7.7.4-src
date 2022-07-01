package com.soft.blued.ui.msg_group.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DialogUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.ui.msg_group.model.GroupNoticeModel;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.text.SimpleDateFormat;

public class GroupNoticeAdapter extends BaseMultiItemQuickAdapter<GroupNoticeModel, BaseViewHolder> {
  private SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", BlueAppLocal.c());
  
  private IRequestHost b;
  
  private Dialog c;
  
  public GroupNoticeAdapter(IRequestHost paramIRequestHost) {
    super(null);
    this.b = paramIRequestHost;
    b(1, 2131493546);
    b(3, 2131493546);
    b(2, 2131493544);
    b(4, 2131493545);
    b(5, 2131493545);
    b(6, 2131493545);
    b(7, 2131493545);
    b(8, 2131493545);
    b(9, 2131493545);
    b(10, 2131493545);
    b(11, 2131493545);
  }
  
  private void a(int paramInt, BaseViewHolder paramBaseViewHolder, GroupNoticeModel paramGroupNoticeModel) {
    MsgGroupHttpUtils.c(this.b, paramGroupNoticeModel.id, paramInt, new BluedUIHttpResponse(this, this.b, paramGroupNoticeModel, paramBaseViewHolder, paramInt) {
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int == 40319014) {
              this.a.result = 3;
              this.d.notifyItemChanged(this.b.getAdapterPosition());
            } 
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            DialogUtils.b(GroupNoticeAdapter.b(this.d));
            if (param1Boolean) {
              this.a.result = this.c;
              this.d.notifyItemChanged(this.b.getAdapterPosition());
            } 
          }
          
          public void onUIStart() {
            super.onUIStart();
            if (GroupNoticeAdapter.b(this.d) == null) {
              GroupNoticeAdapter groupNoticeAdapter = this.d;
              GroupNoticeAdapter.a(groupNoticeAdapter, DialogUtils.a(GroupNoticeAdapter.c(groupNoticeAdapter)));
            } 
            DialogUtils.a(GroupNoticeAdapter.b(this.d));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        });
  }
  
  private void a(ImageView paramImageView, TextView paramTextView, GroupNoticeModel paramGroupNoticeModel) {
    if (paramTextView != null)
      paramTextView.setText(paramGroupNoticeModel.ops_name); 
    if (paramImageView != null) {
      ImageLoader.a(this.b, paramGroupNoticeModel.ops_avatar).a(2131234356).c().a(paramImageView);
      paramImageView.setOnClickListener(new View.OnClickListener(this, paramGroupNoticeModel) {
            public void onClick(View param1View) {
              Context context = GroupNoticeAdapter.a(this.b);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.a.ops_uid);
              stringBuilder.append("");
              UserInfoFragmentNew.a(context, stringBuilder.toString(), "group_chatting");
            }
          });
    } 
  }
  
  private void a(TextView paramTextView, int paramInt) {
    if (paramTextView != null) {
      switch (paramInt) {
        default:
          return;
        case 11:
          paramTextView.setText(this.k.getString(2131756795));
          return;
        case 10:
          paramTextView.setText(this.k.getString(2131756793));
          return;
        case 9:
          paramTextView.setText(this.k.getString(2131756747));
          return;
        case 8:
          paramTextView.setText(this.k.getString(2131756746));
          return;
        case 7:
          paramTextView.setText(this.k.getString(2131756792));
          return;
        case 6:
          paramTextView.setText(this.k.getString(2131756745));
          return;
        case 5:
          paramTextView.setText(this.k.getString(2131756748));
          return;
        case 4:
          paramTextView.setText(this.k.getString(2131756744));
          return;
        case 2:
          break;
      } 
      paramTextView.setText(this.k.getString(2131756616));
    } 
  }
  
  private void b(TextView paramTextView, int paramInt) {
    if (paramTextView == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    paramTextView.setText(TimeAndDateUtils.a(stringBuilder.toString(), null));
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, GroupNoticeModel paramGroupNoticeModel) {
    paramBaseViewHolder.a(2131300663, paramGroupNoticeModel.text);
    Context context = this.k;
    if (paramGroupNoticeModel.type == 4) {
      i = 2131100837;
    } else {
      i = 2131100838;
    } 
    paramBaseViewHolder.f(2131301409, BluedSkinUtils.a(context, i));
    int i = paramGroupNoticeModel.type;
    boolean bool = false;
    if (i == 7) {
      paramBaseViewHolder.b(2131296555, true);
      if (paramGroupNoticeModel.result != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      paramBaseViewHolder.b(2131301141, bool1);
      boolean bool1 = bool;
      if (paramGroupNoticeModel.result == 0)
        bool1 = true; 
      paramBaseViewHolder.b(2131298727, bool1);
      if (paramGroupNoticeModel.result != 0) {
        i = paramGroupNoticeModel.result;
        if (i != 1) {
          if (i != 2) {
            if (i != 3)
              return; 
            paramBaseViewHolder.a(2131301141, this.k.getString(2131756636));
            return;
          } 
          paramBaseViewHolder.a(2131301141, this.k.getString(2131756743));
          return;
        } 
        paramBaseViewHolder.a(2131301141, this.k.getString(2131756612));
        return;
      } 
      if (paramGroupNoticeModel.type == 7) {
        paramBaseViewHolder.a(2131301246, this.k.getString(2131756757));
        paramBaseViewHolder.a(2131300504, this.k.getString(2131756739));
      } 
      paramBaseViewHolder.d(2131301246).setOnClickListener(new View.OnClickListener(this, paramBaseViewHolder, paramGroupNoticeModel) {
            public void onClick(View param1View) {
              GroupNoticeAdapter.a(this.c, 2, this.a, this.b);
            }
          });
      paramBaseViewHolder.d(2131300504).setOnClickListener(new View.OnClickListener(this, paramBaseViewHolder, paramGroupNoticeModel) {
            public void onClick(View param1View) {
              GroupNoticeAdapter.a(this.c, 1, this.a, this.b);
            }
          });
      return;
    } 
    paramBaseViewHolder.b(2131296555, false);
    paramBaseViewHolder.b(2131301141, false);
    paramBaseViewHolder.b(2131298727, false);
  }
  
  private void c(BaseViewHolder paramBaseViewHolder, GroupNoticeModel paramGroupNoticeModel) {
    int i;
    paramBaseViewHolder.a(2131300663, paramGroupNoticeModel.text);
    GroupUtil.a((ShapeTextView)paramBaseViewHolder.d(2131300911), paramGroupNoticeModel.ops_group_ago_role);
    ShapeHelper.ShapeView shapeView = (ShapeHelper.ShapeView)paramBaseViewHolder.d(2131297624);
    if (paramGroupNoticeModel.ops_group_ago_role == 2) {
      i = 2131100458;
    } else {
      i = 2131100881;
    } 
    ShapeHelper.b(shapeView, i);
  }
  
  private void d(BaseViewHolder paramBaseViewHolder, GroupNoticeModel paramGroupNoticeModel) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.k.getString(2131756647));
    stringBuilder.append(paramGroupNoticeModel.group_title);
    paramBaseViewHolder.a(2131300495, stringBuilder.toString());
    paramBaseViewHolder.a(2131300496, paramGroupNoticeModel.reason);
    int i = paramGroupNoticeModel.ops_vbadge;
    boolean bool2 = false;
    if (i == 3 || paramGroupNoticeModel.ops_vbadge == 5) {
      paramBaseViewHolder.b(2131300915, false);
    } else {
      paramBaseViewHolder.b(2131300915, true);
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramGroupNoticeModel.ops_age);
      stringBuilder.append("/");
      stringBuilder.append(paramGroupNoticeModel.ops_height);
      stringBuilder.append("/");
      stringBuilder.append(paramGroupNoticeModel.ops_weight);
      stringBuilder.append("/");
      Context context = this.k;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramGroupNoticeModel.ops_role);
      stringBuilder1.append("");
      stringBuilder.append(UserRelationshipUtils.c(context, stringBuilder1.toString()));
      paramBaseViewHolder.a(2131300915, stringBuilder.toString());
    } 
    if (paramGroupNoticeModel.result != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    paramBaseViewHolder.b(2131301141, bool1);
    boolean bool1 = bool2;
    if (paramGroupNoticeModel.result == 0)
      bool1 = true; 
    paramBaseViewHolder.b(2131298727, bool1);
    if (paramGroupNoticeModel.result != 0) {
      i = paramGroupNoticeModel.result;
      if (i != 1) {
        if (i != 2) {
          if (i != 3)
            return; 
          paramBaseViewHolder.a(2131301141, this.k.getString(2131756636));
          return;
        } 
        paramBaseViewHolder.a(2131301141, this.k.getString(2131756743));
        return;
      } 
      paramBaseViewHolder.a(2131301141, this.k.getString(2131756741));
      return;
    } 
    paramBaseViewHolder.d(2131301246).setOnClickListener(new View.OnClickListener(this, paramBaseViewHolder, paramGroupNoticeModel) {
          public void onClick(View param1View) {
            GroupNoticeAdapter.a(this.c, 2, this.a, this.b);
          }
        });
    paramBaseViewHolder.d(2131300504).setOnClickListener(new View.OnClickListener(this, paramBaseViewHolder, paramGroupNoticeModel) {
          public void onClick(View param1View) {
            GroupNoticeAdapter.a(this.c, 1, this.a, this.b);
          }
        });
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, GroupNoticeModel paramGroupNoticeModel) {
    b((TextView)paramBaseViewHolder.d(2131300697), paramGroupNoticeModel.timestamp);
    a((ImageView)paramBaseViewHolder.d(2131297797), (TextView)paramBaseViewHolder.d(2131301088), paramGroupNoticeModel);
    a((TextView)paramBaseViewHolder.d(2131301409), paramGroupNoticeModel.type);
    Context context = this.k;
    if (paramGroupNoticeModel.isRead == 1) {
      i = 2131100728;
    } else {
      i = 2131100733;
    } 
    paramBaseViewHolder.d(2131296833, BluedSkinUtils.a(context, i));
    int i = paramGroupNoticeModel.type;
    if (i != 1)
      if (i != 2) {
        if (i != 3) {
          b(paramBaseViewHolder, paramGroupNoticeModel);
          return;
        } 
      } else {
        d(paramBaseViewHolder, paramGroupNoticeModel);
        return;
      }  
    c(paramBaseViewHolder, paramGroupNoticeModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\adapter\GroupNoticeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */