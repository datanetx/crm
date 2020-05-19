package com.datanetx.crm.settings.service;

import com.datanetx.crm.exception.LoginException;
import com.datanetx.crm.settings.domain.User;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
