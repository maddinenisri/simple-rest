package com.mdstech.sample.repository;

import com.mdstech.sample.vo.SampleVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<SampleVO, Integer> {

    Page<SampleVO> findByNameContaining(String name, Pageable pageable);

}
