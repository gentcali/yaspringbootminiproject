package com.gent.miniproject.commonbackendservice.Repository;

import java.util.List;

public interface QRepository<Temp> {

    List<Temp> findAll();

    List<Temp> findHalf();

    int save(Temp temp);

    int deleteById(String id);

    int update(Temp produktin);

    Temp findById(int id);


}
