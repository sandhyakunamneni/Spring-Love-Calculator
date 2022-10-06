package com.seleniumexpress.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class UserInfoDTO {

   @NotBlank(message = "* Username cant be blank")
//   @Min(value = 3, message = "* Name should have atleast 3 characters")
    private String userName;

   
   @NotBlank(message = "* Username cant be blank")
    private String crushName;

    
   @AssertTrue(message = "You must agree to terms and conditions to calculate")
   private  boolean termsandconditions;

    public boolean isTermsandconditions() {
	return termsandconditions;
}

public void setTermsandconditions(boolean termsandconditions) {
	this.termsandconditions = termsandconditions;
}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCrushName() {
        return crushName;
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "userName='" + userName + '\'' +
                ", crushName='" + crushName + '\'' +
                '}';
    }
}
