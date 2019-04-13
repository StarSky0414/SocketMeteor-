package db.redis;

import bean.user.UserInfo;

import java.util.*;

public class OnLineList {

    private static Set<UserInfo> userInfoSet = new HashSet<>();
    private static final int LIST_LONG = 5;

    public static List<UserInfo> getUserInfoList() {
//        userInfoList.subList()
        List<UserInfo> userInfos = checkList();
        return userInfos;
    }

    /**
     * 失效时间验证 目前失效时间 100s
     *
     * @param userInfo 用户信息
     * @return 是否失效 【true】没有失效  【false】失效
     */
    private static boolean checkTimeOut(UserInfo userInfo) {
        long date = userInfo.getDate();
        System.out.println("userInfo date :" + date);
        long l = System.currentTimeMillis();
        System.out.println("l:"+l);
        return date+3 < l ? false : true;
    }

    private static List<UserInfo> checkList() {
        ArrayList<UserInfo> userInfoList = new ArrayList<>();
        int whenNum = 0;
        Iterator<UserInfo> iterator = userInfoSet.iterator();
        for (; whenNum <= LIST_LONG && iterator.hasNext(); ) {
            UserInfo userInfoNext = iterator.next();
            if (checkTimeOut(userInfoNext)) {
                System.out.println("成功：" + userInfoNext);
                whenNum++;
                userInfoList.add(userInfoNext);
            }else {
                iterator.remove();
            }
        }
        return userInfoList;
    }

    public synchronized static void setUserInfoSet(UserInfo userInfo) {
        userInfoSet.add(userInfo);
    }
}
