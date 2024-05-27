package com.busanit501.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

//@Primary //먼저 우선
@Repository  //DAO기능을 repository가 대신함
@Qualifier("normal")
public class SampleDAOImpl implements SampleDAO {

}
