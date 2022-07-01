package com.qiniu.android.collect;

import com.qiniu.android.http.UserAgent;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.ContextGetter;
import com.qiniu.android.utils.StringUtils;
import java.lang.reflect.InvocationTargetException;

public class UploadInfoElementCollector {
  public static LogHandler getUplogHandler(final Object obj) {
    return new LogHandler() {
        public Object getUploadInfo() {
          return obj;
        }
        
        public void send(String param1String, Object param1Object) {
          try {
            boolean bool = param1Object instanceof String;
            if (bool) {
              Class<?> clazz = obj.getClass();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("set");
              stringBuilder.append(StringUtils.upperCase(param1String));
              clazz.getMethod(stringBuilder.toString(), new Class[] { Class.forName("java.lang.String") }).invoke(obj, new Object[] { param1Object });
              return;
            } 
            if (param1Object instanceof Integer) {
              Class<?> clazz = obj.getClass();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("set");
              stringBuilder.append(StringUtils.upperCase(param1String));
              clazz.getMethod(stringBuilder.toString(), new Class[] { int.class }).invoke(obj, new Object[] { param1Object });
              return;
            } 
            if (param1Object instanceof Long) {
              Class<?> clazz = obj.getClass();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("set");
              stringBuilder.append(StringUtils.upperCase(param1String));
              clazz.getMethod(stringBuilder.toString(), new Class[] { long.class }).invoke(obj, new Object[] { param1Object });
              return;
            } 
          } catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
          } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
            return;
          } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
            return;
          } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
            return;
          } 
        }
      };
  }
  
  public static void setReqCommonElements(UploadInfoElement.ReqInfo paramReqInfo) {
    paramReqInfo.setOs_version(UserAgent.osVersion());
    paramReqInfo.setSdk_version("7.4.6");
    paramReqInfo.setUp_time(System.currentTimeMillis() / 1000L);
    paramReqInfo.setNetwork_type(AndroidNetwork.networkType(ContextGetter.applicationContext()));
    paramReqInfo.setSignal_strength(AndroidNetwork.getMobileDbm());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\collect\UploadInfoElementCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */