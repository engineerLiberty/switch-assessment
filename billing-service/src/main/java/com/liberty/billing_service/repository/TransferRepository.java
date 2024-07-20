package com.liberty.billing_service.repository;

import com.liberty.billing_service.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
