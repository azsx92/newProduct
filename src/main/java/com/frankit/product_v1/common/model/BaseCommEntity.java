package com.frankit.product_v1.common.model;


import com.frankit.product_v1.util.AuthUtils;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
public class BaseCommEntity {
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    protected LocalDateTime  createdAt;

    @Column(name = "created_by", updatable = false)
    protected String createdBy;

    @Column(name = "updated_at")
    @UpdateTimestamp
    protected LocalDateTime  updatedAt;

    @Column(name = "updated_by")
    protected String updatedBy;

    @PrePersist
    protected void onPersist() {
        this.createdBy = this.updatedBy = AuthUtils.getCurrentLoginUserCd();
        // createdAt은 @CreationTimestamp에 의해 자동으로 설정됨
        // updatedAt도 @CreationTimestamp에 의해 자동으로 설정됨
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedBy = AuthUtils.getCurrentLoginUserCd();
        // updatedAt은 @UpdateTimestamp에 의해 자동으로 설정됨
    }

}
