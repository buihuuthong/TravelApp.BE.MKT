package com.MyTravel.mytravel.security.services;

import com.google.api.gax.rpc.ApiException;
import com.google.firebase.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class UserService {


//    private void checkValidUser(User user) {
//        if (Objects.equals(user.getIsLocked(), true))
//            throw new ApiException(ErrorCode.USER_LOCKED);
//        if (helper.shouldCheckUserExpired(user) && helper.isUserExpired(user))
//            throw new ApiException(ErrorCode.USER_EXPIRED);
//    }
}
