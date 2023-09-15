package com.hashcoders.adhere.payment.repository;

import com.hashcoders.adhere.payment.entity.Payment;
import com.hashcoders.adhere.payment.repository.dto.HostPaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

     @Query(value = "SELECT "
             + "    SUM(amount) AS totalRevenue,"
             + "    COUNT(DISTINCT customer_id) AS customerCount,"
             + "    COUNT(*) AS totalCount"
             + " FROM "
             + "    payment"
             + " WHERE "
             + "    host_id = :id"
             + "    AND status = 'SUCCESS' ",nativeQuery = true)
     HostPaymentHistory getHostPaymentHistory(Long id);
}
