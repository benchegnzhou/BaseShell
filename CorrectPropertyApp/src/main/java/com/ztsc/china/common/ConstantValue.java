package com.ztsc.china.common;

/**
 * Created by lenovo on 2016/10/18.
 * app常量的定义
 */
public class ConstantValue {

    /**
     * 启动相机拍照的请求码
     */
    public static final int REQUEST_CODE_PHOTOGRAPH = 100;

    /**
     * 6.0获取电话状态权限的请求码
     */
    public static final int REQUEST_CODE_PHNE_STATUS = 101;
    /**
     * 6.0获取内存读写权限的请求码
     */
    public static final int REQUEST_CODE_WRITE_SDCARD = 102;


    /**
     * 本地媒体库查询的结果码
     */
    public static int REQUEST_CODE_MULTISELECT_ALBUM = 200;
    /**
     * 从媒体库筛选图片的请求码
     */
    public static final int REQUEST_CODE_ALBUM = 300;

    /**
     * 昵称修改请求码
     */
    public static final int REQUEST_CODE_NICENAMECHANGE_RESULT = 400;


    /**
     * 电话修改请求码
     */
    public static final int REQUEST_CODE_TELNUMCHANGE_RESULT = 401;
    /**
     * Activity  跳转协议码
     */
    public static final int erroCode = -1;                //错误注册协议码
    public static final int changeNiceNameCode = 0;     //昵称修改注册协议码
    public static final int changTelCode = 1;            //电话修改注册协议码

    /**
     * 用户个人信息存储
     */
    public static final String USER_INFORMATION_PATH = "user";

    /**
     * 用户相关信息存储
     */
    public static final String ABOUT_USER_INFORMATION_PATH = "aboutUsers";


    /**
     * 订单的状态
     * 100000	帮助者下单成功等待求助者确认
     * <p>
     * 120000	帮助者取消订单
     * 160000	订单被拒绝，求助者拒绝接受帮助
     * 190000	帮助者接单超时
     * <p>
     * 150000	订单生效并没有到达服务时间，求助者接受
     * 152000	    未到达服务时间，帮助者申请取消订单
     * 152500	        未到达服务时间，帮助者申请取消订单,求助者同意
     * 152600	        未到达服务时间，帮助者申请取消订单,求助者拒绝
     * 152900	        未到达服务时间，帮助者申请取消订单,求助者无动作订单超时订单结束
     * <p>
     * 155000	   求助者确认完成(未到达服务时间)
     * <p>
     * 156000	    未到达服务时间，求助者取消订单
     * 156100	        未到达服务时间，求助者取消订单，帮助者同意
     * 156200	        未到达服务时间，求助者取消订单，帮助者拒绝
     * 156900           未到达服务时间， 求助者取消订单(未到达服务时间)，帮助者无动作订单超时订单结束
     * <p>
     * 159000       订单自动到达服务时间，
     * 159100           到达服务时间，帮助者确认完成
     * 159150	            到达服务时间，帮助者确认完成,求助者同意
     * 159160	            到达服务时间，帮助者确认完成,求助者拒绝
     * 159190	            到达服务时间，帮助者确认完成,求助者无动作订单超时订单结束
     * <p>
     * <p>
     * <p>
     * 159200	    帮助者取消(到达服务时间)
     * 159250	             到达服务时间，订单被求助者申请取消,求助者同意
     * 159260	             到达服务时间，订单被求助者申请取消,求助者拒绝
     * 159290	             到达服务时间，订单被求助者申请取消,求助者无动作订单超时订单结束
     * <p>
     * 159500	    到达服务时间，订单被求助者确认完成
     * <p>
     * 159600	    被求助者取消申请订单(到达服务时间)
     * 159610	            到达服务时间，被求助者取消申请订单,帮助者同意
     * 159620	            到达服务时间，被求助者取消申请订单,帮助者拒绝
     * 159690	            到达服务时间，被求助者取消申请订单,帮助者无动作订单超时订单结束
     * <p>
     * 159161	            到达服务时间，帮助者确认完成,求助者拒绝，帮着同意
     * 159162	            到达服务时间，帮助者确认完成,求助者拒绝，帮着拒绝
     * 159169	            到达服务时间，帮助者确认完成,求助者拒绝，帮着超时
     * <p>
     * <p>
     * xxx	订单删除
     * <p>
     * <p>
     */

    //---------------------接单前的处理---------------------------
    //帮助者下单成功等待求助者确认
    public static final int ORDER_WAITING_BEGGER_ACCEPT = 100000;
    //	帮助者取消订单
    public static final int ORDER_HELP_CANCAL = 120000;
    //	订单被拒绝，求助者拒绝接受帮助
    public static final int ORDER_REFUSE_BEGGER = 160000;
    //	帮助者接单超时
    public static final int ORDER_BEGGER_ACCEPT_OVERTIME = 190000;
    //订单生效并没有到达服务时间，求助者接受
    public static final int ORDER_ACCEPT_INNERDUE = 150000;
    // 	    未到达服务时间，帮助者申请取消订单
    public static final int ORDER_INNERDUE_HELPER_REQUSET_CANCLE = 152000;
    // 	    未到达服务时间，帮助者申请取消订单,求助者同意
    public static final int ORDER_INNERDUE_HELPER_REQUSET_CANCLE_SUCCESS = 152500;
    // 	    未到达服务时间，帮助者申请取消订单,求助者拒絕
    public static final int ORDER_INNERDUE_HELPER_REQUSET_CANCLE_FAIL = 152600;
    // 	    未到达服务时间，帮助者申请取消订单,求助者无动作订单超时订单结束
    public static final int ORDER_INNERDUE_HELPER_REQUSET_CANCLE_OVERTIME = 152900;

