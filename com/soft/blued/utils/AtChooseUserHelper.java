package com.soft.blued.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.EncryptTool;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.MsgChattingFragment;
import com.soft.blued.ui.msg_group.fragment.SearchMemberFragment;
import com.soft.blued.ui.user.fragment.ChooseFollowedFragment;
import com.soft.blued.user.UserInfo;
import java.util.ArrayList;
import java.util.List;

public class AtChooseUserHelper {
  private Context a;
  
  private List<UserBasicModel> b;
  
  private String c;
  
  public AtChooseUserHelper(Context paramContext) {
    this.a = paramContext;
    this.b = new ArrayList<UserBasicModel>();
    this.c = a("0");
  }
  
  public static String a(String paramString) {
    StringBuffer stringBuffer = new StringBuffer();
    String[] arrayOfString = paramString.split(",");
    for (int i = 0; i < arrayOfString.length; i++)
      stringBuffer.append((char)Integer.parseInt(arrayOfString[i])); 
    return stringBuffer.toString();
  }
  
  public static boolean c(String paramString) {
    String str = (UserInfo.a().i()).uid;
    if (!TextUtils.isEmpty(paramString)) {
      if (TextUtils.isEmpty(str))
        return false; 
      if (paramString.contains(str))
        return true; 
      if (paramString.contains(EncryptTool.b(str)))
        return true; 
    } 
    return false;
  }
  
  public void a(EditText paramEditText, Intent paramIntent, TextWatcher paramTextWatcher) {
    String str2 = paramIntent.getStringExtra("UID");
    String str1 = paramIntent.getStringExtra("USER_NAME");
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.uid = str2;
    userBasicModel.name = str1;
    a(paramEditText, userBasicModel, paramTextWatcher);
  }
  
  public void a(EditText paramEditText, UserBasicModel paramUserBasicModel, TextWatcher paramTextWatcher) {
    a(paramEditText, paramUserBasicModel, paramTextWatcher, true);
  }
  
