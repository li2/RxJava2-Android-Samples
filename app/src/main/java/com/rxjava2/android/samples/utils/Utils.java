package com.rxjava2.android.samples.utils;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.rxjava2.android.samples.model.ApiUser;
import com.rxjava2.android.samples.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amitshekhar on 27/08/16.
 */
public class Utils {

    private static final ApiUser API_USER_0 = new ApiUser(0, "三", "张");
    private static final ApiUser API_USER_1 = new ApiUser(1, "四", "李");
    private static final ApiUser API_USER_2 = new ApiUser(2, "二麻子", "王");

    private Utils() {
        // This class in not publicly instantiable.
    }

    public static List<User> getUserList() {
        return convertApiUserListToUserList(getApiUserList());
    }

    public static List<ApiUser> getApiUserList() {

        List<ApiUser> apiUserList = new ArrayList<>();
        apiUserList.add(API_USER_0);
        apiUserList.add(API_USER_1);
        apiUserList.add(API_USER_2);

        return apiUserList;
    }

    public static List<User> convertApiUserListToUserList(List<ApiUser> apiUserList) {

        List<User> userList = new ArrayList<>();

        for (ApiUser apiUser : apiUserList) {
            User user = new User();
            user.firstname = apiUser.firstname;
            user.lastname = apiUser.lastname;
            userList.add(user);
        }

        return userList;
    }

    public static List<User> getUserListWhoLovesCricket() {

        List<User> userList = new ArrayList<>();
        userList.add(new User(API_USER_0));
        userList.add(new User(API_USER_2));
        return userList;
    }


    public static List<User> getUserListWhoLovesFootball() {

        List<User> userList = new ArrayList<>();
        userList.add(new User(API_USER_1));
        userList.add(new User(API_USER_2));
        return userList;
    }


    public static List<User> filterUserWhoLovesBoth(List<User> cricketFans, List<User> footballFans) {
        List<User> userWhoLovesBoth = new ArrayList<User>();
        for (User cricketFan : cricketFans) {
            for (User footballFan : footballFans) {
                if (cricketFan.id == footballFan.id) {
                    userWhoLovesBoth.add(cricketFan);
                }
            }
        }
        return userWhoLovesBoth;
    }

    public static void logError(String TAG, Throwable e) {
        if (e instanceof ANError) {
            ANError anError = (ANError) e;
            if (anError.getErrorCode() != 0) {
                // received ANError from server
                // error.getErrorCode() - the ANError code from server
                // error.getErrorBody() - the ANError body from server
                // error.getErrorDetail() - just a ANError detail
                Log.d(TAG, "onError errorCode : " + anError.getErrorCode());
                Log.d(TAG, "onError errorBody : " + anError.getErrorBody());
                Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
            } else {
                // error.getErrorDetail() : connectionError, parseError, requestCancelledError
                Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
            }
        } else {
            Log.d(TAG, "onError errorMessage : " + e.getMessage());
        }
    }

}
