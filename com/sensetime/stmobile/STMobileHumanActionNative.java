package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STMobileFaceInfo;

public class STMobileHumanActionNative {
  public static final long ST_MOBILE_BODY_ACTION1 = 4294967296L;
  
  public static final long ST_MOBILE_BODY_ACTION2 = 8589934592L;
  
  public static final long ST_MOBILE_BODY_ACTION3 = 17179869184L;
  
  public static final long ST_MOBILE_BODY_ACTION4 = 34359738368L;
  
  public static final long ST_MOBILE_BODY_ACTION5 = 68719476736L;
  
  public static final int ST_MOBILE_BODY_DETECT_FULL = 402653184;
  
  public static final long ST_MOBILE_BODY_KEYPOINTS = 134217728L;
  
  public static final long ST_MOBILE_BROW_JUMP = 32L;
  
  public static final long ST_MOBILE_DETECT_AVATAR_HELPINFO = 140737488355328L;
  
  public static final long ST_MOBILE_DETECT_DYNAMIC_GESTURE = 35184372088832L;
  
  public static final long ST_MOBILE_DETECT_EXTRA_FACE_POINTS = 16777216L;
  
  public static final long ST_MOBILE_DETECT_EYEBALL_CENTER = 33554432L;
  
  public static final long ST_MOBILE_DETECT_EYEBALL_CONTOUR = 67108864L;
  
  public static final long ST_MOBILE_DETECT_GAZE = 17592186044416L;
  
  public static final int ST_MOBILE_DETECT_MODE_IMAGE = 262144;
  
  public static final int ST_MOBILE_DETECT_MODE_VIDEO = 131072;
  
  public static final int ST_MOBILE_DETECT_TONGUE = 1073741824;
  
  public static final int ST_MOBILE_ENABLE_AVATAR_HELPER = 536870912;
  
  public static final int ST_MOBILE_ENABLE_BODY_CONTOUR = 16384;
  
  public static final int ST_MOBILE_ENABLE_BODY_KEYPOINTS = 4096;
  
  public static final int ST_MOBILE_ENABLE_DYNAMIC_GESTURE = 268435456;
  
  public static final int ST_MOBILE_ENABLE_EYEBALL_CENTER_DETECT = 1024;
  
  public static final int ST_MOBILE_ENABLE_EYEBALL_CONTOUR_DETECT = 2048;
  
  public static final int ST_MOBILE_ENABLE_FACE_DETECT = 64;
  
  public static final int ST_MOBILE_ENABLE_FACE_EXTRA_DETECT = 512;
  
  public static final int ST_MOBILE_ENABLE_GAZE_DETECT = 134217728;
  
  public static final int ST_MOBILE_ENABLE_HAIR_SEGMENT = 32768;
  
  public static final int ST_MOBILE_ENABLE_HAND_DETECT = 128;
  
  public static final int ST_MOBILE_ENABLE_HAND_SKELETON_KEYPOINTS = 16777216;
  
  public static final int ST_MOBILE_ENABLE_HAND_SKELETON_KEYPOINTS_3D = 33554432;
  
  public static final int ST_MOBILE_ENABLE_MULTI_SEGMENT = 67108864;
  
  public static final int ST_MOBILE_ENABLE_SEGMENT_DETECT = 256;
  
  public static final long ST_MOBILE_EYE_BLINK = 2L;
  
  public static final long ST_MOBILE_FACE_DETECT = 1L;
  
  public static final int ST_MOBILE_FACE_DETECT_FULL = 255;
  
  public static final long ST_MOBILE_FACE_LIPS_POUTED = 128L;
  
  public static final long ST_MOBILE_FACE_LIPS_UPWARD = 64L;
  
  public static final long ST_MOBILE_HAND_666 = 4194304L;
  
  public static final long ST_MOBILE_HAND_BLESS = 8388608L;
  
  public static final long ST_MOBILE_HAND_CONGRATULATE = 131072L;
  
  public static final long ST_MOBILE_HAND_DETECT_FULL = 71468272516864L;
  
  public static final long ST_MOBILE_HAND_FINGER_HEART = 262144L;
  
  public static final long ST_MOBILE_HAND_FINGER_INDEX = 1048576L;
  
  public static final long ST_MOBILE_HAND_FIST = 2097152L;
  
  public static final long ST_MOBILE_HAND_GOOD = 2048L;
  
  public static final long ST_MOBILE_HAND_HOLDUP = 32768L;
  
  public static final long ST_MOBILE_HAND_ILOVEYOU = 1099511627776L;
  
  public static final long ST_MOBILE_HAND_LOVE = 16384L;
  
  public static final long ST_MOBILE_HAND_OK = 512L;
  
  public static final long ST_MOBILE_HAND_PALM = 4096L;
  
