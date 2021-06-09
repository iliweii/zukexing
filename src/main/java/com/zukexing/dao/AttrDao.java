package com.zukexing.dao;

import com.zukexing.pojo.Attr;
import org.springframework.stereotype.Repository;

@Repository
public interface AttrDao {
    Integer insertAttr(Attr attr);
}
