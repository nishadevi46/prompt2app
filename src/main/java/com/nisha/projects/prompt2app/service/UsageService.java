package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.subscription.PlanLimitsResponse;
import com.nisha.projects.prompt2app.dto.subscription.UsageTodayResponse;

public interface UsageService {
  UsageTodayResponse getTodayUsageOfUser(Long userId);

  PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
