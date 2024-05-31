package com.ngy0428.lunchEx.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


// 같은 애너테이션이 있다면, 하나 선택을 해줌. 우선순위를 높여주는 코드.
//@Primary
@Repository
@Qualifier("normal")
public class SampleDAOImpl implements SampleDAO {

}







