package com.mdstech.sample.service;

import com.mdstech.sample.vo.SampleContainerVO;
import com.mdstech.sample.vo.SampleVO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SampleService {
    List<SampleVO> getAll();

    Page<SampleVO> getPage(String name, int page);
}