  public static final long ST_MOBILE_HAND_PISTOL = 8192L;
  
  public static final long ST_MOBILE_HAND_SCISSOR = 1024L;
  
  public static final long ST_MOBILE_HEAD_PITCH = 16L;
  
  public static final long ST_MOBILE_HEAD_YAW = 8L;
  
  public static final long ST_MOBILE_HUMAN_ACTION_DEFAULT_CONFIG_DETECT = 101177407L;
  
  public static final int ST_MOBILE_HUMAN_ACTION_DEFAULT_CONFIG_IMAGE = 328128;
  
  public static final int ST_MOBILE_HUMAN_ACTION_DEFAULT_CONFIG_VIDEO = 131568;
  
  public static final long ST_MOBILE_MOUTH_AH = 4L;
  
  public static final long ST_MOBILE_SEG_BACKGROUND = 65536L;
  
  public static final long ST_MOBILE_SEG_MULTI = 8796093022208L;
  
  private static final String TAG = STMobileHumanActionNative.class.getSimpleName();
  
  private long nativeHumanActionHandle;
  
  static {
    System.loadLibrary("st_mobile");
    System.loadLibrary("stmobile_jni");
  }
  
  public static native boolean[] getExpression(STHumanAction paramSTHumanAction, int paramInt, boolean paramBoolean);
  
  public static native void setExpressionThreshold(int paramInt, float paramFloat);
  
  public native int addSubModel(String paramString);
  
  public native int addSubModelFromAssetFile(String paramString, AssetManager paramAssetManager);
  
  public native int createInstance(String paramString, int paramInt);
  
  public native int createInstanceFromAssetFile(String paramString, int paramInt, AssetManager paramAssetManager);
  
  public native int createInstanceWithSubModels(String[] paramArrayOfString, int paramInt1, int paramInt2);
  
  public native void destroyInstance();
  
  public native float getFaceActionThreshold(long paramLong);
  
  public native float getFaceDistance(STMobileFaceInfo paramSTMobileFaceInfo, int paramInt1, int paramInt2, int paramInt3, float paramFloat);
  
