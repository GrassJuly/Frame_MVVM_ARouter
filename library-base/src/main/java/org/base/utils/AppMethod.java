package org.base.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.WindowManager;
import android.widget.TextView;

import org.frame.utils.StringUtils;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import androidx.fragment.app.Fragment;

/**
 * @Created by xiaoyu on 2017/1/6.
 * @Describe：公共调用方法
 * @Review by：
 * @Modify by：
 * @Version : $ v_1.0 on 2017/1/6.
 * @Remark:
 */
public class AppMethod {

    private static boolean isExist;

    private AppMethod() {
        throw new Error("我就是我，是一朵即将消逝的烟火。");
    }

    /**
     * 创建w文件
     *
     * @param url
     * @return
     */
    public static boolean createFile(String url) {
        try {
            File mFile = new File(url);
            if (mFile.exists()) {
                mFile.mkdirs();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * 创建w文件
     *
     * @param url
     * @return
     */
    public static void createFiles(String url) {
        try {
            File mFile = new File(url);
            if (mFile.exists()) {
                mFile.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除指定文件
     *
     * @param url
     * @return
     */
    public static boolean delFiles(String url) {
        try {
            File mFile = new File(url);
            return mFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置字符串颜色
     *
     * @param strings
     * @param inColor  前面字体颜色
     * @param outColor 后面字体颜色
     * @return
     */
    public static CharSequence setDiffCollors(CharSequence strings, int inColor, int outColor) {
        if (strings != null || !"".equals(strings)) {
            strings = ColorPhrase.from(strings).withSeparator("{}").innerColor(inColor).outerColor(outColor).format();
        }
        return strings;
    }


    /**
     * 分段显示数据并保留小数点后三位
     */
    public static String sectionDataThree(String data) {
        Double num = Double.parseDouble(data);
        DecimalFormat df = null;
        try {
            df = new DecimalFormat(",###,##0.000");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return df.format(num);
    }

    /**
     * 设置默认数据
     *
     * @param str 判断内容
     * @return
     */
    public static String setDefault(String str) {
        return StringUtils.isEmpty(str) ? "" : str;
    }


    /**
     * 设置默认数据
     *
     * @param str  判断内容
     * @param unit 单位   无单位时传空串 ""
     * @return
     */
    public static String setDefault(String str, String unit) {
        return StringUtils.isEmpty(str) ? "" : str + (StringUtils.isEmpty(unit) ? "" : " " + unit);
    }

    /**
     * 设置默认数据  数字
     *
     * @param str
     * @return
     */
    public static String setDefaultNumber(String str) {
        return StringUtils.isEmpty(str) ? "0" : str;
    }

    /**
     * 获取版本号
     *
     * @param context 上下文
     * @return 版本号
     */
    public static double getVersionCode(Context context) {
        //获取包管理器
        PackageManager pm = context.getPackageManager();
        //获取包信息
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            //返回版本号
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1.0;
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8,7，其他位置的可以为0-9
    */
        String telRegex = "[1][3578]\\d{9}";//"[1]"代表第1位为数字1，"[3587]"代表第二位可以为3、5、8,7中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (StringUtils.isEmpty(mobiles))
            return false;
        else
            return mobiles.matches(telRegex);
    }

    /**
     * @param context
     * @return
     */
    public static String getPackName(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param a
     * @param b
     * @return
     * @throws Exception
     */
    public static String division(String a, String b) {
        try {
            if (TextUtils.isEmpty(a)) return "";
            if (TextUtils.isEmpty(b)) return "";
            if ("0".equals(b)) return "";
            Double c = 0.0;
            double d = Double.parseDouble(a);
            double e = Double.parseDouble(b);
            if (d != 0.0 || e != 0.0) {
                c = d / e;
            }
            return new BigDecimal(c).setScale(0, BigDecimal.ROUND_HALF_UP).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public static String multiply(String a, String b) {
        try {
            if (TextUtils.isEmpty(a)) return "";
            if (TextUtils.isEmpty(b)) return "";
            Double c = 0.0;
            double d = Double.parseDouble(a);
            double e = Double.parseDouble(b);
            if (d != 0.0 || e != 0.0) {
                c = d * e;
            }
            return new BigDecimal(c).setScale(0, BigDecimal.ROUND_HALF_UP).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 校验车牌号
     *
     * @param carnumber
     * @return
     */
    public static boolean isCarnumberNO(String carnumber) {
        /*
         车牌号格式：省会 + A-Z + 5位A-Z或0-9
        （只包括了普通车牌号，教练车和部分部队车等车牌号不包括在内）
          */
        String str = "京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼港澳台";
        if (!StringUtils.isEmpty(carnumber)) {

            String s1 = carnumber.substring(0, 1);//获取字符串的第一个字符

            if (str.contains(s1)) {


            } else {
                return false;
            }


        } else {
            return false;
        }

        String carnumRegex = "[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}";
        if (TextUtils.isEmpty(carnumber)) return false;
        else return carnumber.matches(carnumRegex);
    }

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * @param enable
     */
    public static void setStatusBarVisibility(Activity activity, boolean enable) {
        if (enable) {
            WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
            lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            activity.getWindow().setAttributes(lp);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        } else {
            WindowManager.LayoutParams attr = activity.getWindow().getAttributes();
            attr.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            activity.getWindow().setAttributes(attr);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    /**
     * @param enable
     */
    public static void setFullScreen(Activity activity, boolean enable) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        if (enable) {
            lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        } else {
            lp.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        activity.getWindow().setAttributes(lp);
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    /**
     * //调用
     * SpannableString spannableString = changTVsize("53.9");
     * chooseMoviePrice.setText(spannableString);
     *
     * @param value
     * @return
     */
    public static SpannableString changTVsize(String value) {
        SpannableString spannableString = new SpannableString(value);
        if (value.contains(".")) {
            spannableString.setSpan(new RelativeSizeSpan(0.6f), value.indexOf("."), value.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return spannableString;
    }

    /**
     * 设置中划线
     *
     * @param textView
     */
    public static void setTextViewLine(TextView textView) {
        if (textView != null) {
            textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线 
            textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰
        }
    }

    private static String replaceAction(String str, String regular) {
        return str.replaceAll(regular, "*");
    }

    // 判断字符串是否是数字
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]{1,}");
        Matcher matcher = pattern.matcher(str);
        boolean result = matcher.matches();
        return result;
    }

    //^[A-Za-z0-9]+$

    // 判断字符串是否是数字和字母
    public static boolean isNumberAndLeter(String str) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
        Matcher matcher = pattern.matcher(str);
        boolean result = matcher.matches();
        return result;
    }
}
