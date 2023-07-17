package com.findyourreps.dao;

import com.findyourreps.model.Representative;

import java.util.List;

public interface RepDao {

    List<Representative> findAll();

    List<Representative> searchName(String searchQuery);

    List<Representative> searchParty(String searchQuery);
}
