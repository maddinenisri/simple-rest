package com.mdstech.sample.service;

import com.mdstech.sample.config.ApplicationConfiguration;
import com.mdstech.sample.vo.SampleVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class})
public class SampleServiceTest {

    @Autowired
    private SampleService sampleService;

    @Test
    public void testSpringIitialization() {
        assertThat("Spring Context initialized", is(sampleService), notNullValue() );
    }

    @Test
    public void testPagebaleQuery() {
        Page<SampleVO> page = sampleService.getPage("test1", 1);
        assertThat("Should contain more pages", page.isLast(), is(false));
    }
}
