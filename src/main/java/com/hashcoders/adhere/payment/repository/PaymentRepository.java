package com.hashcoders.adhere.payment.repository;

import com.hashcoders.adhere.payment.entity.Payment;
import com.hashcoders.adhere.payment.repository.dto.HostPaymentHistory;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query(nativeQuery = true,
            value = "SELECT SUM(amount) AS total_amount "
                    + "FROM payment "
                    +"WHERE customer_id = :id and status = :status")
    BigDecimal getTotalInvestmentByCustomerAndStatus(Long id, String status);

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
