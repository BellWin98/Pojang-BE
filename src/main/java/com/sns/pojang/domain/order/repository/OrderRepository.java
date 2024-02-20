package com.sns.pojang.domain.order.repository;

import com.sns.pojang.domain.member.entity.Member;
import com.sns.pojang.domain.order.entity.Order;
import java.util.Optional;
import com.sns.pojang.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sns.pojang.domain.order.entity.Order;
import com.sns.pojang.domain.order.entity.OrderStatus;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByStore(Store store, Pageable pageable);
    Page<Order> findByMember(Member member, Pageable pageable);
    List<Order> findByStore(Store store);
    Optional<Order> findByIdAndOrderStatus(Long orderId, OrderStatus orderStatus);
}
