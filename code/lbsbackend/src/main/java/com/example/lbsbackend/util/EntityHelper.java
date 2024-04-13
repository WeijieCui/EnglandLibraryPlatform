package com.example.lbsbackend.util;

import com.example.lbsbackend.entity.Entity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class EntityHelper {
    private final SnowFlake snowFlake;

    public EntityHelper(SnowFlake snowFlake) {
        this.snowFlake = snowFlake;
    }

    public void batchCheckEntity(List<? extends Entity> entities) {
        if (entities == null) {
            return;
        }
        entities.forEach(this::checkEntity);
    }

    public void checkEntity(Entity entity) {
        if (entity == null) {
            return;
        }
        if (entity.getId() == null) {
            entity.setId(snowFlake.nextId());
        }
        if (entity.getCreatedTime() == null) {
            entity.setCreatedTime(new Date());
        }
    }
}
