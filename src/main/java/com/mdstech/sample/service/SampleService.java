package com.mdstech.sample.service;

import com.mdstech.sample.vo.SampleContainerVO;
import com.mdstech.sample.vo.SampleVO;

import java.util.List;

public interface SampleService {
    List<SampleVO> getAll();

    SampleContainerVO getPage(int page);
}
