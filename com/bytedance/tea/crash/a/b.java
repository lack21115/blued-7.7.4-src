package com.bytedance.tea.crash.a;

import android.app.ActivityManager;

public class b {
  static String a(ActivityManager.ProcessErrorStateInfo paramProcessErrorStateInfo) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("|------------- processErrorStateInfo--------------|\n");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("condition: ");
    stringBuilder2.append(paramProcessErrorStateInfo.condition);
    stringBuilder2.append("\n");
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("processName: ");
    stringBuilder2.append(paramProcessErrorStateInfo.processName);
    stringBuilder2.append("\n");
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("pid: ");
    stringBuilder2.append(paramProcessErrorStateInfo.pid);
    stringBuilder2.append("\n");
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("uid: ");
    stringBuilder2.append(paramProcessErrorStateInfo.uid);
    stringBuilder2.append("\n");
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("tag: ");
    stringBuilder2.append(paramProcessErrorStateInfo.tag);
    stringBuilder2.append("\n");
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("shortMsg : ");
    stringBuilder2.append(paramProcessErrorStateInfo.shortMsg);
    stringBuilder2.append("\n");
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("longMsg : ");
    stringBuilder2.append(paramProcessErrorStateInfo.longMsg);
    stringBuilder2.append("\n");
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder1.append("-----------------------end----------------------------");
    return stringBuilder1.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */