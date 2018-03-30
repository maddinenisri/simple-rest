package com.mdstech.sample.controller;

import com.mdstech.sample.service.SampleService;
import com.mdstech.sample.vo.SampleContainerVO;
import com.mdstech.sample.vo.SampleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CustomController {

    @Autowired
    private SampleService sampleService;

    @GetMapping(path = "/api/list")
    public List<SampleVO> getSampleList() {
        return sampleService.getAll();
    }

    @GetMapping(path = "/api/page/{name}")
    public SampleContainerVO getPage(@PathVariable("name") String name, @RequestParam(value = "page", required = false) Integer page) {
        if(page == null) {
            page = 0;
        }

        Page<SampleVO> pageData = sampleService.getPage(name, page);
        log.debug("------------"+ pageData.getTotalElements() +":"+ pageData.getTotalPages());
        SampleContainerVO sampleContainerVO = new SampleContainerVO();
        sampleContainerVO.setData(pageData.getContent());
        sampleContainerVO.setNext(!pageData.isLast());
        return sampleContainerVO;
    }

}