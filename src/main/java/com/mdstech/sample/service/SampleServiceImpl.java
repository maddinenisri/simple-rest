package com.mdstech.sample.service;

import com.mdstech.sample.repository.SampleRepository;
import com.mdstech.sample.vo.SampleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Value("${sample.records.size}")
    private Integer maxRecords;

    @Autowired
    private SampleRepository sampleRepository;

    @PostConstruct
    public void init() {
        IntStream.range(1, maxRecords).forEach(i -> sampleRepository.save(
                SampleVO.builder()
                .id(i)
                .name(String.format("test%d", i))
                .build()));
    }

    @Override
    public List<SampleVO> getAll() {
        return sampleRepository.findAll();
    }

    @Override
    public Page<SampleVO> getPage(String name, int page) {
        Pageable pageable = new PageRequest(page, maxChunkSize, new Sort(new Sort.Order(Sort.Direction.ASC, "name")));
        return sampleRepository.findByNameContaining(name, pageable);
    }
}
