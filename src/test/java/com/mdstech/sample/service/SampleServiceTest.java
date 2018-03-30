package com.mdstech.sample.service;

import com.mdstech.sample.config.ApplicationConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
}
