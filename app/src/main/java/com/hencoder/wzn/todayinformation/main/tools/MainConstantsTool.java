package com.hencoder.wzn.todayinformation.main.tools;

import android.support.annotation.IntDef;

import static com.hencoder.wzn.todayinformation.main.tools.MainConstantsTool.BEIJING;
import static com.hencoder.wzn.todayinformation.main.tools.MainConstantsTool.HANGZHOU;
import static com.hencoder.wzn.todayinformation.main.tools.MainConstantsTool.SHANGHAI;
import static com.hencoder.wzn.todayinformation.main.tools.MainConstantsTool.SHENZHEN;

/**
 * Created by wzn on 2019/7/14.
 * 通过Android系统自带的注解来定义常量值
 */


@IntDef({SHANGHAI, HANGZHOU, BEIJING, SHENZHEN})
public @interface MainConstantsTool {
    int SHANGHAI = 0; //RadioButton位置，表示上海
    int HANGZHOU = 1;//RadioButton位置，表示杭州
    int BEIJING = 2; //RadioButton位置，表示北京
    int SHENZHEN = 3; //RadioButton位置，表示深圳


}
