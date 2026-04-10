package com.nisha.projects.prompt2app.mapper;

import com.nisha.projects.prompt2app.dto.subscription.PlanResponse;
import com.nisha.projects.prompt2app.dto.subscription.SubscriptionResponse;
import com.nisha.projects.prompt2app.entity.Plan;
import com.nisha.projects.prompt2app.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
  SubscriptionResponse toSubscriptionResponse(Subscription subscription);

  PlanResponse toPlanResponse(Plan plan);
}
