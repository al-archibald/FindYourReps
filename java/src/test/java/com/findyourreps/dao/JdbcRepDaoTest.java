package com.findyourreps.dao;

import com.findyourreps.model.Representative;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcRepDaoTest extends BaseDaoTests {

    private JdbcRepDao sut; // system under test

    @Before
    public void setUp() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcRepDao(jdbcTemplate);
    }

    //Testing findAll method

    @Test
    public void findAll() {
        List<Representative> reps = sut.findAll();

        Assert.assertNotNull(reps);
        Assert.assertEquals(34, reps.size());
    }


    // Testing searchName method

    @Test
    public void searchTommyReturnsTommyTubervilleCaseInsensitive() {
        List<Representative> reps = sut.searchName("tommy", 5, 0, "asc", "name");

        Assert.assertNotNull(reps);
        boolean isTommyTubervilleFound = reps.stream().anyMatch(rep ->
                rep.getName().equalsIgnoreCase("Tommy Tuberville"));
        Assert.assertTrue(isTommyTubervilleFound);
    }

    @Test
    public void searchOOReturnsChrisCoonsCaseInsensitive() {
        List<Representative> reps = sut.searchName("OO", 5, 0, "asc", "name");

        Assert.assertNotNull(reps);
        boolean isChrisCoonsFound = reps.stream().anyMatch(rep ->
                rep.getName().equalsIgnoreCase("Chris Coons"));
        Assert.assertTrue(isChrisCoonsFound);
    }


    // Testing searchParty method

    @Test
    public void searchDReturnsAllDemocratsCaseInsensitive() {
        List<Representative> reps = sut.searchParty("d", 5, 0, "asc", "party");

        Assert.assertNotNull(reps);
        boolean areDemsFound = reps.stream().anyMatch(rep ->
                rep.getParty().equalsIgnoreCase("Democrat"));
        Assert.assertTrue(areDemsFound);
    }

    @Test
    public void searchRepReturnsAllRepublicansCaseInsensitiveDesc() {
        List<Representative> reps = sut.searchParty("rep", 5, 0, "desc", "party");

        Assert.assertNotNull(reps);
        boolean areDemsFound = reps.stream().anyMatch(rep ->
                rep.getParty().equalsIgnoreCase("Republican"));
        Assert.assertTrue(areDemsFound);
    }

}