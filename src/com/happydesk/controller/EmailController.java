package com.happydesk.controller;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edlio.emailreplyparser.EmailReplyParser;
import com.happydesk.dto.EmailDTO;
import com.happydesk.util.CommonUtil;
import com.happydesk.util.HappyDeskConstant;


/**
 * @author amit
 *
 */
public class EmailController {
	private static final Logger log = LoggerFactory
            .getLogger(EmailController.class);
	
	
	/**
	 * @return
	 */
	
	@RequestMapping("/parseemail")  
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			
			log.info("****************Starting Email Parser******************");
			
			
			Map<String, String[]> contentMap = request.getParameterMap();
			
			boolean complaintToBeTracked = true;
			String headers = request.getParameter("headers");
			String messageId = null;
			String mailText = request.getParameter("text");
			String bodyText = null;
			String bodyHtml = request.getParameter("html");
			
			
			// New Implementation to find out Complaint Id(if present) from Message Id header
			if(headers.contains("References:") && headers.contains("odId@smtp.sendgrid.net")) {
				String refString = "References: <";
				String suffixString = "odId@smtp.sendgrid.net>";
			    Pattern pattern = Pattern.compile(refString +"(.*?)" + suffixString);
			    Matcher matcher = pattern.matcher(headers);
			    while (matcher.find()) {
			    	messageId = matcher.group(1);
			    }
				
				// Message-ID has the format "complaintId_complaintDiaryId"
				if(StringUtils.isNotBlank(messageId)) {
					int complaintId = 0;
					if(messageId.contains("_")) {
						complaintId = Integer.valueOf(messageId.split("_")[0]); 
					} else {
						complaintId = Integer.valueOf(messageId);
					}
					//complaintForAppendingComment = emailListenerService.findComplaintByid(complaintId);
				}
			} else if(headers.contains("Message-ID:") && headers.contains("odId@smtp.sendgrid.net")) {
				// this is the case when while replying from dashboard the autoforwarding mail id is included --
				//In such a case complaint/comment not to be filed
					String refString = "Message-ID: <";
					String suffixString = "odId@smtp.sendgrid.net>";
				    Pattern pattern = Pattern.compile(refString +"(.*?)" + suffixString);
				    Matcher matcher = pattern.matcher(headers);
				    while (matcher.find()) {
				    	messageId = matcher.group(1);
				    }
					
					// Message-ID has the format "complaintId_complaintDiaryId"
					if(StringUtils.isNotBlank(messageId)) {
						complaintToBeTracked = false;
					}
				}
				
			
			if(null != null) {
				// Means it is a comment to existing ticket
				try{
					log.info("===Starting Email Parser Listener===");
					
					
					if(mailText != null) {
						mailText = mailText.trim();
						bodyText = EmailReplyParser.parseReply(mailText);
						bodyText = bodyText.replaceAll("\n\r", "\n");
						bodyText = bodyText.replaceAll("\n", "<br>");
					} else {
						bodyText = EmailReplyParser.parseReply(bodyHtml);
					}
					
					if(bodyText != null) {
						
						if(mailText == null) {
							bodyText = CommonUtil.trimHtmlTags(bodyText);
						}
						
						EmailDTO emailDTO = new EmailDTO();
						
						boolean sendCommentNotificationToBrand = false;
						
						String from = request.getParameter("from").trim();
						String name = null;
						String email = null;
						
						if(from.trim().indexOf("<") < 1) {
							if ((from.trim().indexOf("<") == 0) || (from.trim().indexOf("[") < 1)) {
								name = from.substring(0, from.indexOf("@")).trim().replaceAll("[-+.^:,<>]","").replaceAll("\\[", "").replaceAll("\\]","");
								email = from.trim().replaceAll("[<>]","").replaceAll("\\[", "").replaceAll("\\]","");
							} else {
								name = from.substring(0, from.indexOf("[") - 1).trim();
								int begin = from.indexOf("[") + 1;
								int end = from.indexOf("]");
								email = from.substring(begin, end);
							}
						} else { 
							name = from.substring(0, from.indexOf("<") - 1).trim();
							int begin = from.indexOf("<") + 1;
							int end = from.indexOf(">");
							email = from.substring(begin, end);
						}
						
						//emailDTO.setUserName(name);
				//		commentEmailAddresses.setFromEmail(email + HappyDeskConstant.EMAIL_NAME_SEPARATOR + name);
						emailDTO.setFromEmail(email);
						if(bodyText.length() > 4000) {
							bodyText = bodyText.substring(0, 4000);
						}
						emailDTO.setMailBody(bodyText.trim());
						emailDTO.setMailSubject(request.getParameter("subject").trim());
						emailDTO.setAttachmentNumber(Integer.valueOf(request.getParameter("attachments")));
						
						//Complaint complaint = null;
						
						//if forwarded mail then 'from mail id' will be 'to mail id'
						String[] toEmailArray = request.getParameter("to").split(",");
						String[] ccEmailArray;
						//Integer subSectionIdForTrail = null;
						if(request.getParameter("cc") != null) {
							ccEmailArray = request.getParameter("cc").split(",");
							//toEmailArray = (String[]) ArrayUtils.addAll(toEmailArray, ccEmailArray);
							if(ccEmailArray != null) {
								for(int i=0; i < ccEmailArray.length; i++) {
									try {
										String ccEmail;
										if(ccEmailArray[i].trim().indexOf("<") != -1) {
											name = ccEmailArray[i].substring(0, ccEmailArray[i].indexOf("<")).trim();
											int toBegin = ccEmailArray[i].trim().indexOf("<") + 1;
											int toEnd = ccEmailArray[i].trim().indexOf(">");
											if(name != null && name.trim().length() > 0) {
												ccEmail = (ccEmailArray[i].trim()).substring(toBegin, toEnd).trim() + HappyDeskConstant.EMAIL_NAME_SEPARATOR + name;
											} else {
												ccEmail = (ccEmailArray[i].trim()).substring(toBegin, toEnd).trim();
											}
										} else {
											ccEmail = ccEmailArray[i].trim();
										}
										
										//commentEmailAddresses.setCc(commentEmailAddresses.getCc() != null ? commentEmailAddresses.getCc() + "," + ccEmail : ccEmail);
									} catch (Exception e) {
										e.printStackTrace();
										log.info("===== Email Parser Listener Exception Start ====== while parsing ccEmailArray");
										
										log.info("===== Email Parser Listener Exception End ====== while parsing ccEmailArray");
										
									}
								}
							}
						}
						
						if(toEmailArray != null) {
							//int complaintId = 0;
							for(int i=0; i < toEmailArray.length; i++) {
								try {
									String toEmail;
									if(toEmailArray[i].trim().indexOf("<") != -1) {
										name = toEmailArray[i].substring(0, toEmailArray[i].indexOf("<")).trim();
										int toBegin = toEmailArray[i].trim().indexOf("<") + 1;
										int toEnd = toEmailArray[i].trim().indexOf(">");
										if(name != null && name.trim().length() > 0) {
											toEmail = (toEmailArray[i].trim()).substring(toBegin, toEnd).trim() + HappyDeskConstant.EMAIL_NAME_SEPARATOR + name;
										} else {
											toEmail = (toEmailArray[i].trim()).substring(toBegin, toEnd).trim();
										}
									} else {
										toEmail = toEmailArray[i].trim();
									}
									
									
									//commentEmailAddresses.setToEmail(commentEmailAddresses.getToEmail() != null ? commentEmailAddresses.getToEmail() + "," + toEmail : toEmail);
								} catch (Exception e) {
									e.printStackTrace();
									log.info("===== Email Parser Listener Exception Start ====== while parsing toEmailArray");
									
								}
							}
						}		
						/*		
						try {
							if(emailDTO.getAttachmentNumber() != null && emailDTO.getAttachmentNumber() > 0) {
								JSONParser parser = new JSONParser();
								for(int j = 1; j <= emailDTO.getAttachmentNumber(); j++) {
									try {
										File file = ((MultiPartRequestWrapper) request).getFiles("attachment" + j)[0];
										String fileName = file.getName();
										Object obj = ((JSONObject)(parser.parse(((JSONObject)(parser.parse(((String[]) contentMap.get("attachment-info"))[0]))).get("attachment" + j).toString()))).get("name");
										if(obj != null) {
											fileName = obj.toString();
										}
										
										saveAttachmentFile(file, complaintDiaryDto, fileName);
									} catch(Exception e) {
										e.printStackTrace();
										log.info(CommonUtil.getStackTrace(e));
									}
								}
							}
							}catch (Exception e) {
								// TODO: handle exception
							}*/
							/*String cId = CryptUtil.decrypt(complaintIdStr, Constants.LOGIN_COOKIE_KEY);
							try {
								complaintId = Integer.valueOf(cId);
							} catch(Exception e) {
								e.printStackTrace();
								emailParserListenerLogs.error("error: " + CommonUtil.getStackTrace(e));
							}*/
						
							
							/*
							ComplaintDiaryDto complaintDiaryDto = new ComplaintDiaryDto();
							complaintDiaryDto.setComplaintId(complaintForAppendingComment.getId());
							
							emailDTO.setMailSubject(request.getParameter("subject").trim());
							
							if (userId > 0) {
								complaintDiaryDto.setUserId(userId);
								// find user type and make comment
								// visible to sender.
								byte userType = emailListenerService.findUserTypeById(userId).getUserType();
								boolean mailFromAssignedUser = false;
								//check for assigned agent comment
								Integer assignedUserId = companyAssignmentService.findCompanyAssignment(complaintForAppendingComment.getId());
								User assignedUser = null;
								if(assignedUserId != null && assignedUserId > 0) {
									assignedUser = userService.findById(assignedUserId);
									if(assignedUser != null) {
										if(assignedUser.getEmail().equalsIgnoreCase(emailDTO.getFromEmail())) {
											mailFromAssignedUser = true;
										}
									}
								}
								if (userType == Constants.CONSUMER_USER_TYPE && !mailFromAssignedUser ) {
									//set visible to customer
									complaintDiaryDto.setVisibleToCustomer((byte) 1);
									if(complaintForAppendingComment.getSource() != ComplaintSource.Akosha.getType() || complaintForAppendingComment.getSource() != ComplaintSource.AkoshaInbound.getType()) {
										//set visible to brand
										complaintDiaryDto.setVisibleToBrand((byte) 1);
										
										//send mail to brand users flag
										sendCommentNotificationToBrand = true;
										
										//open complaint if it was closed at the brand end
										//complaintStatusService.updateComplaintStatusWithTransactionWithRealTime(complaintForAppendingComment, complaintForAppendingComment.getUser(), complaintForAppendingComment.getUser(), false, (byte)StatusType.Brand.getValue(), true);
										/*byte brandStatus = CollectionsHelper.getFirstObjectFromCollection(complaintForAppendingComment.getComplaintCurrentStatusList()).getBrandStatus();
										if(brandStatus != (byte)StatusValue.Open.getValue()){
											ComplaintStatus complaintStatus = new ComplaintStatus();
											complaintStatus.setComplaint(complaintForAppendingComment);
											complaintStatus.setCreatedAt(DateHelper.getCurrentTimeStamp());
											complaintStatus.setUpdatedBy(complaintForAppendingComment.getUser());
											complaintStatus.setStatusFor(complaintForAppendingComment.getUser());
											complaintStatus.setStatusType((byte)StatusType.Brand.getValue());
											complaintStatus.setStatusValue((byte)StatusValue.Open.getValue());
											complaintStatusService.save(complaintStatus);
											
											 //added by manoranja for realtime desktop push notification for reopen tickets
									         commonUtilityService.realTimeNotificationForReopenTicket(complaintForAppendingComment.getCompany().getId());
										}
									} else {
										complaintDiaryDto.setVisibleToBrand((byte) 0);
									}
									emailParserListenerLogs.info("Info: Comment will be visible to Customer And Brand");
								} else if (userType == Constants.BRAND_USER_TYPE) {
									complaintDiaryDto.setVisibleToCustomer((byte) 0);
									complaintDiaryDto.setVisibleToBrand((byte) 1);
									emailParserListenerLogs.info("Info: Comment will be visible to Brand");
								} else {
									complaintDiaryDto.setVisibleToCustomer((byte) 0);
									complaintDiaryDto.setVisibleToBrand((byte) 0);
									emailParserListenerLogs.info("Info: Comment will be visible to ADMIN/SUPERADMIN only");
								}
								
								complaintDiaryDto.setCreatedAt(DateHelper.getCurrentTimeStamp());
								complaintDiaryDto.setComment(emailDTO.getMailBody() == null || emailDTO.getMailBody().length() <= 0 ? " " : emailDTO.getMailBody());
								*/
								
								/*
								Byte commentingUserType = emailListenerService.findCommentingUserType(complaintForAppendingComment, emailDTO.getFromEmail());
								
								ComplaintDiary complaintDiary =emailListenerService.saveEmailParserData(complaintDiaryDto,commentEmailAddresses,commentingUserType,bodyText);
								
								if(complaintDiary!= null){
									if (userType == Constants.CONSUMER_USER_TYPE && !mailFromAssignedUser ) {
										complaintStatusService.updateComplaintStatusWithTransactionWithRealTime(complaintForAppendingComment, complaintForAppendingComment.getUser(), complaintForAppendingComment.getUser(), false, (byte)StatusType.Brand.getValue(), true);
									}
								}*/
								/*
								ComplaintDiary complaintDiary = emailListenerService.saveComment(complaintDiaryDto);
								
								commentEmailAddresses.setComplaintDiary(complaintDiary);
								Byte commentingUserType = emailListenerService.findCommentingUserType(complaintForAppendingComment, emailDTO.getFromEmail());
								commentEmailAddresses.setCommentUserType(commentingUserType);
								commentEmailAddresses.setCommentType((byte)EmailParserCommentTypeSource.Reply.getType());
								commentEmailAddresses.setCommentEmailSourceType((byte)CommentEmailSourceType.Email.getType());
								commentEmailAddresses.setParentCommentId(CommentReplyType.ReplyThroughEmail.getType());
								
								emailListenerService.saveEmailParserAddressesComment(commentEmailAddresses);
								
								// Check sentiments
	                            Classifier classifier = new SentimentClassifier();
	                            String sentiment = classifier.getSentiment(bodyText, TextType.EMAIL);
	                            emailSentimentService.saveEmailSentiment(null, complaintDiary, sentiment);
	                            */
								
						
					} 
				} catch(Exception e) {
					e.printStackTrace();
					log.info("===== Email Parser Listener Exception Start ======");
					
				}
				log.info("===Exit Email Parser Listener===");
				
				
			} else if(complaintToBeTracked)  {
				
				 // Email Parser Code
				
				String fromEmailStr = null;
				
				
				if(mailText != null) {
					mailText = mailText.trim();
				}
				
				String forwardParserEmail = null;
				if(request.getParameter("to") != null) {
					if(request.getParameter("to").trim().indexOf("<") < 1) {
						forwardParserEmail = request.getParameter("to").trim().replaceAll("[<>]","");
					} else {
						int begin = request.getParameter("to").indexOf("<") + 1;
						int end = request.getParameter("to").indexOf(">");
						forwardParserEmail = request.getParameter("to").substring(begin, end).trim();
					}
				}
				
				boolean isForwardedMail = false;
				boolean stopProcessing = false;
				if(forwardParserEmail != null && StringUtils.equalsIgnoreCase(forwardParserEmail, "forward@parser.akosha.me")) {
					log.info("-----Forwarding Mail Id ---------" + request.getParameter("from"));
					isForwardedMail = true;
					
					int fromIndex = -1;
					int fromEmailStartingIndex = -1, nextLineEndingIndex = -1;
					
					while(true) {
						fromIndex = mailText.indexOf("From", fromIndex + 1);
						
						if(fromIndex == -1) {
							break;
						}
						
						fromEmailStartingIndex  = mailText.indexOf(":", fromIndex);
						nextLineEndingIndex = mailText.indexOf("\n", fromEmailStartingIndex + 1);
						
						if(fromEmailStartingIndex < nextLineEndingIndex) {
							fromEmailStr = mailText.substring(fromEmailStartingIndex + 1, nextLineEndingIndex).trim();
							
							if(fromEmailStr != null && fromEmailStr.contains("\r")) {
								int returnIndex = fromEmailStr.indexOf("\r");
								fromEmailStr = fromEmailStr.substring(0, returnIndex);
							}
							
							if(Pattern.matches(HappyDeskConstant.EMAIL_PATTERN, fromEmailStr)) {
								break;
							}
						}
					}
					
					bodyText = mailText.substring(nextLineEndingIndex).trim();
				} else {
					//bodyHtml = request.getParameter("html");
					if(mailText != null) {
						bodyText = EmailReplyParser.parseReply(mailText);
						bodyText = bodyText.replaceAll("\n\r", "\n");
						bodyText = bodyText.replaceAll("\n", "<br>");
					} else {
						bodyText = EmailReplyParser.parseReply(bodyHtml);
					}
				}
				
				if(bodyText != null) {
					if(mailText == null) {
						bodyText = CommonUtil.trimHtmlTags(bodyText);
					}
					EmailDTO emailDTO = new EmailDTO();
					//EmailParserCompanyInfo emailParserCompanyInfo = null;
					String from = isForwardedMail ? fromEmailStr : request.getParameter("from").trim();
							
					String name = null;
					String email = null;
					if(from.trim().indexOf("<") < 1) {
						if ((from.trim().indexOf("<") == 0) || (from.trim().indexOf("[") < 1)) {
							name = from.substring(0, from.indexOf("@")).trim().replaceAll("[-+.^:,<>]","").replaceAll("\\[", "").replaceAll("\\]","");
							email = from.trim().replaceAll("[<>]","").replaceAll("\\[", "").replaceAll("\\]","");
						} else {
							name = from.substring(0, from.indexOf("[") - 1).trim();
							int begin = from.indexOf("[") + 1;
							int end = from.indexOf("]");
							email = from.substring(begin, end);
						}
					} else { 
						name = from.substring(0, from.indexOf("<") - 1).trim();
						int begin = from.indexOf("<") + 1;
						int end = from.indexOf(">");
						email = from.substring(begin, end);
					}
					
					emailDTO.setUserName(name);
					emailDTO.setFromEmail(email);
					emailDTO.setFromWithName(email + HappyDeskConstant.EMAIL_NAME_SEPARATOR + name);
					if(emailDTO.getFromEmail().equalsIgnoreCase("forwarding-noreply@google.com")) {
						//sendForwardingMail(request);
					} else {
						
						
						
						//check if 'from email' is not our support email id if yes then dont render it
						
					}
				} else {
					log.info("[Error]===== Email Parser Exception ====== Body text null");
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			log.info("===== Email Parser Exception Start ======");
			
			
			//log.info("--- Exception for TO mail id ---" + request.getParameter("to") + "--- FROM mail id ---" + request.getParameter("from") + "---Mail Body ---"+request.getParameter("text"));
		}
}

}
