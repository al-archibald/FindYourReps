package com.findyourreps.dao;

import com.findyourreps.model.Representative;

import java.util.List;

public interface RepDao {

    List<Representative> findAll();

    List<Representative> searchName(String searchQuery, int size, int page, String direction, String sort);

    List<Representative> searchParty(String searchQuery);
}
