package com.mdstech.sample.vo;

import lombok.Data;

import java.util.List;

@Data
public class SampleContainerVO {
    private List<SampleVO> data;
    private boolean next;
}
