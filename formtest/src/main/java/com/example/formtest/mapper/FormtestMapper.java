package com.example.formtest.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;


@Mapper
public interface FormtestMapper {

    public int insertMember(@RequestParam HashMap<String, String> params);

}