  public void a(EditText paramEditText, UserBasicModel paramUserBasicModel, TextWatcher paramTextWatcher, boolean paramBoolean) {
    if (paramUserBasicModel != null) {
      String str1 = paramUserBasicModel.uid;
      String str2 = paramUserBasicModel.name;
      if (!StringUtils.e(str1) && !StringUtils.e(str2)) {
        CharSequence charSequence;
        Editable editable1;
        if (this.b == null)
          this.b = new ArrayList<UserBasicModel>(); 
        this.b.add(paramUserBasicModel);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@");
        stringBuilder.append(paramUserBasicModel.name);
        stringBuilder.append(" ");
        stringBuilder.append(this.c);
        String str = stringBuilder.toString();
        Editable editable2 = paramEditText.getText();
        int i = paramEditText.getSelectionEnd();
        if (i != 0) {
          if (paramBoolean) {
            charSequence = paramEditText.getText().subSequence(0, i - 1);
          } else {
            charSequence = paramEditText.getText().subSequence(0, i);
          } 
          CharSequence charSequence2 = paramEditText.getText().subSequence(i, editable2.length());
          CharSequence charSequence1 = charSequence;
          charSequence = charSequence2;
        } else {
          editable1 = paramEditText.getText();
          charSequence = "";
        } 
        paramEditText.removeTextChangedListener(paramTextWatcher);
        paramEditText.setText("");
        paramEditText.append((CharSequence)editable1);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(2131100716)), 0, str.length(), 33);
        spannableString.setSpan(new StyleSpan(1), 0, str.length(), 33);
        paramEditText.addTextChangedListener(paramTextWatcher);
        paramEditText.append((CharSequence)spannableString);
        paramEditText.append(charSequence);
        if (i != editable2.length()) {
          if (paramBoolean) {
            paramEditText.setSelection(i + str.length() - 1);
            return;
          } 
          paramEditText.setSelection(i + str.length());
        } 
      } 
    } 
  }
  
  public boolean a(Object paramObject, int paramInt1, String paramString1, String paramString2, Editable paramEditable, int paramInt2, int paramInt3) {
    if (!StringUtils.e(paramString2)) {
      Context context;
      StringBuilder stringBuilder;
      boolean bool = StringUtils.e(paramString1);
      byte b = 2;
      if (bool || paramString2.length() > paramString1.length()) {
        if (paramString2.length() >= 1) {
          int i = paramInt2 - 1;
          if (i >= 0) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(paramString2.subSequence(i, paramInt2));
            stringBuilder1.append("");
            if (stringBuilder1.toString().equals("@")) {
              if (paramObject != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("from", paramInt1);
                if (paramObject instanceof com.blued.android.core.ui.BaseFragment) {
                  if (paramObject instanceof MsgChattingFragment) {
                    paramObject = paramObject;
                    if (((MsgChattingFragment)paramObject).t.j() == null) {
                      paramInt1 = b;
                    } else {
                      paramInt1 = (((MsgChattingFragment)paramObject).t.j()).group_role;
                    } 
                    context = paramObject.getContext();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(((MsgChattingFragment)paramObject).t.f());
                    stringBuilder.append("");
                    SearchMemberFragment.a(context, 1, stringBuilder.toString(), paramInt1, paramInt3);
                    return true;
                  } 
                  paramObject = paramObject;
                  TerminalActivity.a((Fragment)paramObject, ChooseFollowedFragment.class, (Bundle)context, paramInt3);
                  ActivityChangeAnimationUtils.a((Activity)paramObject.getActivity());
                  return true;
                } 
                if (paramObject instanceof Activity) {
                  paramObject = paramObject;
                  TerminalActivity.a((Context)paramObject, ChooseFollowedFragment.class, (Bundle)context, paramInt3);
                  ActivityChangeAnimationUtils.a((Activity)paramObject);
                } 
              } 
              return true;
            } 
          } 
        } 
        return false;
      } 
      if (stringBuilder.length() != context.length() && !StringUtils.e((String)context)) {
        paramObject = this.c;
        paramInt1 = paramInt2 + 1;
        if (paramObject.equals(context.substring(paramInt2, paramInt1))) {
          if (context.length() < paramInt1)
            paramInt1 = context.length(); 
          paramObject = this.c;
          paramInt2 = paramInt1 - 1;
          if (paramObject.equals(context.substring(paramInt2, paramInt1))) {
            paramObject = paramEditable.subSequence(0, paramInt2);
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(paramObject);
            stringBuilder1.append("");
            paramObject = stringBuilder1.toString().split("@");
            if (paramObject.length >= 2)
              paramEditable.delete(paramInt2 - paramObject[paramObject.length - 1].length() - 1, paramInt2); 
            return true;
          } 
        } 
      } 
    } 
    return false;
  }
  
  public boolean a(Object paramObject, String paramString1, String paramString2, Editable paramEditable, int paramInt) {
    return a(paramObject, 0, paramString1, paramString2, paramEditable, paramInt, 9090);
  }
  
  public String b(String paramString) {
    String str = paramString;
    if (!StringUtils.e(paramString)) {
      String str1;
      int i = 0;
      while (true) {
        str1 = paramString;
        if (i < this.b.size()) {
          str = ((UserBasicModel)this.b.get(i)).uid;
          str1 = ((UserBasicModel)this.b.get(i)).name;
          str = StringUtils.c(((UserBasicModel)this.b.get(i)).name, str);
          while (true) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("@");
            stringBuilder.append(str1);
            if (paramString.contains(stringBuilder.toString())) {
              stringBuilder = new StringBuilder();
              stringBuilder.append("@");
              stringBuilder.append(str1);
              paramString = paramString.replace(stringBuilder.toString(), str);
              continue;
            } 
            i++;
          } 
        } 
        break;
      } 
      while (true) {
        str = str1;
        if (str1.contains(this.c)) {
          str1 = str1.replace(this.c, "");
          continue;
        } 
        break;
      } 
    } 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\AtChooseUserHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */