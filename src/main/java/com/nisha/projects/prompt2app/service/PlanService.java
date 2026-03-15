package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.subscription.PlanResponse;
import java.util.List;

public interface PlanService {
  List<PlanResponse> getAllActivePlans();
}
