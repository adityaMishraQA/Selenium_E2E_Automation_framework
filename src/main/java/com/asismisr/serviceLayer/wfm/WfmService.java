package com.asismisr.serviceLayer.wfm;

import com.asismisr.pages.cargoRunner.WfmMilestonePage;
import com.asismisr.pojo.wfm.MilestoneCreationPojo;
import com.asismisr.pojo.wfm.MilestoneUpdationPojo;

public class WfmService {

    WfmMilestonePage milestonePage = new WfmMilestonePage();

    public void createMilStoneService(MilestoneCreationPojo milestoneCreationPojo){

        String milestoneName = milestoneCreationPojo.getMileStoneName().trim();
        String milestoneCode = milestoneCreationPojo.getMileStoneCode().trim();
        String milestoneDescription = milestoneCreationPojo.getMileStoneDescription().trim();
        String milestoneWorkflowType = milestoneCreationPojo.getMileStoneWorkflowType().trim();
        String customerPortalFlag = milestoneCreationPojo.getMileStoneCustomerPortalFlag().trim();
        String dynamicFlag = milestoneCreationPojo.getMileStoneDynamicFlag().trim();

        if(!milestoneName.isBlank()){
            milestonePage.fillingMilestoneName(milestoneName);
        }

        if(!milestoneCode.isBlank()){
            milestonePage.fillingMilestoneCode(milestoneCode);
        }

        if(!milestoneDescription.isBlank()){
            milestonePage.fillingMilestoneDiscription(milestoneDescription);
        }

        if(!milestoneWorkflowType.isBlank()){
            milestonePage.fillingMilestoneType(milestoneWorkflowType);
        }

//        if (customerPortalFlag.equals("TRUE")) {
//            milestonePage.tickOnShowonCustomerCheckbox();
//        }
//
//        if(dynamicFlag.equals("TRUE")){
//            milestonePage.tickOnDynamicCheckbox();
//        }
    }

    public void updateMilStoneService(MilestoneUpdationPojo milestoneUpdationPojo){

        String milestoneName = milestoneUpdationPojo.getEditMilestoneName().trim();
        String milestoneCode = milestoneUpdationPojo.getEditMilestoneCode().trim();
        String milestoneDescription = milestoneUpdationPojo.getEditMilestoneDiscription().trim();
        String milestoneWorkflowType = milestoneUpdationPojo.getEditWorkflowType().trim();
        String customerPortalFlag = milestoneUpdationPojo.getEditShowCustomerPortalFlag().trim();
        String dynamicFlag = milestoneUpdationPojo.getEditDynamicFlag().trim();

        if(!milestoneName.isBlank()){
            milestonePage.updatingMilestoneName(milestoneName);
        }

        if(!milestoneCode.isBlank()){
            milestonePage.updatingMilestoneCode(milestoneCode);
        }

        if(!milestoneDescription.isBlank()){
            milestonePage.updatingMilestoneDescription(milestoneDescription);
        }

        if(!milestoneWorkflowType.isBlank()){
            milestonePage.updatingMilestoneWorkflowType(milestoneWorkflowType);
        }

//        if (milestonePage.isCheckedAttributePresentinShowonCustomerCheckbox())
//        {
//            if (customerPortalFlag.equals("TRUE")) {
//                milestonePage.tickOnShowonCustomerCheckbox();
//            }
//            if(dynamicFlag.equals("TRUE")){
//                milestonePage.tickOnDynamicCheckbox();
//            }
//        }
//
//        if (milestonePage.isCheckedAttributePresentinDynamicCheckbox())
//        {
//            if (customerPortalFlag.equals("TRUE")) {
//                milestonePage.tickOnShowonCustomerCheckbox();
//            }
//            if(dynamicFlag.equals("TRUE")){
//                milestonePage.tickOnDynamicCheckbox();
//            }
//        }
//
//        if (milestonePage.isCheckedAttributePresentinDynamicCheckbox()==false && milestonePage.isCheckedAttributePresentinShowonCustomerCheckbox()==false)
//        {
//            if (customerPortalFlag.equals("TRUE")) {
//                milestonePage.tickOnShowonCustomerCheckbox();
//            }
//            if(dynamicFlag.equals("TRUE")){
//                milestonePage.tickOnDynamicCheckbox();
//            }
//        }






    }
}
