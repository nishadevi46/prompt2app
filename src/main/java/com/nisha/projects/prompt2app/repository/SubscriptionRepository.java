package com.nisha.projects.prompt2app.repository;

import com.nisha.projects.prompt2app.entity.Subscription;
import com.nisha.projects.prompt2app.enums.SubscriptionStatus;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
  Optional<Subscription> findByUserIdAndStatusIn(Long userId, Set<SubscriptionStatus> statusSet);

  boolean existsByStripeSubscriptionId(String subscriptionId);

  Optional<Subscription> findByStripeSubscriptionId(String gatewaySubscriptionId);
}
