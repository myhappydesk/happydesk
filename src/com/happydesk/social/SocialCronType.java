package com.happydesk.social;

/**
 * @author Om Yadav
 *
 */
public enum SocialCronType {
	Twitter(1),
	TwitterDM(2),
	Facebook(3),
	FacebookDM(4);

	int statusType;

	SocialCronType(int type){
		this.statusType = type;
	}
	public int getValue() {
		return statusType;
	}
}
