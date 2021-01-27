package com.evildoer.exam.model.vo;

import com.evildoer.exam.common.entity.User;
import lombok.Data;

@Data
public class UserVo extends User {

    String token;

    String role;
}
