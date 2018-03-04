package com.mdstech.sample.controller;

import com.mdstech.sample.service.SampleService;
import com.mdstech.sample.vo.SampleContainerVO;
import com.mdstech.sample.vo.SampleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomController {

    @Autowired
    private SampleService sampleService;

    @GetMapping(path = "/api/list")
    public List<SampleVO> getSampleList() {
        return sampleService.getAll();
    }

    @GetMapping(path = "/api/page")
    public SampleContainerVO getPage() {
        return sampleService.getPage(0);
    }

    @GetMapping(path = "/api/page/{page}")
    public SampleContainerVO getPage(@PathVariable("page") Integer page) {
        return sampleService.getPage(page);
    }

}
