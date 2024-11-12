package com.airindia.carina.demo.db.mappers;

import com.airindia.carina.demo.db.models.UserPreference;

public interface UserPreferenceMapper {

	void create(UserPreference userPreference);

	UserPreference findById(Long id);
}
