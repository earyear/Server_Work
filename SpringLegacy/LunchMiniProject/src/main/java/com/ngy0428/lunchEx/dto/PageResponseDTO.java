package com.ngy0428.lunchEx.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

// <E>, 포괄적인 표현
// 예) PageResponseDTO<TodoDTO>
// 예) PageResponseDTO<SearchDTO>
// 예) PageResponseDTO<MemberDTO>
@Getter
@ToString
public class PageResponseDTO<E> {
  private int page;
  private int size;
  private int total;

  //시작, 끝 페이지 번호
  private int start;
  private int end;

  // 이전 페이지 존재 여부
  private boolean prev;

  // 다음 페이지 존재 여부
  private boolean next;

  // 전달할 페이징이 된 todo 10개 목록.
  private List<E> dtoList;


  //생성자 만들기.
  // builderMethodName = "withAll" -> 기존 빌더 패턴 사용시, lunchVO.builder.build()
  // builder 의 이름이 -> withAll 교체 ex) lunchVO.withAll.build()
  // List<E> dtoList : 10개씩 조회한 정보들
  // total : lunch의 전체 갯수
  // 결론, PageResponseDTO 에, 파라미터의 정보들이 다 들어있다.
  @Builder(builderMethodName = "withAll")
  public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){
    this.page = pageRequestDTO.getPage();
    this.size = pageRequestDTO.getSize();

    this.total = total;
    this.dtoList = dtoList;

    // 추가정보 [하단 페이징 번호]
    // end : 끝페이지 번호, start : 시작페이지 번호
    // page : 1 ~ 10 -> (int)(Math.ceil(this.page / 10.0)) : 1,
    this.end = (int)(Math.ceil(this.page / 10.0)) * 10; //10
    this.start = this.end - 9; //1

    // 10페이지 미만인 경우, 위에 식이 안 먹힌다. > 10페이지에 리스트가 없음
    // 10 > 8 , end : 8. 총 개수가 75개라서 페이지가 8개뿐..      // 부트는 Pageable 인터페이스 도구 이용하면, 한방에 됨. 걱정 노노.!!
    int last = (int)(Math.ceil(total/(double)size)); //8
    this.end = end > last ? last : end; //10 > 8 ? 8 : 10

    //true, false로 값 판단.
    this.prev = this.start > 1; //1~10 보여주는 페이지가 아니면 다 true.
    this.next = total > this.end * this.size; //75> 80 false.
  }

}







