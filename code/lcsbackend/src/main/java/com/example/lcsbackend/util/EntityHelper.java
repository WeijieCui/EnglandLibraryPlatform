package com.example.lcsbackend.util;

import com.example.lcsbackend.entity.Entity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * EntityHelper
 *
 * @description: EntityHelper
 */
@Component
public class EntityHelper {
    private final SnowFlake snowFlake;

    public EntityHelper(SnowFlake snowFlake) {
        this.snowFlake = snowFlake;
    }

    /**
     * batchCheckEntities
     *
     * @description: batch check entities, add default id, created time
     * @param: List<? extends Entity> entities
     * @return: void
     */
    public void batchCheckEntities(List<? extends Entity> entities) {
        if (entities == null) {
            return;
        }
        entities.forEach(this::checkEntity);
    }

    /**
     * checkEntity
     *
     * @description: checkEntity
     * @param: Entity
     * @return: void
     */
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
