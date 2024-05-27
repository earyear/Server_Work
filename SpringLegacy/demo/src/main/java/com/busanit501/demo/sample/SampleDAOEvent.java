package com.busanit501.demo.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository  //DAO기능을 repository가 대신함
@Qualifier("event")
public class SampleDAOEvent implements SampleDAO {

}