    // 	   未到达服务时间,求助者确认完成
    public static final int ORDER_INNERDUE_BEGGER_REQUSET_COMPLETE = 155000;
    // 	    	    未到达服务时间，求助者取消订单
    public static final int ORDER_INNERDUE_BEGGER_REQUSET_CANCLE = 156000;
    // 	    	        未到达服务时间，求助者取消订单，帮助者同意
    public static final int ORDER_INNERDUE_BEGGER_REQUSET_CANCLE_SUCCESS = 156100;
    // 	    	        未到达服务时间，求助者取消订单，帮助者拒绝
    public static final int ORDER_INNERDUE_BEGGER_REQUSET_CANCLE_FAIL = 156200;
    // 	    未到达服务时间， 求助者取消订单(未到达服务时间)，帮助者无动作订单超时订单结束
    public static final int ORDER_INNERDUE_BEGGER_REQUSET_CANCLE_OVERTIME = 156900;


    // 	           订单自动到达服务时间，
    public static final int ORDER_OVERDUE_EFFECTIVE = 159000;
    // 	              到达服务时间，帮助者确认完成
    public static final int ORDER_OVERDUE_HELPER_REQUSET_COMPLETE = 159100;
    // 	   	            到达服务时间，帮助者确认完成,求助者同意
    public static final int ORDER_OVERDUE_HELPER_REQUSET_COMPLETE_SUCCESS = 159150;
    // 	  	            到达服务时间，帮助者确认完成,求助者拒绝
    public static final int ORDER_OVERDUE_HELPER_REQUSET_COMPLETE_FAIL = 159160;
    //  	            到达服务时间，帮助者确认完成,求助者无动作订单超时订单结束
    public static final int ORDER_OVERDUE_HELPER_REQUSET_COMPLETE_OVERTIME = 159190;

    //                  到达服务时间去，上方都无动作，订单失效
    public static final int ORDER_OVERDUE_OVERTIME = 159900;


    // 	  	    到达服务时间，帮助者确认完成,求助者拒绝,帮助者同意
    public static final int ORDER_OVERDUE_HELPER_REQUSET_COMPLETE_REFUSE_SUCCESS = 159161;
    //          到达服务时间,帮助者确认完成,求助者拒绝，求助者同意付款
    public static final int ORDER_OVERDUE_HELPER_REQUSET_COMPLETE_REFUSE_PAY = 159165;
    // 	  	    到达服务时间，帮助者确认完成,求助者拒绝,帮助者拒绝
    public static final int ORDER_OVERDUE_HELPER_REQUSET_COMPLETE_REFUSE_FAIL = 159162;
    // 	  	    到达服务时间，帮助者确认完成,求助者拒绝,帮助者无响应
    public static final int ORDER_OVERDUE_HELPER_REQUSET_COMPLETE_REFUSE_OVERTIME = 159169;


    //  	    到达服务时间,帮助者取消订单
    public static final int ORDER_OVERDUE_HELPER_REQUSET_CANCLE = 159200;
    // 	  到达服务时间，订单被求助者申请取消,求助者同意
    public static final int ORDER_OVERDUE_HELPER_REQUSET_CANCLE_SUCCESS = 159250;
    //   到达服务时间，订单被求助者申请取消,求助者拒绝
    public static final int ORDER_OVERDUE_HELPER_REQUSET_CANCLE_FAIL = 159260;
    //     到达服务时间，订单被求助者申请取消,求助者无动作订单超时订单结束
    public static final int ORDER_OVERDUE_HELPER_REQUSET_CANCLE_OVERTIME = 159290;

    //      到达服务时间，订单被求助者确认完成
    public static final int ORDER_OVERDUE_BEGGER_REQUSET_COMPLETE = 159500;

    //      	    到达服务时间,被求助者取消申请订单
    public static final int ORDER_OVERDUE_BEGGER_REQUSET_CANCLE = 159600;
    // 	            到达服务时间，被求助者取消申请订单,帮助者同意
    public static final int ORDER_OVERDUE_BEGGER_REQUSET_CANCLE_SUCCESS = 159610;
    //              到达服务时间，被求助者取消申请订单,最后确认付款
    public static final int ORDER_OVERDUE_BEGGER_COMPELETE_AFTER_CANCLE = 159650;
    //	            到达服务时间，被求助者取消申请订单,帮助者拒绝
    public static final int ORDER_OVERDUE_BEGGER_REQUSET_CANCLE_FAIL = 159620;
    //  	    到达服务时间，被求助者取消申请订单,帮助者无动作订单超时订单结束
    public static final int ORDER_OVERDUE_BEGGER_REQUSET_CANCLE_OVERTIME = 159690;


}