  public native STHumanAction humanActionDetect(byte[] paramArrayOfbyte, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  public native int removeSubModelByConfig(int paramInt);
  
  public native int reset();
  
  public native int setFaceActionThreshold(long paramLong, float paramFloat);
  
  public native int setParam(int paramInt, float paramFloat);
  
  public enum STMobileExpression {
    ST_MOBILE_EXPRESSION_BROW_JUMP,
    ST_MOBILE_EXPRESSION_COUNT,
    ST_MOBILE_EXPRESSION_EYE_BLINK(1),
    ST_MOBILE_EXPRESSION_FACE_ALL(1),
    ST_MOBILE_EXPRESSION_FACE_LIPS_CURL_LEFT(1),
    ST_MOBILE_EXPRESSION_FACE_LIPS_CURL_RIGHT(1),
    ST_MOBILE_EXPRESSION_FACE_LIPS_POUTED(1),
    ST_MOBILE_EXPRESSION_FACE_LIPS_UPWARD(1),
    ST_MOBILE_EXPRESSION_HAND_ALL(1),
    ST_MOBILE_EXPRESSION_HAND_CONGRATULATE(1),
    ST_MOBILE_EXPRESSION_HAND_FINGER_HEART(1),
    ST_MOBILE_EXPRESSION_HAND_FINGER_INDEX(1),
    ST_MOBILE_EXPRESSION_HAND_GOOD(1),
    ST_MOBILE_EXPRESSION_HAND_HOLDUP(1),
    ST_MOBILE_EXPRESSION_HAND_LOVE(1),
    ST_MOBILE_EXPRESSION_HAND_OK(1),
    ST_MOBILE_EXPRESSION_HAND_PALM(1),
    ST_MOBILE_EXPRESSION_HAND_PISTOL(1),
    ST_MOBILE_EXPRESSION_HAND_SCISSOR(1),
    ST_MOBILE_EXPRESSION_HEAD_LOWER(1),
    ST_MOBILE_EXPRESSION_HEAD_NORMAL(1),
    ST_MOBILE_EXPRESSION_HEAD_PITCH(1),
    ST_MOBILE_EXPRESSION_HEAD_RISE(1),
    ST_MOBILE_EXPRESSION_HEAD_YAW(1),
    ST_MOBILE_EXPRESSION_LEFTEYE_CLOSE_RIGHTEYE_OPEN(1),
    ST_MOBILE_EXPRESSION_LEFTEYE_OPEN_RIGHTEYE_CLOSE(1),
    ST_MOBILE_EXPRESSION_MOUTH_AH(2),
    ST_MOBILE_EXPRESSION_MOUTH_CLOSE(2),
    ST_MOBILE_EXPRESSION_MOUTH_OPEN(2),
    ST_MOBILE_EXPRESSION_SIDE_FACE_LEFT(2),
    ST_MOBILE_EXPRESSION_SIDE_FACE_RIGHT(2),
    ST_MOBILE_EXPRESSION_TILTED_FACE_LEFT(2),
    ST_MOBILE_EXPRESSION_TILTED_FACE_RIGHT(2),
    ST_MOBILE_EXPRESSION_TWO_EYE_CLOSE(2),
    ST_MOBILE_EXPRESSION_TWO_EYE_OPEN(2);
    
    private final int expressionCode;
    
    static {
      ST_MOBILE_EXPRESSION_HEAD_PITCH = new STMobileExpression("ST_MOBILE_EXPRESSION_HEAD_PITCH", 3, 4);
      ST_MOBILE_EXPRESSION_BROW_JUMP = new STMobileExpression("ST_MOBILE_EXPRESSION_BROW_JUMP", 4, 5);
      ST_MOBILE_EXPRESSION_HAND_OK = new STMobileExpression("ST_MOBILE_EXPRESSION_HAND_OK", 5, 9);
      ST_MOBILE_EXPRESSION_HAND_SCISSOR = new STMobileExpression("ST_MOBILE_EXPRESSION_HAND_SCISSOR", 6, 10);
      ST_MOBILE_EXPRESSION_HAND_GOOD = new STMobileExpression("ST_MOBILE_EXPRESSION_HAND_GOOD", 7, 11);
      ST_MOBILE_EXPRESSION_HAND_PALM = new STMobileExpression("ST_MOBILE_EXPRESSION_HAND_PALM", 8, 12);
      ST_MOBILE_EXPRESSION_HAND_PISTOL = new STMobileExpression("ST_MOBILE_EXPRESSION_HAND_PISTOL", 9, 13);
      ST_MOBILE_EXPRESSION_HAND_LOVE = new STMobileExpression("ST_MOBILE_EXPRESSION_HAND_LOVE", 10, 14);
      ST_MOBILE_EXPRESSION_HAND_HOLDUP = new STMobileExpression("ST_MOBILE_EXPRESSION_HAND_HOLDUP", 11, 15);
      ST_MOBILE_EXPRESSION_HAND_CONGRATULATE = new STMobileExpression("ST_MOBILE_EXPRESSION_HAND_CONGRATULATE", 12, 17);
      ST_MOBILE_EXPRESSION_HAND_FINGER_HEART = new STMobileExpression("ST_MOBILE_EXPRESSION_HAND_FINGER_HEART", 13, 18);
      ST_MOBILE_EXPRESSION_HAND_FINGER_INDEX = new STMobileExpression("ST_MOBILE_EXPRESSION_HAND_FINGER_INDEX", 14, 20);
      ST_MOBILE_EXPRESSION_HEAD_NORMAL = new STMobileExpression("ST_MOBILE_EXPRESSION_HEAD_NORMAL", 15, 65);
      ST_MOBILE_EXPRESSION_SIDE_FACE_LEFT = new STMobileExpression("ST_MOBILE_EXPRESSION_SIDE_FACE_LEFT", 16, 66);
      ST_MOBILE_EXPRESSION_SIDE_FACE_RIGHT = new STMobileExpression("ST_MOBILE_EXPRESSION_SIDE_FACE_RIGHT", 17, 67);
      ST_MOBILE_EXPRESSION_TILTED_FACE_LEFT = new STMobileExpression("ST_MOBILE_EXPRESSION_TILTED_FACE_LEFT", 18, 68);
      ST_MOBILE_EXPRESSION_TILTED_FACE_RIGHT = new STMobileExpression("ST_MOBILE_EXPRESSION_TILTED_FACE_RIGHT", 19, 69);
      ST_MOBILE_EXPRESSION_HEAD_RISE = new STMobileExpression("ST_MOBILE_EXPRESSION_HEAD_RISE", 20, 70);
      ST_MOBILE_EXPRESSION_HEAD_LOWER = new STMobileExpression("ST_MOBILE_EXPRESSION_HEAD_LOWER", 21, 71);
      ST_MOBILE_EXPRESSION_TWO_EYE_CLOSE = new STMobileExpression("ST_MOBILE_EXPRESSION_TWO_EYE_CLOSE", 22, 85);
      ST_MOBILE_EXPRESSION_TWO_EYE_OPEN = new STMobileExpression("ST_MOBILE_EXPRESSION_TWO_EYE_OPEN", 23, 86);
      ST_MOBILE_EXPRESSION_LEFTEYE_OPEN_RIGHTEYE_CLOSE = new STMobileExpression("ST_MOBILE_EXPRESSION_LEFTEYE_OPEN_RIGHTEYE_CLOSE", 24, 87);
      ST_MOBILE_EXPRESSION_LEFTEYE_CLOSE_RIGHTEYE_OPEN = new STMobileExpression("ST_MOBILE_EXPRESSION_LEFTEYE_CLOSE_RIGHTEYE_OPEN", 25, 88);
      ST_MOBILE_EXPRESSION_MOUTH_OPEN = new STMobileExpression("ST_MOBILE_EXPRESSION_MOUTH_OPEN", 26, 105);
      ST_MOBILE_EXPRESSION_MOUTH_CLOSE = new STMobileExpression("ST_MOBILE_EXPRESSION_MOUTH_CLOSE", 27, 106);
      ST_MOBILE_EXPRESSION_FACE_LIPS_UPWARD = new STMobileExpression("ST_MOBILE_EXPRESSION_FACE_LIPS_UPWARD", 28, 107);
      ST_MOBILE_EXPRESSION_FACE_LIPS_POUTED = new STMobileExpression("ST_MOBILE_EXPRESSION_FACE_LIPS_POUTED", 29, 108);
      ST_MOBILE_EXPRESSION_FACE_LIPS_CURL_LEFT = new STMobileExpression("ST_MOBILE_EXPRESSION_FACE_LIPS_CURL_LEFT", 30, 109);
      ST_MOBILE_EXPRESSION_FACE_LIPS_CURL_RIGHT = new STMobileExpression("ST_MOBILE_EXPRESSION_FACE_LIPS_CURL_RIGHT", 31, 110);
      ST_MOBILE_EXPRESSION_COUNT = new STMobileExpression("ST_MOBILE_EXPRESSION_COUNT", 32, 128);
      ST_MOBILE_EXPRESSION_FACE_ALL = new STMobileExpression("ST_MOBILE_EXPRESSION_FACE_ALL", 33, 257);
      ST_MOBILE_EXPRESSION_HAND_ALL = new STMobileExpression("ST_MOBILE_EXPRESSION_HAND_ALL", 34, 258);
      $VALUES = new STMobileExpression[] { 
          ST_MOBILE_EXPRESSION_EYE_BLINK, ST_MOBILE_EXPRESSION_MOUTH_AH, ST_MOBILE_EXPRESSION_HEAD_YAW, ST_MOBILE_EXPRESSION_HEAD_PITCH, ST_MOBILE_EXPRESSION_BROW_JUMP, ST_MOBILE_EXPRESSION_HAND_OK, ST_MOBILE_EXPRESSION_HAND_SCISSOR, ST_MOBILE_EXPRESSION_HAND_GOOD, ST_MOBILE_EXPRESSION_HAND_PALM, ST_MOBILE_EXPRESSION_HAND_PISTOL, 
          ST_MOBILE_EXPRESSION_HAND_LOVE, ST_MOBILE_EXPRESSION_HAND_HOLDUP, ST_MOBILE_EXPRESSION_HAND_CONGRATULATE, ST_MOBILE_EXPRESSION_HAND_FINGER_HEART, ST_MOBILE_EXPRESSION_HAND_FINGER_INDEX, ST_MOBILE_EXPRESSION_HEAD_NORMAL, ST_MOBILE_EXPRESSION_SIDE_FACE_LEFT, ST_MOBILE_EXPRESSION_SIDE_FACE_RIGHT, ST_MOBILE_EXPRESSION_TILTED_FACE_LEFT, ST_MOBILE_EXPRESSION_TILTED_FACE_RIGHT, 
          ST_MOBILE_EXPRESSION_HEAD_RISE, ST_MOBILE_EXPRESSION_HEAD_LOWER, ST_MOBILE_EXPRESSION_TWO_EYE_CLOSE, ST_MOBILE_EXPRESSION_TWO_EYE_OPEN, ST_MOBILE_EXPRESSION_LEFTEYE_OPEN_RIGHTEYE_CLOSE, ST_MOBILE_EXPRESSION_LEFTEYE_CLOSE_RIGHTEYE_OPEN, ST_MOBILE_EXPRESSION_MOUTH_OPEN, ST_MOBILE_EXPRESSION_MOUTH_CLOSE, ST_MOBILE_EXPRESSION_FACE_LIPS_UPWARD, ST_MOBILE_EXPRESSION_FACE_LIPS_POUTED, 
          ST_MOBILE_EXPRESSION_FACE_LIPS_CURL_LEFT, ST_MOBILE_EXPRESSION_FACE_LIPS_CURL_RIGHT, ST_MOBILE_EXPRESSION_COUNT, ST_MOBILE_EXPRESSION_FACE_ALL, ST_MOBILE_EXPRESSION_HAND_ALL };
    }
    
    STMobileExpression(int param1Int1) {
      this.expressionCode = param1Int1;
    }
    
    public int getExpressionCode() {
      return this.expressionCode;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STMobileHumanActionNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */