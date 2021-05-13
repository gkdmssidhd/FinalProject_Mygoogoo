package com.mygg.mygg.domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeRepository {
    List<Map<String,Object>> getNotices();   // 마이바티스와 직접 매핑되는 List불러오기
    Map<String,Object> getNotice(int board_id);
    int insertNotice();
    int updateNotice();
    int deleteNotice();
    List<Map<String,Object>> searchNotices();

}
