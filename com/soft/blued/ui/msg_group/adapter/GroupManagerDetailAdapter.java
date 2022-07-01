package com.soft.blued.ui.msg_group.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public class GroupManagerDetailAdapter extends BaseQuickAdapter<GroupMemberModel, BaseViewHolder> {
  private IRequestHost a;
  
  public GroupManagerDetailAdapter(List<GroupMemberModel> paramList, IRequestHost paramIRequestHost) {
    super(2131493540, paramList);
    this.a = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, GroupMemberModel paramGroupMemberModel) {
    boolean bool;
    if (paramGroupMemberModel.online_state == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    paramBaseViewHolder.c(2131297883, bool);
    TextView textView5 = (TextView)paramBaseViewHolder.d(2131299744);
    TextView textView6 = (TextView)paramBaseViewHolder.d(2131299358);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131299164);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131296426);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131297368);
    TextView textView4 = (TextView)paramBaseViewHolder.d(2131301755);
    LinearLayout linearLayout2 = (LinearLayout)paramBaseViewHolder.d(2131299013);
    LinearLayout linearLayout1 = (LinearLayout)paramBaseViewHolder.d(2131298778);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297447);
    RelativeLayout relativeLayout = (RelativeLayout)paramBaseViewHolder.d(2131296638);
    UserRelationshipUtils.a(imageView, (UserBasicModel)paramGroupMemberModel);
    if (paramGroupMemberModel.is_official != 1)
      UserRelationshipUtils.a(this.k, textView5, paramGroupMemberModel.role); 
    if (!TextUtils.isEmpty(paramGroupMemberModel.note)) {
      textView6.setText(paramGroupMemberModel.note);
    } else if (!TextUtils.isEmpty(paramGroupMemberModel.name)) {
      textView6.setText(paramGroupMemberModel.name);
    } else {
      textView6.setText("");
    } 
    UserRelationshipUtils.a(this.k, textView6, (UserBasicModel)paramGroupMemberModel);
    if (paramGroupMemberModel.vbadge == 3 || paramGroupMemberModel.vbadge == 5) {
      linearLayout2.setVisibility(8);
    } else {
      linearLayout2.setVisibility(0);
      if (!TextUtils.isEmpty(paramGroupMemberModel.age)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramGroupMemberModel.age);
        stringBuilder.append(this.k.getResources().getString(2131755267));
        textView2.setText(stringBuilder.toString());
      } else {
        textView2.setText("");
      } 
      if (!TextUtils.isEmpty(paramGroupMemberModel.height)) {
        textView3.setText(paramGroupMemberModel.height);
      } else {
        textView3.setText("");
      } 
      if (!TextUtils.isEmpty(paramGroupMemberModel.weight)) {
        textView4.setText(paramGroupMemberModel.weight);
      } else {
        textView4.setText("");
      } 
    } 
    if (paramGroupMemberModel.vbadge == 3) {
      linearLayout1.setVisibility(8);
    } else {
      linearLayout1.setVisibility(0);
    } 
    if (!TextUtils.isEmpty(paramGroupMemberModel.location) && paramGroupMemberModel.vbadge != 3) {
      textView1.setText(paramGroupMemberModel.location);
    } else {
      textView1.setText("");
    } 
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(2131300911);
    if ("0".equals(paramGroupMemberModel.uid)) {
      ImageLoader.a(this.a, 2131232522).c().a((ImageView)paramBaseViewHolder.d(2131297804));
      shapeTextView.setVisibility(4);
      relativeLayout.setVisibility(8);
    } else {
      relativeLayout.setVisibility(0);
      GroupUtil.a(shapeTextView, paramGroupMemberModel.group_role);
      ImageLoader.a(this.a, AvatarUtils.a(0, paramGroupMemberModel.avatar)).c().a(2131234356).a((ImageView)paramBaseViewHolder.d(2131297804));
    } 
    paramBaseViewHolder.c(2131297804);
    paramBaseViewHolder.c(2131296638);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\adapter\GroupManagerDetailAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */