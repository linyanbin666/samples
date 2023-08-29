package com.horin.base.mapper;

import com.horin.samples.mybatisplus.config.DaoConfig;
import com.horin.samples.mybatisplus.entity.DemoEntity;
import com.horin.samples.mybatisplus.mapper.DemoEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Rollback
@Transactional
@EnableTransactionManagement
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DaoConfig.class)
@SpringBootApplication(scanBasePackageClasses = DaoConfig.class)
class DemoEntityMapperTest {

    @Autowired
    private DemoEntityMapper demoEntityMapper;

    @Test
    void testInsertAndUpdate() throws Exception {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setDemo("test1");
        demoEntityMapper.insert(demoEntity);
        DemoEntity dbDemo = demoEntityMapper.selectById(demoEntity.getId());
        assertThat(dbDemo).isNotNull();
        log.info("dbDemo after insert: {}", dbDemo);

        DemoEntity updateDemoEntity = new DemoEntity();
        updateDemoEntity.setDemo("test2");
        demoEntityMapper.update(updateDemoEntity, null);
        dbDemo = demoEntityMapper.selectById(demoEntity.getId());
        assertThat(dbDemo.getDemo()).isEqualTo("test2");
        log.info("dbDemo after update: {}", dbDemo);

        int effectedRow = demoEntityMapper.deleteById(demoEntity.getId());
        assertThat(effectedRow).isEqualTo(1);
        dbDemo = demoEntityMapper.selectById(demoEntity.getId());
        assertThat(dbDemo).isNull();
    }

    @Test
    void testSelect() {
        List<DemoEntity> demoEntities = demoEntityMapper.selectList(null);
        log.info("demoEntities: {}", demoEntities);
        assertThat(demoEntities.size()).isEqualTo(1);
        assertThat(demoEntities.get(0).getDemo()).isEqualTo("t1");
    }

}