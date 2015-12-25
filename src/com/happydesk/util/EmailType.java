package com.happydesk.util;

public enum EmailType {
	
	RESETPASSWORD("/pages/email/resetpassword.html"),
	REGISTRATION("/pages/email/registration.html"), 
	ComplaintUpdate("/pages/email/productcomment.html"),
	QUERY("/pages/email/query.html"),
	PSWCHANGE("/pages/email/sendpassword.html"),
	PAYMENT_LINK ("/pages/email/requestpayment.html"),
	COMMENT_NOTIFICATION("/pages/email/commentnotification.html"),
	ADMIN_COMMENT_NOTIFICATION("/pages/email/admincommentnotification.html"),
	//commented by Manoj on 8 Nov 2012 as not used now.
	//BRAND_COMMENT_NOTIFICATION("/pages/email/brandcommentnotification.html"),
	ADMIN_BRAND_COMMENT_NOTIFICATION("/pages/email/admintobrandcommentnotification.html"),
	CUSTOMER_BRAND_COMMENT_NOTIFICATION("/pages/email/customertobrandcommentnotification.html"),
	BRAND_ADMIN_COMMENT_NOTIFICATION("/pages/email/brandtoadmincommentnotification.html"),
	BRAND_CUSTOMER_COMMENT_NOTIFICATION("/pages/email/brandtocustomercommentnotification.html"),
	ADMIN_SUPERUSER_COMMENT_NOTIFICATION("/pages/email/admintosuperusercommentnotification.html"),
	BRANDADMIN_SUBUSER_COMMENT_NOTIFICATION("/pages/email/brandtobrandcommentnotification.html"),
	NEW_COMPLAINT_NOTIFICATION("/pages/email/newcomplaintnotification.html"),
	MODIFY_USER_NOTIFICATION("/pages/email/modifyusernotification.html"),
	MODIFY_USER_EMAIL("/pages/email/modifyuseremail.html"),
	MODIFY_USER_DETAILS("/pages/email/modifyuserdetails.html"),
	MODIFY_BRAND_NOTIFICATION("/pages/email/modifybrandnotification.html"),
	MODIFY_BRAND_EMAIL("/pages/email/modifybrandemail.html"),
	CREATE_BRAND_NOTIFICATION("/pages/email/createbrandnotification.html"),
	HIGH_PRIORITY_KEYWORD_INTERCEPTED("/pages/email/veryhighpriorityalert.html"),
	PRIORITY_KEYWORD_INTERCEPTED("/pages/email/highpriorityalert.html"),
	HIGH_PRIORITY_KEYWORD_INTERCEPTED_FACEBOOK("/pages/email/veryhighpriorityalertfacebook.html"),
	HIGH_PRIORITY_KEYWORD_INTERCEPTED_TWITTER("/pages/email/veryhighpriorityalerttwitter.html"),
	PRIORITY_KEYWORD_INTERCEPTED_TWITTER("/pages/email/highpriorityalerttwitter.html"),
	CREATE_USER_NOTIFICATION("/pages/email/createusernotification.html"),
	SEND_NOTICE("/pages/email/notice.html"),
	HIGH_AMOUNT_FILED("/pages/email/highamountnotification.html"),
	HIGH_AMOUNT_ASSIGNED("/pages/email/highamountassignmentchangednotification.html"),
	UNFILTERED_LOW_AMOUNT_COMPLAINT_FILED_NOTIFICATION("/pages/email/unfilteredlowamountcomplaintfilednotification.html"),
	BRAND_UNFILTERED_LOW_AMOUNT_COMPLAINT_FILED_NOTIFICATION("/pages/email/brandunfilteredlowamountcomplaintfilednotification.html"),
	EXCEPTION_MAIL_TO_TECHTEAM("/pages/email/exceptionnotification.html"),
	UNFILTERED_LOW_AMOUNT_FOLLOWUP_NOTIFICATION1("/pages/email/unfilteredlowamountfollowupnotification1.html"),
	UNFILTERED_LOW_AMOUNT_FOLLOWUP_NOTIFICATION2("/pages/email/unfilteredlowamountfollowupnotification2.html"),
	DATA_DELETION_NOTIFICATION("/pages/email/datadeletenotification.html"),
	REQUEST_CALLBACK("/pages/email/requestcallbacknotification.html"),
	ASK_CUSTOM_FIELDS("/pages/email/askcustomfields.html"),
	SOCIAL_COMPLAINT_NOTIFICATION("/pages/email/socialcomplaintnotification.html"),
	SOCIAL_COMPLAINT_SEND_PASSWORD("/pages/email/socialcomplaintsendpassword.html"),
	FEEDBACK_NOTIFICATION("/pages/email/feedbacknotification.html"),
	BRAND_BOUNCEDEMAIL_NOTIFICATION("/pages/email/brandbouncedemailnotification.html"),
	REQUEST_CALLBACK_CUSTOMER_NOTIFICATION("/pages/email/requestcallbacknotificationtocustomer.html"),
	COMPLAINT_SEND_TO_BRAND_NOTIFICATION("/pages/email/sendtobrand.html"),
	ENTERPRISE_QUERY("/pages/email/enterprisequery.html"),
	NEGATIVE_FEEDBACK("/pages/email/negativefeedback.html"),
	PENDING_REQUEST_CALLBACK_NOTIFICATION("/pages/email/pendingrequestcallbacknotification.html"),
	BRAND_UPDATE("/pages/email/brandupdate.html"),
	ENTERPRISE_LEAD_NOTIFICATION_TO_CUSTOMER("/pages/email/enterpriseleadnotification.html"),	
	ENTERPRISE_LEAD("/pages/email/enterpriselead.html"),
	CONSUMER_STATUS_YES("/pages/email/consumerstatustoyes.html"),
	FEED_BACK_NOTIFICATION("/pages/email/feedbackresponsenotification.html"),
	FEED_BACK_NOTIFICATION_BRAND("/pages/email/feedbacknotificationtobrand.html"),
	FEED_BACK_NOTIFICATION_CUSTOMER("/pages/email/feedbackresponsetobrandnotification.html"),
	UPGRADE_ACCOUNT_NOTIFICATION_BRAND("/pages/email/brandupgradeaccount.html"),
	UPGRADE_ACCOUNT_NOTIFICATION_AKOSHA("/pages/email/brandupgradenotificationtoakosha.html"),
	BRAND_ENGAGEMENT_NOTIFICATION("/pages/email/brandengagementmail.html"),
	BRAND_ENGAGEMENT__NOT_LOGIN_NOTIFICATION("/pages/email/usernotloggedin.html"),
	CONSUMER_STATUS_NO("/pages/email/consumerstatustono.html"),
	NOTIFICATION_TO_CMO("/pages/email/notificationtocmo.html"),
	OPERATION_TEAM_NOTIFICATION("/pages/email/sendmailforoperationdata.html"),
	INVITATION_EMAIL("/pages/email/invitationtoakosha.html"),
	INVITATION_EMAIL_FOR_UNLOGGED_USER("/pages/email/invitationtoakoshabyunloggeduser1.html"),
	RESOLVED_COMPLAINT_EMAIL("/pages/email/resolvedcomplaint.html"),
	WEEKLY_REPORT_BRAND_RELATION("/pages/email/weeklyReportBrandRelation.html"),
	MAIL_TO_NOT_WORKING_ASSIGNMENT("/pages/email/mailToNotWorkingAssignment.html"),
	SEND_EXCEL_TO_BRAND("/pages/email/sendexceltobrand.html"),
	MAIL_FOR_UNIDENTIFIED_COMPANY("/pages/email/mailForUnidentifiedCompany.html"),
	MAIL_TO_CUSTOMER_FOR_ESCALATION_TO_COMPANY("/pages/email/mailToCustomerForEscalationToCompany.html"),
	MAIL_TO_CUSTOMER_FOR_NO_DASHBOARD_COMPANY("/pages/email/mailToCustomerForNoDashboardCompany.html"),
	MAIL_TO_CUSTOMER_FOR_NO_DASHBOARD_COMPANY_NO_SUPPORT_EMAIL("/pages/email/mailToCustomerForNoDashboardNoSupportEmailCompany.html"),
	MAIL_TO_CUSTOMER_FOR_COMPANY_AKOSHA("/pages/email/mailToCustomerForCompanyAkosha.html"),
	MAIL_TO_CUSTOMER_MANUAL_IDENTIFY_COMPANY("/pages/email/mailToCustomerManualIdentifyCompany.html"),
	MAIL_TO_CUSTOMER_HIGH_VALUE_ACKNOWLEDGE("/pages/email/mailToCustomerHighValueAcknowledge.html"),
	MAIL_TO_CUSTOMER_LOW_VALUE_LM1("/pages/email/mailToCustomerLowValueLM1.html"),
	MAIL_TO_CUSTOMER_LOW_VALUE_LM2("/pages/email/mailToCustomerLowValueLM2.html"),
	BRAND_UPDATE_DAILY_DIGEST("/pages/email/brandupdatedailydigest.html"),
	NOTIFY_USER_SELECT_PRICING_PLAN("/pages/email/notificationmailforselectingpricingplan.html"),
	MICROMAX_DAILY_DIGEST("/pages/email/micromaxDailyDigest.html"),
	INBOUND_CUSTOMER_CARE_MAIL("/pages/email/inboundCustomerCareMail.html"),
	MAIL_TO_CUSTOMER_LOW_VALUE_ACKNOWLEDGE("/pages/email/mailToCustomerLowValueAcknowledge.html"),
	INACTIVE_AGENT_PAYMENT_MAIL("/pages/email/inactiveAgentAssignedPayment.html"),
	MAIL_TO_CUSTOMER_NONAKOSHA_TICKET_COMMENT_BY_AGENT("/pages/email/nonakoshaticketcommentbyagent.html"),
	MAIL_TO_CUSTOMER_NONAKOSHA_TICKET_RESOLVED_MAIL("/pages/email/nonakoshaticketmarkedresolvedmail.html"),
	ESCALATION_MAIL_TO_AIRCEL_CIRCLE_LEVEL("/pages/email/aircelcirclelevelescaltionmail.html"),
	AIRCEL_COMPLAINT_NOTIFICATION_TO_BRAND("/pages/email/aircelcomplaintnotificationtobrand.html"),
	MAIL_TO_CUSTOMER_NONAKOSHA_TICKET_ACKNOWLEDGEMENT("/pages/email/nonakoshaticketacknowledgement.html"),
	MAIL_TO_CUSTOMER_NONAKOSHA_TICKET_ACKNOWLEDGEMENT_GOIBIBO("/pages/email/nonakoshaticketacknowledgementgoibibo.html"),
	MAIL_TO_CUSTOMER_NONAKOSHA_TICKET_ACKNOWLEDGEMENT_HOUSEJOY("/pages/email/nonakoshaticketacknowledgementhousejoy.html"),
	//MAIL_TO_CUSTOMER_NONAKOSHA_TICKET_ACKNOWLEDGEMENT_BAGIT_TODAY("/pages/email/nonakoshaticketacknowledgementbagittoday.html"),
	MOBILEAPP_CUSTOM_EMAIL("/pages/email/mobileappcustomemail.html"),
	MOBILEAPP_WELCOME_EMAIL("/pages/email/androidappwelcome.html"),
	TWITTER_HIGH_FOLLOWER_COUNT_COMPLAINT_NOTIFICATION("/pages/email/highfollowercounttwitter.html"),
	PUMA_COMPLAINT_NOTIFICATION_TO_CUSTOMER("/pages/email/pumacomplaintnotificationtocustomer.html"),
	PUMA_COMPLAINT_APPROVAL_REJECTION_NOTIFICATION("/pages/email/pumaticketapprovalnotification.html"),
	PUMA_COMPLAINT_ESCALATION_NOTIFICATION("/pages/email/pumaescalationnotification.html"),
	PUMA_NO_BILL_MAIL_TO_CUSTOMER("/pages/email/pumanobilllinktocustomer.html"),
	PUMA_DAILY_REPORT("/pages/email/pumadailyreport.html"),
	AIRCEL_RETAIL_DAILY_REPORT("/pages/email/aircelretaildailypulsereport.html"),
	ADV_BRAND_UPDATE_DAILY_DIGEST("/pages/email/makemytrip_brandupdatedailydigest.html"),
	ADV_EXPORT_TO_EXCEL_MAIL("/pages/email/exporttoexcelmail.html"),
	HB_CONSTITUENCY_COMPLAINT_NOTIFICATION_TO_CUSTOMER("/pages/email/hbconstituencycomplaintnotificationtocustomer.html"),
	AIRCEL_MTD_ROLLED_UP_REPORT("/pages/email/aircelmtdrolledup.html"),
	AIRCEL_BOUNCE_ROLLED_UP_REPORT("/pages/email/aircelbouncerolledupreport.html"),
	GNIP_POWERTRACK_STREAM_EMAIL("/pages/email/GNIPPowerTrackStreamTemplate.html"),
	TICKET_ASSIGNMENT("/pages/email/ticketassignment.html"),
	GROFERS_DAILY_REPORT("pages/email/grofersdailyreport.html"),
	KOTAK_EXCEL_REPORT("/pages/email/kotakExcelReport.html"),
    GENERIC_BRANDS_REPORT("pages/email/brandreport.html");

	private final String emailType;

	EmailType(String name) {
		this.emailType = name;
	}
	
	public String getEmailType() {
		return emailType;
	}
}