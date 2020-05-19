package com.datanetx.crm.settings.dao;

import com.datanetx.crm.settings.domain.User;

import java.util.Map;

public interface UserDao {

    User login(Map<String, String> map);
}
