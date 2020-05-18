package com.datanetx.crm.settings.service.impl;

import com.datanetx.crm.settings.dao.UserDao;
import com.datanetx.crm.settings.service.UserService;
import com.datanetx.crm.utils.SqlSessionUtils;

public class UserServiceImpl implements UserService {
    private UserDao userDao= SqlSessionUtils.getSession().getMapper(UserDao.class);
}
