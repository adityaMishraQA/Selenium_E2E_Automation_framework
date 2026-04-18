package com.asismisr.pojo.wfm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MilestoneUpdationPojo {

    private String mileStoneName;
    private String mileStoneCode;
    private String mileStoneWorkflowType;
    private String mileStoneDescription;
    private String mileStoneCustomerPortalFlag;
    private String mileStoneDynamicFlag;

    private String editMilestoneName;
    private String editMilestoneCode;
    private String editWorkflowType;
    private String editMilestoneDiscription;
    private String editShowCustomerPortalFlag;
    private String editDynamicFlag;
}
