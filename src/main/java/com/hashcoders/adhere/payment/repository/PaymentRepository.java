package com.hashcoders.adhere.payment.repository;

import com.hashcoders.adhere.payment.entity.Payment;
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
}
