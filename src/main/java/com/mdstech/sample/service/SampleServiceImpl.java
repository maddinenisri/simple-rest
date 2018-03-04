package com.mdstech.sample.service;

import com.mdstech.sample.vo.SampleContainerVO;
import com.mdstech.sample.vo.SampleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@Slf4j
public class SampleServiceImpl implements SampleService {

    private List<SampleVO> data = new LinkedList<>();

    @Value("${maxchunk.size}")
    private Integer maxChunkSize;

    @PostConstruct
    public void init() {
        IntStream.range(1, 10000).forEach(i -> data.add(SampleVO.builder().id(i).name(String.format("test%d", i)).build()));
    }

    @Override
    public List<SampleVO> getAll() {
        return data;
    }

    @Override
    public SampleContainerVO getPage(int page) {
        SampleContainerVO sampleContainerVO = new SampleContainerVO();
        boolean nextChunk = (data.size() > page*maxChunkSize) ? true : false;
        if(nextChunk) {
            sampleContainerVO.setData(data.subList(page * maxChunkSize, ((page + 1) * maxChunkSize) - 1));
        }
        else {
            sampleContainerVO.setData(data.subList(page * maxChunkSize, data.size()));
        }
        sampleContainerVO.setNext(nextChunk);
        return sampleContainerVO;
    }
}
